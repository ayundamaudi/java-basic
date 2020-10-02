public class Buku {
    private String kode;
    private String judul;
    private String penerbit;

    public Buku() {
    }

    public Buku(String kode, String judul, String penerbit) {
        this.judul = judul;
        this.kode = kode;
        this.penerbit = penerbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}