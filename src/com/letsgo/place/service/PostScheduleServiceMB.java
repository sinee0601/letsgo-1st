package com.letsgo.place.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.DBCPMyBatis.DBCPMybatis;
import com.letsgo.place.MyBatis.PostScheduleDAOMB;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.PostScheduleDAOInterface;
import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class PostScheduleServiceMB implements PostScheduleServiceInterface {

	private PostScheduleDAOInterface dao;
	private SqlSession session;

	public PostScheduleServiceMB() {
		session = DBCPMybatis.getSqlSession();
		dao = new PostScheduleDAOMB(session);
	}

	@Override
	public boolean deletePostScheduleAndVisitItem(String scheduleId) {
		boolean result = dao.deletePostSchedule(scheduleId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLike() {
		return dao.getPostScheduleListLike();
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView() {
		return dao.getPostScheduleListView();
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle() {
		return dao.getPostScheduleListTitle();
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest() {
		return dao.getPostScheduleListLatest();
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLike(String keyword) {
		return dao.getPostScheduleListLike(keyword);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView(String keyword) {
		return dao.getPostScheduleListView(keyword);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle(String keyword) {
		return dao.getPostScheduleListTitle(keyword);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest(String keyword) {
		return dao.getPostScheduleListLatest(keyword);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId) {
		return dao.getUserPostScheduleListLike(userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId) {
		return dao.getUserPostScheduleListView(userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId) {
		return dao.getUserPostScheduleListTitle(userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId) {
		return dao.getUserPostScheduleListLatest(userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword) {
		return dao.getUserPostScheduleListLike(userId, keyword);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword) {
		return dao.getUserPostScheduleListView(userId, keyword);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword) {
		return dao.getUserPostScheduleListTitle(userId, keyword);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword) {
		return dao.getUserPostScheduleListLatest(userId, keyword);
	}

	@Override
	public String getBudgetDetail(String postId) {
		return dao.getBudgetDetail(postId);
	}

	@Override
	public String getTodoDetail(String postId) {
		return dao.getTodoDetail(postId);
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String postId) {
		return dao.getScheduleRoute(postId);
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String postId) {
		return dao.getMapSchedule(postId);
	}

	@Override
	public String getScheduleTitle(String postId) {
		return dao.getScheduleTitle(postId);
	}

	@Override
	public int getLikeCount(String postId) {
		return dao.getLikeCount(postId);
	}

	@Override
	public int getViewCount(String postId) {
		return dao.getViewCount(postId);
	}

	@Override
	public boolean plusLike(String postId) {
		boolean result = dao.plusLike(postId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean plusView(String postId) {
		boolean result = dao.plusView(postId);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public String getUserId(String postId) {
		return dao.getUserId(postId);
	}

	@Override
	public boolean addToMySchedule(String postId, String userId) {
		List<RouteScheduleVO> routes = dao.getScheduleRoute(postId);
		String title = dao.getScheduleTitle(postId);
		String budgetDetail = dao.getBudgetDetail(postId);
		String todoDetail = dao.getTodoDetail(postId);

		String myScheduleId = dao.copyToMySchedule(title, budgetDetail, todoDetail, userId);
		if (myScheduleId == null) {
			session.rollback();
			return false;
		}

		if (routes != null && !routes.isEmpty()) {
			for (RouteScheduleVO route : routes) {
				if (!dao.copyToVisitItem(myScheduleId, route)) {
					session.rollback();
					return false;
				}
			}
		}

		session.commit();
		return true;
	}
}
