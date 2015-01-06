package com.shooksweb.service;

import com.shooksweb.model.Page;

import java.util.ArrayList;

/**
 * Created by Rob Whitaker on 1/5/2015.
 */
public class PageService {

    private ArrayList<Page> pages = new ArrayList<>();

    protected void pageService() {
        Page productPage = new Page();
        productPage.setName("Product Page");
        productPage.setParent("What goes here?");
        productPage.setTitle("This is the Product Page");
        productPage.setDescription("The Product Page is where you can view attributes of a product");
        productPage.setKeywords("Product, Page");
        productPage.setHasHeader(true);
        productPage.setHasFooter(true);
        productPage.setHasNavigation(true);
    }
}