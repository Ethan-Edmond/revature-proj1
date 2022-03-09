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

@WebServlet(urlPatterns = "/studies")
public class StudiesServlet extends HttpServlet {
    @Autowired
    StudyService studyService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            StudyStub[] stubs = studyService.findAll()
                    .stream()
                    .map(StudyStub::new)
                    .toArray(StudyStub[]::new); // TODO maybe put this stuff in the service layer

            req.setAttribute("allStudies", stubs);
            RequestDispatcher view = req.getRequestDispatcher("studies.jsp");
            view.forward(req, resp);
        }
    }
}
