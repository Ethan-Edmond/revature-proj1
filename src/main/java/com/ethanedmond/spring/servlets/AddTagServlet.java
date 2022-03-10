package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.model.Tag;
import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.service.TagService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/addTag")
public class AddTagServlet extends HttpServlet {
    @Autowired
    TagService tagService;

    @Autowired
    StudyService studyService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            String name = req.getParameter("name");
            int studyId = Integer.parseInt(req.getParameter("studyId"));
            Study study = studyService.findByStudyId(studyId);
            Tag updated = tagService.findByName(name);
            if (updated != null) {
                updated.addStudy(study);
                tagService.save(updated);
            } else {
                Tag newTag = new Tag(name);
                newTag.addStudy(study);
                tagService.save(newTag);
            }
            resp.sendRedirect("study?studyId=" + studyId);
        }
    }
}
