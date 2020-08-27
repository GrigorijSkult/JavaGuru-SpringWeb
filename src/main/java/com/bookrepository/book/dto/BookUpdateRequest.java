package com.bookrepository.book.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BookUpdateRequest {

    @NotEmpty
    String id;
    @NotEmpty
    @Size(min = 2, max = 20)
    String bookName;
    @Size(max = 255)
    private String bookDescription;

    public BookUpdateRequest() {
    }

    public BookUpdateRequest(@NotEmpty String id, @NotEmpty @Size(min = 2, max = 20) String bookName, @Size(max = 255) String bookDescription) {
        this.id = id;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        BookUpdateRequest that = (BookUpdateRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(bookDescription, that.bookDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookDescription);
    }

    @Override
    public String toString() {
        return "BookUpdateRequest{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
