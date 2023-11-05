package com.codewithsiva.dao;

import com.codewithsiva.database.Database_db;
import com.codewithsiva.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static Connection con;
    public ProductDao() {
        con = Database_db.getConnection();
    }
    private static String selectAllProductSQL = "SELECT * FROM products";
    private static String INSERT_CART="";

    public static List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            PreparedStatement ps = con.prepareStatement(selectAllProductSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(Integer.parseInt(rs.getString("id")));
                product.setTitle(rs.getString("title"));
                product.setPrice(rs.getInt("price"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERT_CART);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
