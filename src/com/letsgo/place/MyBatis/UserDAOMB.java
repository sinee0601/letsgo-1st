package com.letsgo.place.MyBatis;

import com.letsgo.place.model.UserDAOInterface;
import com.letsgo.place.model.UserVO;

public class UserDAOMB implements UserDAOInterface {

	@Override
	public UserVO login(String userID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(String userID, String email, String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean idcheck(String userID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(String userID, String email, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findUserIdByNameAndEmail(String name, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
