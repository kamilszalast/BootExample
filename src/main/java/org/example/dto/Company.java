package org.example.dto;

import java.util.Objects;

public class Company {

    private static final String DEFAULT_COMPANY_NAME = "NO NAME COMPANY";
    private final String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company() {
        this.companyName = DEFAULT_COMPANY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName);
    }
}
