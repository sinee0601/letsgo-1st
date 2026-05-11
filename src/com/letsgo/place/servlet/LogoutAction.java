package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.mybatis.service.PlaceServiceMB;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		if(session != null){
			session.invalidate();
		}
		request.setAttribute("sortOrder", "like");
		request.setAttribute("leisurePlaceList", new PlaceServiceMB().getLeisurePlacesOrderByLikeDesc());
		return "index.jsp";
	}
}
