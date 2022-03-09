package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.service.ArtistService;
import com.ethanedmond.spring.service.StudyService;
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

@WebServlet(urlPatterns = "/addStudy")
public class AddStudyServlet extends HttpServlet {
    @Autowired
    ArtistService artistService;
    @Autowired
    StudyService studyService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            RequestDispatcher view = req.getRequestDispatcher("addStudy.html");
            view.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            String title = req.getParameter("title");
            Study newStudy = new Study();
            Artist owner = artistService.findByArtistId((int) sesh.getAttribute("userId"));
            newStudy.setOwner(owner);
            newStudy.setTitle(title);
            Study saved = studyService.save(newStudy);
            resp.sendRedirect("study?studyId=" + saved.getStudyId());
        }
    }
}
