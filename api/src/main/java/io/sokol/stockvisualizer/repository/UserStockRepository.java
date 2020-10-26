package io.sokol.stockvisualizer.repository;

import io.sokol.stockvisualizer.entity.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStockRepository extends JpaRepository<UserStock, Long> {
}
