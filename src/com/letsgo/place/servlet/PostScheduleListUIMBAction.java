package com.letsgo.place.servlet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.service.PostScheduleServiceMB;

public class PostScheduleListUIMBAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		String sortOrder = (String) request.getParameter("sortOrder");
		String title = (String) request.getParameter("searchTitle");
		
		if (userId == null) {
			return "login.jsp";
		}
	
		PostScheduleServiceMB service = new PostScheduleServiceMB();
		List<PostScheduleVO> list = null;
		try {
		    list = service.getPostScheduleList(sortOrder, title);
		} finally {
		    service.close();
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
