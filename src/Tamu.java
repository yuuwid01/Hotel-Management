
// Class Entitas
public class Tamu extends Penduduk {
    String alamat;
    String noTelp;

    public Tamu() {
    }

    // Constructor
    public Tamu(String nik, String nama, String alamat, String noTelp) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    // Method
    public void dataTamu() {
        System.out.println("Nama Tamu       : " + nama);
        System.out.println("NIK Tamu        : " + nik);
        System.out.println("Alamat          : " + alamat);
        System.out.println("No Telp         : " + noTelp);
    }

}
