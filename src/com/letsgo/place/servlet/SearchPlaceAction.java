package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.service.PlaceServiceInterface;

public class SearchPlaceAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
        String placeType = request.getParameter("placeType"); 
        String keyword = request.getParameter("keyword");     
        String category = request.getParameter("category");   
        String sortOrder = request.getParameter("sortOrder"); 
        
        if (placeType == null || placeType.trim().isEmpty()) {
            placeType = "LEISURE"; 
        }

        PlaceServiceInterface placeService = new PlaceServiceMB();
        List<PlaceVO> placeList = searchPlaces(placeService, placeType, category, keyword, sortOrder);
        
        int totalCount = placeList.size(); 
        request.setAttribute("totalCount", totalCount);
        
        if ("RESTAURANT".equals(placeType)) {
            request.setAttribute("restaurantPlaceList", placeList);
            return "restaurant.jsp";
            
        } else if ("STAY".equals(placeType)) {
            request.setAttribute("stayPlaceList", placeList);
            return "stay.jsp";
            
        } else {
            request.setAttribute("leisurePlaceList", placeList);
            return "leisure.jsp";
        }
	}

    private List<PlaceVO> searchPlaces(PlaceServiceInterface placeService, String placeType, String category,
            String keyword, String sortOrder) {
        boolean hasCategory = category != null && !category.trim().isEmpty();
        boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
        boolean orderByLike = "popular".equals(sortOrder) || "like".equals(sortOrder);

        if (hasCategory && hasKeyword) {
            return orderByLike
                    ? placeService.searchPlacesByCategoryAndKeywordOrderByLike(placeType, category, keyword)
                    : placeService.searchPlacesByCategoryAndKeywordOrderByTitle(placeType, category, keyword);
        }
        if (hasCategory) {
            return orderByLike
                    ? placeService.searchPlacesByCategoryOrderByLike(placeType, category)
                    : placeService.searchPlacesByCategoryOrderByTitle(placeType, category);
        }
        if (hasKeyword) {
            return orderByLike
                    ? placeService.searchPlacesByKeywordOrderByLike(placeType, keyword)
                    : placeService.searchPlacesByKeywordOrderByTitle(placeType, keyword);
        }
        return orderByLike ? placeService.searchPlacesOrderByLike(placeType)
                : placeService.searchPlacesOrderByTitle(placeType);
    }
}

