package com.letsgo.place.service;

import com.letsgo.place.model.UserVO;

public interface UserServiceInterface {

    UserVO login(String userID, String password);

    boolean signup(String userID, String email, String name, String password);

    boolean idcheck(String userID);

    boolean updatePassword(String userID, String email, String newPassword);

    String findUserIdByNameAndEmail(String name, String email);
}
