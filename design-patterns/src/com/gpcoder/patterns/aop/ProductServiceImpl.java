package com.gpcoder.patterns.aop;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        System.out.println("addProduct(): " + product.getName());
        products.add(product);
    }

    @Override
    public void remove(Product product) {
        System.out.println("removeProduct(): " + product.getName());
        products.remove(product);
    }

    @Override
    public long size() {
        System.out.println("size(): " + products.size());
        return products.size();
    }

}
