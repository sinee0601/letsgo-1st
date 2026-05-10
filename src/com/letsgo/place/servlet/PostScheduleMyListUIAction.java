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

import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.service.PostScheduleService;

public class PostScheduleMyListUIAction implements Action {

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
	
		PostScheduleService service = new PostScheduleService();
		List<PostScheduleVO> list = null;
		
		// 1. 검색어(title/keyword)가 있는 경우
        if (title != null && !title.trim().isEmpty()) {
            if ("like".equals(sortOrder)) {
                list = service.getUserPostScheduleListLike(userId, title);
            } else if ("view".equals(sortOrder)) {
                list = service.getUserPostScheduleListView(userId, title);
            } else if ("title".equals(sortOrder)) {
                list = service.getUserPostScheduleListTitle(userId, title);
            } else {
                // 기본값: latest (최신순)
                list = service.getUserPostScheduleListLatest(userId, title);
            }
        } 
        // 2. 검색어(title/keyword)가 없는 경우
        else {
            if ("like".equals(sortOrder)) {
                list = service.getUserPostScheduleListLike(userId);
            } else if ("view".equals(sortOrder)) {
                list = service.getUserPostScheduleListView(userId);
            } else if ("title".equals(sortOrder)) {
                list = service.getUserPostScheduleListTitle(userId);
            } else {
                // 기본값: latest (최신순)
                list = service.getUserPostScheduleListLatest(userId);
            }
        }
		
		Map<String, PostScheduleVO> uniqueMap = new LinkedHashMap<>();
		for (PostScheduleVO vo : list) {

			if (!uniqueMap.containsKey(vo.getPostId())) {
				uniqueMap.put(vo.getPostId(), vo);
			} else {
				PostScheduleVO existingVO = uniqueMap.get(vo.getPostId());
		        String combinedPlaces = existingVO.getPlaceTitle() + " / " + vo.getPlaceTitle();
		        existingVO.setPlaceTitle(combinedPlaces);
			}
			
		}

		request.setAttribute("postScheduleList", new ArrayList<>(uniqueMap.values()));
			
					
		return "postScheduleList.jsp";
	}
	
	
}

