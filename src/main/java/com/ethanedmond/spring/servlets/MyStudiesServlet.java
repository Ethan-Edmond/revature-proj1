package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.stubs.StudiesStub;
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

@WebServlet(urlPatterns = "/myStudies")
public class MyStudiesServlet extends HttpServlet {
    @Autowired
    StudyService studyService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            int userId = (int) sesh.getAttribute("userId"); // TODO change all instances to artistId or userId. just choose one
            StudiesStub[] stubs = studyService.getByArtistId(userId)
                    .stream()
                    .map(StudiesStub::new)
                    .toArray(StudiesStub[]::new); // TODO maybe put this stuff in the service layer
            req.setAttribute("myStudies", stubs);
            RequestDispatcher view = req.getRequestDispatcher("myStudies.jsp");
            view.forward(req, resp);
        }
    }
}
