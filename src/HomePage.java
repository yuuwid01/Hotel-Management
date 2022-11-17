
import java.util.Scanner;

public class HomePage {
    private Scanner scanner = new Scanner(System.in);

    public HomePage() {
        run();
    }

    private void run() {
        String str = """
                ============== HOTEL MANAGEMENT ==============
                1. Check In
                2. Check Out
                3. Daftar Reservasi
                0. Keluar
                ==============================================
                """;

        int menu = -1;

        do {
            System.out.print(str);
            System.out.print("Pilih: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    daftarReservasi();
                    break;
                case 0:
                    System.out.println("Keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }

        } while (menu != 0);
    }

    private void checkIn() {
        System.out.println("------------------ RESERVASI -----------------");
        System.out.println("------------------ CHECK  IN -----------------");

        String nik, nama, alamat, noTelp;

        System.out.print("Masukan NIK Tamu    : ");
        nik = scanner.nextLine();

        System.out.print("Masukan Nama Tamu   : ");
        nama = scanner.nextLine();

        System.out.print("Masukan Alamat Tamu : ");
        alamat = scanner.nextLine();

        System.out.print("Masukan No Telp Tamu: ");
        noTelp = scanner.nextLine();

        Kamar kamar = pilihKamar();

        System.out.print("Berapa Malam        : ");
        int malam = scanner.nextInt();
        scanner.nextLine();

        Tamu tamu = new Tamu(nik, nama, alamat, noTelp);

        Hotel.checkIn(tamu, kamar, malam);
    }

    private Kamar pilihKamar() {
        boolean pilihKamarStatus = false;
        String kodeKamar;
        Kamar kamar;

        do {
            System.out.print("  Masukan Kode Kamar    : ");
            kodeKamar = scanner.nextLine();
            kamar = Hotel.cariKamar(kodeKamar);

            if (kamar != null) {
                if (kamar.status) {
                    char pilihKamarIni = 'n';

                    System.out.println("    Kode Kamar      : " + kamar.kodeKamar);
                    System.out.println("    Jenis Kamar     : " + kamar.jenisKamar);
                    System.out.println("    Harga Permalam  : " + kamar.hargaPerMalam);

                    System.out.print("  Pilih Kamar ini (y/n) : ");
                    pilihKamarIni = scanner.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        pilihKamarStatus = true;
                        break;
                    }

                } else {
                    System.out.println("------------- KAMAR TELAH DIPESAN ------------");
                }
            } else {
                System.out.println("------------ KAMAR TIDAK DITEMUKAN -----------");
            }
        } while (pilihKamarStatus == false);

        return kamar;
    }

    private void checkOut() {
        System.out.println("------------------ RESERVASI -----------------");
        System.out.println("------------------ CHECK OUT -----------------");

        String kodeKamar;

        System.out.print("Masukan Kode Kamar  : ");
        kodeKamar = scanner.nextLine();

        int indexReservasi = Hotel.cariReservasibyKodeKamar(kodeKamar);
        if (indexReservasi > -1) {
            Hotel.checkOut(indexReservasi);

            System.out.println("BERHASIL CHECK OUT");
        } else {
            System.out.println("Data Tidak Ditemukan !");
        }
    }

    private void daftarReservasi() {
        for (Reservasi reservasi : Hotel.daftarReservasi) {
            System.out.println("==============================================");
            System.out.println("Kode Kamar      : " + reservasi.kamar.kodeKamar);
            System.out.println("Jenis Kamar     : " + reservasi.kamar.jenisKamar);
            System.out.println("----------------------------------------------");
            System.out.println("NIK Tamu        : " + reservasi.tamu.nik);
            System.out.println("Nama Tamu       : " + reservasi.tamu.nama);
            System.out.println("No Telp Tamu    : " + reservasi.tamu.noTelp);
            System.out.println("----------------------------------------------");
            System.out.println("Tanggal CheckIn : " + reservasi.tanggalCheckIn);
            System.out.println("Malam           : " + reservasi.malam);
            System.out.println("Tanggal CheckOut: " + reservasi.tanggalCheckOut);
            System.out.println("==============================================");
        }
    }

}
