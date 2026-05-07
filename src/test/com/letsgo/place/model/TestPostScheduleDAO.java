package test.com.letsgo.place.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.DBCP;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.PostScheduleDAO;
import com.letsgo.place.model.PostScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class TestPostScheduleDAO {
	private PostScheduleDAO dao;
	private Connection conn;
	
	@Before
	public void setup() throws Exception {
		conn = DBCP.getConnection();
		conn.setAutoCommit(false);
		dao = new PostScheduleDAO(conn);
	}
	
	@After
	public void tearDown() throws Exception {
		if (conn != null) {
			conn.rollback();
			conn.close();
		}
	}
	
	@Test
	public void getPostScheduleList() {
		List<PostScheduleVO> list;
		assertNotNull(dao.getPostScheduleListLike()); //게시물 일정 전체 불러오기
		assertNotNull(dao.getPostScheduleListView()); //게시물 일정 전체 불러오기
		assertNotNull(dao.getPostScheduleListTitle()); //게시물 일정 전체 불러오기
		assertNotNull(dao.getPostScheduleListLatest()); //게시물 일정 전체 불러오기
		assertNotNull(dao.getPostScheduleListLike("서울")); ///게시물 일정 이름으로 검색하기
		assertNotNull(dao.getPostScheduleListView("다래")); //게시물 일정 상세 플레이스명(장소)으로 검색하기
		assertNotNull(dao.getPostScheduleListTitle("다래")); //게시물 이름으로 정렬하기
		assertNotNull(dao.getPostScheduleListLatest("다래")); //게시물 조회순으로 정렬하기
		
		System.out.println(list = dao.getPostScheduleListLike());
		System.out.println(list = dao.getPostScheduleListView());
		System.out.println(list = dao.getPostScheduleListTitle());
		System.out.println(list = dao.getPostScheduleListLatest());
		System.out.println(list = dao.getPostScheduleListLike("서울"));
		System.out.println(list = dao.getPostScheduleListView("다래"));
		System.out.println(list = dao.getPostScheduleListTitle("다래"));
		System.out.println(list = dao.getPostScheduleListLatest("다래"));

		}
	@Test
	public void getUserPostScheduleList() {
		List<PostScheduleVO> list;
		assertNotNull(dao.getUserPostScheduleListLike("user01")); //내가 올린 게시물 일정 전체 불러오기
		assertNotNull(dao.getUserPostScheduleListView("user01")); //내가 올린 게시물 일정 전체 불러오기
		assertNotNull(dao.getUserPostScheduleListTitle("user01")); //내가 올린 게시물 일정 전체 불러오기
		assertNotNull(dao.getUserPostScheduleListLatest("user01")); //내가 올린 게시물 일정 전체 불러오기
		assertNotNull(dao.getUserPostScheduleListLike("user01", "서울")); //내가 올린 게시물 일정 이름으로 검색하기
		assertNotNull(dao.getUserPostScheduleListView("user01", "다래")); //내가 올린 게시물 일정 상세 플레이스명(장소)으로 검색하기
		assertNotNull(dao.getUserPostScheduleListTitle("user01", "서울")); //내가 올린 게시물 이름으로 정렬하기
		assertNotNull(dao.getUserPostScheduleListLatest("user01", "서울")); //내가 올린 게시물 조회순으로 정렬하기
		
		System.out.println(dao.getUserPostScheduleListLike("user01"));
		System.out.println(dao.getUserPostScheduleListView("user01"));
		System.out.println(dao.getUserPostScheduleListTitle("user01"));
		System.out.println(dao.getUserPostScheduleListLatest("user01"));
		System.out.println(dao.getUserPostScheduleListLike("user01", "서울"));
		System.out.println(dao.getUserPostScheduleListView("user01", "서울"));
		System.out.println(dao.getUserPostScheduleListTitle("user01", "다래"));
		System.out.println(dao.getUserPostScheduleListLatest("user01", "서울"));
	}
	
	@Test
	public void getBudgetDetailTest() throws Exception {
		assertEquals("삼겹살 마구 먹기", dao.getBudgetDetail("P023"));
		assertNotEquals("삼겹살 마구 먹기", dao.getBudgetDetail("P023"));
	}
	
	@Test
	public void getTodoDetailTest() throws Exception {
		assertEquals("햄부기 사냥함부기", dao.getTodoDetail("P023"));
		assertNotEquals("햄부기 사냥햄부기", dao.getTodoDetail("P023"));
	}

	@Test
	public void getScheduleRouteTest() throws Exception {
		assertEquals(new ArrayList<RouteScheduleVO>(), dao.getScheduleRoute("P023"));
		
		assertNotNull(dao.getScheduleRoute("P023"));
	}

	@Test
	public void getMapScheduleVOTest() throws Exception {
		List<MapScheduleVO> mapList = dao.getMapSchedule("P023");
		assertNotNull(mapList);
	}
	
	@Test
	public void getScheduleTitle() {
		assertNotNull(dao.getScheduleTitle("P001"));
	}
	
	@Test
	public void deletePostSchedule() {
	assertTrue(dao.deletePostSchedule("P002"));
	}
	
	@Test
	public void getLikeCount() {
		assertNotNull(dao.getLikeCount("P001"));
	}
	
	@Test
	public void getViewCount() {
		assertNotNull(dao.getViewCount("P001"));
	}
	
	@Test
	public void plusLike() {
		assertTrue(dao.plusLike("P003"));
	}
	
	@Test
	public void plusView() {
		assertTrue(dao.plusView("P003"));
	}
	
	@Test
	public void getUserId() {
		assertNotNull(dao.getUserId("P001"));
	}
	
	@Test
	public void copyToMySchedule()  {
		assertNotNull(dao.copyToMySchedule("", "", "", "user02"));
	}
	
	@Test
	public void copyToVisitItem() {
		RouteScheduleVO route;
		//assertNotNull(dao.copyToVisitItem(null, null));
	}
	


}
