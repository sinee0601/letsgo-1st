package com.letsgo.place.model;

import org.apache.ibatis.annotations.Param;

public interface UserDAOInterface {

    // 로그인
    UserVO login(@Param("userID") String userID, @Param("password") String password);

    // 회원가입
    boolean signup(
            @Param("userID") String userID,
            @Param("email") String email,
            @Param("name") String name,
            @Param("password") String password);

    // 아이디 체크
    boolean idcheck(@Param("userID") String userID);

    // 비밀번호 변경
    boolean updatePassword(
            @Param("userID") String userID,
            @Param("email") String email,
            @Param("newPassword") String newPassword);

    // 이름·이메일로 아이디 조회
    String findUserIdByNameAndEmail(@Param("name") String name, @Param("email") String email);
}
