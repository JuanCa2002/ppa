package com.puntopago.ppa.application.exceptions.general;

public class NotFoundException extends ApiException{

    public NotFoundException(String message){
        super(message, 404);
    }
}
