package org.example.dto;

import java.util.List;
import java.util.Objects;

public class Mall {

    private final List<Store> stores;

    public Mall(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mall mall = (Mall) o;
        return Objects.equals(stores, mall.stores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stores);
    }
}
