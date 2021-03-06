package com.wooky.web.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import no.api.freemarker.java8.Java8ObjectWrapper;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Locale;

@ApplicationScoped
public class TemplateProvider {

    private static final String TEMPLATE_DIRECTORY_PATH = "ftlh";
    private static final String TEMPLATE_EXT = ".ftlh";

    public Template getTemplate(ServletContext servletContext, String templateName, String language) throws IOException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        cfg.setDefaultEncoding("utf-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(true);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);
        cfg.setLocale(Locale.forLanguageTag(language));
        cfg.setObjectWrapper(new Java8ObjectWrapper(Configuration.VERSION_2_3_28));

        return cfg.getTemplate(templateName + TEMPLATE_EXT);
    }
}
