package com.studentrepository.projectUtilites;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.studentrepository.projectUtilites.exceptions.*;

@ControllerAdvice
public class Controller {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handlerNotFound(ItemNotFound exception){
        System.out.println(exception.getMessage());
    }

    //Добавить
    //не доступная база данных/не существует таблици
}
