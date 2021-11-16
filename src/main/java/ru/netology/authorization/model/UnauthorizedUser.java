package ru.netology.authorization.model;

public class UnauthorizedUser extends RuntimeException{

    public UnauthorizedUser(String message) {
        super(message);
    }
}
