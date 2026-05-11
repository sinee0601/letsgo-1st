package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.mybatis.service.MyScheduleServiceMB;

public class UpdateStartAtAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginOK");

		if (userId == null) {
			return "login.jsp";
		}

		String myScheduleId = (String) session.getAttribute("currentScheduleId");
		String startAt = request.getParameter("startAt");

		if (myScheduleId != null && startAt != null && startAt.matches("\\d{4}-\\d{2}-\\d{2}")) {
			MyScheduleServiceMB service = new MyScheduleServiceMB();
			service.setStartAt(myScheduleId, startAt, userId);
		}

		return new MyScheduleRouteManageUIAction().execute(request);
	}
}
