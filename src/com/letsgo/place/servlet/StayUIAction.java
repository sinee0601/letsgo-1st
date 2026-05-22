package com.letsgo.place.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.letsgo.place.mybatis.service.PlaceServiceMB;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.service.PlaceServiceInterface;

public class StayUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		PlaceVO leisure = CartUtil.getLeisureInCart(session);
		if (leisure == null) {
			request.setAttribute("cartMessage", "레저스포츠를 먼저 장바구니에 담아주세요.");
			return new LeisureUIAction().execute(request);
		}

		String sortOrder = request.getParameter("sortOrder");
		boolean orderByLike = "popular".equals(sortOrder);
		PlaceServiceInterface placeService = new PlaceServiceMB();

		List<PlaceVO> stayPlaceList = placeService.searchNearbyPlaces(
				"STAY", leisure.getMapx(), leisure.getMapy(),
				CartUtil.NEARBY_RADIUS_KM, null, null, orderByLike);

		request.setAttribute("stayPlaceList", stayPlaceList);
		request.setAttribute("totalCount", stayPlaceList.size());
		request.setAttribute("nearbyRadiusKm", CartUtil.NEARBY_RADIUS_KM);

		return "stay.jsp";
	}

}
