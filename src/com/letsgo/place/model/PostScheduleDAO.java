package com.letsgo.place.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostScheduleDAO implements PostScheduleDAOInterface {
	private Connection conn;

	
	public PostScheduleDAO(Connection conn){
		this.conn = conn;
	}
	
	//게시물 불러오기(like)
	public List<PostScheduleVO> getPostScheduleListLike() {
		List<PostScheduleVO> tmp = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_LIKE);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 불러오기(view)
	public List<PostScheduleVO> getPostScheduleListView() {
		List<PostScheduleVO> tmp = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_VIEW);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 불러오기(title)
	public List<PostScheduleVO> getPostScheduleListTitle() {
		List<PostScheduleVO> tmp = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_TITLE);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 불러오기(latest)
	public List<PostScheduleVO> getPostScheduleListLatest() {
		List<PostScheduleVO> tmp = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_LATEST);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	
	//게시물 검색어 (like)
	public List<PostScheduleVO> getPostScheduleListLike(String keyword) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_SEARCH_LIKE);

			String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword + "%";
			stmt.setString(1, searchKey);
			stmt.setString(2, searchKey);
			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 검색어 (view)
	public List<PostScheduleVO> getPostScheduleListView(String keyword) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_SEARCH_VIEW);

			String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword + "%";
			stmt.setString(1, searchKey);
			stmt.setString(2, searchKey);
			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 검색어 (title)
	public List<PostScheduleVO> getPostScheduleListTitle(String keyword) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_SEARCH_TITLE);

			String searchKey = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword + "%";
			stmt.setString(1, searchKey);
			stmt.setString(2, searchKey);
			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	//게시물 검색어 (latest)
	public List<PostScheduleVO> getPostScheduleListLatest(String keyword) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_POST_SCHEDULE_LIST_SEARCH_LATEST);
			
			String searchKey = "%" + keyword + "%";
			stmt.setString(1, searchKey);
			stmt.setString(2, searchKey);
			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
		
	
		//내 게시물 불러오기(like)
		public List<PostScheduleVO> getUserPostScheduleListLike(String userId) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_LIKE);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
		
		//내 게시물 불러오기(view)
		public List<PostScheduleVO> getUserPostScheduleListView(String userId) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_VIEW);
			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
		
		//내 게시물 불러오기(title)
		public List<PostScheduleVO> getUserPostScheduleListTitle(String userId) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_TITLE);
			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
		
		//내 게시물 불러오기(latest)
		public List<PostScheduleVO> getUserPostScheduleListLatest(String userId) {
		List<PostScheduleVO> tmp = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_LATEST);
			stmt.setString(1, userId);

			ResultSet rs = stmt.executeQuery();
			tmp = new ArrayList<>();
			while (rs.next()) {
				tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		}
	
	
	
	
	
	
		//내 게시물 좋아요순
		public List<PostScheduleVO> getUserPostScheduleListLike(String userId, String keyword) {
			List<PostScheduleVO> tmp = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_SEARCH_LIKE);
				stmt.setString(1, userId);

				String searchKey = "%" + keyword + "%";
				stmt.setString(2, searchKey);
				stmt.setString(3, searchKey);
				ResultSet rs = stmt.executeQuery();
				tmp = new ArrayList<>();
				while (rs.next()) {
					tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tmp;
			}
		
		//내 게시물 조회요순
		public List<PostScheduleVO> getUserPostScheduleListView(String userId, String keyword) {
			List<PostScheduleVO> tmp = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_SEARCH_VIEW);
				stmt.setString(1, userId);
					
				String searchKey = "%" + keyword + "%";
				stmt.setString(2, searchKey);
				stmt.setString(3, searchKey);
				ResultSet rs = stmt.executeQuery();
				tmp = new ArrayList<>();
				while (rs.next()) {
					tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tmp;
			}
		
		//내 게시물 제목순
		public List<PostScheduleVO> getUserPostScheduleListTitle(String userId, String keyword) {
			List<PostScheduleVO> tmp = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_SEARCH_TITLE);
				stmt.setString(1, userId);

				String searchKey = "%" + keyword + "%";
				stmt.setString(2, searchKey);
				stmt.setString(3, searchKey);
				ResultSet rs = stmt.executeQuery();
				tmp = new ArrayList<>();
				while (rs.next()) {
					tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tmp;
			}
		
		//내 게시물 최신순
		public List<PostScheduleVO> getUserPostScheduleListLatest(String userId, String keyword) {
			List<PostScheduleVO> tmp = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_POST_SCHEDULE_LIST_SEARCH_LATEST);
				stmt.setString(1, userId);

				String searchKey = "%" + keyword + "%";
				stmt.setString(2, searchKey);
				stmt.setString(3, searchKey);
				ResultSet rs = stmt.executeQuery();
				tmp = new ArrayList<>();
				while (rs.next()) {
					tmp.add(new PostScheduleVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), "나", rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tmp;
			}
		
		
		public String getBudgetDetail(String postId) {
			String str = null;
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_BUDGET_DETAIL);

				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next())
					str = rs.getString(1);

				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return str;

		}
		public String getTodoDetail(String postId) {
			String str = null;
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_TODO_DETAIL);

				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next())
					str = rs.getString(1);

				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return str;

		}

		public List<RouteScheduleVO> getScheduleRoute(String postId) {
			List<RouteScheduleVO> list = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_SCHEDULE_ROUTE);

				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				list = new ArrayList<RouteScheduleVO>();
				while (rs.next()) {
					list.add(new RouteScheduleVO(rs.getString("VISIT_ITEM_ID"), rs.getString("VISIT_ORDER"),
							rs.getString("PLACE_ID"), rs.getString("TITLE")));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		public List<MapScheduleVO> getMapSchedule(String postId) {
			List<MapScheduleVO> list = null;
			
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_MAP_SCHEDULE);

				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				list = new ArrayList<MapScheduleVO>();
				while (rs.next()) {
					list.add(new MapScheduleVO(rs.getString("VISIT_ORDER"), rs.getString("TITLE"), rs.getString("MAPX"),
							rs.getString("MAPY"), rs.getString("DISTANCE_TO_NEXT")));
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
			return list;
		}
		
		public String getScheduleTitle(String postId) {
			String str = null;
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_SCHEDULE_TITLE);
				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next())
					str = rs.getString(1);
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		
		public boolean deletePostSchedule(String postId) {
			boolean flag = false;
			try {

				PreparedStatement stmtVisitItem = conn.prepareStatement(PostScheduleQuery.DELETE_VISIT_ITEM);
				PreparedStatement stmtSchedulePost = conn.prepareStatement(PostScheduleQuery.DELETE_SCHEDULE_POST);
				stmtVisitItem.setString(1, postId);
				stmtVisitItem.executeUpdate();

				stmtSchedulePost.setString(1, postId);
				stmtSchedulePost.executeUpdate();
		
				stmtVisitItem.close();
				stmtSchedulePost.close();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;

		}
		
		
		public boolean deleteVisitItem(String postId) {
			boolean flag = false;
			try {

				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.DELETE_VISIT_ITEM);
				stmt.setString(1, postId);
				stmt.executeUpdate();
		
				stmt.close();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;

		}
		
		public int getLikeCount(String postId) {
			int likeCount = 0; 
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_LIKE_COUNT);
				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					likeCount = rs.getInt(1);
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return likeCount;
		}
		
		public int getViewCount(String postId) {
			int viewCount = 0; 
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_VIEW_COUNT);
				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					viewCount = rs.getInt(1);
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return viewCount;
		}
		
		public boolean plusLike(String postId) {
			boolean flag = false;
			try {
				
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.PLUS_LIKE_COUNT);
				
				stmt.setString(1, postId);
				flag = (stmt.executeUpdate() == 1);
				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return flag;
		}
		
		public boolean plusView(String postId) {
			boolean flag = false;
			try {
				
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.PLUS_VIEW_COUNT);
				
				stmt.setString(1, postId);
				flag = (stmt.executeUpdate() == 1);
				stmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			return flag;
		}
		
		public String getUserId(String postId) {
			String str = ""; 
			try {
				PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.GET_USER_ID);
				stmt.setString(1, postId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					str = rs.getString(1);
				}
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		
		public String copyToMySchedule(String title, String budgetDetail, String todoDetail, String userId) {
		    String generatedId = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    
		    try {
		    	stmt = conn.prepareStatement(PostScheduleQuery.COPY_TO_MY_SCHEDULE, Statement.RETURN_GENERATED_KEYS);
		        stmt.setString(1, title);
		        stmt.setString(2, budgetDetail);
		        stmt.setString(3, todoDetail);
		        stmt.setString(4, userId);

		        if (stmt.executeUpdate() == 1) {
		        	rs = stmt.getGeneratedKeys();
		            if (rs != null && rs.next()) {
		                generatedId = rs.getString(1);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		        
		        try {
		            if (stmt != null) stmt.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    
		    return generatedId;
		}
		
		public boolean copyToVisitItem(String myScheduleId, RouteScheduleVO route) {
		    boolean flag = false;
		    try (PreparedStatement stmt = conn.prepareStatement(PostScheduleQuery.COPY_TO_VISIT_ITEM)) {
		        stmt.setString(1, route.getVisitOrder());
		        stmt.setDouble(2, route.getDistanceToNext());
		        stmt.setString(3, route.getPlaceId());
		        stmt.setString(4, myScheduleId);
		        stmt.setString(5, "MY_SCH");
		        
		        if (stmt.executeUpdate() == 1) {
		            flag = true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return flag;
		}
	}

