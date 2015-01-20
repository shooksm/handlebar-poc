package com.shooksweb.controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.cache.GuavaTemplateCache;
import com.github.jknack.handlebars.cache.HighConcurrencyTemplateCache;
import com.github.jknack.handlebars.io.*;
import com.google.common.cache.Cache;
import com.shooksweb.helper.IndexHelper;
import com.shooksweb.service.PageService;
import com.shooksweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/handlebar")
public class HandlebarController {

    @Autowired
    ProductService productService;

    @Autowired
    PageService pageService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(ModelMap modelMap) throws IOException {
        TemplateLoader templateLoader = new ClassPathTemplateLoader("/WEB-INF/static/hbs", ".hbs");
//        Handlebars handlebars = new Handlebars(templateLoader);
        Handlebars handlebars = new Handlebars(templateLoader)
                .with(new HighConcurrencyTemplateCache());
//        Cache<TemplateSource, Template> cache = null;
//        Handlebars handlebars = new Handlebars(templateLoader)
//                .with(new GuavaTemplateCache(cache));
        Template template = handlebars.compile("index");

        int numberOfProducts = productService.getNumberOfProducts();
        handlebars.registerHelpers(IndexHelper.class);

        modelMap.addAttribute(productService.getProductsByPage(1));
        modelMap.addAttribute("numberOfProducts", numberOfProducts);
        modelMap.addAttribute(pageService.getPage("product"));
        modelMap.addAttribute("firstProduct", productService.getFirstProductForPage());
        modelMap.addAttribute("lastProduct", productService.getLastProductForPage());
        modelMap.addAttribute("pages", productService.getPages());

        return template.apply(modelMap);
    }
}
