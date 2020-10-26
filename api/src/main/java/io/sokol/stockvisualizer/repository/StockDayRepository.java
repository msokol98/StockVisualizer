package io.sokol.stockvisualizer.repository;

import io.sokol.stockvisualizer.entity.StockDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StockDayRepository extends JpaRepository<StockDay, Long> {
    List<StockDay> findByDate(LocalDate date);
}

