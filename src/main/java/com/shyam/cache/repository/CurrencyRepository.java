package com.shyam.cache.repository;

import com.shyam.cache.entity.CurrencyCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyCode, String> {
}
