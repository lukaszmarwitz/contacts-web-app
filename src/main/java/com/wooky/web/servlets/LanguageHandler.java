package com.wooky.web.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("language")
public class LanguageHandler extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(LanguageHandler.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String referrer = req.getParameter("referrer");
        String language = req.getParameter("lang");

        HttpSession session = req.getSession();
        session.setAttribute("session_language", language);
        LOG.info("The following language was stored in session and set: {}", language);

        resp.sendRedirect(referrer);
        LOG.info("Redirecting back to referrer: {}", referrer);
    }
}
