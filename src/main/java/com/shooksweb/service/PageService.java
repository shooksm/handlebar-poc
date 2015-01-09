package com.shooksweb.service;

import com.shooksweb.model.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rob Whitaker on 1/5/2015.
 */

@Service
public class PageService {

    private Map<String, Page> pages = new HashMap<String, Page>();

    PageService() {
        Page productPage = new Page();
        productPage.setName("Product Page");
        productPage.setParent("What goes here?");
        productPage.setTitle("This is the Product Page");
        productPage.setDescription("The Product Page is where you can view attributes of a product");
        productPage.setKeywords("Product, Page");
        productPage.setHasHeader(true);
        productPage.setHasFooter(true);
        productPage.setHasNavigation(true);

        pages.put("product", productPage);
    }

    public Page getPage(String page) {
        return pages.get(page.toLowerCase());
    }
}