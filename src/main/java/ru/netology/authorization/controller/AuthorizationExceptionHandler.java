package ru.netology.authorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.authorization.model.InvalidCredentials;
import ru.netology.authorization.model.UnauthorizedUser;

@ControllerAdvice
public class AuthorizationExceptionHandler {

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity <String> handleUnauthorized(UnauthorizedUser ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity <String> handleUnauthorized(InvalidCredentials ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity <String> handleBlind(BindException ex) {

        String message = String.format("%s field is not filled", ex.getFieldError().getField());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
