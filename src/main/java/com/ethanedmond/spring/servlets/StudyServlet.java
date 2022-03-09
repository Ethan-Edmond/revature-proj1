package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.stubs.StudyStub;
import com.ethanedmond.spring.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/study")
public class StudyServlet extends HttpServlet {
    @Autowired
    StudyService studyService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            Integer studyId = Integer.parseInt(req.getParameter("studyId"));
            StudyStub stub = new StudyStub(studyService.findByStudyId(studyId));
            req.setAttribute("study", stub); // you know what's funny? the amount of time I thought that jackson was necessary here.
            RequestDispatcher view = req.getRequestDispatcher("study.jsp");
            view.forward(req, resp);
        }
    }
}
