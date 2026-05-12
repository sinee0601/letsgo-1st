package test.com.letsgo.place.mybatis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.letsgo.place.model.vo.UserVO;
import com.letsgo.place.mybatis.service.UserServiceMB;

public class TestUserServiceMB {

private UserServiceMB service;
	
	@Before
	public void setup() {
		service = new UserServiceMB();
		service.updatePassword("user01", "kim@test.com", "pass123");
	}
	
    @Test
    public void loginTest() {
        UserVO result = service.login("user01", "pass123");
        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getEmail());
        
        assertNull(service.login("user01", "wrongPassword"));

        assertNull(service.login("user9999", "anyPassword"));
    }

    @Test
    public void signupTest() {
    	if (!service.idcheck("newUser999")) {
            assertTrue(service.signup("newUser999", "new@test.com", "홍길동", "pass1234"));
        }
        assertNotNull(service.login("newUser999", "pass1234"));
        assertTrue(service.idcheck("user01"));
    }

    @Test
    public void idcheckTest() {
        assertTrue(service.idcheck("user01"));

        assertFalse(service.idcheck("user9999"));
    }

    @Test
    public void updatePasswordTest() {
        assertTrue(service.updatePassword("user01", "kim@test.com", "newPass999"));
        assertNotNull(service.login("user01", "newPass999"));

        assertFalse(service.updatePassword("user01", "wrong@email.com", "anyPass"));

        assertFalse(service.updatePassword("user9999", "any@email.com", "pass"));
    }

    @Test
    public void findUserIdByNameAndEmailTest() {
        String result = service.findUserIdByNameAndEmail("김철수", "kim@test.com");
        assertNotNull(result);
        assertEquals("user01", result);

        assertNull(service.findUserIdByNameAndEmail("없는이름", "kim@test.com"));

        assertNull(service.findUserIdByNameAndEmail("김철수", "wrong@email.com"));

        assertNull(service.findUserIdByNameAndEmail("없는사람", "none@none.com"));
    }
}
