package com.bookrepository.book.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    private String id;
    @NotEmpty
    @Size(min=1, max = 30)
    private String bookName;
    @Size(max = 255)
    private String bookDescription;

    public BookEntity() {
    }

    public BookEntity(String id, String bookName, String bookDescription) {
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
        BookEntity that = (BookEntity) o;
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
        return "BookEntity{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
