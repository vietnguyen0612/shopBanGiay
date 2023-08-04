package com.VietNguyen.WesBanGiay.repository;

import com.VietNguyen.WesBanGiay.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
