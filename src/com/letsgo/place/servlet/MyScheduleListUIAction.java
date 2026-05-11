package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.model.vo.MyScheduleVO;
import com.letsgo.place.mybatis.service.MyScheduleServiceMB;
import com.letsgo.place.mybatis.service.MyScheduleServiceMB;
import com.letsgo.place.service.MyScheduleServiceInterface;

public class MyScheduleListUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		String keyword = request.getParameter("searchTitle");
		String sortOrder = request.getParameter("sortOrder");
		String sharedFilter = request.getParameter("sharedFilter");

		if (userId == null) {
			return "login.jsp";
		}

		boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
		boolean isSortTitle = "title".equals(sortOrder);
		boolean isShared = "true".equals(sharedFilter);

		MyScheduleServiceInterface service = new MyScheduleServiceMB();
		List<MyScheduleVO> list;

		if (isShared) {
			if (hasKeyword) {
				list = isSortTitle
					? service.getMyScheduleListSearchSharedByTitle(userId, keyword)
					: service.getMyScheduleListSearchSharedByDate(userId, keyword);
			} else {
				list = isSortTitle
					? service.getMyScheduleListSharedByTitle(userId)
					: service.getMyScheduleListSharedByDate(userId);
			}
		} else {
			if (hasKeyword) {
				list = isSortTitle
					? service.getMyScheduleListSearchByTitle(userId, keyword)
					: service.getMyScheduleListSearchByDate(userId, keyword);
			} else {
				list = isSortTitle
					? service.getMyScheduleListAllByTitle(userId)
					: service.getMyScheduleListAllByDate(userId);
			}
		}

		if (list == null) {
			list = new ArrayList<>();
		}

		Map<String, MyScheduleVO> uniqueMap = new LinkedHashMap<>();
		for (MyScheduleVO vo : list) {
			if (!uniqueMap.containsKey(vo.getMyScheduleId())) {
				uniqueMap.put(vo.getMyScheduleId(), vo);
			} else {
				MyScheduleVO existingVO = uniqueMap.get(vo.getMyScheduleId());
				if (existingVO.getFirstImage() == null) {
					existingVO.setFirstImage(vo.getFirstImage());
				}
				String combinedPlaces = existingVO.getPlaceTitle() + " / " + vo.getPlaceTitle();
				existingVO.setPlaceTitle(combinedPlaces);
			}
		}
		request.setAttribute("myScheduleList", new ArrayList<>(uniqueMap.values()));

		return "myScheduleList.jsp";
	}

}

