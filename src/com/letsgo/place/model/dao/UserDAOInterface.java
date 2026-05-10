package com.letsgo.place.model.dao;

import com.letsgo.place.model.vo.UserVO;

public interface UserDAOInterface {

    UserVO login(String userID, String password);

    boolean signup(String userID, String email, String name, String password);

    boolean idcheck(String userID);

    boolean updatePassword(String userID, String email, String newPassword);

    String findUserIdByNameAndEmail(String name, String email);
}

