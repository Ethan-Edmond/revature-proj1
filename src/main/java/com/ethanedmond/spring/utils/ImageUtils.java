package com.ethanedmond.spring.utils;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class ImageUtils {

    private static URLConnection connectToImageServer() throws IOException {
        Properties props = new Properties();
        URL url = ImageUtils.class.getResource("/imageServer.properties");
        InputStream stream = url.openStream();
        props.load(stream);
        URL imageServerUrl = new URL(props.getProperty("image.server.url"));
        stream.close();
        URLConnection imageServerConnection = imageServerUrl.openConnection();
        imageServerConnection.connect();
        return imageServerConnection;
    }

//    public static String uploadImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//    }
}
