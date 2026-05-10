package com.letsgo.place.model;

public interface UserDAOInterface {

    UserVO login(String userID, String password);

    boolean signup(String userID, String email, String name, String password);

    boolean idcheck(String userID);

    boolean updatePassword(String userID, String email, String newPassword);

    String findUserIdByNameAndEmail(String name, String email);
}
