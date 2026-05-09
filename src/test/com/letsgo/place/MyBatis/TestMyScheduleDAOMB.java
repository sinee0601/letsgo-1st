package test.com.letsgo.place.MyBatis;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.DBCPMyBatis.DBCPMybatis;
import com.letsgo.place.MyBatis.MyScheduleDAOMB;
import com.letsgo.place.model.ColleagueVO;
import com.letsgo.place.model.MapScheduleVO;
import com.letsgo.place.model.MyScheduleVO;
import com.letsgo.place.model.RouteScheduleVO;

public class TestMyScheduleDAOMB {

	private MyScheduleDAOMB dao;
	private SqlSession session;

	@Before
	public void setup() {
		session = DBCPMybatis.getSqlSession();
		dao = new MyScheduleDAOMB(session);
	}

	@After
	public void tearDown() {
		if (session != null) {
			session.rollback();
			session.close();
		}
	}

	@Test
	public void getMyScheduleListAllByDate_existingUser_returnsNonNull() {
		List<MyScheduleVO> result = dao.getMyScheduleListAllByDate("user01");
		assertNotNull(result);
	}

	@Test
	public void getMyScheduleListAllByDate_existingUser_returnsItems() {
		List<MyScheduleVO> result = dao.getMyScheduleListAllByDate("user01");
		assertFalse("user01", result.isEmpty());
	}

	@Test
	public void getMyScheduleListAllByDate_voFieldsNotNull() {
		List<MyScheduleVO> result = dao.getMyScheduleListAllByDate("user01");
		MyScheduleVO first = result.get(0);
		assertNotNull("myScheduleId가 null이면 안 됩니다", first.getMyScheduleId());
		assertNotNull("myScheduleTitle이 null이면 안 됩니다", first.getMyScheduleTitle());
	}

	@Test
	public void getMyScheduleListAllByDate_nonexistentUser_returnsEmptyList() {
		List<MyScheduleVO> result = dao.getMyScheduleListAllByDate("noSuchUser9999");
		assertNotNull(result);
		assertTrue("존재하지 않는 사용자는 빈 목록이어야 합니다", result.isEmpty());
	}

	@Test
	public void getMyScheduleListAllByTitleTest() {
		List<MyScheduleVO> result = dao.getMyScheduleListAllByTitle("user01");
		assertNotNull(result);
	}

	@Test
	public void getMyScheduleListSharedByDateTest() {
		assertNotNull(dao.getMyScheduleListSharedByDate("user01"));
	}

	@Test
	public void getMyScheduleListSharedByTitleTest() {
		assertNotNull(dao.getMyScheduleListSharedByTitle("user01"));
	}

	@Test
	public void getMyScheduleListSearchByDateTest() {
		assertNotNull(dao.getMyScheduleListSearchByDate("user01", "서대문"));
		assertNotNull(dao.getMyScheduleListSearchByDate("user01", ""));
	}

	@Test
	public void getMyScheduleListTest() {
		assertNotNull(dao.getMyScheduleList("user01", "서대문", "title", false));
		assertNotNull(dao.getMyScheduleList("user01", "", "title", false));
		assertNotNull(dao.getMyScheduleList("user01", null, "date", true));
	}

	@Test
	public void deleteMyScheduleTest() {
		assertTrue(dao.deleteMySchedule("SCH022"));
	}

	@Test
	public void deleteMyScheduleListTest() {
		String[] ids = { "SCH001", "SCH002" };
		assertTrue(dao.deleteMyScheduleList("user01", ids));
	}

	@Test
	public void setMyScheduleTest() {
		String[] visitItemIds = { "4", "5", "6" };
		int[] visitOrders = { 3, 2, 1 };
		String[] distanceToNexts = { "64", "23", "35" };
		assertTrue(dao.setMySchedule(visitItemIds, visitOrders, distanceToNexts,
				"SCH002", "여의도 대탐방", "26/05/15",
				"삼겹살 마구 먹기", "햄부기 사냥하기", "user01", 1));
	}

	@Test
	public void setAndGetTodoDetailTest() {
		assertTrue(dao.setTodoDetail("SCH002", "햄부기 사냥함부기"));
		assertEquals("햄부기 사냥함부기", dao.getTodoDetail("SCH002"));
	}

	@Test
	public void setAndGetBudgetDetailTest() {
		assertTrue(dao.setBudgetDetail("SCH002", "1인당 2만원"));
		assertEquals("1인당 2만원", dao.getBudgetDetail("SCH002"));
	}

	@Test
	public void getScheduleTitleTest() {
		assertNotNull(dao.getScheduleTitle("SCH001"));
	}

	@Test
	public void getStartAtTest() {
		assertNotNull(dao.getStartAt("SCH001"));
	}

	@Test
	public void setStartAtTest() {
		assertTrue(dao.setStartAt("SCH002", "2026-05-15", "user01"));
	}

	@Test
	public void setMyScheduleTitleTest() {
		assertTrue(dao.setMyScheduleTitle("새 제목 테스트", "SCH002", "user01"));
	}

	@Test
	public void isScheduleOwnedByUserTest() {
		assertTrue(dao.isScheduleOwnedByUser("SCH001", "user01"));
		assertFalse(dao.isScheduleOwnedByUser("SCH001", "user99"));
	}

	@Test
	public void listMyScheduleIdAndTitleTest() {
		List<String[]> list = dao.listMyScheduleIdAndTitle("user01");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertNotNull(list.get(0)[0]);
		assertNotNull(list.get(0)[1]);
	}

	@Test
	public void getScheduleRouteTest() {
		List<RouteScheduleVO> list = dao.getScheduleRoute("SCH001");
		assertNotNull(list);
	}

	@Test
	public void getMapScheduleTest() {
		List<MapScheduleVO> list = dao.getMapSchedule("SCH001");
		assertNotNull(list);
	}

	@Test
	public void addVisitItemTest() {
		assertTrue(dao.addVisitItem(5, "1", "SCH011"));
	}

	@Test
	public void deleteVisitItemByIdTest() {
		assertFalse(dao.deleteVisitItemById("1"));
	}

	@Test
	public void addCompanionTest() {
		assertTrue(dao.addCompanion("SCH002", "user06"));
	}

	@Test
	public void setCompanionPermissionTest() {
		assertFalse(dao.setCompanionPermission("SCH002", "user01", "R"));
	}

	@Test
	public void getCompanionListTest() {
		List<ColleagueVO> list = dao.getCompanionList("SCH001");
		assertNotNull(list);
	}

	@Test
	public void shareToPostTest() throws Exception {
		String result = dao.shareToPost("SCH002", "user01", 0);
		assertEquals("SCH002", result);
	}

	@Test
	public void allocateNextMyScheduleIdTest() {
		String id = dao.allocateNextMyScheduleId();
		assertNotNull(id);
		assertTrue("ID는 SCH로 시작해야 합니다", id.startsWith("SCH"));
	}

	@Test
	public void insertMyScheduleRowTest() {
		String id = dao.allocateNextMyScheduleId();
		assertNotNull(id);
		assertTrue(dao.insertMyScheduleRow(id, "테스트 일정", "user01"));
	}

}
