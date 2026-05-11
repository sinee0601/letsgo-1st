package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.service.MyScheduleService;
import com.letsgo.place.mybatis.service.PostScheduleServiceMB;

public class PostScheduleBudgetDetailUIAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");
		
		if (userId == null) {
			return "login.jsp";
		}

		String postId = (String) session.getAttribute("currentPostScheduleId");
		PostScheduleServiceMB service = new PostScheduleServiceMB();
		ArrayList<RouteScheduleVO> list = (ArrayList<RouteScheduleVO>) service.getScheduleRoute(postId);
		String budgetDetail = service.getBudgetDetail(postId);
		String scheduleTitle = service.getScheduleTitle(postId);
		int likeCount = service.getLikeCount(postId);

		request.setAttribute("ScheduleRoute", list);
		request.setAttribute("budgetDetail", budgetDetail);
		request.setAttribute("scheduleTitle", scheduleTitle);
		request.setAttribute("postId", postId);
		request.setAttribute("count", likeCount);
		
		return "postScheduleBudgetDetail.jsp";
	}
}

