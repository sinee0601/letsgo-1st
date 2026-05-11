package test.com.letsgo.place.mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.UserVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.UserDAOMB;


public class TestUserDAOMB {

	private UserDAOMB dao;
	private SqlSession session;

	@Before
	public void setup() {
		session = DBCPMybatis.getSqlSession();
		dao = new UserDAOMB(session);
	}

	@After
	public void tearDown() {
		if (session != null) {
			session.rollback();
			session.close();
		}
	}
	
	//@Test
	public void loginTest(){
        UserVO result = dao.login("user01", "pass123");
        assertNotNull(result);
        assertNotNull("name이 null이면 안 됩니다", result.getName());
        assertNotNull("email이 null이면 안 됩니다", result.getEmail());
        assertNull(dao.login("user01", "wrongPassword"));
        assertNull(dao.login("user9999", "anyPassword"));
	}
	
	@Test
	public void signupTest(){
		assertTrue(dao.signup("newUser999", "new@test.com", "홍길동", "pass1234"));
        assertNotNull(dao.login("newUser999", "pass1234"));
        assertTrue("중복 ID는 idcheck에서 true여야 합니다", dao.idcheck("user01"));
	}
	
	//@Test
	public void idcheckTest(){
        assertTrue(dao.idcheck("user01"));
        assertFalse(dao.idcheck("user9999"));
	}

	//@Test
	public void updatePasswordTest(){
		assertTrue(dao.updatePassword("user01", "kim@test.com", "newPass999"));
        assertNotNull(dao.login("user01", "newPass999"));
        assertFalse(dao.updatePassword("user01", "wrong@email.com", "newPass999"));
        assertFalse(dao.updatePassword("user9999", "any@email.com", "pass"));
	}
	
	//@Test
	public void findUserIdByNameAndEmailTest(){
		String result = dao.findUserIdByNameAndEmail("김철수", "kim@test.com");
        assertNotNull(result);
        assertEquals("user01", result);
        assertNull(dao.findUserIdByNameAndEmail("없는이름", "kim@test.com"));
        assertNull(dao.findUserIdByNameAndEmail("김철수", "wrong@email.com"));
        assertNull(dao.findUserIdByNameAndEmail("없는사람", "none@none.com"));
	}
	
}
