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

        // 식당/숙박은 장바구니 LEISURE 좌표 기준 반경 내 결과만 반환
        if ("RESTAURANT".equals(placeType) || "STAY".equals(placeType)) {
            HttpSession session = request.getSession();
            PlaceVO leisure = CartUtil.getLeisureInCart(session);
            if (leisure == null) {
                request.setAttribute("cartMessage", "레저스포츠를 먼저 장바구니에 담아주세요.");
                return new LeisureUIAction().execute(request);
            }

            boolean orderByLike = "popular".equals(sortOrder) || "like".equals(sortOrder);
            String normalizedCategory = (category != null && !category.trim().isEmpty()) ? category : null;
            String normalizedKeyword = (keyword != null && !keyword.trim().isEmpty()) ? keyword : null;

            List<PlaceVO> placeList = placeService.searchNearbyPlaces(
                    placeType, leisure.getMapx(), leisure.getMapy(),
                    CartUtil.NEARBY_RADIUS_KM, normalizedCategory, normalizedKeyword, orderByLike);

            request.setAttribute("totalCount", placeList.size());
            request.setAttribute("nearbyRadiusKm", CartUtil.NEARBY_RADIUS_KM);
            if ("RESTAURANT".equals(placeType)) {
                request.setAttribute("restaurantPlaceList", placeList);
                return "restaurant.jsp";
            }
            request.setAttribute("stayPlaceList", placeList);
            return "stay.jsp";
        }

        List<PlaceVO> placeList = searchPlaces(placeService, placeType, category, keyword, sortOrder);
        request.setAttribute("totalCount", placeList.size());
        request.setAttribute("leisurePlaceList", placeList);
        return "leisure.jsp";
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
