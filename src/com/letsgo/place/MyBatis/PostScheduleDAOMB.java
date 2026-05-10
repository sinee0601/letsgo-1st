package com.letsgo.place.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.dao.PostScheduleDAOInterface;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;

public class PostScheduleDAOMB implements PostScheduleDAOInterface {

	private SqlSession session;

	public PostScheduleDAOMB(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLike() {
		return session.selectList("postScheduleMapper.getPostScheduleListLike");
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView() {
		return session.selectList("postScheduleMapper.getPostScheduleListView");
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle() {
		return session.selectList("postScheduleMapper.getPostScheduleListTitle");
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest() {
		return session.selectList("postScheduleMapper.getPostScheduleListLatest");
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLike(String keyword) {
		String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%" : "%" + keyword + "%";
		return session.selectList("postScheduleMapper.getPostScheduleListSearchLike", searchKey);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView(String keyword) {
		String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%" : "%" + keyword + "%";
		return session.selectList("postScheduleMapper.getPostScheduleListSearchView", searchKey);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle(String keyword) {
		String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%" : "%" + keyword + "%";
		return session.selectList("postScheduleMapper.getPostScheduleListSearchTitle", searchKey);
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest(String keyword) {
		String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%" : "%" + keyword + "%";
		return session.selectList("postScheduleMapper.getPostScheduleListSearchLatest", searchKey);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId) {
		return session.selectList("postScheduleMapper.getUserPostScheduleListLike", userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId) {
		return session.selectList("postScheduleMapper.getUserPostScheduleListView", userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId) {
		return session.selectList("postScheduleMapper.getUserPostScheduleListTitle", userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId) {
		return session.selectList("postScheduleMapper.getUserPostScheduleListLatest", userId);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", "%" + keyword + "%");
		return session.selectList("postScheduleMapper.getUserPostScheduleListSearchLike", params);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", "%" + keyword + "%");
		return session.selectList("postScheduleMapper.getUserPostScheduleListSearchView", params);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", "%" + keyword + "%");
		return session.selectList("postScheduleMapper.getUserPostScheduleListSearchTitle", params);
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("keyword", "%" + keyword + "%");
		return session.selectList("postScheduleMapper.getUserPostScheduleListSearchLatest", params);
	}

	@Override
	public String getBudgetDetail(String postId) {
		return session.selectOne("postScheduleMapper.getBudgetDetail", postId);
	}

	@Override
	public String getTodoDetail(String postId) {
		return session.selectOne("postScheduleMapper.getTodoDetail", postId);
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String postId) {
		return session.selectList("postScheduleMapper.getScheduleRoute", postId);
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String postId) {
		return session.selectList("postScheduleMapper.getMapSchedule", postId);
	}

	@Override
	public String getScheduleTitle(String postId) {
		return session.selectOne("postScheduleMapper.getScheduleTitle", postId);
	}

	@Override
	public boolean deletePostSchedule(String postId) {
		session.delete("postScheduleMapper.deleteVisitItem", postId);
		return session.delete("postScheduleMapper.deleteSchedulePost", postId) == 1;
	}

	@Override
	public boolean deleteVisitItem(String postId) {
		session.delete("postScheduleMapper.deleteVisitItem", postId);
		return true;
	}

	@Override
	public int getLikeCount(String postId) {
		Integer count = session.selectOne("postScheduleMapper.getLikeCount", postId);
		return count != null ? count : 0;
	}

	@Override
	public int getViewCount(String postId) {
		Integer count = session.selectOne("postScheduleMapper.getViewCount", postId);
		return count != null ? count : 0;
	}

	@Override
	public boolean plusLike(String postId) {
		return session.update("postScheduleMapper.plusLike", postId) == 1;
	}

	@Override
	public boolean plusView(String postId) {
		return session.update("postScheduleMapper.plusView", postId) == 1;
	}

	@Override
	public String getUserId(String postId) {
		return session.selectOne("postScheduleMapper.getUserId", postId);
	}

	@Override
	public String copyToMySchedule(String title, String budgetDetail, String todoDetail, String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("title", title);
		params.put("budgetDetail", budgetDetail);
		params.put("todoDetail", todoDetail);
		params.put("userId", userId);
		session.insert("postScheduleMapper.copyToMySchedule", params);
		return (String) params.get("myScheduleId");
	}

	@Override
	public boolean copyToVisitItem(String myScheduleId, RouteScheduleVO route) {
		Map<String, Object> params = new HashMap<>();
		params.put("visitOrder", route.getVisitOrder());
		params.put("distanceToNext", route.getDistanceToNext());
		params.put("placeId", route.getPlaceId());
		params.put("myScheduleId", myScheduleId);
		return session.insert("postScheduleMapper.copyToVisitItem", params) == 1;
	}
}

