package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.mybatis.service.PostScheduleServiceMB;

public class PostScheduleAddToMyScheduleAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		String postId = request.getParameter("postId");

		PostScheduleServiceMB service = new PostScheduleServiceMB();
		
		if (userId == null) {
			return "login.jsp";
		}
		
		if (postId != null) {
			session.setAttribute("currentPostScheduleId", postId);
		} else {
			postId = (String) session.getAttribute("currentPostScheduleId");
		}

		boolean result = service.addToMySchedule(postId, userId);
		request.setAttribute("addResult", result);
		
		System.out.println("등록 결과: " + result);
		System.out.println("현재 세션 아이디: " + userId);
		System.out.println("이동할 목적지: controller?cmd=postScheduleDetailUI&postId=" + postId);
		
		return "controller?cmd=postScheduleRouteManageUI";
	}
	
	
}
