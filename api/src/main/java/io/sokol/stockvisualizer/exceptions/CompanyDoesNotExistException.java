package io.sokol.stockvisualizer.exceptions;

public class CompanyDoesNotExistException extends Exception {
    public CompanyDoesNotExistException() {
        super("Could not find a company by given params.");
    }
}
