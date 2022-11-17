
// Class Entitas
public class Kamar {
    String kodeKamar;
    String jenisKamar;
    int hargaPerMalam;
    boolean status;

    public Kamar() {
    }

    // Constructor
    public Kamar(String kodeKamar, String jenisKamar,
            int hargaPerMalam, boolean status) {
        this.kodeKamar = kodeKamar;
        this.jenisKamar = jenisKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = status;
    }

    // Method
    public void dataKamar() {
        System.out.println("Kode Kamar      : " + kodeKamar);
        System.out.println("Jenis Kamar     : " + jenisKamar);
        System.out.println("Harga Per Malam : " + hargaPerMalam);
        System.out.println("Status          : " + status);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}