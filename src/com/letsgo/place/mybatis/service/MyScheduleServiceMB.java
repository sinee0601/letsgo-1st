package com.letsgo.place.mybatis.service;

import com.letsgo.place.service.MyScheduleServiceInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.vo.ColleagueVO;
import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.dao.MyScheduleDAOInterface;
import com.letsgo.place.model.vo.MyScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.MyScheduleDAOMB;
import com.letsgo.place.service.MyScheduleService.NewScheduleFromCartResult;

public class MyScheduleServiceMB implements MyScheduleServiceInterface {

	public MyScheduleServiceMB() {
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByDate(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListAllByDate(userId);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByTitle(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListAllByTitle(userId);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByDate(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSharedByDate(userId);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByTitle(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSharedByTitle(userId);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByDate(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSearchByDate(userId, keyword);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByTitle(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSearchByTitle(userId, keyword);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByDate(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSearchSharedByDate(userId, keyword);
		session.close();
		return result;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByTitle(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MyScheduleVO> result = dao.getMyScheduleListSearchSharedByTitle(userId, keyword);
		session.close();
		return result;
	}

	@Override
	public String getStartAt(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		String result = dao.getStartAt(scheduleId);
		session.close();
		return result;
	}

	@Override
	public String getTodoDetail(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		String result = dao.getTodoDetail(scheduleId);
		session.close();
		return result;
	}

	@Override
	public String getBudgetDetail(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		String result = dao.getBudgetDetail(scheduleId);
		session.close();
		return result;
	}

	@Override
	public String getScheduleTitle(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		String result = dao.getScheduleTitle(scheduleId);
		session.close();
		return result;
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<RouteScheduleVO> result = dao.getScheduleRoute(scheduleId);
		session.close();
		return result;
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<MapScheduleVO> result = dao.getMapSchedule(scheduleId);
		session.close();
		return result;
	}

	@Override
	public List<ColleagueVO> getCompanionList(String myScheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<ColleagueVO> result = dao.getCompanionList(myScheduleId);
		session.close();
		return result;
	}

	@Override
	public List<String[]> listMyScheduleIdAndTitle(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		List<String[]> result = dao.listMyScheduleIdAndTitle(userId);
		session.close();
		return result;
	}

	@Override
	public boolean deleteMySchedule(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.deleteMySchedule(scheduleId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean deleteMyScheduleList(String userId, String[] scheduleIds) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.deleteMyScheduleList(userId, scheduleIds);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setMySchedule(String[] visitItemId, int[] visitOrder, String[] distanceToNext, String scheduleId,
			String scheduleTitle, String startAt, String budgetDetail, String todoDetail, String userId, int isShared) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setMySchedule(visitItemId, visitOrder, distanceToNext, scheduleId,
				scheduleTitle, startAt, budgetDetail, todoDetail, userId, isShared);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean updateVisitOrders(String[] visitItemIds, int[] visitOrders, String[] distances) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.updateVisitOrders(visitItemIds, visitOrders, distances);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setMyScheduleTitle(String title, String myScheduleId, String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setMyScheduleTitle(title, myScheduleId, userId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setStartAt(String scheduleId, String startAt, String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setStartAt(scheduleId, startAt, userId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setTodoDetail(String scheduleId, String todoDetail) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setTodoDetail(scheduleId, todoDetail);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setBudgetDetail(String scheduleId, String budgetDetail) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setBudgetDetail(scheduleId, budgetDetail);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean addVisitItem(int visitOrder, String placeId, String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.addVisitItem(visitOrder, placeId, scheduleId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean deleteVisitItemById(String visitItemId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.deleteVisitItemById(visitItemId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean addCompanion(String myScheduleId, String sharedUserId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.addCompanion(myScheduleId, sharedUserId);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public boolean setCompanionPermission(String myScheduleId, String sharedUserId, String permission) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		boolean result = dao.setCompanionPermission(myScheduleId, sharedUserId, permission);
		if (result) session.commit();
		else        session.rollback();
		session.close();
		return result;
	}

	@Override
	public String shareToPost(String myScheduleId, String userId, int isAnonymous) {
		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		String result = null;
		try {
			result = dao.shareToPost(myScheduleId, userId, isAnonymous);
			session.commit();
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public NewScheduleFromCartResult createNewScheduleFromCartPlaces(String userId, List<String> placeIds,
			String title) {
		List<String> ordered = new ArrayList<>();
		if (placeIds != null) {
			for (String pid : placeIds) {
				if (pid != null) {
					String t = pid.trim();
					if (!t.isEmpty())
						ordered.add(t);
				}
			}
		}
		if (ordered.isEmpty())
			return null;

		String scheduleTitle = (title != null && !title.trim().isEmpty()) ? title.trim() : "카트에서 만든 여행";

		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		try {
			String newId = dao.allocateNextMyScheduleId();
			if (newId == null || !dao.insertMyScheduleRow(newId, scheduleTitle, userId)) {
				session.rollback();
				session.close();
				return null;
			}
			int visitOrder = 0;
			for (String placeId : ordered) {
				if (!dao.addVisitItem(++visitOrder, placeId, newId)) {
					session.rollback();
					session.close();
					return null;
				}
			}
			session.commit();
			session.close();
			return new NewScheduleFromCartResult(newId, new ArrayList<>(ordered));
		} catch (Exception e) {
			session.rollback();
			session.close();
			throw e;
		}
	}

	@Override
	public List<String> addCartPlacesToSchedule(String userId, String scheduleId, List<String> placeIds) {
		if (scheduleId == null || scheduleId.trim().isEmpty() || placeIds == null || placeIds.isEmpty())
			return new ArrayList<>();

		SqlSession session = DBCPMybatis.getSqlSession();
		MyScheduleDAOInterface dao = new MyScheduleDAOMB(session);
		try {
			if (!dao.isScheduleOwnedByUser(scheduleId, userId)) {
				session.close();
				return null;
			}

			List<RouteScheduleVO> route = dao.getScheduleRoute(scheduleId);
			Set<String> existing = new HashSet<>();
			int maxOrder = 0;
			if (route != null) {
				for (RouteScheduleVO r : route) {
					if (r.getPlaceId() != null)
						existing.add(r.getPlaceId());
					try {
						int o = Integer.parseInt(r.getVisitOrder());
						if (o > maxOrder) maxOrder = o;
					} catch (NumberFormatException ignored) {
					}
				}
			}

			List<String> addedIds = new ArrayList<>();
			int nextOrder = maxOrder;
			for (String placeId : placeIds) {
				if (placeId == null || placeId.trim().isEmpty()) continue;
				if (existing.contains(placeId)) continue;
				if (!dao.addVisitItem(++nextOrder, placeId, scheduleId)) {
					session.rollback();
					session.close();
					return null;
				}
				existing.add(placeId);
				addedIds.add(placeId);
			}
			session.commit();
			session.close();
			return addedIds;
		} catch (Exception e) {
			session.rollback();
			session.close();
			throw e;
		}
	}

}
