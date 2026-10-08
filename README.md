# Minpro-3-PBO-SistemListTugasKuliah <br>  

# Judul : Sistem List Tugas Kuliah (Mini Project 3)

---

## 1. Deskripsi Singkat Program  
Pada program ini saya mengembangkan sistem berbasis CLI untuk membantu mahasiswa dalam mengelola, mencatat, serta memantau status penyelesaian daftar tugas perkuliahan secara dinamis. Di dalam program ini pengguna dapat menambahkan tugas baru, menampilkan daftar tugas, mengubah data tugas, memperbarui status pengerjaan tugas, mencari tugas berdasarkan mata kuliah, serta menghapus tugas yang sudah selesai. Program ini dikembangkan dengan menerapkan arsitektur MVC (Model-View-Controller), prinsip-prinsip OOP (Encapsulation, Inheritance, Polymorphism, Abstraction), Interface, penggunaan keyword `final`, generator Auto ID, serta sistem validasi input yang ketat agar aplikasi tidak gampang *crash*.

---  

## 2. Penjelasan Class, Interface & Atribut  
Struktur project dipisah ke dalam arsitektur MVC berbasis package:

**Package model:**
* **PenyimpananData (interface)**
  * Method contract: `getKategoriFormat()`, `cetakBaris()`
* **EntitasTugas (superclass / abstract class)**
  * kodeTugas (final)
  * namaMatkul
  * detailTugas
  * dateline
  * isSelesai
* **TugasIndividu (subclass 1)**
  * platformPengumpulan
* **TugasKelompok (subclass 2)**
  * jumlahAnggota
* **Mahasiswa**
  * nim (final)
  * nama (final)

**Package controller:**
* **TugasController**
  * listTugasKu (ArrayList<EntitasTugas>)
  * counterID (static int)
  * PREFIX (static final String)

**Package view:**
* **MainView**
  * controller (final TugasController)
  * scan (final Scanner)

**Package Main:**
* **main** (Entry point)

---

## 3. Penjelasan Tiap Class & Interface

* **PenyimpananData (Interface)**
  * Penjelasan interface: Berperan sebagai kontrak standar pengeluaran format data yang menjamin setiap entitas tugas dapat mencetak baris data dan kategorinya secara konsisten.

* **EntitasTugas (Abstract Class)**
  * Penjelasan class: Berfungsi sebagai superclass (abstract class) yang mengimplementasikan `PenyimpananData` dan menampung atribut umum tugas perkuliahan (`kodeTugas`, `namaMatkul`, `detailTugas`, `dateline`, `isSelesai`).
  * Menyediakan abstract method `getTipeTugas()` yang wajib di-override oleh kelas turunan.

* **TugasIndividu (Subclass 1)**
  * Penjelasan class: Class turunan dari `EntitasTugas` yang khusus menampung data tugas kategori individu dengan atribut tambahan `platformPengumpulan`.
  * Meng-override method `getTipeTugas()` dan `cetakBaris()` untuk menyesuaikan tampilan tabel khusus tugas individu.

* **TugasKelompok (Subclass 2)**
  * Penjelasan class: Class turunan dari `EntitasTugas` yang khusus menampung data tugas kategori kelompok dengan atribut tambahan `jumlahAnggota`.
  * Meng-override method `getTipeTugas()` dan `cetakBaris()` untuk menampilkan jumlah anggota tim.

* **Mahasiswa**
  * Penjelasan class: Menampung identitas mahasiswa (`nim` dan `nama`) yang di-set sebagai `final` agar nilainya tidak dapat diubah setelah diinisialisasi (*immutable*).

* **TugasController**
  * Penjelasan class: Merupakan pusat pengolahan logika bisnis, pengelolaan `ArrayList<EntitasTugas>`, pencarian data berbasis *Method Overloading*, serta penjana kode tugas otomatis (*Auto-Increment ID Generator*).

* **MainView**
  * Penjelasan class: Mengelola antarmuka CLI, rendering dashboard statistik tugas, alur input interaktif, serta sanitisasi/validasi input pengguna.

* **main**
  * Penjelasan class: Class entry point utama untuk menginisialisasi objek `Mahasiswa` dan menjalankan antarmuka utama pada `MainView`.

---  

## 4. Penjelasan Penerapan Abstraction, Inheritance, Polymorphism, Interface, Encapsulation & Keyword Final  

* **Abstraction & Interface**
  * Abstract Class `EntitasTugas` mencegah instansiasi objek generik dan mewajibkan subclass mendefinisikan method abstrak `getTipeTugas()`.
  * Interface `PenyimpananData` memberikan kontrak baku untuk penataan output tabel CLI.

* **Encapsulation & Keyword `final`**
  * Seluruh atribut di dalam model menggunakan access modifier `private` dan diakses melalui getter/setter.
  * Keyword `final` digunakan pada atribut identitas mutlak (`nim`, `nama`, `kodeTugas`) untuk menjaga immutability data, serta pada konstanta `PREFIX = "TGS-"` di Controller.

* **Inheritance**
  * Class `EntitasTugas` bertindak sebagai Superclass yang diwarisi oleh `TugasIndividu` dan `TugasKelompok` menggunakan keyword `extends`.

* **Polymorphism**
  * **Method Overriding**: Terdapat pada method `getTipeTugas()` dan `cetakBaris()` pada subclass `TugasIndividu` dan `TugasKelompok`.
  * **Method Overloading**: Terdapat pada class `TugasController` berupa dua variasi method `cariTugas()` (berdasarkan Kode Unik Tugas atau Nama Mata Kuliah).

---

## 5. Penjelasan Alur Program dan Dokumentasi Output  
Saat aplikasi dijalankan, sistem secara otomatis memasukkan dummy data sampel dan menampilkan dashboard statistik tugas di atas menu utama.

Menu utama menyediakan 7 pilihan interaktif:

## 5. Penjelasan Alur Program dan Dokumentasi Output  
Saat aplikasi dijalankan, sistem secara otomatis memasukkan dummy data sampel dan menampilkan dashboard statistik tugas di atas menu utama.

<img width="648" height="301" alt="Cuplikan layar 2026-10-08 221645" src="https://github.com/user-attachments/assets/f51a924b-5f28-4ec9-b60b-dc00ca73af26" />

Menu utama menyediakan 7 pilihan interaktif:

1. **Tambah Data Tugas Baru (Create):**
   Sistem membuat Kode Tugas secara otomatis (Auto ID seperti `TGS-003`). Pengguna memilih jenis tugas (Individu/Kelompok) dan memasukkan detail tugas. Fungsi validasi `bacaTeks()` menolak input jika berupa string kosong atau hanya terdiri dari karakter angka.
   <br>
   <p align="center">
     <img width="465" height="429" alt="Cuplikan layar 2026-10-08 221959" src="https://github.com/user-attachments/assets/cdb6cccd-f7a3-42ac-bec7-3689d0fa6584" />
   </p>

2. **Tampilkan Daftar Tugas (Read):**
   Menampilkan tabel daftar seluruh tugas beserta atribut spesifik dan status pengerjaannya secara rapi. Data yang tampil mencakup dummy data awal dan data baru yang ditambahkan.
   <br>
   <p align="center">
     <img width="842" height="302" alt="image" src="https://github.com/user-attachments/assets/2edaca25-a859-4c6c-a194-19e39abc3087" />
   </p>

3. **Cari Tugas berdasarkan Mata Kuliah:**
   Memanfaatkan *method overloading* untuk memfilter dan menampilkan daftar tugas sesuai nama mata kuliah yang diinputkan oleh pengguna.
   <br>
   <p align="center">
     <img width="828" height="317" alt="image" src="https://github.com/user-attachments/assets/2c33abf4-0814-46b9-8455-a76890731c30" />
   </p>

4. **Tandai Status Tugas (Task Tracking):**
   Memungkinkan pengguna memperbarui status tugas dari `BELUM [x]` menjadi `SELESAI [v]`. Perubahan status ini secara otomatis memperbarui angka kalkulasi pada Dashboard Statistik.
   <br>
   <p align="center">
     <img width="836" height="411" alt="image" src="https://github.com/user-attachments/assets/990821ec-ca2c-4a16-bef1-16a6fef9ea98" />
   </p>

5. **Ubah Data Tugas (Update):**
   Sistem menampilkan tabel seluruh daftar tugas terlebih dahulu agar pengguna tidak salah memasukkan Kode Tugas, kemudian meminta masukan data baru yang ingin diubah.
   <br>
   <p align="center">
     <img width="834" height="486" alt="image" src="https://github.com/user-attachments/assets/5e791b95-7bdf-4537-9ca1-b47824e62059" />
   </p>

6. **Hapus Data Tugas (Delete):**
   Sistem menampilkan daftar tugas aktif terlebih dahulu untuk memberikan konteks visual, lalu menghapus objek tugas berdasarkan Kode Tugas yang dipilih dari `ArrayList`.
   <br>
   <p align="center">
     <img width="832" height="446" alt="image" src="https://github.com/user-attachments/assets/2fa63799-dd2b-4f68-a8b9-3df55c626e42" />
   </p>

7. **Keluar Application:**
   Menutup perulangan (*looping*) program CLI dan menampilkan pesan terima kasih/penutup kepada pengguna.
   <br>
   <p align="center">
     <img width="528" height="309" alt="image" src="https://github.com/user-attachments/assets/85624318-04a2-4fce-930b-52e0aa11005d" />
   </p>

---  
