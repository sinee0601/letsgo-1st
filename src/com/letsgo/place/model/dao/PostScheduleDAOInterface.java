package com.letsgo.place.model.dao;

import java.util.List;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;

public interface PostScheduleDAOInterface {

	// 1, 2. 일정 리스트 조회
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
	
    
    // 3. 예산 및 할일 상세 조회
    String getBudgetDetail(String postId);
    String getTodoDetail(String postId);

    // 4. 경로 및 지도 데이터 조회
    List<RouteScheduleVO> getScheduleRoute(String postId);
    List<MapScheduleVO> getMapSchedule(String postId);

    // 5. 제목 조회
    String getScheduleTitle(String postId);

    // 6. 일정 삭제 (VisitItem과 SchedulePost 연쇄 삭제 대응)
    boolean deletePostSchedule(String postId);
    boolean deleteVisitItem(String postId);

    // 7. 좋아요 및 조회수 조회
    int getLikeCount(String postId);
    int getViewCount(String postId);

    // 8. 좋아요 및 조회수 증가 (성공 시 true)
    boolean plusLike(String postId);
    boolean plusView(String postId);

    // 9. 작성자 ID 조회
    String getUserId(String postId);

    // 10. 내 일정으로 복사 (생성된 PK 문자열 반환)
    String copyToMySchedule(String title, String budgetDetail, String todoDetail, String userId);

    // 11. 방문 항목 복사 (void 유지)
    boolean copyToVisitItem(String myScheduleId, RouteScheduleVO route);
}

