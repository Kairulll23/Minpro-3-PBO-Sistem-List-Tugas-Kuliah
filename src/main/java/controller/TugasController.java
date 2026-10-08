package controller;

import model.EntitasTugas;
import model.TugasIndividu;
import model.TugasKelompok;

import java.util.ArrayList;

public class TugasController {
    private final ArrayList<EntitasTugas> listTugasKu = new ArrayList<>();
    private static int counterID = 1;
    private static final String PREFIX = "TGS-";

    public TugasController() {
        // Dummy Data Awal
        TugasIndividu t1 = new TugasIndividu(generateAutoKode(), "PBO", "Laporan Mini Project 3", "2026-10-15 23:59", "Spada");
        TugasKelompok t2 = new TugasKelompok(generateAutoKode(), "Basis Data", "Desain ERD & Normalisasi", "2026-10-20 20:00", 4);
        
        t2.setSelesai(true); // Contoh 1 tugas sudah selesai
        listTugasKu.add(t1);
        listTugasKu.add(t2);
    }

    public String generateAutoKode() {
        return String.format("%s%03d", PREFIX, counterID++);
    }

    public void tambahTugas(EntitasTugas t) {
        listTugasKu.add(t);
    }

    public ArrayList<EntitasTugas> getAllTugas() {
        return listTugasKu;
    }

    // Overloading 1: Cari berdasarkan kode
    public EntitasTugas cariTugas(String kodeTugas) {
        for (EntitasTugas t : listTugasKu) {
            if (t.getKodeTugas().equalsIgnoreCase(kodeTugas)) {
                return t;
            }
        }
        return null;
    }

    // Overloading 2: Cari berdasarkan nama matkul
    public ArrayList<EntitasTugas> cariTugas(String namaMatkul, boolean isMatkul) {
        ArrayList<EntitasTugas> hasil = new ArrayList<>();
        for (EntitasTugas t : listTugasKu) {
            if (t.getNamaMatkul().equalsIgnoreCase(namaMatkul)) {
                hasil.add(t);
            }
        }
        return hasil;
    }

    public boolean hapusTugas(String kodeTugas) {
        EntitasTugas t = cariTugas(kodeTugas);
        if (t != null) {
            listTugasKu.remove(t);
            return true;
        }
        return false;
    }

    // Hitung statistik untuk Dashboard Stakeholder
    public int getJumlahSelesai() {
        int count = 0;
        for (EntitasTugas t : listTugasKu) {
            if (t.isSelesai()) count++;
        }
        return count;
    }
}