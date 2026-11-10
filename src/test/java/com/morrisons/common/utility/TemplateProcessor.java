package com.morrisons.common.utility;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class TemplateProcessor {

    public static TemplateProcessor processTemplate() {
        return new TemplateProcessor();
    }

    private String templateResourcePath;
    private Map<String, String> templateData;
    private Configuration cfg = new Configuration();


    private TemplateProcessor() {
        cfg.setClassForTemplateLoading(this.getClass(),"/test-data/");
    }

    public TemplateProcessor fromResource(String templateResourcePath) {
        this.templateResourcePath = templateResourcePath;
        return this;
    }

    public TemplateProcessor withValues(Map<String, String> templateData) {
        // Puts randomId for JSON templates to use where needed
        this.templateData = templateData;
        return this;
    }

    public TemplateProcessor usingFreeMarkerConfiguration(Configuration cfg) {
        this.cfg = cfg;
        return this;
    }

/*
    public StubMapping getStubMapping() throws IOException, TemplateException {
        return StubMapping.buildFrom(result());
    }
*/

    //TODO:
    public String result()  {
        Template template = getTemplate();
        try {
            final StringWriter stringWriter = new StringWriter();
            template.process(templateData, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException("Faile to process template: " + templateResourcePath, e);
        }
    }

    private Template getTemplate() {
        try {
            return cfg.getTemplate(templateResourcePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read tempalte file: " + templateResourcePath, e);
        }
    }


    public JSONObject resultAsJson() {
        return new JSONObject(result());
    }
}
