package com.letsgo.place.mybatis.service;

import com.letsgo.place.service.UserServiceInterface;

import org.apache.ibatis.session.SqlSession;

import com.letsgo.place.model.dao.UserDAOInterface;
import com.letsgo.place.model.vo.UserVO;
import com.letsgo.place.mybatis.dao.DBCPMybatis;
import com.letsgo.place.mybatis.dao.UserDAOMB;

public class UserServiceMB implements UserServiceInterface {

	public UserServiceMB() {
    }

    @Override
    public UserVO login(String userID, String password) {
        SqlSession session = DBCPMybatis.getSqlSession();
        UserDAOInterface dao = new UserDAOMB(session);
        UserVO result = dao.login(userID, password);
        session.close();
        return result;
    }

    @Override
    public boolean signup(String userID, String email, String name, String password) {
        SqlSession session = DBCPMybatis.getSqlSession();
        UserDAOInterface dao = new UserDAOMB(session);
        boolean result = dao.signup(userID, email, name, password);
        if (result) session.commit();
        else        session.rollback();
        session.close();
        return result;
    }

    @Override
    public boolean idcheck(String userID) {
        SqlSession session = DBCPMybatis.getSqlSession();
        UserDAOInterface dao = new UserDAOMB(session);
        boolean result = dao.idcheck(userID);
        session.close();
        return result;
    }

    @Override
    public boolean updatePassword(String userID, String email, String newPassword) {
        SqlSession session = DBCPMybatis.getSqlSession();
        UserDAOInterface dao = new UserDAOMB(session);
        boolean result = dao.updatePassword(userID, email, newPassword);
        if (result) session.commit();
        else        session.rollback();
        session.close();
        return result;
    }

    @Override
    public String findUserIdByNameAndEmail(String name, String email) {
        SqlSession session = DBCPMybatis.getSqlSession();
        UserDAOInterface dao = new UserDAOMB(session);
        String result = dao.findUserIdByNameAndEmail(name, email);
        session.close();
        return result;
    }
}




