package com.letsgo.place.mybatis.service;

import com.letsgo.place.service.PlaceServiceInterface;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.PlaceDAOInterface;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.model.vo.VisitItemVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.PlaceDAOMB;

public class PlaceServiceMB implements PlaceServiceInterface {

	private PlaceDAOInterface dao;
	private SqlSession session;

	public PlaceServiceMB() {
		session = DBCPMybatis.getSqlSession();
		dao = new PlaceDAOMB(session);
	}

	@Override
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		return dao.getPlaceByTitle(placeType, title);
	}

	@Override
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		return dao.getPlaceByCategory(placeType, lclssystm3);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		return dao.getPlaceOrderByLike(placeType);
	}

	@Override
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		return dao.getPlaceOrderByTitle(placeType);
	}

	@Override
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		return dao.getPlaceByAddr(placeType, addr);
	}

	@Override
	public List<PlaceVO> getPlace(String placeId) {
		return dao.getPlace(placeId);
	}

	@Override
	public int getPlaceCount(String placeType) {
		return dao.getPlaceCount(placeType);
	}

	@Override
	public boolean setPlaceLikeCount(String placeId) {
		boolean result = dao.setPlaceLikeCount(placeId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public int getPlaceLikeCount(String placeType, String placeId) {
		return dao.getPlaceLikeCount(placeType, placeId);
	}

	@Override
	public List<PlaceVO> getPlaces() {
		return dao.getPlaces();
	}

	@Override
	public boolean insertVisitItem(int visitOrder, int distanceToNext,
			String placeId, String scheduleId, String scheduleType) {
		boolean result = dao.insertVisitItem(visitOrder, distanceToNext, placeId, scheduleId, scheduleType);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		return dao.getLeisurePlacesOrderByLikeDesc();
	}

	@Override
	public List<PlaceVO> getLeisurePlaces() {
		return dao.getLeisurePlaces();
	}

	@Override
	public boolean setCounting(String postId) {
		boolean result = dao.setCounting(postId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public PlaceVO getPlaceById(String placeId) {
		return dao.getPlaceById(placeId);
	}

	@Override
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		return dao.getVisitItemsByScheduleId(scheduleId);
	}

	@Override
	public PlaceVO getPlaceByPlaceId(String placeId) {
		return dao.getPlaceByPlaceId(placeId);
	}

	@Override
	public List<PlaceVO> searchPlaces(String placeType, String category, String keyword, String sortType) {
		return null;
	}
}




