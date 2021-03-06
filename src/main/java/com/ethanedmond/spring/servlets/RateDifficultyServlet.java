package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/rateDifficulty")
public class RateDifficultyServlet extends HttpServlet {
    @Autowired
    StudyService studyService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            int studyId = Integer.parseInt(req.getParameter("studyId"));
            Study study = studyService.findByStudyId(studyId);
            int difficultyRating = Integer.parseInt(req.getParameter("difficulty"));
            System.out.println(difficultyRating);
            study.addDifficulty(difficultyRating);
            studyService.save(study);
            resp.sendRedirect("/study?studyId=" + studyId);
        }
    }
}
