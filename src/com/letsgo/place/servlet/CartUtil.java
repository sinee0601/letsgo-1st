package com.letsgo.place.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.letsgo.place.model.vo.PlaceVO;

final class CartUtil {

	// 장바구니 내 LEISURE 좌표 기준 식당/숙박 검색 반경 (km).
	// 차로 15~20분 동선을 가정한 값. 조정 시 이 상수만 바꾸면 모든 호출지점에 반영됨.
	static final double NEARBY_RADIUS_KM = 10.0;

	private CartUtil() {
	}

	@SuppressWarnings("unchecked")
	static PlaceVO getLeisureInCart(HttpSession session) {
		if (session == null) {
			return null;
		}
		List<PlaceVO> cartList = (List<PlaceVO>) session.getAttribute("placeCartList");
		if (cartList == null) {
			return null;
		}
		for (PlaceVO place : cartList) {
			if ("LEISURE".equals(place.getPlaceType())
					&& place.getMapx() != null && !place.getMapx().isEmpty()
					&& place.getMapy() != null && !place.getMapy().isEmpty()) {
				return place;
			}
		}
		return null;
	}
}
