package com.jsweeney.petfinder.pets;

public class MissingPetReportNotFoundException extends RuntimeException {

    public MissingPetReportNotFoundException(Long id) {
        super("Could not find missing pet report for id: " + id);
    }
}
