package ru.netology.authorization.model;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials (String msg) {
        super(msg);
    }

}
