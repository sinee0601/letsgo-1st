package com.letsgo.place.MyBatis;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.DBCPMybatis.DBCPMybatis;
import com.letsgo.place.model.UserDAOInterface;
import com.letsgo.place.model.UserVO;

public class UserDAOMB implements UserDAOInterface {

	@Override
	public UserVO login(String userID, String password) {
		SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession();
		UserVO result = session.selectOne("userMapper.login", new UserVO(userID, null, null, password));
		session.close();
		return result;
	}

	@Override
	public boolean signup(String userID, String email, String name, String password) {
		SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession();
		boolean result = session.insert("userMapper.signUp", new UserVO(userID, email, name, password)) == 1;
		if(result)session.commit();
		session.close();
		return result;
	}

	@Override
	public boolean idcheck(String userID) {
		SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession();
		boolean result = (session.selectOne("userMapper.idCheck", userID) != null);
		session.close();
		return result;
	}

	@Override
	public boolean updatePassword(String userID, String email, String newPassword) {
		SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession();
		boolean result = session.update("userMapper.updatePassword", new UserVO(userID, email, null, newPassword)) == 1;
		if(result)session.commit();
		session.close();
		return result;
	}

	@Override
	public String findUserIdByNameAndEmail(String name, String email) {
		SqlSession session = DBCPMybatis.getSqlSessionFactory().openSession();
		String result = session.selectOne("userMapper.findUserId", new UserVO(null, email, name, null));
		session.close();
		return result;
	}

}
