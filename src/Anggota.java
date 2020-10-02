import java.util.ArrayList;

public class Anggota {
    private String nomor;
    private String nama;
    private String alamat;
    private ArrayList daftarPinjaman;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList getDaftarPinjaman() {
        return daftarPinjaman;
    }

    public void setDaftarPinjaman(ArrayList daftarPinjaman) {
        this.daftarPinjaman = daftarPinjaman;
    }

    public Anggota() {
        daftarPinjaman = new ArrayList();
    }

    public Anggota(String nomor, String nama, String alamat) {
        this.alamat = alamat;
        this.nama = nama;
        this.nomor = nomor;
        daftarPinjaman = new ArrayList();
    }

    public void pinjam(Buku buku) {
        this.daftarPinjaman.add(buku);
    }

    public Buku kembalikan(Buku buku) {
        if (this.daftarPinjaman.contains(buku)) {
            this.daftarPinjaman.remove(buku);
            return buku;
        } else {
            return null;
        }
    }

    public Buku searchBuku(String kode) {
        Buku temp = null;
        for (int x = 0; x < this.daftarPinjaman.size(); x++) {
            temp = (Buku) this.daftarPinjaman.get(x);
            if (temp.getKode().equalsIgnoreCase(kode))
                break;
        }
        return temp;
    }   
}