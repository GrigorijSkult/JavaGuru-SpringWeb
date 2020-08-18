package com.bookrepository.repositoryutilities;

import com.bookrepository.repositoryutilities.exceptions.ItemNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Controller {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handlerNotFound(ItemNotFound exception) {
        System.out.println(exception.getMessage());
    }

    //Добавить
    //не доступная база данных/не существует таблици
}
