
// Class Entitas
public class Staff extends Penduduk {
    String password;

    public Staff() {
    }

    // Constructor dengan Parameter
    public Staff(String nama, String nip, String password) {
        this.nama = nama;
        this.nip = nip;
        this.password = password;
    }

    // Method
    public void dataStaff() {
        System.out.println("Nama Staff      : " + nama);
        System.out.println("NIP Staff       : " + nip);
        System.out.println("Password        : " + password);
    }
}
