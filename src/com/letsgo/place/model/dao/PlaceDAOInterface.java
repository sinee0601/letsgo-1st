package com.letsgo.place.model.dao;

import java.util.List;

import com.letsgo.place.model.vo.PlaceVO;
import com.letsgo.place.model.vo.VisitItemVO;

public interface PlaceDAOInterface {
    List<PlaceVO> getPlaceByTitle(String placeType, String title);

    List<PlaceVO> getPlaceByCategory(String placeType, String lclssystm3);

    List<PlaceVO> getPlaceOrderByLike(String placeType);

    List<PlaceVO> getPlaceOrderByTitle(String placeType);

    List<PlaceVO> getPlaceByAddr(String placeType, String addr);

    List<PlaceVO> getPlace(String placeId);

    int getPlaceCount(String placeType);

    boolean setPlaceLikeCount(String placeId);

    int getPlaceLikeCount(String placeType, String placeId);

    List<PlaceVO> getPlaces();

    boolean insertVisitItem(int visitOrder, int distanceToNext,
            String placeId, String scheduleId, String scheduleType);

    List<PlaceVO> getLeisurePlacesOrderByLikeDesc();

    List<PlaceVO> getLeisurePlaces();

    boolean setCounting(String postId);

    PlaceVO getPlaceById(String placeId);

    List<VisitItemVO> getVisitItemsByScheduleId(String scheduleId);

    PlaceVO getPlaceByPlaceId(String placeId);
}
