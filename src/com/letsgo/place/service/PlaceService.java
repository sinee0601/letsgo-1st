package com.letsgo.place.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.letsgo.place.model.dao.DBCP;
import com.letsgo.place.model.dao.PlaceDAO;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.model.vo.VisitItemVO;

public class PlaceService implements PlaceServiceInterface {
	
	private PlaceDAO dao;
	
	private Connection conn;

	public PlaceService() throws ClassNotFoundException, SQLException {
		conn = DBCP.getConnection();
		dao = new PlaceDAO(conn);
	}
	
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		return dao.getPlaceByTitle(placeType, title);
	}
	
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		return dao.getPlaceByCategory(placeType, lclssystm3);
	}
	
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		return dao.getPlaceOrderByLike(placeType);
	}
	
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		return dao.getPlaceOrderByTitle(placeType);
	}
	
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		return dao.getPlaceByAddr(placeType, addr);
	}
	
	public List<PlaceVO> getPlace(String placeId) {
		return dao.getPlace(placeId);
	}
	
	public int getPlaceCount(String placeType) {
		return dao.getPlaceCount(placeType);
	}
	
	public boolean setPlaceLikeCount(String placeId) {
		boolean result = false;
		try {
			conn.setAutoCommit(false);
			result = dao.setPlaceLikeCount(placeId);
			if (result)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int getPlaceLikeCount(String placeType, String placeId) {
		return dao.getPlaceLikeCount(placeType, placeId);
	}
	
	public List<PlaceVO> getPlaces() {
		return dao.getPlaces();
	}
	
	public boolean insertVisitItem(int visitOrder, int distanceToNext,
            String placeId, String scheduleId, String scheduleType) {
		boolean result = false;
		try {
			conn.setAutoCommit(false);
			result = dao.insertVisitItem(visitOrder, distanceToNext, placeId, scheduleId, scheduleType);
			if (result)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//좋아요 정렬
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		return dao.getLeisurePlacesOrderByLikeDesc();
	}
	//레저만 보여주기
	public List<PlaceVO> getLeisurePlaces(){
		return dao.getLeisurePlaces();
	}
	
	public boolean setCounting(String postId) {
		boolean result = false;
		try {
			conn.setAutoCommit(false);
			result = dao.setCounting(postId);
			if (result)
				conn.commit();
			else
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public PlaceVO getPlaceById(String placeId) {
		return dao.getPlaceById(placeId);
	}
	
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		return dao.getVisitItemsByScheduleId(scheduleId);
	}
	
	public PlaceVO getPlaceByPlaceId(String placeId) {
		return dao.getPlaceByPlaceId(placeId);
	}
	
	public List<PlaceVO> searchPlaces(String placeType, String category, String keyword, String sortType) {
		boolean hasCategory = category != null && !category.trim().isEmpty();
		boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
		boolean orderByLike = "popular".equals(sortType);

		if (hasCategory && hasKeyword) {
			return orderByLike
					? searchPlacesByCategoryAndKeywordOrderByLike(placeType, category, keyword)
					: searchPlacesByCategoryAndKeywordOrderByTitle(placeType, category, keyword);
		}
		if (hasCategory) {
			return orderByLike
					? searchPlacesByCategoryOrderByLike(placeType, category)
					: searchPlacesByCategoryOrderByTitle(placeType, category);
		}
		if (hasKeyword) {
			return orderByLike
					? searchPlacesByKeywordOrderByLike(placeType, keyword)
					: searchPlacesByKeywordOrderByTitle(placeType, keyword);
		}
		return orderByLike ? searchPlacesOrderByLike(placeType) : searchPlacesOrderByTitle(placeType);
	}

	public List<PlaceVO> searchPlacesOrderByTitle(String placeType) {
		return dao.searchPlacesOrderByTitle(placeType);
	}

	public List<PlaceVO> searchPlacesOrderByLike(String placeType) {
		return dao.searchPlacesOrderByLike(placeType);
	}

	public List<PlaceVO> searchPlacesByCategoryOrderByTitle(String placeType, String category) {
		return dao.searchPlacesByCategoryOrderByTitle(placeType, category);
	}

	public List<PlaceVO> searchPlacesByCategoryOrderByLike(String placeType, String category) {
		return dao.searchPlacesByCategoryOrderByLike(placeType, category);
	}

	public List<PlaceVO> searchPlacesByKeywordOrderByTitle(String placeType, String keyword) {
		return dao.searchPlacesByKeywordOrderByTitle(placeType, keyword);
	}

	public List<PlaceVO> searchPlacesByKeywordOrderByLike(String placeType, String keyword) {
		return dao.searchPlacesByKeywordOrderByLike(placeType, keyword);
	}

	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByTitle(String placeType, String category,
			String keyword) {
		return dao.searchPlacesByCategoryAndKeywordOrderByTitle(placeType, category, keyword);
	}

	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByLike(String placeType, String category, String keyword) {
		return dao.searchPlacesByCategoryAndKeywordOrderByLike(placeType, category, keyword);
	}

	public List<PlaceVO> searchNearbyPlaces(String placeType, String centerLon, String centerLat,
			double radiusKm, String category, String keyword, boolean orderByLike) {
		return dao.searchNearbyPlaces(placeType, centerLon, centerLat, radiusKm, category, keyword, orderByLike);
	}

}

