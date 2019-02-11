package com.wooky.web.servlets;

import com.wooky.web.freemaker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("login")
public class Login extends HttpServlet {

    private static final String TEMPLATE_LOGIN = "login";

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> model = templateProvider.setTemplateProviderTop(req, resp);
        model.put("activeList", "");
        model.put("activeAdd", "");
        model.put("activeLogin", "active");
        model.put("referrer", "&referrer=login");
        templateProvider.setTemplateProviderBottom(model, resp, getServletContext(), TEMPLATE_LOGIN);
    }
}