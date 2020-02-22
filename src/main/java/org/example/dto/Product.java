package org.example.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private final String productName;
    private final Company company;
    private Integer price;
    private LocalDate expiryDate;
    private LocalDateTime madeDate;

    public Product(String productName, Company company, Integer price, LocalDate expiryDate, LocalDateTime madeDate) {
        this.productName = productName;
        this.company = company;
        this.price = price;
        this.expiryDate = expiryDate;
        this.madeDate = madeDate;
    }

    public Product(String productName, Company company, Integer price, LocalDateTime madeDate) {
        this.productName = productName;
        this.company = company;
        this.price = price;
        this.madeDate = madeDate;
        this.expiryDate = LocalDate.MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) &&
                Objects.equals(company, product.company) &&
                Objects.equals(price, product.price) &&
                Objects.equals(expiryDate, product.expiryDate) &&
                Objects.equals(madeDate, product.madeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, company, price, expiryDate, madeDate);
    }

    public boolean isIndefiniteProductExpiryDate() {
        return LocalDate.MAX == expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public Company getCompany() {
        return company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(LocalDateTime madeDate) {
        this.madeDate = madeDate;
    }
}
