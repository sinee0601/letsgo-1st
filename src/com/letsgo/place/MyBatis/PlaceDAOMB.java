package com.letsgo.place.MyBatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.PlaceDAOInterface;
import com.letsgo.place.model.PlaceVO;
import com.letsgo.place.model.VisitItemVO;

public class PlaceDAOMB implements PlaceDAOInterface {

	private SqlSession session;

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
		params.put("placetype", placeType);
		params.put("lclssystm3", lclssystm3);
		return session.selectList("PlaceMapper.getPlaceByCategory", params);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		Map<String, Object> params = new HashMap<>();
		params.put("placetype", placeType);
		return session.selectList("PlaceMapper.getPlaceByCategory", params);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		return null;
	}

	@Override
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		return null;
	}

	@Override
	public List<PlaceVO> getPlace(String placeId) {
		return null;
	}

	@Override
	public int getPlaceCount(String placeType) {
		return 0;
	}

	@Override
	public boolean setPlaceLikeCount(String placeId) {
		return false;
	}

	@Override
	public int getPlaceLikeCount(String placeType, String placeId) {
		return 0;
	}

	@Override
	public List<PlaceVO> getPlaces() {
		return null;
	}

	@Override
	public boolean insertVisitItem(int visitOrder, int distanceToNext, String placeId, String scheduleId,
			String scheduleType) {
		return false;
	}

	@Override
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		return null;
	}

	@Override
	public List<PlaceVO> getLeisurePlaces() {
		return null;
	}

	@Override
	public boolean setCounting(String postId) {
		return false;
	}

	@Override
	public PlaceVO getPlaceById(String placeId) {
		return null;
	}

	@Override
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		return null;
	}

	@Override
	public PlaceVO getPlaceByPlaceId(String placeId) {
		return null;
	}
}
