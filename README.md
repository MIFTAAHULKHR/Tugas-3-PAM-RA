# My Profile App

Aplikasi profil pribadi sederhana yang dibangun menggunakan **Compose Multiplatform**. Aplikasi ini menampilkan informasi profil Miftahul Khoiriyah dengan antarmuka yang modern dan responsif.

## Penjelasan Komponen UI (Jetpack Compose)

Dalam pembuatan aplikasi ini, digunakan beberapa komponen dasar Jetpack Compose untuk menyusun antarmuka pengguna:

1.  **Column**: Digunakan sebagai layout utama untuk menyusun elemen secara vertikal dari atas ke bawah, seperti menyusun Header, Kartu Informasi, dan Tombol.
2.  **Row**: Digunakan di dalam komponen `InfoItem` untuk menyusun ikon dan teks secara horizontal (berdampingan).
3.  **Box**: Digunakan pada bagian foto profil untuk menumpuk elemen. Dalam hal ini, `Box` membungkus `Image` agar bisa diberikan efek *border* dan *clip* berbentuk lingkaran.
4.  **Card**: Digunakan untuk membungkus list informasi (Email, Phone, Location) agar terlihat terkelompok dalam satu kontainer dengan sudut yang melengkung (*rounded*) dan latar belakang yang berbeda.
5.  **Text**: Komponen utama untuk menampilkan informasi teks, seperti nama, deskripsi bio yang panjang, serta label informasi. Digunakan juga pengaturan *font weight* dan *text align*.
6.  **Button**: Digunakan untuk aksi interaktif "Contact Me" di bagian bawah layar.
7.  **Image & Icon**: 
    *   `Image` digunakan untuk menampilkan foto profil (`profile.jpg`) dengan skalasi *Crop*.
    *   `Icon` (dari Material Icons) digunakan untuk memberikan visualisasi pada tiap item informasi (Email, Telepon, dan Lokasi).

## Output Hasil

Aplikasi ini menghasilkan satu halaman profil yang terdiri dari:
- **Header**: Foto profil berbentuk lingkaran (circular) dengan *border* biru, diikuti nama tebal dan deskripsi diri (bio) yang rapi di tengah.
- **Informasi Kontak**: Sebuah kartu (Card) yang berisi daftar email, nomor telepon, dan lokasi Indonesia, lengkap dengan ikon pendukung yang memberikan kesan profesional.
- **Interaksi**: Tombol "Contact Me" di bagian bawah yang memenuhi lebar layar untuk memudahkan akses navigasi lebih lanjut.

Layout aplikasi ini juga sudah mendukung fitur *scrolling* (`verticalScroll`), sehingga tetap nyaman dilihat meskipun dijalankan pada perangkat dengan layar kecil.
