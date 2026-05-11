package test.com.letsgo.place.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.PostScheduleDAOMB;


public class TestPostScheduleDAOMB {

	SqlSession session;
	PostScheduleDAOMB dao;

	@Before
	public void setup() throws Exception {
		session = DBCPMybatis.getSqlSession();
		dao = new PostScheduleDAOMB(session);
	}


	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.rollback();
			session.close();
		}
	}

	@Test
	public void getPostScheduleListLike() {
		List<PostScheduleVO> list = dao.getPostScheduleListLike();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getPostScheduleListView() {
		List<PostScheduleVO> list = dao.getPostScheduleListView();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getPostScheduleListTitle() {
		List<PostScheduleVO> list = dao.getPostScheduleListTitle();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getPostScheduleListLatest() {
		List<PostScheduleVO> list = dao.getPostScheduleListLatest();
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getPostScheduleListLikeKeyword() {
		assertNotNull(dao.getPostScheduleListLike("여의도"));
	}

	@Test
	public void getPostScheduleListViewKeyword() {  
		assertNotNull(dao.getPostScheduleListView("여의도"));
	}

	@Test
	public void getPostScheduleListTitleKeyword() {
		assertNotNull(dao.getPostScheduleListTitle("여의도"));
	}

	@Test
	public void getPostScheduleListLatestKeyword() {
		assertNotNull(dao.getPostScheduleListLatest("여의도"));
	}


	@Test
	public void getUserPostScheduleListLike() {
		assertNotNull(dao.getUserPostScheduleListLike("user01"));
	}

	@Test
	public void getUserPostScheduleListView() {
		assertNotNull(dao.getUserPostScheduleListView("user01"));
	}

	@Test
	public void getUserPostScheduleListTitle() {
		assertNotNull(dao.getUserPostScheduleListTitle("user01"));
	}

	@Test
	public void getUserPostScheduleListLatest() {
		assertNotNull(dao.getUserPostScheduleListLatest("user01"));
	}

	@Test
	public void getUserPostScheduleListLikeKeyword() {
		assertNotNull(dao.getUserPostScheduleListLike("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListViewKeyword() {
		assertNotNull(dao.getUserPostScheduleListView("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListTitleKeyword() {
		assertNotNull(dao.getUserPostScheduleListTitle("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListLatestKeyword() {
		assertNotNull(dao.getUserPostScheduleListLatest("user01", "여의도"));
	}


	@Test
	public void getBudgetDetail() {
		assertEquals("삼겹살 마구 먹기", dao.getBudgetDetail("P027"));
	}

	@Test
	public void getTodoDetail() {
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
	public void copyToMySchedule() {
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
