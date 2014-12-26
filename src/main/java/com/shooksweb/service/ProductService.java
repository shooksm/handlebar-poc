package com.shooksweb.service;

import com.shooksweb.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
	private ArrayList<Product> products = new ArrayList<>();

	ProductService() {
		for (Integer i = 0; i < 5; i++) {
			Product product = new Product();
			product.setName("Product " + i.toString());
			product.setComparePrice(19.99 * i);
			product.setPrice(9.99 * i);
			product.setProductId("dsw12340" + i.toString());
			products.add(product);
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
}
