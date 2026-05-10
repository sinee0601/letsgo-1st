package com.letsgo.place.MyBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.ColleagueVO;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.MyScheduleDAOInterface;
import com.letsgo.place.model.MyScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class MyScheduleDAOMB implements MyScheduleDAOInterface {

	private SqlSession session;

	public MyScheduleDAOMB(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByDate(String userId) {
		return session.selectList("myScheduleMapper.getMyScheduleListAllByDate", userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListAllByTitle(String userId) {
		return session.selectList("myScheduleMapper.getMyScheduleListAllByTitle", userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByDate(String userId) {
		return session.selectList("myScheduleMapper.getMyScheduleListSharedByDate", userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSharedByTitle(String userId) {
		return session.selectList("myScheduleMapper.getMyScheduleListSharedByTitle", userId);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByDate(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", keyword);
		return session.selectList("myScheduleMapper.getMyScheduleListSearchByDate", params);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchByTitle(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", keyword);
		return session.selectList("myScheduleMapper.getMyScheduleListSearchByTitle", params);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByDate(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", keyword);
		return session.selectList("myScheduleMapper.getMyScheduleListSearchSharedByDate", params);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleListSearchSharedByTitle(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", keyword);
		return session.selectList("myScheduleMapper.getMyScheduleListSearchSharedByTitle", params);
	}

	@Override
	public List<MyScheduleVO> getMyScheduleList(String userId, String keyword, String sortType, boolean sharedFilter) {
		boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", hasKeyword ? keyword : null);
		params.put("sharedFilter", sharedFilter);
		params.put("sortType", sortType);
		return session.selectList("myScheduleMapper.getMyScheduleList", params);
	}

	@Override
	public boolean deleteMySchedule(String scheduleId) {
		session.delete("myScheduleMapper.deleteVisitItemsByScheduleId", scheduleId);
		return session.delete("myScheduleMapper.deleteScheduleById", scheduleId) == 1;
	}

	@Override
	public boolean deleteMyScheduleList(String userId, String[] scheduleIds) {
		boolean flag = false;
		for (String schId : scheduleIds) {
			session.delete("myScheduleMapper.deleteVisitItemsByScheduleId", schId);
			Map<String, Object> params = new HashMap<>();
			params.put("scheduleId", schId);
			params.put("userId", userId);
			flag = session.delete("myScheduleMapper.deleteScheduleByIdAndUserId", params) == 1;
		}
		return flag;
	}

	@Override
	public boolean setMySchedule(String[] visitItemId, int[] visitOrder, String[] distanceToNext,
			String scheduleId, String scheduleTitle, String startAt,
			String budgetDetail, String todoDetail, String userId, int isShared) {
		for (int i = 0; i < visitItemId.length; i++) {
			Map<String, Object> itemParams = new HashMap<>();
			itemParams.put("visitOrder", visitOrder[i]);
			itemParams.put("distanceToNext", distanceToNext[i]);
			itemParams.put("visitItemId", visitItemId[i]);
			session.update("myScheduleMapper.updateVisitItem", itemParams);
		}
		Map<String, Object> scheduleParams = new HashMap<>();
		scheduleParams.put("scheduleTitle", scheduleTitle);
		scheduleParams.put("startAt", startAt);
		scheduleParams.put("budgetDetail", budgetDetail);
		scheduleParams.put("todoDetail", todoDetail);
		scheduleParams.put("isShared", isShared);
		scheduleParams.put("scheduleId", scheduleId);
		scheduleParams.put("userId", userId);
		return session.update("myScheduleMapper.updateSchedule", scheduleParams) == 1;
	}

	@Override
	public boolean updateVisitOrders(String[] visitItemIds, int[] visitOrders, String[] distances) {
		for (int i = 0; i < visitItemIds.length; i++) {
			Map<String, Object> params = new HashMap<>();
			params.put("visitOrder", visitOrders[i]);
			params.put("distanceToNext", distances[i]);
			params.put("visitItemId", visitItemIds[i]);
			session.update("myScheduleMapper.updateVisitItem", params);
		}
		return true;
	}

	@Override
	public boolean setMyScheduleTitle(String title, String myScheduleId, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("title", title);
		params.put("myScheduleId", myScheduleId);
		params.put("userId", userId);
		return session.update("myScheduleMapper.setMyScheduleTitle", params) == 1;
	}

	@Override
	public boolean setTodoDetail(String scheduleId, String todoDetail) {
		Map<String, Object> params = new HashMap<>();
		params.put("todoDetail", todoDetail);
		params.put("scheduleId", scheduleId);
		return session.update("myScheduleMapper.setTodoDetail", params) == 1;
	}

	@Override
	public String getTodoDetail(String scheduleId) {
		return session.selectOne("myScheduleMapper.getTodoDetail", scheduleId);
	}

	@Override
	public boolean setBudgetDetail(String scheduleId, String budgetDetail) {
		Map<String, Object> params = new HashMap<>();
		params.put("budgetDetail", budgetDetail);
		params.put("scheduleId", scheduleId);
		return session.update("myScheduleMapper.setBudgetDetail", params) == 1;
	}

	@Override
	public String getBudgetDetail(String scheduleId) {
		return session.selectOne("myScheduleMapper.getBudgetDetail", scheduleId);
	}

	@Override
	public String getScheduleTitle(String scheduleId) {
		return session.selectOne("myScheduleMapper.getScheduleTitle", scheduleId);
	}

	@Override
	public String getStartAt(String scheduleId) {
		return session.selectOne("myScheduleMapper.getStartAt", scheduleId);
	}

	@Override
	public boolean setStartAt(String scheduleId, String startAt, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("startAt", startAt);
		params.put("scheduleId", scheduleId);
		params.put("userId", userId);
		return session.update("myScheduleMapper.setStartAt", params) == 1;
	}

	@Override
	public String allocateNextMyScheduleId() {
		for (int i = 0; i < 100; i++) {
			String id = session.selectOne("myScheduleMapper.getNextMyScheduleIdCandidate");
			Integer count = session.selectOne("myScheduleMapper.checkMyScheduleIdExists", id);
			if (count == null || count == 0)
				return id;
		}
		return null;
	}

	@Override
	public boolean insertMyScheduleRow(String myScheduleId, String title, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("myScheduleId", myScheduleId);
		params.put("title", title);
		params.put("userId", userId);
		return session.insert("myScheduleMapper.insertMyScheduleRow", params) == 1;
	}

	@Override
	public boolean isScheduleOwnedByUser(String scheduleId, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("scheduleId", scheduleId);
		params.put("userId", userId);
		Integer count = session.selectOne("myScheduleMapper.isScheduleOwnedByUser", params);
		return count != null && count > 0;
	}

	@Override
	public List<String[]> listMyScheduleIdAndTitle(String userId) {
		List<Map<String, Object>> rows = session.selectList("myScheduleMapper.listMyScheduleIdAndTitle", userId);
		List<String[]> list = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			list.add(new String[] {
				String.valueOf(row.get("MY_SCHEDULE_ID")),
				String.valueOf(row.get("TITLE"))
			});
		}
		return list;
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String scheduleId) {
		return session.selectList("myScheduleMapper.getScheduleRoute", scheduleId);
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String scheduleId) {
		return session.selectList("myScheduleMapper.getMapSchedule", scheduleId);
	}

	@Override
	public boolean addVisitItem(int visitOrder, String placeId, String scheduleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("visitOrder", visitOrder);
		params.put("placeId", placeId);
		params.put("scheduleId", scheduleId);
		return session.insert("myScheduleMapper.addVisitItem", params) == 1;
	}

	@Override
	public boolean deleteVisitItemById(String visitItemId) {
		return session.delete("myScheduleMapper.deleteVisitItemById", visitItemId) == 1;
	}

	@Override
	public boolean addCompanion(String myScheduleId, String sharedUserId) {
		Map<String, Object> params = new HashMap<>();
		params.put("myScheduleId", myScheduleId);
		params.put("sharedUserId", sharedUserId);
		return session.insert("myScheduleMapper.addCompanion", params) == 1;
	}

	@Override
	public boolean setCompanionPermission(String myScheduleId, String sharedUserId, String permission) {
		Map<String, Object> params = new HashMap<>();
		params.put("permission", permission);
		params.put("myScheduleId", myScheduleId);
		params.put("sharedUserId", sharedUserId);
		return session.update("myScheduleMapper.setCompanionPermission", params) == 1;
	}

	@Override
	public List<ColleagueVO> getCompanionList(String myScheduleId) {
		return session.selectList("myScheduleMapper.getCompanionList", myScheduleId);
	}

	@Override
	public String shareToPost(String myScheduleId, String userId, int isAnonymous) throws SQLException {
		Map<String, Object> params = new HashMap<>();
		params.put("isAnonymous", isAnonymous);
		params.put("userId", userId);
		params.put("myScheduleId", myScheduleId);
		session.insert("myScheduleMapper.shareToPostInsert", params);
		session.insert("myScheduleMapper.shareVisitItemsToPost", myScheduleId);
		return myScheduleId;
	}
}
