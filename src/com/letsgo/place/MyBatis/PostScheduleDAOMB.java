package com.letsgo.place.MyBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.PostScheduleDAOInterface;
import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class PostScheduleDAOMB implements PostScheduleDAOInterface {

	private SqlSession session;
	
	public PostScheduleDAOMB(SqlSession session){
		this.session = session;
	}
		
	@Override
	public List<PostScheduleVO> getPostScheduleListLike() {
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLike(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListView(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListTitle(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getPostScheduleListLatest(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBudgetDetail(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTodoDetail(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RouteScheduleVO> getScheduleRoute(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapScheduleVO> getMapSchedule(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getScheduleTitle(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePostSchedule(String postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVisitItem(String postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLikeCount(String postId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getViewCount(String postId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean plusLike(String postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean plusView(String postId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUserId(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String copyToMySchedule(String title, String budgetDetail, String todoDetail, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean copyToVisitItem(String myScheduleId, RouteScheduleVO route) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
