package com.letsgo.place.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.DBCPMyBatis.DBCPMybatis;
import com.letsgo.place.MyBatis.MyScheduleDAOMB;
import com.letsgo.place.model.ColleagueVO;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.MyScheduleDAOInterface;
import com.letsgo.place.model.MyScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;
import com.letsgo.place.service.MyScheduleService.NewScheduleFromCartResult;

public class MyScheduleServiceMB implements MyScheduleServiceInterface {

	private MyScheduleDAOInterface dao;
	private SqlSession session;

	public MyScheduleServiceMB() {
		session = DBCPMybatis.getSqlSession();
		dao = new MyScheduleDAOMB(session);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByDate(String userId) {
		return dao.getMyScheduleListAllByDate(userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByTitle(String userId) {
		return dao.getMyScheduleListAllByTitle(userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByDate(String userId) {
		return dao.getMyScheduleListSharedByDate(userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByTitle(String userId) {
		return dao.getMyScheduleListSharedByTitle(userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByDate(String userId, String keyword) {
		return dao.getMyScheduleListSearchByDate(userId, keyword);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByTitle(String userId, String keyword) {
		return dao.getMyScheduleListSearchByTitle(userId, keyword);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByDate(String userId, String keyword) {
		return dao.getMyScheduleListSearchSharedByDate(userId, keyword);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByTitle(String userId, String keyword) {
		return dao.getMyScheduleListSearchSharedByTitle(userId, keyword);
	}

	@Override
	public String getStartAt(String scheduleId) {
		return dao.getStartAt(scheduleId);
	}

	@Override
	public String getTodoDetail(String scheduleId) {
		return dao.getTodoDetail(scheduleId);
	}

	@Override
	public String getBudgetDetail(String scheduleId) {
		return dao.getBudgetDetail(scheduleId);
	}

	@Override
	public String getScheduleTitle(String scheduleId) {
		return dao.getScheduleTitle(scheduleId);
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String scheduleId) {
		return dao.getScheduleRoute(scheduleId);
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String scheduleId) {
		return dao.getMapSchedule(scheduleId);
	}

	@Override
	public List<ColleagueVO> getCompanionList(String myScheduleId) {
		return dao.getCompanionList(myScheduleId);
	}

	@Override
	public List<String[]> listMyScheduleIdAndTitle(String userId) {
		return dao.listMyScheduleIdAndTitle(userId);
	}

	@Override
	public boolean deleteMySchedule(String scheduleId) {
		boolean result = dao.deleteMySchedule(scheduleId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean deleteMyScheduleList(String userId, String[] scheduleIds) {
		boolean result = dao.deleteMyScheduleList(userId, scheduleIds);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setMySchedule(String[] visitItemId, int[] visitOrder, String[] distanceToNext,
			String scheduleId, String scheduleTitle, String startAt,
			String budgetDetail, String todoDetail, String userId, int isShared) {
		boolean result = dao.setMySchedule(visitItemId, visitOrder, distanceToNext,
				scheduleId, scheduleTitle, startAt, budgetDetail, todoDetail, userId, isShared);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean updateVisitOrders(String[] visitItemIds, int[] visitOrders, String[] distances) {
		boolean result = dao.updateVisitOrders(visitItemIds, visitOrders, distances);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setMyScheduleTitle(String title, String myScheduleId, String userId) {
		boolean result = dao.setMyScheduleTitle(title, myScheduleId, userId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setStartAt(String scheduleId, String startAt, String userId) {
		boolean result = dao.setStartAt(scheduleId, startAt, userId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setTodoDetail(String scheduleId, String todoDetail) {
		boolean result = dao.setTodoDetail(scheduleId, todoDetail);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setBudgetDetail(String scheduleId, String budgetDetail) {
		boolean result = dao.setBudgetDetail(scheduleId, budgetDetail);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean addVisitItem(int visitOrder, String placeId, String scheduleId) {
		boolean result = dao.addVisitItem(visitOrder, placeId, scheduleId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean deleteVisitItemById(String visitItemId) {
		boolean result = dao.deleteVisitItemById(visitItemId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean addCompanion(String myScheduleId, String sharedUserId) {
		boolean result = dao.addCompanion(myScheduleId, sharedUserId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean setCompanionPermission(String myScheduleId, String sharedUserId, String permission) {
		boolean result = dao.setCompanionPermission(myScheduleId, sharedUserId, permission);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public String shareToPost(String myScheduleId, String userId, int isAnonymous) {
		String result = null;
		try {
			result = dao.shareToPost(myScheduleId, userId, isAnonymous);
			session.commit();
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NewScheduleFromCartResult createNewScheduleFromCartPlaces(String userId, List<String> placeIds, String title) {
		List<String> ordered = new ArrayList<>();
		if (placeIds != null) {
			for (String pid : placeIds) {
				if (pid != null) {
					String t = pid.trim();
					if (!t.isEmpty()) ordered.add(t);
				}
			}
		}
		if (ordered.isEmpty()) return null;

		String scheduleTitle = (title != null && !title.trim().isEmpty()) ? title.trim() : "카트에서 만든 여행";

		String newId = dao.allocateNextMyScheduleId();
		if (newId == null || !dao.insertMyScheduleRow(newId, scheduleTitle, userId)) {
			session.rollback();
			return null;
		}
		int visitOrder = 0;
		for (String placeId : ordered) {
			visitOrder++;
			if (!dao.addVisitItem(visitOrder, placeId, newId)) {
				session.rollback();
				return null;
			}
		}
		session.commit();
		return new NewScheduleFromCartResult(newId, new ArrayList<>(ordered));
	}

	@Override
	public List<String> addCartPlacesToSchedule(String userId, String scheduleId, List<String> placeIds) {
		List<String> addedIds = new ArrayList<>();
		if (scheduleId == null || scheduleId.trim().isEmpty() || placeIds == null || placeIds.isEmpty()) {
			return addedIds;
		}
		if (!dao.isScheduleOwnedByUser(scheduleId, userId)) {
			session.rollback();
			return null;
		}
		List<RouteScheduleVO> route = dao.getScheduleRoute(scheduleId);
		Set<String> existing = new HashSet<>();
		int maxOrder = 0;
		if (route != null) {
			for (RouteScheduleVO r : route) {
				if (r.getPlaceId() != null) existing.add(r.getPlaceId());
				try {
					int o = Integer.parseInt(r.getVisitOrder());
					if (o > maxOrder) maxOrder = o;
				} catch (NumberFormatException ignored) {
				}
			}
		}
		int nextOrder = maxOrder;
		for (String placeId : placeIds) {
			if (placeId == null || placeId.trim().isEmpty()) continue;
			if (existing.contains(placeId)) continue;
			nextOrder++;
			if (!dao.addVisitItem(nextOrder, placeId, scheduleId)) {
				session.rollback();
				return null;
			}
			existing.add(placeId);
			addedIds.add(placeId);
		}
		session.commit();
		return addedIds;
	}

}
