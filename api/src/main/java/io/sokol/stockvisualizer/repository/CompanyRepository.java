package io.sokol.stockvisualizer.repository;

import io.sokol.stockvisualizer.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findBySymbol(String symbol);
}
