package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.service.PlaceServiceInterface;

public class StayUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String sortOrder = request.getParameter("sortOrder");
	    PlaceServiceInterface placeService = new PlaceServiceMB();
		
		List<PlaceVO> stayPlaceList;
		
		if ("popular".equals(sortOrder)) {
	        stayPlaceList = placeService.getPlaceOrderByLike("STAY");
	    } else {
	        stayPlaceList = placeService.getPlaceOrderByTitle("STAY");
	    }
		
        request.setAttribute("stayPlaceList", stayPlaceList);
        request.setAttribute("totalCount", stayPlaceList.size());
        
		return "stay.jsp";
	}

}

