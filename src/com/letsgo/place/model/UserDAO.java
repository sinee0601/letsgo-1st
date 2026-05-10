package com.letsgo.place.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements UserQuery {

    private Connection conn;

    public UserDAO() throws Exception {
        this.conn = DBCP.getConnection();
    }

    public UserDAO(Connection conn) throws Exception {
        this.conn = conn;
    }

    public UserVO login(String userID, String password) {
        UserVO user = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(LOGIN_SQL);
            pstmt.setString(1, userID);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                user = new UserVO(userID, email, name, password);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean signup(String userID, String email, String name, String password) {
        boolean result = false;
        try {
            PreparedStatement pstmt = conn.prepareStatement(SIGNUP_SQL);
            pstmt.setString(1, userID);
            pstmt.setString(2, email);
            pstmt.setString(3, name);
            pstmt.setString(4, password);
            result = pstmt.executeUpdate() > 0;
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean idcheck(String userID) {
        boolean result = false;
        try {
            PreparedStatement pstmt = conn.prepareStatement(IDCHECK_SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            result = rs.next();
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updatePassword(String userID, String email, String newPassword) {
        boolean result = false;
        try {
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_PASSWORD_BY_ID_EMAIL_SQL);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, userID);
            pstmt.setString(3, email);
            result = pstmt.executeUpdate() == 1;
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String findUserIdByNameAndEmail(String name, String email) {
        String userId = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(FIND_USER_ID_BY_NAME_EMAIL_SQL);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userId = rs.getString("USER_ID");
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }
}
