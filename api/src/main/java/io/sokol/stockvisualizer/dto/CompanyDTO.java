package io.sokol.stockvisualizer.dto;

import io.sokol.stockvisualizer.entity.Company;
import io.sokol.stockvisualizer.entity.StockDay;

import java.util.List;

public class CompanyDTO {

    private Company company;
    public CompanyDTO(Company c) {
        company = c;
    }

    public String getSymbol() {
        return company.getSymbol();
    }

    public String getName() {
        return company.getName();
    }

    public String getExchange() {
        return company.getExchange();
    }

    public String getIndustry() {
        return company.getIndustry();
    }

    public String getWebsite() {
        return company.getWebsite();
    }


    public String getDescription() {
        return company.getDescription();
    }


    public String getCeo() {
        return company.getCeo();
    }

    public String getSector() {
        return company.getSector();
    }

    public int getNoEmployees() {
        return company.getNoEmployees();
    }

    public String getCountry() {
        return company.getCountry();
    }

    public String getPhone() {
        return company.getPhone();
    }

    public String getAddress() {
        return company.getAddress();
    }

    public String getCity() {
        return company.getCity();
    }

    public String getState() {
        return company.getState();
    }

    public String getZip() {
        return company.getZip();
    }

    public String getImage() {
        return company.getImage();
    }

    public String getIpoDate() {
        return company.getIpoDate();
    }

    public List<StockDay> getStockDays() {
        return company.getStockDays();
    }


}
