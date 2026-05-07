package com.letsgo.place.MyBatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.DBCPMybatis.DBCPMybatis;
import com.letsgo.place.model.ColleagueVO;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.MyScheduleDAOInterface;
import com.letsgo.place.model.MyScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class MyScheduleDAOMB implements MyScheduleDAOInterface {

	@Override//이건 빡세니까 나중에
	public List<MyScheduleVO> getMyScheduleList(String userId, String keyword, String sortType, boolean sharedFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMySchedule(String scheduleId) {
		SqlSession session=
				DBCPMybatis.getSqlSessionFactory().openSession();
		return false;
	}

	@Override
	public boolean deleteMyScheduleList(String userId, String[] scheduleIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setMySchedule(String[] visitItemId, int[] visitOrder, String[] distanceToNext, String scheduleId,
			String scheduleTitle, String startAt, String budgetDetail, String todoDetail, String userId, int isShared) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVisitOrders(String[] visitItemIds, int[] visitOrders, String[] distances) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setMyScheduleTitle(String title, String myScheduleId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTodoDetail(String scheduleId, String todoDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTodoDetail(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBudgetDetail(String scheduleId, String budgetDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getBudgetDetail(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScheduleTitle(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStartAt(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setStartAt(String scheduleId, String startAt, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String allocateNextMyScheduleId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertMyScheduleRow(String myScheduleId, String title, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isScheduleOwnedByUser(String scheduleId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String[]> listMyScheduleIdAndTitle(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVisitItem(int visitOrder, String placeId, String scheduleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVisitItemById(String visitItemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCompanion(String myScheduleId, String sharedUserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCompanionPermission(String myScheduleId, String sharedUserId, String permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ColleagueVO> getCompanionList(String myScheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shareToPost(String myScheduleId, String userId, int isAnonymous) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
