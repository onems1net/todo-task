package com.animesh.todotask.exception;

import com.animesh.todotask.model.BalanceTestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<BalanceTestResult> handleException(ValidationException validationException) {
        return new ResponseEntity<BalanceTestResult>(validationException.getBalanceTestResult(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ToDoItemNotFoundException.class)
    protected ResponseEntity<String> handleException(ToDoItemNotFoundException toDoItemNotFoundException) {
        return new ResponseEntity<String>(toDoItemNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
