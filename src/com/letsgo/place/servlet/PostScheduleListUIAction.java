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

import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.service.PostScheduleService;

public class PostScheduleListUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		String sortOrder = (String) request.getParameter("sortOrder");
		String title = (String) request.getParameter("searchTitle");
		
		if (userId == null) {
			return "login.jsp";
		}
	
		PostScheduleService service = new PostScheduleService();
		List<PostScheduleVO> list = null;
	

		// 1. 검색어(keyword)가 있는 경우
        if (title != null && !title.trim().isEmpty()) {
            if ("like".equals(sortOrder)) {
                list = service.getPostScheduleListLike(title);
            } else if ("view".equals(sortOrder)) {
                list = service.getPostScheduleListView(title);
            } else if ("title".equals(sortOrder)) {
                list = service.getPostScheduleListTitle(title);
            } else {
                // 기본값: latest (최신순)
                list = service.getPostScheduleListLatest(title);
            }
        } 
        // 2. 검색어(keyword)가 없는 경우
        else {
            if ("like".equals(sortOrder)) {
                list = service.getPostScheduleListLike();
            } else if ("view".equals(sortOrder)) {
                list = service.getPostScheduleListView();
            } else if ("title".equals(sortOrder)) {
                list = service.getPostScheduleListTitle();
            } else {
                // 기본값: latest (최신순)
                list = service.getPostScheduleListLatest();
            }
        }
		
		
		Map<String, PostScheduleVO> uniqueMap = new LinkedHashMap<>();
		for (PostScheduleVO vo : list) {

			if (!uniqueMap.containsKey(vo.getPostId())) {
				uniqueMap.put(vo.getPostId(), vo);
			} else {
				PostScheduleVO existingVO = uniqueMap.get(vo.getPostId());
				if (existingVO.getFirstImage() == null) {
					existingVO.setFirstImage(vo.getFirstImage());
				}
		        String combinedPlaces = existingVO.getPlaceTitle() + " / " + vo.getPlaceTitle();
		        existingVO.setPlaceTitle(combinedPlaces);
			}
		}
		


		request.setAttribute("postScheduleList", new ArrayList<>(uniqueMap.values()));
		
					
		return "postScheduleList.jsp";
	}	
}
