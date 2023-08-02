package com.example.proyek.controllers;

import com.example.proyek.models.Pengeluaran;
import com.example.proyek.models.PerencanaanAnggaran;
import com.example.proyek.models.User;
import com.example.proyek.services.PengeluaranService;
import com.example.proyek.services.PerencanaanAnggaranService;
import com.example.proyek.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {
    private final UserService userService;
    private final PerencanaanAnggaranService perencanaanAnggaranService;

    private final PengeluaranService pengeluaranService;

    @Autowired
    public UserController(UserService userService, PerencanaanAnggaranService perencanaanAnggaranService,
                          PengeluaranService pengeluaranService) {
        this.userService = userService;
        this.perencanaanAnggaranService = perencanaanAnggaranService;
        this.pengeluaranService = pengeluaranService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Ganti "login" dengan nama halaman login Thymeleaf Anda
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Lakukan validasi login
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Login berhasil, lakukan sesuatu (misalnya, redirect ke halaman lain)
            return "redirect:/dashboard"; // Ganti "dashboard" dengan halaman yang sesuai
        } else {
            // Login gagal, lakukan sesuatu (misalnya, redirect kembali ke halaman login)
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Ganti "register" dengan nama halaman register Thymeleaf Anda
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        // Lakukan validasi data atau manipulasi lain yang diperlukan sebelum menyimpan ke database
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUang(0.0); // Isi uang dengan nilai default saat register

        userService.saveUser(user);

        return "redirect:/login"; // Redirect ke halaman login setelah register
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Ambil data pengguna yang sedang login dari session (anda bisa gunakan Spring Security untuk otentikasi)
        String username = "user1"; // Ganti dengan kode untuk mengambil username dari session

        // Set username ke dalam model untuk digunakan di halaman dashboard.html
        model.addAttribute("username", username);

        return "dashboard";
    }

    @GetMapping("/buat-anggaran")
    public String showBuatAnggaran() {
        return "buat-anggaran";
    }

    @PostMapping("/buat-anggaran")
    public String buatAnggaran(@RequestParam int bulan, @RequestParam double budget, @RequestParam String sumberAnggaran,
                               @RequestParam Map<String, String> form) {
        String username = "user1"; // Ganti dengan kode untuk mengambil username dari session

        User user = userService.getUserByUsername(username);

        // Simpan data anggaran bulanan ke dalam database
        PerencanaanAnggaran perencanaanAnggaran = new PerencanaanAnggaran();
        perencanaanAnggaran.setBulan(bulan);
        perencanaanAnggaran.setAnggaranBulanan(budget);
        perencanaanAnggaran.setSumberAnggaran(sumberAnggaran);
        perencanaanAnggaran.setUser(user);

        perencanaanAnggaranService.savePerencanaanAnggaran(perencanaanAnggaran);

        // Simpan data pengeluaran ke dalam basis data
        for (Map.Entry<String, String> entry : form.entrySet()) {
            if (entry.getKey().startsWith("kategori[")) {
                int index = Integer.parseInt(entry.getKey().replace("kategori[", "").replace("]", ""));
                String kategori = entry.getValue();
                String jumlahKey = "jumlah[" + index + "]";
                double jumlah = Double.parseDouble(form.get(jumlahKey));

                Pengeluaran pengeluaran = new Pengeluaran();
                pengeluaran.setKategoriPengeluaran(kategori); // Pastikan nama setter benar
                pengeluaran.setJumlah(jumlah);
                pengeluaran.setPerencanaanAnggaran(perencanaanAnggaran);

                pengeluaranService.savePengeluaran(pengeluaran);
            }
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/catat-pengeluaran")
    public String showCatatPengeluaran() {
        return "catat-pengeluaran";
    }

    @GetMapping("/kelola-tabungan")
    public String showKelolaTabungan() {
        return "kelola-tabungan";
    }
}
