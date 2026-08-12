package com.jay.registrationapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "login", value="/login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String pass = req.getParameter("upass");

        Model model = new Model();
        model.setName(name);
        model.setPass(pass);

        HttpSession session = req.getSession();
        session.setAttribute("name", name);

        ResultSet rs = model.login();
        if (rs==null){
            resp.sendRedirect("./login-failure.jsp");
        } else {
            resp.sendRedirect("./login-success.jsp");
        }

    }
}
