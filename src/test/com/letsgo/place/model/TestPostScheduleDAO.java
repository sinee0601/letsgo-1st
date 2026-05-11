package test.com.letsgo.place.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.dao.DBCP;
import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.dao.PostScheduleDAO;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;

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
		assertNotNull(dao.getPostScheduleListLike());
		assertNotNull(dao.getPostScheduleListView()); 
		assertNotNull(dao.getPostScheduleListTitle()); 
		assertNotNull(dao.getPostScheduleListLatest()); 
		assertNotNull(dao.getPostScheduleListLike("서울")); 
		assertNotNull(dao.getPostScheduleListView("다래")); 
		assertNotNull(dao.getPostScheduleListTitle("다래")); 
		assertNotNull(dao.getPostScheduleListLatest("다래")); 

		}
	@Test
	public void getUserPostScheduleList() {
		List<PostScheduleVO> list;
		assertNotNull(dao.getUserPostScheduleListLike("user01")); 
		assertNotNull(dao.getUserPostScheduleListView("user01")); 
		assertNotNull(dao.getUserPostScheduleListTitle("user01")); 
		assertNotNull(dao.getUserPostScheduleListLatest("user01")); 
		assertNotNull(dao.getUserPostScheduleListLike("user01", "여의도")); 
		assertNotNull(dao.getUserPostScheduleListView("user01", "여의도"));
		assertNotNull(dao.getUserPostScheduleListTitle("user01", "여의도")); 
		assertNotNull(dao.getUserPostScheduleListLatest("user01", "여의도")); 
		
	}
	
	@Test
	public void getBudgetDetailTest() throws Exception {
		assertEquals("삼겹살 마구 먹기", dao.getBudgetDetail("P027"));
	}
	
	@Test
	public void getTodoDetailTest() {
		assertEquals("햄부기 사냥함부기", dao.getTodoDetail("P027"));
	}

	@Test
	public void getScheduleRoute() {
		List<RouteScheduleVO> list = dao.getScheduleRoute("P091");
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getMapSchedule() {
		List<MapScheduleVO> mapList = dao.getMapSchedule("P091");
		assertNotNull(mapList);
		assertFalse(mapList.isEmpty());
	}
	
	@Test
	public void getScheduleTitle() {
		assertNotNull(dao.getScheduleTitle("P012"));
	}
	

	
	@Test
	public void getLikeCount() {
		assertTrue(dao.getLikeCount("P091") >= 0);
	}
	

	@Test
	public void getViewCount() {
		assertTrue(dao.getViewCount("P091") >= 0); 
	}
	
	@Test
	public void getUserId() {
		assertNotNull(dao.getUserId("P091"));
	}
	
	@Test
	public void deletePostSchedule() {
	assertTrue(dao.deletePostSchedule("P012"));
	}
	
	@Test
	public void plusLike() {
		int before = dao.getLikeCount("P091");
		assertTrue(dao.plusLike("P091"));
		assertEquals(before + 1, dao.getLikeCount("P091"));
	}
	
	@Test
	public void plusView() {
		int before = dao.getViewCount("P091");
		assertTrue(dao.plusView("P091"));
		assertEquals(before + 1, dao.getViewCount("P091"));
	}
	
	
	@Test
	public void copyToMySchedule()  {
		String generatedId = dao.copyToMySchedule("여의도 대탐방", "삼겹살 마구 먹기", "햄부기 사냥함부기", "user01");
		assertNotNull(generatedId);
		assertTrue(generatedId.startsWith("SCH"));
	}
	
	@Test
	public void copyToVisitItem() {
		String myScheduleId = dao.copyToMySchedule("새 제목 테스트", "삼겹살 마구 먹기", "햄부기 사냥하기", "mskk0410");
		assertNotNull(myScheduleId);
		List<RouteScheduleVO> routes = dao.getScheduleRoute("P091");
		assertFalse(routes.isEmpty());
		for (RouteScheduleVO route : routes) {
			assertTrue(dao.copyToVisitItem(myScheduleId, route));
		}
	}
	


}

