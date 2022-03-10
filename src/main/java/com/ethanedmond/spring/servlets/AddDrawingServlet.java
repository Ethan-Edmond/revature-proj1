package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.model.Drawing;
import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.service.ArtistService;
import com.ethanedmond.spring.service.DrawingService;
import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/addDrawing")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 100)
public class AddDrawingServlet extends HttpServlet {
    @Autowired
    DrawingService drawingService;

    @Autowired
    ArtistService artistService;

    @Autowired
    StudyService studyService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesh = HttpUtils.RedirectOnNoSesh(req, resp);
        if (sesh != null) {
            String imagesPath = System.getProperty("user.dir") + "\\src\\main\\webapp\\";
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            if (isMultipart) {
                ServletFileUpload upload = new ServletFileUpload();
                FileItemIterator iter = upload.getItemIterator(req);
                while (iter.hasNext()) {
                    FileItemStream item = iter.next();
                    String name = item.getFieldName();
                    if (name.equals("image")) {
                        resp.setContentType(item.getContentType()); // TODO clean this up! seriously...
                        String[] splitName = item.getName().split("\\.");
                        String fileextension = splitName[splitName.length - 1];
                        int fileId = (int) (Math.random() * Integer.MAX_VALUE);
                        String fileName = "images\\" + fileId + "." + fileextension;
                        String fullPath = imagesPath + "\\" + fileName;
                        File outfile = new File(fullPath);
                        FileOutputStream out = new FileOutputStream(outfile);
                        InputStream in = item.openStream();
                        byte[] buffer = new byte[1024];
                        int length = 0;
                        length = in.read(buffer);
                        while (length >= 0) {
                            out.write(buffer, 0, length);
                            length = in.read(buffer);
                        }
                        in.close();
                        out.close();
                        Drawing added = new Drawing();
                        int artistId = (int) sesh.getAttribute("userId");
                        Artist artist = artistService.findByArtistId(artistId);
                        added.setArtist(artist);
                        int studyId = Integer.parseInt(req.getParameter("studyId"));
                        Study study = studyService.findByStudyId(studyId);
                        added.setStudy(study);
                        added.setImageLink(fileName);
                        drawingService.save(added);
                        int referenceIndex = Integer.parseInt(req.getParameter("referenceIndex"));
                        resp.sendRedirect("/draw?studyId=" + studyId + "&referenceIndex=" + referenceIndex);
                    } else {
                        // TODO figure out if you want anything here
                    }
                }
            }
        }
    }
}
