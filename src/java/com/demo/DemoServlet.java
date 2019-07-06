package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

@WebServlet(name = "/DemoServlet")
public class DemoServlet extends HttpServlet {

    public DemoServlet() {
        super();




    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        doGet(request, response);

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        try {
            Class.forName("com.mysql.jdbc.Driver");


        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname", "root", "Asap0921!");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select uname,upass from dbname.user_reg where uname='" + name + "'and upass= '" + pass + "'");


            if (rs.next()) {


                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                response.sendRedirect("WelcomeUser.jsp");
            }else {
                System.out.println("wrong username or password");

            }






        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub



    }
}