package com.bookrepository.book.restapi;

public class RestApiData {

    private String description;

    public RestApiData() {
    }

    public RestApiData(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
