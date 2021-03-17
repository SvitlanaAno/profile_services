package com.profileService.profile.errors;

public class NameIsAlreadyTakenException extends RuntimeException {

    public NameIsAlreadyTakenException(String message) {
        super(message);
    }

}
