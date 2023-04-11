import java.util.Scanner;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper();
        String[][] panel = mineSweeper.PanelOlustur();
        String[][] bombapanel = new String[mineSweeper.satir][mineSweeper.sutun];
        bombapanel = mineSweeper.Olustur(bombapanel);
        mineSweeper.BombaPanel(bombapanel);//bombapanele bombaları yerleştiriyor
        while (mineSweeper.kontrol){
            System.out.println("======================");
            mineSweeper.OyunaBasla(panel,bombapanel);

        }
    }



}


