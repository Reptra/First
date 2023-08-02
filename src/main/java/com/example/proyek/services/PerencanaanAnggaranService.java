package com.example.proyek.services;

import com.example.proyek.models.PerencanaanAnggaran;
import com.example.proyek.repositories.PerencanaanAnggaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerencanaanAnggaranService {
    private final PerencanaanAnggaranRepository perencanaanAnggaranRepository;

    @Autowired
    public PerencanaanAnggaranService(PerencanaanAnggaranRepository perencanaanAnggaranRepository) {
        this.perencanaanAnggaranRepository = perencanaanAnggaranRepository;
    }

    public PerencanaanAnggaran savePerencanaanAnggaran(PerencanaanAnggaran perencanaanAnggaran) {
        return perencanaanAnggaranRepository.save(perencanaanAnggaran);
    }
}
