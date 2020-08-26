package com.bookrepository.core.apirequests;

import java.util.Objects;

public class QuoteRequest {

    private String description;

    public QuoteRequest() {
    }

    public QuoteRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuoteRequest that = (QuoteRequest) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "RestApiData{" +
                "description='" + description + '\'' +
                '}';
    }
}
