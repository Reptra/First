package com.example.proyek.services;

import com.example.proyek.models.Pengeluaran;
import com.example.proyek.repositories.PengeluaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PengeluaranService {
    private final PengeluaranRepository pengeluaranRepository;


    @Autowired
    public PengeluaranService(PengeluaranRepository pengeluaranRepository) {
        this.pengeluaranRepository = pengeluaranRepository;
    }

    public Pengeluaran savePengeluaran(Pengeluaran pengeluaran) {
        return pengeluaranRepository.save(pengeluaran);
    }
}
