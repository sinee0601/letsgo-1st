package com.letsgo.place.model.query;

public interface PlaceQuery {
	
	//정리본
	
	String GET_PLACE = "SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type = ? ";
	
	String BY_TITLE = "AND title = ? ";
	String BY_CATEGORY = "AND lclssystm3 = ? ";
	String BY_ADDR = "AND addr1 Like ? ";
	
	String ORDER_BY_LIKE = "ORDER BY like_count DESC ";
	String ORDER_BY_TITLE = "ORDER BY title ASC ";
	String GET_BY_TITLE_OR_ADDR = "AND (title LIKE ? OR addr1 LIKE ?) ";
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	String GET_PLACE_BY_TITLE_SQL=			"SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type=? AND title=?";
	
	String GET_PLACE_BY_CATEGORY_SQL=		"SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type=? AND lclssystm3=?";
	
	String GET_PLACE_ORDER_BY_LIKE_SQL=		"SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type=? ORDER BY like_count DESC";
	
	String GET_PLACE_ORDER_BY_TITLE_SQL=	"SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type=? ORDER BY title ASC";
	
	String GET_PLACE_BY_ADDR_SQL=			"SELECT place_Id, title, first_image, addr1, mapx, mapy, like_count FROM place WHERE place_type =? AND addr1 Like ?";
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	String GET_PLACES_SQL = 			"SELECT place_id, title, addr1, mapx, mapy FROM place";
	
	String GET_PLACE_BY_PLACE_ID_SQL = 	"SELECT place_id, title, addr1, mapx, mapy FROM place WHERE place_Id = ?";
	
	String GET_PLACE_SQL=				"SELECT title, addr1, mapx, mapy FROM place WHERE place_type=? AND place_Id=?";
	
	String GET_PLACE_BYID_SQL = 		"SELECT title, addr1, mapx, mapy FROM place WHERE place_Id = ?";
	
	String GET_PLACE_COUNT_SQL=			"SELECT COUNT(place_Id) FROM place WHERE place_type=?";
	
	String ADD_PLACE_LIKE_COUNT_SQL=	"UPDATE place SET like_count = like_count + 1 WHERE place_Id=?";
	
	String GET_PLACE_LIKE_COUNT_SQL=	"SELECT like_count FROM place WHERE place_type=? AND place_Id=?";
	
	String GET_LEISURE_PLACE_DESC_SQL = "SELECT * FROM place WHERE place_type = 'LEISURE' ORDER BY like_count DESC";
	
	String GET_LEISERE_PLACE_SQL ="SELECT * FROM place WHERE place_type = 'LEISURE'";
	
	String GET_VISIT_ITEM_SCHEDULE_ID_SQL = "SELECT VISIT_ORDER, DISTANCE_TO_NEXT, PLACE_ID FROM VISIT_ITEM WHERE SCHEDULE_ID = ? ORDER BY VISIT_ORDER ASC";
	
	String SET_COUNTING_SQL = "UPDATE place SET like_count = like_count + 1 WHERE place_id = ?";

	String INSERT_VISIT_ITEM_SQL = "INSERT INTO VISIT_ITEM (VISIT_ITEM_ID, VISIT_ORDER, DISTANCE_TO_NEXT, PLACE_ID, SCHEDULE_ID, SCHEDULE_TYPE) VALUES ((SELECT NVL(MAX(VISIT_ITEM_ID), 0) + 1 FROM VISIT_ITEM), ?, ?, ?, ?, ?)";

	/*
	 * 장바구니 내 LEISURE 좌표 기준 반경(km) 내 PLACE 조회 (식당/숙박).
	 *  - Haversine 공식 (지구 반경 6371km, 0.017453292519943295 = π/180)
	 *  - mapx = 경도, mapy = 위도
	 *  - 바인딩 순서: placeType, [category], [keywordPattern x2], centerLat(=mapy), centerLat, centerLon(=mapx), radiusKm,
	 *                그리고 ORDER BY 가 distance 인 경우 centerLat, centerLat, centerLon 추가
	 *  - 동적 WHERE/ORDER 조합이 복잡해 호출 측에서 직접 SQL 을 조립한다 (PlaceDAO 참고)
	 */
	String NEARBY_HAVERSINE_KM_TEMPLATE =
			"(6371 * 2 * ASIN(SQRT(" +
			"  POWER(SIN((TO_NUMBER(MAPY) - TO_NUMBER(?)) * 0.017453292519943295 / 2), 2)" +
			" + COS(TO_NUMBER(MAPY) * 0.017453292519943295)" +
			"   * COS(TO_NUMBER(?) * 0.017453292519943295)" +
			"   * POWER(SIN((TO_NUMBER(MAPX) - TO_NUMBER(?)) * 0.017453292519943295 / 2), 2)" +
			")))";
}

