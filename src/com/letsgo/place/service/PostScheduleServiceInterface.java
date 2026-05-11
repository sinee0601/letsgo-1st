package com.letsgo.place.service;

import java.util.List;
import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;

public interface PostScheduleServiceInterface {

    boolean deletePostScheduleAndVisitItem(String scheduleId);

    List<PostScheduleVO> getPostScheduleListLike();

    List<PostScheduleVO> getPostScheduleListView();

    List<PostScheduleVO> getPostScheduleListTitle();

    List<PostScheduleVO> getPostScheduleListLatest();

    List<PostScheduleVO> getPostScheduleListLike(String keyword);

    List<PostScheduleVO> getPostScheduleListView(String keyword);

    List<PostScheduleVO> getPostScheduleListTitle(String keyword);

    List<PostScheduleVO> getPostScheduleListLatest(String keyword);

    List<PostScheduleVO> getUserPostScheduleListLike(String userId);

    List<PostScheduleVO> getUserPostScheduleListView(String userId);

    List<PostScheduleVO> getUserPostScheduleListTitle(String userId);

    List<PostScheduleVO> getUserPostScheduleListLatest(String userId);

    List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword);

    List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword);

    List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword);

    List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword);

    String getBudgetDetail(String postId);

    String getTodoDetail(String postId);

    List<RouteScheduleVO> getScheduleRoute(String postId);

    List<MapScheduleVO> getMapSchedule(String postId);

    String getScheduleTitle(String postId);

    int getLikeCount(String postId);

    int getViewCount(String postId);

    boolean plusLike(String postId);

    boolean plusView(String postId);

    String getUserId(String postId);

    boolean addToMySchedule(String postId, String userId);
}
