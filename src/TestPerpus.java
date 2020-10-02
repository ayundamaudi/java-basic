import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPerpus {
    static Perpustakaan perpus = new Perpustakaan();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int pilihan = 0;
        do {
            renderMenu();
            pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 1:
                    daftarAnggota();
                    break;
                case 2:
                    inputAnggota(input);
                    break;
                case 3:
                    hapusAnggota(input);
                    break;
                case 4:
                    daftarBuku();
                    break;
                case 5:
                    inputBuku(input);
                    break;
                case 6:
                    hapusBuku(input);
                    break;
                case 7:
                    pinjamBuku(input);
                    break;
                case 8:
                    kembalikanBuku(input);
                    break;
                case 9:
                    System.out.println("Bye..bye....");
                    break;
            }
        } while (pilihan != 9);
    }

    static void daftarAnggota() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("DAFTAR ANGGOTA");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Nomor Anggota" + "\t\t\t" + "Nama" + "\t\t\t" + "Alamat");
        for (int x = 0; x < perpus.getDaftarAnggota().size(); x++) {
            System.out.println(((Anggota) perpus.getDaftarAnggota().get(x)).getNomor() + "\t\t\t\t"
                    + ((Anggota) perpus.getDaftarAnggota().get(x)).getNama() + "\t\t\t"
                    + ((Anggota) perpus.getDaftarAnggota().get(x)).getAlamat());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    static void daftarBuku() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("DAFTAR BUKU");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Kode Buku" + "\t\t\t" + "Judul" + "\t\t\t" + "Penerbit");
        for (int x = 0; x < perpus.getDaftarBuku().size(); x++) {
            System.out.println(((Buku) perpus.getDaftarBuku().get(x)).getKode() + "\t\t\t\t"
                    + ((Buku) perpus.getDaftarBuku().get(x)).getJudul() + "\t\t\t"
                    + ((Buku) perpus.getDaftarBuku().get(x)).getPenerbit());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    static void renderMenu() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println("P E R P U T A K A A N");
        System.out.println("---------------------");
        System.out.println("[1]Daftar Anggota");
        System.out.println("[2]Anggota Baru");
        System.out.println("[3]Hapus Anggota");
        System.out.println("[4]Daftar Buku");
        System.out.println("[5]Buku Baru");
        System.out.println("[6]Hapus Buku");
        System.out.println("[7]Pinjam Buku");
        System.out.println("[8]Kembalikan Buku");
        System.out.println("[9]Keluar");
        System.out.println("----------------------");
        System.out.print("Pilihan: ");
    }

    static void pinjamBuku(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("ANGGOTA PINJAM BUKU");
        System.out.println("--------------------------------------");
        System.out.print("Nomor Anggota: ");
        String nomor = input.readLine();
        System.out.print("Kode Buku: ");
        String kode = input.readLine();
        System.out.println(perpus.pinjamBuku(nomor, kode));
    }

    static void kembalikanBuku(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("ANGGOTA KEMABALIKAN BUKU");
        System.out.println("--------------------------------------");
        System.out.print("Nomor Anggota: ");
        String nomor = input.readLine();
        System.out.print("Kode Buku: ");
        String kode = input.readLine();
        perpus.kembalikanBuku(nomor, kode);
    }

    static void inputAnggota(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("ANGGOTA BARU");
        System.out.println("--------------------------------------");
        Anggota agt = new Anggota();
        System.out.print("Nomor Anggota: ");
        agt.setNomor(input.readLine());
        System.out.print("Nama Anggota: ");
        agt.setNama(input.readLine());
        System.out.print("Alamat: ");
        agt.setAlamat(input.readLine());
        perpus.addAnggota(agt);
        System.out.println("Data Anggota tersimpan...");
    }

    static void inputBuku(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("BUKU BARU");
        System.out.println("--------------------------------------");
        Buku buku = new Buku();
        System.out.print("Kode Buku: ");
        buku.setKode(input.readLine());
        System.out.print("Judul: ");
        buku.setJudul(input.readLine());
        System.out.print("Penerbit: ");
        buku.setPenerbit(input.readLine());
        perpus.addBuku(buku);
        System.out.println("Data Buku tersimpan...");
    }

    static void hapusAnggota(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("HAPUS ANGGOTA");
        System.out.println("--------------------------------------");
        System.out.print("Input Nomor Anggota: ");
        String nomor = input.readLine();
        int x = perpus.deleteAnggota(nomor);
        if (x == 1)
            System.out.println("Data terhapus...");
        else
            System.out.println("Data gagal dihapus...");
    }

    static void hapusBuku(BufferedReader input) throws IOException {
        System.out.println("--------------------------------------");
        System.out.println("HAPUS BUKU");
        System.out.println("--------------------------------------");
        System.out.print("Input Kode Buku: ");
        String kode = input.readLine();
        int x = perpus.deleteBuku(kode);
        if (x == 1)
            System.out.println("Data terhapus...");
        else
            System.out.println("Data gagal dihapus...");
    }
}