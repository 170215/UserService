package com.users.userservice.exception;

public class InvalidCredentialExceptions extends Exception{
    public InvalidCredentialExceptions(String invalidPassword) {
    super(invalidPassword);
    }
}
