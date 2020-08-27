package com.bookrepository.book.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BookCreateRequest {

    @NotEmpty
    @Size(min = 2, max = 20)
    private String bookName;
    @Size(max = 255)
    private String bookDescription;

    public BookCreateRequest() {
    }

    public BookCreateRequest(@NotEmpty @Size(min = 2, max = 20) String bookName, @Size(max = 255) String bookDescription) {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCreateRequest that = (BookCreateRequest) o;
        return Objects.equals(bookName, that.bookName) &&
                Objects.equals(bookDescription, that.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookDescription);
    }

    @Override
    public String toString() {
        return "BookCreateRequest{" +
                "bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
