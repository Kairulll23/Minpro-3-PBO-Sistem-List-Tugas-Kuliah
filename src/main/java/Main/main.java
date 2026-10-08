package Main;

import model.Mahasiswa;
import view.MainView;

public class main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("2509116097", "Khairul Ikhsan");
        
        MainView app = new MainView();
        app.olahMenu(mhs);
    }
}