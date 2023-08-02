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
public class RencanaTabungan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bulan;
    private int tahun;
    private double jumlahTabungan;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
