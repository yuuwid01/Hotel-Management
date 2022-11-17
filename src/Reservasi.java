
// Class Entitas
public class Reservasi {
    Tamu tamu;
    Kamar kamar;
    int malam;
    String tanggalCheckIn;
    String tanggalCheckOut;

    public Reservasi() {
    }

    // Constructor
    public Reservasi(Tamu tamu, Kamar kamar, int malam) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.malam = malam;
        this.tanggalCheckIn = DateString.now();
    }

    // Method
    public void dataKamar() {
        tamu.dataTamu();
        kamar.dataKamar();
        System.out.println("Malam           : " + malam);
        System.out.println("Tanggal CheckIn : " + tanggalCheckIn);
        System.out.println("Tanggal CheckOut: " + tanggalCheckOut);
    }

}