package com.ethanedmond.spring.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/studies")
public class StudiesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = req.getSession(false);
        if (sesh == null) {
            resp.sendRedirect("Schmerror");
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("Heeeeeey" + sesh.getAttribute("userId"));
        }
    }
}
