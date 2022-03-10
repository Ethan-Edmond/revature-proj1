package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Drawing;
import com.ethanedmond.spring.service.DrawingService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myDrawings")
public class MyDrawingsServlet extends HttpServlet {
    @Autowired
    DrawingService drawingService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            int artistId = (int) sesh.getAttribute("userId");
            List<Drawing> myDrawings = drawingService.getByArtistId(artistId);
            req.setAttribute("myDrawings", myDrawings);
            RequestDispatcher view = req.getRequestDispatcher("myDrawings.jsp");
            view.forward(req, resp);
        }
    }
}
