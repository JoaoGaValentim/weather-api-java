package com.github.joaogavalentim.climatic.app.services.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("NotFoundException: Request don't found.");
    }
}
