package com.shooksweb.service;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.cache.HighConcurrencyTemplateCache;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.shooksweb.helper.IndexHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TemplateService {
    TemplateLoader templateLoader;
    Handlebars handlebars;

    TemplateService() {
        templateLoader = new ClassPathTemplateLoader("/WEB-INF/static/hbs", ".hbs");
        handlebars = new Handlebars(templateLoader)
                .with(new HighConcurrencyTemplateCache());
        handlebars.registerHelpers(IndexHelper.class);
    }

    public Template getTemplate(String template) throws IOException {
        return handlebars.compile(template);
    }
}
