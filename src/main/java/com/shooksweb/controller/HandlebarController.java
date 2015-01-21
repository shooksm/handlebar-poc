package com.shooksweb.controller;

import com.github.jknack.handlebars.Template;
import com.shooksweb.service.PageService;
import com.shooksweb.service.ProductService;
import com.shooksweb.service.TemplateService;
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

    @Autowired
    TemplateService templateService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(ModelMap modelMap) throws IOException {
        Template template = templateService.getTemplate("index");

        int numberOfProducts = productService.getNumberOfProducts();

        modelMap.addAttribute(productService.getProductsByPage(1));
        modelMap.addAttribute("numberOfProducts", numberOfProducts);
        modelMap.addAttribute(pageService.getPage("product"));
        modelMap.addAttribute("firstProduct", productService.getFirstProductForPage());
        modelMap.addAttribute("lastProduct", productService.getLastProductForPage());
        modelMap.addAttribute("pages", productService.getPages());

        return template.apply(modelMap);
    }
}
