package com.letsgo.place.MyBatis;

import java.util.List;

import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.PostScheduleDAOInterface;
import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class PostScheduleDAOMB implements PostScheduleDAOInterface {

	@Override
	public List<PostScheduleVO> getPostScheduleList(String keyword, String sortType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostScheduleVO> getUserPostScheduleList(String userId, String keyword, String sortType) {
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
	public void copyToVisitItem(String myScheduleId, RouteScheduleVO route) {
		// TODO Auto-generated method stub

	}

}
