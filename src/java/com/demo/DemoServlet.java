package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        doGet(request,response);

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name.equals("abc") && pass.equals("asd")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            response.sendRedirect("WelcomeUser.jsp");
        }else
            System.out.println("wrong username or password");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

}