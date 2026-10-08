package model;

public class TugasKelompok extends EntitasTugas {
    private int jumlahAnggota;

    public TugasKelompok(String kodeTugas, String namaMatkul, String detailTugas, String dateline, int jumlahAnggota) {
        super(kodeTugas, namaMatkul, detailTugas, dateline);
        this.jumlahAnggota = jumlahAnggota;
    }

    public int getJumlahAnggota() { return jumlahAnggota; }
    public void setJumlahAnggota(int jumlahAnggota) { this.jumlahAnggota = jumlahAnggota; }

    @Override
    public String getTipeTugas() {
        return "Kelompok";
    }

    @Override
    public String cetakBaris() {
        String detailWithAnggota = getDetailTugas() + " (" + jumlahAnggota + " Org)";
        return String.format("| %-8s | %-10s | %-18s | %-26s | %-16s | %-11s |", 
                getKodeTugas(), getTipeTugas(), getNamaMatkul(), detailWithAnggota, getDateline(), getStatusTeks());
    }
}