package com.example.proyek.repositories;

import com.example.proyek.models.PerencanaanAnggaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerencanaanAnggaranRepository extends JpaRepository<PerencanaanAnggaran, Long> {
}
