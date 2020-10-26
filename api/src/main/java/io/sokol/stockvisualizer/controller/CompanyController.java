package io.sokol.stockvisualizer.controller;

import io.sokol.stockvisualizer.dto.CompanyDTO;
import io.sokol.stockvisualizer.exceptions.CompanyDoesNotExistException;
import io.sokol.stockvisualizer.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public CompanyDTO getCompanyBySymbol(@RequestParam("symbol") String symbol) throws CompanyDoesNotExistException {
        return companyService.getCompanyBySymbol(symbol);
    }
}
