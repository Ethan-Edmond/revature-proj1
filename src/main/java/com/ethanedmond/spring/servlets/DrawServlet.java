package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.ReferenceImage;
import com.ethanedmond.spring.service.ReferenceImageService;
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
import java.util.List;

@WebServlet(urlPatterns = "/draw")
public class DrawServlet extends HttpServlet {
    @Autowired
    ReferenceImageService referenceImageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            int studyId = Integer.parseInt(req.getParameter("studyId"));
            int referenceIndex = Integer.parseInt(req.getParameter("referenceIndex"));
            List<ReferenceImage> referenceImages = referenceImageService.getByStudyId(studyId);
            int referenceCount = referenceImages.size();
            if (0 > referenceIndex || referenceIndex >= referenceCount) {
                resp.sendRedirect("/study?studyId=" + studyId);
            } else {
                String referenceImageLink = referenceImages.get(referenceIndex).getImageLink();
                req.setAttribute("referenceImageLink", referenceImageLink);
                req.setAttribute("studyId", studyId);
                req.setAttribute("referenceIndex", referenceIndex);
                req.setAttribute("referenceCount", referenceCount);
                RequestDispatcher view = req.getRequestDispatcher("draw.jsp");
                view.forward(req, resp);
            }
        }
    }
}
