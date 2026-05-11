package com.letsgo.place.mybatis.service;

import com.letsgo.place.service.PlaceServiceInterface;

import java.util.List;
import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.PlaceDAOInterface;
import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.model.vo.VisitItemVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.PlaceDAOMB;

public class PlaceServiceMB implements PlaceServiceInterface {

	public PlaceServiceMB() {
	}

	@Override
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		return executeRead(dao -> dao.getPlaceByTitle(placeType, title));
	}

	@Override
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		return executeRead(dao -> dao.getPlaceByCategory(placeType, lclssystm3));
	}

	@Override
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		return executeRead(dao -> dao.getPlaceOrderByLike(placeType));
	}

	@Override
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		return executeRead(dao -> dao.getPlaceOrderByTitle(placeType));
	}

	@Override
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		return executeRead(dao -> dao.getPlaceByAddr(placeType, addr));
	}

	@Override
	public List<PlaceVO> getPlace(String placeId) {
		return executeRead(dao -> dao.getPlace(placeId));
	}

	@Override
	public int getPlaceCount(String placeType) {
		return executeRead(dao -> dao.getPlaceCount(placeType));
	}

	@Override
	public boolean setPlaceLikeCount(String placeId) {
		return executeWrite(dao -> dao.setPlaceLikeCount(placeId));
	}

	@Override
	public int getPlaceLikeCount(String placeType, String placeId) {
		return executeRead(dao -> dao.getPlaceLikeCount(placeType, placeId));
	}

	@Override
	public List<PlaceVO> getPlaces() {
		return executeRead(PlaceDAOInterface::getPlaces);
	}

	@Override
	public boolean insertVisitItem(int visitOrder, int distanceToNext,
			String placeId, String scheduleId, String scheduleType) {
		return executeWrite(dao -> dao.insertVisitItem(visitOrder, distanceToNext, placeId, scheduleId, scheduleType));
	}

	@Override
	public List<PlaceVO> getLeisurePlacesOrderByLikeDesc() {
		return executeRead(PlaceDAOInterface::getLeisurePlacesOrderByLikeDesc);
	}

	@Override
	public List<PlaceVO> getLeisurePlaces() {
		return executeRead(PlaceDAOInterface::getLeisurePlaces);
	}

	@Override
	public boolean setCounting(String postId) {
		return executeWrite(dao -> dao.setCounting(postId));
	}

	@Override
	public PlaceVO getPlaceById(String placeId) {
		return executeRead(dao -> dao.getPlaceById(placeId));
	}

	@Override
	public List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId) {
		return executeRead(dao -> dao.getVisitItemsByScheduleId(scheduleId));
	}

	@Override
	public PlaceVO getPlaceByPlaceId(String placeId) {
		return executeRead(dao -> dao.getPlaceByPlaceId(placeId));
	}

	@Override
	public List<PlaceVO> searchPlacesOrderByTitle(String placeType) {
		return executeRead(dao -> dao.searchPlacesOrderByTitle(placeType));
	}

	@Override
	public List<PlaceVO> searchPlacesOrderByLike(String placeType) {
		return executeRead(dao -> dao.searchPlacesOrderByLike(placeType));
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryOrderByTitle(String placeType, String category) {
		return executeRead(dao -> dao.searchPlacesByCategoryOrderByTitle(placeType, category));
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryOrderByLike(String placeType, String category) {
		return executeRead(dao -> dao.searchPlacesByCategoryOrderByLike(placeType, category));
	}

	@Override
	public List<PlaceVO> searchPlacesByKeywordOrderByTitle(String placeType, String keyword) {
		return executeRead(dao -> dao.searchPlacesByKeywordOrderByTitle(placeType, keyword));
	}

	@Override
	public List<PlaceVO> searchPlacesByKeywordOrderByLike(String placeType, String keyword) {
		return executeRead(dao -> dao.searchPlacesByKeywordOrderByLike(placeType, keyword));
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByTitle(String placeType, String category,
			String keyword) {
		return executeRead(dao -> dao.searchPlacesByCategoryAndKeywordOrderByTitle(placeType, category, keyword));
	}

	@Override
	public List<PlaceVO> searchPlacesByCategoryAndKeywordOrderByLike(String placeType, String category, String keyword) {
		return executeRead(dao -> dao.searchPlacesByCategoryAndKeywordOrderByLike(placeType, category, keyword));
	}

	//조회 공통 처리
	private <T> T executeRead(Function<PlaceDAOInterface, T> action) {
		return withSession(session -> {
			PlaceDAOInterface dao = new PlaceDAOMB(session);
			return action.apply(dao);
		});
	}

	//수정 공통 처리
	private boolean executeWrite(Function<PlaceDAOInterface, Boolean> action) {
		return withSession(session -> {
			PlaceDAOInterface dao = new PlaceDAOMB(session);
			boolean result = action.apply(dao);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		});
	}

	//세션 생성/ 닫기
	private <T> T withSession(Function<SqlSession, T> action) {
		try (SqlSession session = DBCPMybatis.getSqlSession()) {
			return action.apply(session);
		}
	}
}
