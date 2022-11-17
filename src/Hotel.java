import java.util.ArrayList;

// Class Inti (Core)
public class Hotel {
    public static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    public static ArrayList<Staff> daftarStaff = new ArrayList<>();

    public static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

    public static void initialKamar() {
        daftarKamar.add(new Kamar("101", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("102", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("103", "Double Bed", 600000, true));
        daftarKamar.add(new Kamar("104", "Superior Room", 820000, true));
    }

    public static void initalStaff() {
        daftarStaff.add(new Staff("Staff 1", "123", "1"));
        daftarStaff.add(new Staff("Staff 2", "654321", "123321"));
    }

    public static Kamar cariKamar(String kode) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.kodeKamar.equals(kode)) {
                return kamar;
            }
        }
        return null;
    }

    private static void updateStatusKamar(Kamar kamar, boolean status) {
        for (Kamar kamar2 : daftarKamar) {
            if (kamar.kodeKamar.equals(kamar2.kodeKamar)) {
                kamar2.setStatus(status);
                break;
            }
        }
    }

    public static void checkIn(Tamu tamu, Kamar kamar, int malam) {
        Reservasi checkIn = new Reservasi(tamu, kamar, malam);

        updateStatusKamar(kamar, false);

        daftarReservasi.add(checkIn);
    }

    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (Reservasi reservasi : daftarReservasi) {
            i += 1;
            if (reservasi.kamar.kodeKamar.equals(kodeKamar)) {
                if (!reservasi.kamar.status) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkOut(int indexReservasi) {
        Reservasi reservasi = daftarReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        Kamar kamar = reservasi.kamar;
        updateStatusKamar(kamar, true);

        daftarReservasi.set(indexReservasi, reservasi);
    }
}
