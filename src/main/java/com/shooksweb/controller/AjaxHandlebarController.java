package com.shooksweb.controller;

import com.shooksweb.service.PageService;
import com.shooksweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by Rob Whitaker on 1/8/2015.
 */

@Controller
@RequestMapping("/api/products")
public class AjaxHandlebarController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getProductsByPage(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        addProductData(modelAndView, page);
        addPageData(modelAndView);

        return modelAndView;
    }

    private void addProductData(ModelAndView modelAndView, int page) {
        modelAndView.addObject(productService.getProductsByPage(page));
        modelAndView.addObject("firstProduct", productService.getFirstProductForPage());
        modelAndView.addObject("lastProduct", productService.getLastProductForPage());
        modelAndView.addObject("numberOfProducts", productService.getNumberOfProducts());
    }

    private void addPageData(ModelAndView modelAndView) {
        modelAndView.addObject("numberOfPages", productService.getNumberOfPages());
        modelAndView.addObject("nextPage", productService.getNextPage());
        modelAndView.addObject("previousPage", productService.getPreviousPage());
        modelAndView.addObject("currentPage", productService.getCurrentPage());
    }
}