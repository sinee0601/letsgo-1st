package com.letsgo.place.MyBatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.DBCPMyBatis.DBCPMybatis;
import com.letsgo.place.model.PlaceDAOInterface;
import com.letsgo.place.model.PlaceVO;
import com.letsgo.place.model.VisitItemVO;

public class PlaceDAOMB implements PlaceDAOInterface {



	@Override// 이름으로 플레이스 조회 
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		try (SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession()) {
			Map<String, Object> params = new HashMap<>();
			params.put("placeType", placeType);
			params.put("title", title);
			return session.selectList("PlaceMapper.getPlaceByTitle", params);
		}
	}

	@Override// 카테고리로 플레이스 조회
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		try(SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession()){
			Map<String, Object> params = new HashMap<>();
			params.put("placetype", placeType);
			params.put("lclssystm3", lclssystm3);
			return session.selectList("PlaceMapper.getPlaceByCategory", params);
		}
	}

	@Override// 좋아요 순으로 플레이스 조회
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		try (SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession()){
			Map<String, Object> params = new HashMap<>();
			params.put("placetype", placeType);
			return session.selectList("PlaceMapper.getPlaceByCategory", params);
		}
	}

	@Override// 이름 순으로 플레이스 조회
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override// 지역으로 플레이스 조회
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override// 플레이스 담기
	public List<PlaceVO> getPlace(String placeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override// 플레이스 타입별 전체 개수 조회
	public int getPlaceCount(String placeType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override// 좋아요 수 증가
	public boolean setPlaceLikeCount(String placeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override// 플레이스 좋아요 수 조회
	public int getPlaceLikeCount(String placeType, String placeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override// 전체 장소 목록 및 좌표 조회ㅜㅜ
	public List<PlaceVO> getPlaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertVisitItem(int visitOrder, int distanceToNext, String placeId, String scheduleId,
			String scheduleType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getLeisurePlaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setCounting(String postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlaceVO getPlaceById(String placeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaceVO getPlaceByPlaceId(String placeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
