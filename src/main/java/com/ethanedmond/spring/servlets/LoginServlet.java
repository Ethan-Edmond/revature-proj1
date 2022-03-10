package com.ethanedmond.spring.servlets;

import com.ethanedmond.spring.model.Artist;
import com.ethanedmond.spring.service.ArtistService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired ArtistService artistService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        Artist artist = artistService.findByUsername(username);
        if (artist == null) {
            Artist newArtist = new Artist();
            newArtist.setUsername(username);
            artist = artistService.save(newArtist);
        }
        Integer userId = artist.getArtistId();
        HttpSession sesh = req.getSession();
        sesh.setAttribute("userId", userId);
        LogManager.getLogger().info("User: " + username + " has logged in");
        System.out.println("should have logged");
        res.sendRedirect("myStudies");
    }
}
