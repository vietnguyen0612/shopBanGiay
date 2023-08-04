package com.VietNguyen.WesBanGiay.repository;

import com.VietNguyen.WesBanGiay.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
