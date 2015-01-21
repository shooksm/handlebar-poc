package com.shooksweb.controller;

import com.shooksweb.service.PageService;
import com.shooksweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pureJSP")
public class JspController {

    @Autowired
    ProductService productService;

    @Autowired
    PageService pageService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() throws Exception {
        ModelAndView model = new ModelAndView("indexPure");

        model.addObject("productList", productService.getProductsByPage(1));
        model.addObject("firstProduct", productService.getFirstProductForPage());
        model.addObject("lastProduct", productService.getLastProductForPage());
        model.addObject("numberOfProducts", productService.getNumberOfProducts());
        model.addObject("pages", productService.getPages());
        model.addObject("productPage", pageService.getPage("product"));
        return model;
    }
}
