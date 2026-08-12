package com.jay.registrationapplication;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {  // Controller
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String mail = req.getParameter("umail");
        String pass = req.getParameter("upass");
        String city = req.getParameter("ucity");

        Model model = new Model();
        model.setName(name);
        model.setMail(mail);
        model.setPass(pass);
        model.setCity(city);

        HttpSession session = req.getSession();
        session.setAttribute("name", name);

        Integer row = model.register();
        if (row == 0){
            resp.sendRedirect("./failure.jsp");
        } else {
            resp.sendRedirect("./success.jsp");
        }
    }
}
