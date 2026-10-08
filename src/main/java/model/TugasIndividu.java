package model;

public class TugasIndividu extends EntitasTugas {
    private String platformPengumpulan;

    public TugasIndividu(String kodeTugas, String namaMatkul, String detailTugas, String dateline, String platformPengumpulan) {
        super(kodeTugas, namaMatkul, detailTugas, dateline);
        this.platformPengumpulan = platformPengumpulan;
    }

    public String getPlatformPengumpulan() { return platformPengumpulan; }
    public void setPlatformPengumpulan(String platformPengumpulan) { this.platformPengumpulan = platformPengumpulan; }

    @Override
    public String getTipeTugas() {
        return "Individu";
    }

    @Override
    public String cetakBaris() {
        String detailWithPlatform = getDetailTugas() + " (" + platformPengumpulan + ")";
        return String.format("| %-8s | %-10s | %-18s | %-26s | %-16s | %-11s |", 
                getKodeTugas(), getTipeTugas(), getNamaMatkul(), detailWithPlatform, getDateline(), getStatusTeks());
    }
}