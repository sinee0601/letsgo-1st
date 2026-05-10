package com.letsgo.place.mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.UserDAOInterface;
import com.letsgo.place.model.vo.UserVO;

public class UserDAOMB implements UserDAOInterface {

	private SqlSession session;

	public UserDAOMB(SqlSession session) {
		this.session = session;
	}

	@Override
	public UserVO login(String userID, String password) {
		return session.selectOne("userMapper.login", new UserVO(userID, null, null, password));
	}

	@Override
	public boolean signup(String userID, String email, String name, String password) {
		return session.insert("userMapper.signUp", new UserVO(userID, email, name, password)) == 1;
	}

	@Override
	public boolean idcheck(String userID) {
		return session.selectOne("userMapper.idCheck", userID) != null;
	}

	@Override
	public boolean updatePassword(String userID, String email, String newPassword) {
		return session.update("userMapper.updatePassword", new UserVO(userID, email, null, newPassword)) == 1;
	}

	@Override
	public String findUserIdByNameAndEmail(String name, String email) {
		return session.selectOne("userMapper.findUserId", new UserVO(null, email, name, null));
	}

}

