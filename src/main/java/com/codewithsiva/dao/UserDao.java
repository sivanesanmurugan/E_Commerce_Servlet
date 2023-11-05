package com.codewithsiva.dao;

import com.codewithsiva.database.Database_db;
import com.codewithsiva.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection con;

    public UserDao() {
        con = Database_db.getConnection();
    }
    private String selectSQL = "SELECT id, email, password FROM User WHERE email=? and password=?";
    private String RegisterSQL="INSERT INTO User(email,password)VALUES(?,?);";
    public User loginUser(String email, String password) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(selectSQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void register(String email, String password) {
        try {
            PreparedStatement rt= con.prepareStatement(RegisterSQL);
            rt.setString(1, email);
            rt.setString(2, password);
            rt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
