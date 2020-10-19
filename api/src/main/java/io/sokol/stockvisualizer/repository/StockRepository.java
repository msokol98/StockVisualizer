package io.sokol.stockvisualizer.repository;

import io.sokol.stockvisualizer.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {}
