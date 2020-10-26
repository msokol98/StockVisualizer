package io.sokol.stockvisualizer.service;

import io.sokol.stockvisualizer.dto.CompanyDTO;
import io.sokol.stockvisualizer.entity.Company;
import io.sokol.stockvisualizer.exceptions.CompanyDoesNotExistException;
import io.sokol.stockvisualizer.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepo;

    @Override
    public CompanyDTO getCompanyBySymbol(String symbol) throws CompanyDoesNotExistException {
        Optional<Company> optionalCompany = companyRepo.findBySymbol(symbol);
        optionalCompany.orElseThrow(CompanyDoesNotExistException::new);
        return new CompanyDTO(optionalCompany.get());
    }
}
