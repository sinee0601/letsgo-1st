package com.letsgo.place.servlet;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.letsgo.place.mybatis.service.PostScheduleServiceMB;

public class DeletePostScheduleAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String postId = request.getParameter("postId");
		
		PostScheduleServiceMB service = new PostScheduleServiceMB();
		boolean result = service.deletePostScheduleAndVisitItem(postId);
		
		request.setAttribute("result", result);
		return "controller?cmd=postScheduleMyListUI";
	}

}
