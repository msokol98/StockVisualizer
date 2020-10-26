package io.sokol.stockvisualizer.service;

import io.sokol.stockvisualizer.dto.CompanyDTO;
import io.sokol.stockvisualizer.exceptions.CompanyDoesNotExistException;

public interface CompanyService {
    CompanyDTO getCompanyBySymbol(String symbol) throws CompanyDoesNotExistException;
}
