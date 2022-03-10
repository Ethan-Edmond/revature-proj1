package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.ReferenceImage;
import com.ethanedmond.spring.model.Study;
import com.ethanedmond.spring.service.ReferenceImageService;
import com.ethanedmond.spring.service.StudyService;
import com.ethanedmond.spring.utils.HttpUtils;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = "/addReference")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 100)
public class AddReferenceServlet extends HttpServlet {
    @Autowired
    ReferenceImageService referenceImageService;

    @Autowired
    StudyService studyService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
                        String fullPath = imagesPath + "\\" + fileName; // TODO figure out a path that allows you to serve those images
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
                        ReferenceImage added = new ReferenceImage();
                        int studyId = Integer.parseInt(req.getParameter("studyId"));
                        Study study = studyService.findByStudyId(studyId);
                        added.setStudy(study);
                        added.setImageLink(fileName); // TODO get a studyId to give this thing
                        referenceImageService.save(added);
                        System.out.println(fullPath); // TODO make this generate unique names
                        resp.sendRedirect("/study?studyId=" + studyId);
                    } else {
                        System.out.println("name: " + name);
                    }
                }
            }
        }
    }
}
