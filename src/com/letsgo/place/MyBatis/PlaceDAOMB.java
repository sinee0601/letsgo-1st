package com.letsgo.place.MyBatis;

import java.util.List;

import com.letsgo.place.model.PlaceDAOInterface;
import com.letsgo.place.model.PlaceVO;
import com.letsgo.place.model.VisitItemVO;

public class PlaceDAOMB implements PlaceDAOInterface {

	@Override
	public List<PlaceVO> getPlaceByTitle(String placeType, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getPlaceOrderByLike(String placeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getPlaceOrderByTitle(String placeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getPlaceByAddr(String placeType, String addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceVO> getPlace(String placeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPlaceCount(String placeType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setPlaceLikeCount(String placeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPlaceLikeCount(String placeType, String placeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
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
