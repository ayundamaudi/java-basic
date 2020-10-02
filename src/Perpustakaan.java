import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList daftarAnggota;
    private ArrayList daftarBuku;

    public Perpustakaan() {
        daftarAnggota = new ArrayList();
        daftarBuku = new ArrayList();
        daftarAnggota.add(new Anggota("001", "Hendro", "Salatiga"));
        daftarAnggota.add(new Anggota("002", "Steven", "Semarang"));
        daftarBuku.add(new Buku("BK001", "Sincan", "Elexmedia"));
        daftarBuku.add(new Buku("BK002", "Detektif Conan", "Elexmedia"));
    }

    public ArrayList getDaftarAnggota() {
        return daftarAnggota;
    }

    public ArrayList getDaftarBuku() {
        return daftarBuku;
    }

    public void addAnggota(Anggota agt) {
        this.daftarAnggota.add(agt);
    }

    public int deleteAnggota(String nomor) {
        if (searchAnggota(nomor) != null) {
            this.daftarAnggota.remove(searchAnggota(nomor));
            return 1;
        } else
            return 0;
    }

    public Anggota searchAnggota(String nomor) {
        Anggota temp = null;
        for (int x = 0; x < daftarAnggota.size(); x++) {
            temp = (Anggota) daftarAnggota.get(x);
            if (temp.getNomor().equalsIgnoreCase(nomor))
                break;
            temp = null;
        }
        return temp;
    }

    public void addBuku(Buku buku) {
        this.daftarBuku.add(buku);
    }

    public int deleteBuku(String kode) {
        if (searchBuku(kode) != null) {
            this.daftarBuku.remove(searchBuku(kode));
            return 1;
        } else
            return 0;
    }

    public Buku searchBuku(String kode) {
        Buku buku = null;
        for (int x = 0; x < daftarBuku.size(); x++) {
            buku = (Buku) daftarBuku.get(x);
            if (buku.getKode().equalsIgnoreCase(kode))
                break;
            buku = null;
        }
        return buku;
    }

    public String pinjamBuku(String nomor, String kode) {
        if (searchBuku(kode) != null) {
            if (searchAnggota(nomor) != null) {
                Buku buku = searchBuku(kode);
                Anggota agt = searchAnggota(nomor);
                agt.pinjam(buku);
                deleteBuku(kode);
                return "Transaksi berhasil...";
            } else {
                return "Maaf, Anda belum terdaftar sebagai Anggota...";
            }
        } else {
            return "Buku Keluar....";
        }
    }

    public void kembalikanBuku(String nomor, String kode) {
        addBuku(searchAnggota(nomor).searchBuku(kode));
        searchAnggota(nomor).kembalikan(searchAnggota(nomor).searchBuku(kode));
    }
}