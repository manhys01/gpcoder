package com.gpcoder.annotation;

import java.util.List;

@XmlRootElement(value = "store", namespace = "com.gpcoder.annotation.reflection")
public class Store {

    @XmlElement
    private String name;

    @XmlElement
    private String location;

    @XmlElementWrapper
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
