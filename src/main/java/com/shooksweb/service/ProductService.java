package com.shooksweb.service;

import com.shooksweb.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class ProductService {
    private ArrayList<Product> products = new ArrayList<>();
    private int numberOfProducts;
    private int firstProductForPage;
    private int lastProductForPage;
    private int numberOfPages;
    private int nextPage;
    private int previousPage;
    private int currentPage;

    ProductService() {
        Random randomNumber = new Random();
        int imageNumber;
        for (Integer i = 0; i < 40; i++) {
            Product product = new Product();
            product.setName("Product " + i.toString());
            product.setComparePrice(19.99 * i);
            product.setPrice(9.99 * i);
            product.setProductId("dsw12340" + i.toString());
            imageNumber = randomNumber.nextInt(10) + 1;
            String imageURL = String.format("http://lorempixel.com/188/171/animals/%d", imageNumber);
            product.setProductImage(imageURL);

            products.add(product);
        }
        setNumberOfProducts(products.size());
        setNumberOfPages(calculateNumberOfPages());
    }

    private int calculateNumberOfPages() {
        return (products.size() + 10 - 1) / 10;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Product> getProductsByPage(int page) {
        int startIndex = (page - 1) * 10;
        int endIndex = ((startIndex + 9) < getNumberOfProducts()) ? startIndex + 9 : getNumberOfProducts();
        setFirstProductForPage(startIndex);
        setLastProductForPage(endIndex);
        ArrayList<Product> out = new ArrayList<Product>();
        for (int i = startIndex; i <= endIndex; i++) {
            out.add(getProducts().get(i));
        }
        setNextPage(page + 1);
        setPreviousPage(page - 1);
        setCurrentPage(page);
        return out;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getFirstProductForPage() {
        return firstProductForPage;
    }

    public void setFirstProductForPage(int firstProductForPage) {
        this.firstProductForPage = firstProductForPage;
    }

    public int getLastProductForPage() {
        return lastProductForPage;
    }

    public void setLastProductForPage(int lastProductForPage) {
        this.lastProductForPage = lastProductForPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
