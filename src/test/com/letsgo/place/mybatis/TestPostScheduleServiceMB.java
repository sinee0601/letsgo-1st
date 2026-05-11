package test.com.letsgo.place.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.vo.PostScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.mybatis.service.PostScheduleServiceMB;


public class TestPostScheduleServiceMB {

	private PostScheduleServiceMB service;

	@Before
	public void setup() throws Exception {
		service = new PostScheduleServiceMB();
	}



	@Test
	public void getPostScheduleListLike() {
		assertNotNull(service.getPostScheduleListLike());
	}

	@Test
	public void getPostScheduleListView() {
		assertNotNull(service.getPostScheduleListView());
	}

	@Test
	public void getPostScheduleListTitle() {
		assertNotNull(service.getPostScheduleListTitle());
	}

	@Test
	public void getPostScheduleListLatest() {
		assertNotNull(service.getPostScheduleListLatest());
	}


	@Test
	public void getPostScheduleListLikeKeyword() {
		assertNotNull(service.getPostScheduleListLike("여의도"));
	}

	@Test
	public void getPostScheduleListViewKeyword() {
		assertNotNull(service.getPostScheduleListView("여의도"));
	}

	@Test
	public void getPostScheduleListTitleKeyword() {
		assertNotNull(service.getPostScheduleListTitle("여의도"));
	}

	@Test
	public void getPostScheduleListLatestKeyword() {
		assertNotNull(service.getPostScheduleListLatest("여의도"));
	}





	@Test
	public void getUserPostScheduleListLike() {
		assertNotNull(service.getUserPostScheduleListLike("user01"));
	}

	@Test
	public void getUserPostScheduleListView() {
		assertNotNull(service.getUserPostScheduleListView("user01"));
	}

	@Test
	public void getUserPostScheduleListTitle() {
		assertNotNull(service.getUserPostScheduleListTitle("user01"));
	}

	@Test
	public void getUserPostScheduleListLatest() {
		assertNotNull(service.getUserPostScheduleListLatest("user01"));
	}

	@Test
	public void getUserPostScheduleListLikeKeyword() {
		assertNotNull(service.getUserPostScheduleListLike("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListViewKeyword() {
		assertNotNull(service.getUserPostScheduleListView("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListTitleKeyword() {
		assertNotNull(service.getUserPostScheduleListTitle("user01", "여의도"));
	}

	@Test
	public void getUserPostScheduleListLatestKeyword() {
		assertNotNull(service.getUserPostScheduleListLatest("user01", "여의도"));
	}


	@Test
	public void getBudgetDetail() {
		assertEquals("삼겹살 마구 먹기", service.getBudgetDetail("P027"));
	}

	@Test
	public void getTodoDetail() {
		assertEquals("햄부기 사냥함부기", service.getTodoDetail("P027"));
	}

	@Test
	public void getScheduleRoute() {
		List<RouteScheduleVO> list = service.getScheduleRoute("P027");
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void getMapSchedule() {
		List<MapScheduleVO> mapList = service.getMapSchedule("P027");
		assertNotNull(mapList);
	}

	@Test
	public void getScheduleTitle() {
		assertNotNull(service.getScheduleTitle("P027"));
	}

	@Test
	public void getLikeCount() {
		assertTrue(service.getLikeCount("P027") >= 0);
	}

	@Test
	public void getViewCount() {
		assertTrue(service.getViewCount("P027") >= 0);
	}

	@Test
	public void getUserId() {
		assertNotNull(service.getUserId("P027"));
	}


	@Test
	public void deletePostSchedule() {
		assertTrue(service.deletePostScheduleAndVisitItem("P013"));
	}

	@Test
	public void plusLike() {
		int before = service.getLikeCount("P027");
		assertTrue(service.plusLike("P027"));
		assertEquals(before + 1, service.getLikeCount("P027"));
	}

	@Test
	public void plusView() {
		int before = service.getViewCount("P027");
		assertTrue(service.plusView("P027"));
		assertEquals(before + 1, service.getViewCount("P027"));
	}

	@Test
	public void addToMySchedule() {
		assertTrue(service.addToMySchedule("P040", "mskk0410"));
	}

}
