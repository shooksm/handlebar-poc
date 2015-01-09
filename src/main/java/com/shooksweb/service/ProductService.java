package com.shooksweb.service;

import com.shooksweb.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class ProductService {
    private ArrayList<Product> products = new ArrayList<>();

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
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Product> getProductsByPage(int page) {
        int startIndex = (page - 1) * 10;
        int endIndex = startIndex + 9;
        ArrayList<Product> out = new ArrayList<Product>();
        for (int i = startIndex; i <= endIndex; i++) {
            out.add(products.get(i));
        }
        return out;
    }
}
