package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Drawing;
import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.service.DrawingService;
import com.ethanedmond.spring.service.ReferenceImageService;
import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.service.TagService;
import com.ethanedmond.spring.stubs.DrawingStub;
import com.ethanedmond.spring.stubs.ReferenceStub;
import com.ethanedmond.spring.stubs.StudyStub;
import com.ethanedmond.spring.stubs.TagStub;
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
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/study")
public class StudyServlet extends HttpServlet {
    @Autowired
    StudyService studyService;

    @Autowired
    ReferenceImageService referenceImageService;

    @Autowired
    TagService tagService;

    @Autowired
    DrawingService drawingService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            Integer studyId = Integer.parseInt(req.getParameter("studyId"));
            Study study = studyService.findByStudyId(studyId);
            StudyStub stub = new StudyStub(study);
            req.setAttribute("study", stub); // you know what's funny? the amount of time I thought that jackson was necessary here.

            List<ReferenceStub> referenceStubs = referenceImageService.getByStudyId(studyId)
                    .stream()
                    .map(ReferenceStub::new)
                    .collect(Collectors.toList());
            req.setAttribute("referenceImages", referenceStubs);

            List<DrawingStub> drawings = drawingService.getByStudyId(studyId)
                    .stream()
                    .map(DrawingStub::new)
                    .collect(Collectors.toList());
            req.setAttribute("drawings", drawings);

            List<TagStub> tagStubs = tagService.getByStudyId(studyId)
                    .stream()
                    .map(TagStub::new)
                    .collect(Collectors.toList());
            req.setAttribute("tags", tagStubs);

            RequestDispatcher view = req.getRequestDispatcher("study.jsp");
            view.forward(req, resp);
        }
    }
}
