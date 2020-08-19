package com.bookrepository.book.mappers;

import com.bookrepository.book.domain.BookEntity;
import com.bookrepository.book.dto.BookResponse;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookEntity bookToEntity(BookResponse bookResponse) {
        return new BookEntity(
                bookResponse.getId(),
                bookResponse.getBook()
        );
    }

    public BookResponse bookToDto(BookEntity bookEntity) {
        return new BookResponse(
                bookEntity.getId(),
                bookEntity.getBookName()
        );
    }
}
