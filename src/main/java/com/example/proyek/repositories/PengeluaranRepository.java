package com.example.proyek.repositories;

import com.example.proyek.models.Pengeluaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengeluaranRepository extends JpaRepository<Pengeluaran, Long> {
}
