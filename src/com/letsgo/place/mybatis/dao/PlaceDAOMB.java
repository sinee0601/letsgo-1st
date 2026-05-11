package com.letsgo.place.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.PlaceDAOInterface;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.model.vo.VisitItemVO;


public class PlaceDAOMB implements PlaceDAOInterface {
	private final SqlSession session;

	public PlaceDAOMB(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("title", title);
		return session.selectList("PlaceMapper.getPlaceByTitle", params);
	}

	@Override
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("lclssystm3", lclssystm3);
		return session.selectList("PlaceMapper.getPlaceByCategory", params);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		return session.selectList("PlaceMapper.getPlaceOrderByLike", params);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		return session.selectList("PlaceMapper.getPlaceOrderByTitle", params);
	}

	@Override
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("addrPattern", "%" + addr + "%");
		return session.selectList("PlaceMapper.getPlaceByAddr", params);
	}

	@Override
	public List<PlaceVO> getPlace(String placeId) {
		return session.selectList("PlaceMapper.getPlaceByPlaceIdList", placeId);
	}

	@Override
	public int getPlaceCount(String placeType) {
		Integer count = session.selectOne("PlaceMapper.getPlaceCount", placeType);
		return count != null ? count : 0;
	}

	@Override
	public boolean setPlaceLikeCount(String placeId) {
		int rows = session.update("PlaceMapper.setPlaceLikeCount", placeId);
		return rows > 0;
	}

	@Override
	public int getPlaceLikeCount(String placeType, String placeId) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("placeId", placeId);
		Integer count = session.selectOne("PlaceMapper.getPlaceLikeCount", params);
		return count != null ? count : 0;
	}

	@Override
	public List<PlaceVO> getPlaces() {
		return session.selectList("PlaceMapper.getPlaces");
	}

	@Override
	public boolean insertVisitItem(int visitOrder, int distanceToNext, String placeId, String scheduleId,
			String scheduleType) {
		Map<String, Object> params = new HashMap<>();
		params.put("visitOrder", visitOrder);
		params.put("distanceToNext", distanceToNext);
		params.put("placeId", placeId);
		params.put("scheduleId", scheduleId);
		params.put("scheduleType", scheduleType);
		int rows = session.insert("PlaceMapper.insertVisitItem", params);
		return rows > 0;
	}

	@Override
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		return session.selectList("PlaceMapper.getLeisurePlacesOrderByLikeDesc");
	}

	@Override
	public List<PlaceVO> getLeisurePlaces() {
		return session.selectList("PlaceMapper.getLeisurePlaces");
	}

	@Override
	public boolean setCounting(String placeId) {
		int rows = session.update("PlaceMapper.setCounting", placeId);
		return rows > 0;
	}

	@Override
	public PlaceVO getPlaceById(String placeId) {
		return session.selectOne("PlaceMapper.getPlaceById", placeId);
	}

	@Override
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		return session.selectList("PlaceMapper.getVisitItemsByScheduleId", scheduleId);
	}

	@Override
	public List<PlaceVO> searchPlacesOrderByTitle(String placeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		return session.selectList("PlaceMapper.searchPlacesOrderByTitle", params);
	}

	@Override
	public List<PlaceVO> searchPlacesOrderByLike(String placeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		return session.selectList("PlaceMapper.searchPlacesOrderByLike", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryOrderByTitle(String placeType, String category) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("category", category);
		return session.selectList("PlaceMapper.searchPlacesByCategoryOrderByTitle", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryOrderByLike(String placeType, String category) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("category", category);
		return session.selectList("PlaceMapper.searchPlacesByCategoryOrderByLike", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByKeywordOrderByTitle(String placeType, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("keywordPattern", "%" + keyword + "%");
		return session.selectList("PlaceMapper.searchPlacesByKeywordOrderByTitle", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByKeywordOrderByLike(String placeType, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("keywordPattern", "%" + keyword + "%");
		return session.selectList("PlaceMapper.searchPlacesByKeywordOrderByLike", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByTitle(String placeType, String category, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("category", category);
		params.put("keywordPattern", "%" + keyword + "%");
		return session.selectList("PlaceMapper.searchPlacesByCategoryAndKeywordOrderByTitle", params);
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByLike(String placeType, String category, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("placeType", placeType);
		params.put("category", category);
		params.put("keywordPattern", "%" + keyword + "%");
		return session.selectList("PlaceMapper.searchPlacesByCategoryAndKeywordOrderByLike", params);
	}

	@Override
	public PlaceVO getPlaceByPlaceId(String placeId) {
		return session.selectOne("PlaceMapper.getPlaceByPlaceId", placeId);
	}

}
