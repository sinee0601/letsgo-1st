package com.letsgo.place.service;

import java.util.List;
import com.letsgo.place.model.ColleagueVO;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.MyScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public interface MyScheduleServiceInterface {

	List<MyScheduleVO> getMyScheduleListAllByDate(String userId);

	List<MyScheduleVO> getMyScheduleListAllByTitle(String userId);

	List<MyScheduleVO> getMyScheduleListSharedByDate(String userId);

	List<MyScheduleVO> getMyScheduleListSharedByTitle(String userId);

	List<MyScheduleVO> getMyScheduleListSearchByDate(String userId, String keyword);

	List<MyScheduleVO> getMyScheduleListSearchByTitle(String userId, String keyword);

	List<MyScheduleVO> getMyScheduleListSearchSharedByDate(String userId, String keyword);

	List<MyScheduleVO> getMyScheduleListSearchSharedByTitle(String userId, String keyword);

	boolean deleteMySchedule(String scheduleId);

	boolean deleteMyScheduleList(String userId, String[] scheduleIds);

	boolean setMySchedule(String[] visitItemId, int[] visitOrder, String[] distanceToNext, String scheduleId,
			String scheduleTitle, String startAt, String budgetDetail, String todoDetail, String userId, int isShared);

	boolean updateVisitOrders(String[] visitItemIds, int[] visitOrders, String[] distances);

	boolean setMyScheduleTitle(String title, String myScheduleId, String userId);

	String getStartAt(String scheduleId);

	boolean setStartAt(String scheduleId, String startAt, String userId);

	boolean setTodoDetail(String scheduleId, String todoDetail);

	String getTodoDetail(String scheduleId);

	List<RouteScheduleVO> getScheduleRoute(String scheduleId);

	List<MapScheduleVO> getMapSchedule(String scheduleId);

	boolean addVisitItem(int visitOrder, String placeId, String scheduleId);

	boolean deleteVisitItemById(String visitItemId);

	boolean addCompanion(String myScheduleId, String sharedUserId);

	boolean setCompanionPermission(String myScheduleId, String sharedUserId, String permission);

	List<ColleagueVO> getCompanionList(String myScheduleId);

	String shareToPost(String myScheduleId, String userId, int isAnonymous);

	String getBudgetDetail(String scheduleId);

	boolean setBudgetDetail(String scheduleId, String budgetDetail);

	String getScheduleTitle(String scheduleId);

	List<String[]> listMyScheduleIdAndTitle(String userId);

	MyScheduleService.NewScheduleFromCartResult createNewScheduleFromCartPlaces(String userId, List<String> placeIds,
			String title);

	List<String> addCartPlacesToSchedule(String userId, String scheduleId, List<String> placeIds);
}