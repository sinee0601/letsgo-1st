package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.service.PlaceServiceInterface;

public class PlaceLikeAction implements Action {
    @Override
    public String execute(HttpServletRequest request)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        String placeId = request.getParameter("placeId");
        String sort = request.getParameter("sortOrder");
        
        PlaceServiceInterface placeService = new PlaceServiceMB();
        if (placeId != null && !placeId.trim().isEmpty()) {
            placeService.setPlaceLikeCount(placeId);
        }

        request.setAttribute("sortOrder", sort);
        return new PlaceLikeSortingAction().execute(request);
    }
}