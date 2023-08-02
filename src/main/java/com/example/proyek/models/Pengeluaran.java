package com.example.proyek.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Pengeluaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tanggalTransaksi;
    private String kategoriPengeluaran;
    private double jumlah;
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "perencanaan_anggaran_id")
    private PerencanaanAnggaran perencanaanAnggaran;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getKategoriPengeluaran() {
        return kategoriPengeluaran;
    }

    public void setKategoriPengeluaran(String kategoriPengeluaran) {
        this.kategoriPengeluaran = kategoriPengeluaran;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public PerencanaanAnggaran getPerencanaanAnggaran() {
        return perencanaanAnggaran;
    }

    public void setPerencanaanAnggaran(PerencanaanAnggaran perencanaanAnggaran) {
        this.perencanaanAnggaran = perencanaanAnggaran;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
