package test.com.letsgo.place.mybatis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.MyScheduleVO;
import com.letsgo.place.mybatis.service.MyScheduleServiceMB;
import com.letsgo.place.service.MyScheduleService.NewScheduleFromCartResult;

public class TestMyScheduleServiceMB {

	private MyScheduleServiceMB service;

	@Before
	public void setup() {
		service = new MyScheduleServiceMB();
	}

	@Test
	public void getMyScheduleListAllByDate_returnsNonNull() {
		assertNotNull(service.getMyScheduleListAllByDate("user01"));
	}

	@Test
	public void getMyScheduleListAllByDate_existingUser_returnsItems() {
		assertFalse(service.getMyScheduleListAllByDate("user01").isEmpty());
	}

	@Test
	public void getMyScheduleListAllByDate_nonexistentUser_returnsEmpty() {
		List<MyScheduleVO> result = service.getMyScheduleListAllByDate("noSuchUser9999");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	public void getMyScheduleListAllByTitle_returnsNonNull() {
		assertNotNull(service.getMyScheduleListAllByTitle("user01"));
	}

	@Test
	public void getMyScheduleListSharedByDate_returnsNonNull() {
		assertNotNull(service.getMyScheduleListSharedByDate("user01"));
	}

	@Test
	public void getMyScheduleListSharedByTitle_returnsNonNull() {
		assertNotNull(service.getMyScheduleListSharedByTitle("user01"));
	}

	@Test
	public void getMyScheduleListSearchByDate_withKeyword() {
		assertNotNull(service.getMyScheduleListSearchByDate("user01", "서대문"));
	}

	@Test
	public void getMyScheduleListSearchByDate_emptyKeyword() {
		assertNotNull(service.getMyScheduleListSearchByDate("user01", ""));
	}

	@Test
	public void getMyScheduleListSearchByTitle_returnsNonNull() {
		assertNotNull(service.getMyScheduleListSearchByTitle("user01", "서대문"));
	}

	@Test
	public void getMyScheduleListSearchSharedByDate_returnsNonNull() {
		assertNotNull(service.getMyScheduleListSearchSharedByDate("user01", ""));
	}

	@Test
	public void getMyScheduleListSearchSharedByTitle_returnsNonNull() {
		assertNotNull(service.getMyScheduleListSearchSharedByTitle("user01", ""));
	}

	@Test
	public void getStartAt_returnsNonNull() {
		assertNotNull(service.getStartAt("SCH001"));
	}

	@Test
	public void getScheduleTitle_returnsNonNull() {
		assertNotNull(service.getScheduleTitle("SCH001"));
	}

	@Test
	public void getScheduleRoute_returnsNonNull() {
		assertNotNull(service.getScheduleRoute("SCH001"));
	}

	@Test
	public void getMapSchedule_returnsNonNull() {
		assertNotNull(service.getMapSchedule("SCH001"));
	}

	@Test
	public void getCompanionList_returnsNonNull() {
		assertNotNull(service.getCompanionList("SCH001"));
	}

	@Test
	public void listMyScheduleIdAndTitle_returnsNonEmpty() {
		List<String[]> list = service.listMyScheduleIdAndTitle("user01");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertNotNull(list.get(0)[0]);
		assertNotNull(list.get(0)[1]);
	}

	@Test
	public void setAndGetTodoDetail() {
		assertTrue(service.setTodoDetail("SCH002", "햄부기 사냥함부기"));
		assertEquals("햄부기 사냥함부기", service.getTodoDetail("SCH002"));
	}

	@Test
	public void setAndGetBudgetDetail() {
		assertTrue(service.setBudgetDetail("SCH002", "1인당 2만원"));
		assertEquals("1인당 2만원", service.getBudgetDetail("SCH002"));
	}

	@Test
	public void setMyScheduleTitle_success() {
		assertTrue(service.setMyScheduleTitle("새 제목 테스트", "SCH002", "user01"));
	}

	@Test
	public void setStartAt_success() {
		assertTrue(service.setStartAt("SCH002", "2026-05-15", "user01"));
	}

	@Test
	public void setMySchedule_success() {
		String[] visitItemIds = {"4", "5", "6"};
		int[] visitOrders = {3, 2, 1};
		String[] distanceToNexts = {"64", "23", "35"};
		assertTrue(service.setMySchedule(visitItemIds, visitOrders, distanceToNexts,
				"SCH002", "여의도 대탐방", "26/05/15",
				"삼겹살 마구 먹기", "햄부기 사냥하기", "user01", 1));
	}

	@Test
	public void updateVisitOrders_success() {
		String[] visitItemIds = {"4", "5"};
		int[] visitOrders = {1, 2};
		String[] distances = {"100", "200"};
		assertTrue(service.updateVisitOrders(visitItemIds, visitOrders, distances));
	}


	@Test
	public void addVisitItem_success() {
		assertTrue(service.addVisitItem(5, "1", "SCH011"));
	}

	@Test
	public void deleteVisitItemById_nonExistent_returnsFalse() {
		assertFalse(service.deleteVisitItemById("99999"));
	}


	@Test
	public void addCompanion_success() {
		assertTrue(service.addCompanion("SCH002", "user06"));
	}

	@Test
	public void setCompanionPermission_noMatchingRow_returnsFalse() {
		assertFalse(service.setCompanionPermission("SCH002", "user01", "R"));
	}


	@Test
	public void deleteMySchedule_nonExistent_returnsFalse() {
		assertFalse(service.deleteMySchedule("SCH999"));
	}

	@Test
	public void deleteMyScheduleList_nonExistent_returnsFalse() {
		String[] ids = {"SCH066", "SCH077"};
		assertFalse(service.deleteMyScheduleList("user99", ids));
	}


	@Test
	public void shareToPost_success() {
		String result = service.shareToPost("SCH002", "user01", 0);
		assertEquals("SCH002", result);
	}


	@Test
	public void createNewScheduleFromCartPlaces_emptyList_returnsNull() {
		assertNull(service.createNewScheduleFromCartPlaces("user01", new ArrayList<>(), "빈 테스트"));
	}

	@Test
	public void createNewScheduleFromCartPlaces_nullList_returnsNull() {
		assertNull(service.createNewScheduleFromCartPlaces("user01", null, "null 테스트"));
	}

	@Test
	public void createNewScheduleFromCartPlaces_withPlaces_returnsResult() {
		List<String> placeIds = new ArrayList<>();
		placeIds.add("1");
		placeIds.add("2");
		NewScheduleFromCartResult result = service.createNewScheduleFromCartPlaces("user01", placeIds, "카트 테스트 일정");
		assertNotNull(result);
		assertNotNull(result.getScheduleId());
		assertTrue(result.getScheduleId().startsWith("SCH"));
		assertEquals(2, result.getAddedPlaceIds().size());
	}

	@Test
	public void createNewScheduleFromCartPlaces_defaultTitle_whenTitleBlank() {
		List<String> placeIds = new ArrayList<>();
		placeIds.add("1");
		NewScheduleFromCartResult result = service.createNewScheduleFromCartPlaces("user01", placeIds, "  ");
		assertNotNull(result);
		assertNotNull(result.getScheduleId());
	}


	@Test
	public void addCartPlacesToSchedule_emptyScheduleId_returnsEmpty() {
		List<String> placeIds = new ArrayList<>();
		placeIds.add("1");
		List<String> result = service.addCartPlacesToSchedule("user01", "", placeIds);
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	public void addCartPlacesToSchedule_wrongOwner_returnsNull() {
		List<String> placeIds = new ArrayList<>();
		placeIds.add("1");
		assertNull(service.addCartPlacesToSchedule("user99", "SCH001", placeIds));
	}

	@Test
	public void addCartPlacesToSchedule_emptyPlaceIds_returnsEmpty() {
		List<String> result = service.addCartPlacesToSchedule("user01", "SCH001", new ArrayList<>());
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

}

