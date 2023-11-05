package com.codewithsiva.controller;

import com.codewithsiva.dao.ProductDao;
import com.codewithsiva.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class HomeController extends HttpServlet {
    private ProductDao productDao;
    private UserDao userDao;
    public HomeController() {
      userDao=new UserDao();
      productDao=new ProductDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HttpSession httpSession = req.getSession();
        int loggedInUser= (int) httpSession.getAttribute("id");
        System.out.println(id);
        if (id != null) {
            productDao.addProduct(Integer.parseInt(id));
        }
        doPost(req, resp);
    }

}
