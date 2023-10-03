package com.ashaka.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Cloud not found the id"+id);
    }

}
