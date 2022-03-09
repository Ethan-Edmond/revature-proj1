package com.ethanedmond.spring.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HttpUtils {
    public static HttpSession RedirectOnNoSesh(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession sesh = req.getSession(false);
        if (sesh == null) {
            res.sendRedirect("");
            return null;
        } else {
            return sesh;
        }
    }
}
