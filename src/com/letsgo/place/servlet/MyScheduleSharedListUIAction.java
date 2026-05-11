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

public class MyScheduleSharedListUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		String title = (String) request.getParameter("searchTitle");
		String sortOrder = (String) request.getParameter("sortOrder");
		if (userId == null) {
			return "login.jsp";
		}

		MyScheduleServiceMB service = new MyScheduleServiceMB();
		List<MyScheduleVO> list;

		boolean hasKeyword = title != null && !title.trim().isEmpty();
		boolean byTitle = "title".equals(sortOrder);

		if (hasKeyword) {
			list = byTitle
				? service.getMyScheduleListSearchSharedByTitle(userId, title)
				: service.getMyScheduleListSearchSharedByDate(userId, title);
		} else {
			list = byTitle
				? service.getMyScheduleListSharedByTitle(userId)
				: service.getMyScheduleListSharedByDate(userId);
		}


		Map<String, MyScheduleVO> uniqueMap = new LinkedHashMap<>();
		for (MyScheduleVO vo : list) {

			if (!uniqueMap.containsKey(vo.getMyScheduleId())) {
				uniqueMap.put(vo.getMyScheduleId(), vo);
			}
		}
		request.setAttribute("myScheduleList", new ArrayList<>(uniqueMap.values()));

		return "myScheduleList.jsp";
	}

}

