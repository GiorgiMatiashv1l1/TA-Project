package model;

import java.util.List;

public class ProductsResponse {
    private int responseCode;
    private List<Product> products;

    // Default Constructor
    public ProductsResponse() {
    }

    public ProductsResponse(int responseCode, List<Product> products) {
        this.responseCode = responseCode;
        this.products = products;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductsResponse{" +
                "responseCode=" + responseCode +
                ", products=" + products +
                '}';
    }
}