package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.service.PlaceServiceInterface;

public class RestaurantUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String sortOrder = request.getParameter("sortOrder");
		PlaceServiceInterface placeService = new PlaceServiceMB();
		
        List<PlaceVO> restaurantPlaceList;
        
        if ("popular".equals(sortOrder)) {
            restaurantPlaceList = placeService.getPlaceOrderByLike("RESTAURANT");
        } else {
            restaurantPlaceList = placeService.getPlaceOrderByTitle("RESTAURANT"); 
        }

        request.setAttribute("restaurantPlaceList", restaurantPlaceList);
        request.setAttribute("totalCount", restaurantPlaceList.size());
        
		return "restaurant.jsp";
		
	}

}

