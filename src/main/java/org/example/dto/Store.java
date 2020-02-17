package org.example.dto;

import java.util.List;
import java.util.Objects;

public class Store {

    private final List<Product> products;
    private final String storeName;
    private final Company company;

    public Store(List<Product> products, String storeName, Company company) {
        this.products = products;
        this.storeName = storeName;
        this.company = company;
    }

    public Store(List<Product> products, String storeName) {
        this.products = products;
        this.storeName = storeName;
        this.company = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Store store = (Store) o;
        return Objects.equals(products, store.products) &&
                Objects.equals(storeName, store.storeName) &&
                Objects.equals(company, store.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, storeName, company);
    }

    public Company getCompany() {
        return company;
    }

    public boolean isCompanyStore() {
        return Objects.nonNull(company);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStoreName() {
        return storeName;
    }
}
