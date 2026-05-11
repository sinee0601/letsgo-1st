package com.letsgo.place.mybatis.dao;

import com.letsgo.place.service.UserServiceInterface;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.UserDAOInterface;
import com.letsgo.place.model.vo.UserVO;

public class UserServiceMB implements UserServiceInterface {

	private UserDAOInterface dao;
	private SqlSession session;

	public UserServiceMB() {
		session = DBCPMybatis.getSqlSession();
		dao = new UserDAOMB(session);
	}

	@Override
	public UserVO login(String userID, String password) {
		return dao.login(userID, password);
	}

	@Override
	public boolean signup(String userID, String email, String name, String password) {
		boolean result = dao.signup(userID, email, name, password);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public boolean idcheck(String userID) {
		return dao.idcheck(userID);
	}

	@Override
	public boolean updatePassword(String userID, String email, String newPassword) {
		boolean result = dao.updatePassword(userID, email, newPassword);
		if (result) session.commit();
		else session.rollback();
		return result;
	}

	@Override
	public String findUserIdByNameAndEmail(String name, String email) {
		return dao.findUserIdByNameAndEmail(name, email);
	}
}




