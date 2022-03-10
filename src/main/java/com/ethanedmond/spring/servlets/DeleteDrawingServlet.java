package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.service.DrawingService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteDrawing")
public class DeleteDrawingServlet extends HttpServlet {
    @Autowired
    DrawingService drawingService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            int drawingId = Integer.parseInt(req.getParameter("drawingId"));
            drawingService.deleteByDrawingId(drawingId);
            resp.sendRedirect("/myDrawings");
        }
    }
}
