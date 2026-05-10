package test.com.letsgo.place.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.MapScheduleVO;
import com.letsgo.place.model.vo.RouteScheduleVO;
import com.letsgo.place.service.PostScheduleService;


public class TestPostScheduleService {

	private PostScheduleService service;
	
	
	@Before
	public void setup() throws Exception{
		service = new PostScheduleService();
	}
//	
//	@Test
//	public void deletePostSchedule() {
//		assertTrue(service.deletePostScheduleAndVisitItem("P002"));
//	}
//	
//	@Test
//	public void getPostScheduleListLike() {
//		assertNotNull(service.getPostScheduleListLike());
//	}
//	@Test
//	public void getPostScheduleListView() {
//		assertNotNull(service.getPostScheduleListView());
//	}
//	@Test
//	public void getPostScheduleListTitle() {
//		assertNotNull(service.getPostScheduleListTitle());
//	}
//	@Test
//	public void getPostScheduleListLatest() {
//		assertNotNull(service.getPostScheduleListLatest());
//	}
//	@Test
//	public void getPostScheduleListLikeKeyword() {
//		assertNotNull(service.getPostScheduleListLike("다래"));
//	}
//	@Test
//	public void getPostScheduleListViewKeyword() {
//		assertNotNull(service.getPostScheduleListView());
//	}
//	@Test
//	public void getPostScheduleListTitleKeyword() {
//		assertNotNull(service.getPostScheduleListTitle());
//	}
//	@Test
//	public void getPostScheduleListLatestKeyword() {
//		assertNotNull(service.getPostScheduleListLatest());
//	}
//	
//	@Test
//	public void getUserPostScheduleListLike() {
//		assertNotNull(service.getUserPostScheduleListLike("user01"));
//	}
//	@Test
//	public void getUserPostScheduleListView() {
//		assertNotNull(service.getUserPostScheduleListView("user01"));
//	}
//	@Test
//	public void getUserPostScheduleListTitle() {
//		assertNotNull(service.getUserPostScheduleListTitle("user01"));
//	}
//	@Test
//	public void getUserPostScheduleListLatest() {
//		assertNotNull(service.getUserPostScheduleListLatest("user01"));
//	}
//	@Test
//	public void getUserPostScheduleListLikeKeyword() {
//		assertNotNull(service.getUserPostScheduleListLike("user01",""));
//	}
//	@Test
//	public void getUserPostScheduleListViewKeyword() {
//		assertNotNull(service.getUserPostScheduleListView("user01",""));
//	}
//	@Test
//	public void getUserPostScheduleListTitleKeyword() {
//		assertNotNull(service.getUserPostScheduleListTitle("user01",""));
//	}
//	@Test
//	public void getUserPostScheduleListLatestKeyword() {
//		assertNotNull(service.getUserPostScheduleListLatest("user01",""));
//	}
//	
//	@Test
//	public void getBudgetDetail() {
//		assertEquals("삼겹살 마구 먹기", service.getBudgetDetail("P023"));
//		//assertNotEquals("삼겹살 마구 먹기", service.getBudgetDetail("P023"));
//	}
//	
//	@Test
//	public void getTodoDetail() {
//		assertEquals("햄부기 사냥함부기", service.getTodoDetail("P023"));
//		//assertNotEquals("햄부기 사냥햄부기", service.getTodoDetail("P023"));
//	}
//	
//	@Test
//	public void getScheduleRoute() {
//		//assertEquals(new ArrayList<RouteScheduleVO>(), service.getScheduleRoute("P023"));
//		System.out.println(service.getScheduleRoute("P023"));
//			
//	}
//	
//	@Test
//	public void getMapSchedule() {
//		List<MapScheduleVO> mapList = service.getMapSchedule("P023");
//		assertNotNull(mapList);
//	}
//	
//	@Test
//	public void getScheduleTitle() {
//		assertNotNull(service.getScheduleTitle("P023"));
//	}
//	
//	@Test
//	public void getLikeCount() {
//		assertNotNull(service.getLikeCount("P001"));
//	}
//	
//	@Test
//	public void getViewCount() {
//		assertNotNull(service.getViewCount("P001"));
//	}
//	
//	@Test
//	public void plusLike() {
//		assertTrue(service.plusLike("P023"));
//	}
//	
//	@Test
//	public void plusView() {
//		assertTrue(service.plusView("P003"));
//	}
//	
//	@Test
//	public void getUserId() {
//		assertNotNull(service.getUserId("P001"));
//	}
	
	@Test
	public void addToMySchedule() {
		assertTrue(service.addToMySchedule("P040", "mskk0410"));
	}

}

