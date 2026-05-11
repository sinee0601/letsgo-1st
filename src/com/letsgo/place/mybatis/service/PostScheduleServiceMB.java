package com.letsgo.place.mybatis.service;

import com.letsgo.place.service.PostScheduleServiceInterface;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.dao.PostScheduleDAOInterface;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.PostScheduleDAOMB;

public class PostScheduleServiceMB implements PostScheduleServiceInterface {

	public boolean deletePostScheduleAndVisitItem(String scheduleId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			dao.deleteVisitItem(scheduleId);
			dao.deletePostSchedule(scheduleId);
			session.commit();
			return true;
		} catch (Exception e) {
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public List<PostScheduleVO> getPostScheduleList(String sortOrder, String keyword) {
		if (sortOrder == null || sortOrder.trim().isEmpty()) {
			sortOrder = "latest";
		}
		if (keyword == null || keyword.trim().isEmpty()) {
			switch (sortOrder) {
				case "like":  return getPostScheduleListLike();
				case "view":  return getPostScheduleListView();
				case "title": return getPostScheduleListTitle();
				default:      return getPostScheduleListLatest();
			}
		} else {
			switch (sortOrder) {
				case "like":  return getPostScheduleListLike(keyword);
				case "view":  return getPostScheduleListView(keyword);
				case "title": return getPostScheduleListTitle(keyword);
				default:      return getPostScheduleListLatest(keyword);
			}
		}
	}

	public List<PostScheduleVO> getUserPostScheduleList(String userId, String sortOrder, String keyword) {
		if (sortOrder == null || sortOrder.trim().isEmpty()) {
			sortOrder = "latest";
		}
		if (keyword == null || keyword.trim().isEmpty()) {
			switch (sortOrder) {
				case "like":  return getUserPostScheduleListLike(userId);
				case "view":  return getUserPostScheduleListView(userId);
				case "title": return getUserPostScheduleListTitle(userId);
				default:      return getUserPostScheduleListLatest(userId);
			}
		} else {
			switch (sortOrder) {
				case "like":  return getUserPostScheduleListLike(userId, keyword);
				case "view":  return getUserPostScheduleListView(userId, keyword);
				case "title": return getUserPostScheduleListTitle(userId, keyword);
				default:      return getUserPostScheduleListLatest(userId, keyword);
			}
		}
	}

	public List<PostScheduleVO> getPostScheduleListLike() {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListLike();
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListView() {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListView();
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListTitle() {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListTitle();
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListLatest() {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListLatest();
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListLike(String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListLike(keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListView(String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListView(keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListTitle(String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListTitle(keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getPostScheduleListLatest(String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getPostScheduleListLatest(keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListLike(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListLike(userId);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListView(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListView(userId);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListTitle(userId);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListLatest(userId);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListLike(userId, keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListView(userId, keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListTitle(userId, keyword);
		session.close();
		return result;
	}

	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<PostScheduleVO> result = dao.getUserPostScheduleListLatest(userId, keyword);
		session.close();
		return result;
	}

	public String getBudgetDetail(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		String result = dao.getBudgetDetail(postId);
		session.close();
		return result;
	}

	public String getTodoDetail(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		String result = dao.getTodoDetail(postId);
		session.close();
		return result;
	}

	public List<RouteScheduleVO> getScheduleRoute(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<RouteScheduleVO> result = dao.getScheduleRoute(postId);
		session.close();
		return result;
	}

	public List<MapScheduleVO> getMapSchedule(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		List<MapScheduleVO> result = dao.getMapSchedule(postId);
		session.close();
		return result;
	}

	public String getScheduleTitle(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
	    String result = dao.getScheduleTitle(postId);
		session.close();
		return result;
	}

	public int getLikeCount(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			return dao.getLikeCount(postId);
		} finally {
			session.close();
		}
	}

	public int getViewCount(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			return dao.getViewCount(postId);
		} finally {
			session.close();
		}
	}

	public boolean plusLike(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			boolean result = dao.plusLike(postId);
			session.commit();
			return result;
		} catch (Exception e) {
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean plusView(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			boolean result = dao.plusView(postId);
			session.commit();
			return result;
		} catch (Exception e) {
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public String getUserId(String postId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			return dao.getUserId(postId);
		} finally {
			session.close();
		}
	}

	public boolean addToMySchedule(String postId, String userId) {
		SqlSession session = DBCPMybatis.getSqlSession();
		PostScheduleDAOInterface dao = new PostScheduleDAOMB(session);
		try {
			String title        = dao.getScheduleTitle(postId);
			String budgetDetail = dao.getBudgetDetail(postId);
			String todoDetail   = dao.getTodoDetail(postId);
			List<RouteScheduleVO> routes = dao.getScheduleRoute(postId);
			String myScheduleId = dao.copyToMySchedule(title, budgetDetail, todoDetail, userId);
			for (RouteScheduleVO route : routes) {
				dao.copyToVisitItem(myScheduleId, route);
			}
			session.commit();
			return true;
		} catch (Exception e) {
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}
}
