
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class MineSweeper{
    int oyunsayac= 0;
    boolean kontrol = true;
    int satir ,sutun;
    Random rnd = new Random();
    Scanner scn = new Scanner(System.in);

    String[][] Olustur(String[][] panel){
        for (int i = 0 ; i<panel.length;i++){
            for (int j = 0 ; j<panel[i].length;j++){
                panel[i][j] = "-";
            }
        }
        return  panel;
    }
    void Yazdir(String[][] panel){
        for (int i = 0 ; i<panel.length;i++){
            for (int j = 0 ; j<panel[i].length;j++){
                System.out.print(panel[i][j]);
            }
            System.out.println();
        }
    }
    String[][] PanelOlustur(){

        System.out.print("lütfen satır sayısı giriniz : ");
        this.satir = scn.nextInt();
        System.out.print("lütfen sutun sayısı giriniz : ");
        this.sutun = scn.nextInt();
        String[][] panel = new String[this.satir][this.sutun] ;
        panel = Olustur(panel);
        return panel;
    }
    String[][] BombaPanel(String[][] bombapanel){
        int rndsatir,rndsutun;
        for (int i = 0 ; i<(satir*sutun)/4;i++){
            rndsatir = rnd.nextInt(this.satir);
            rndsutun = rnd.nextInt(this.sutun);
            if (bombapanel[rndsatir][rndsutun].equals("-")){
                bombapanel[rndsatir][rndsutun] = "*";
            }
            else{
                i--;
            }
        }
        return bombapanel;
    }
    void OyunaBasla(String[][] panel,String[][] bombapanel) {

        do {
            int sayac = 0;

            Yazdir(panel);
            System.out.print("lütfen bir  satır giriniz : ");
            int gsatir = scn.nextInt();
            System.out.print("lütfen bir sütun giriniz  : ");
            int gsutun = scn.nextInt();
            if (gsatir<satir && gsutun< sutun && gsatir>=0 && gsutun>=0) {
                if (bombapanel[gsatir][gsutun].equals("*")) {
                    System.out.println("mayına bastın oyun bitti ! ");
                    for (int i = 0; i < panel.length; i++) {
                        for (int j = 0; j < panel[i].length; j++) {
                            if (bombapanel[i][j].equals("*")) {
                                panel[i][j] = "*";
                            }
                        }
                    }
                    Yazdir(panel);

                    this.kontrol = false;
                } else {
                    oyunsayac++;
                    if (gsutun > 0 && (bombapanel[gsatir][gsutun - 1].equals("*"))) sayac++;
                    if (gsutun < bombapanel.length - 1 && (bombapanel[gsatir][gsutun + 1].equals("*"))) sayac++;
                    if (gsatir > 0 && (bombapanel[gsatir - 1][gsutun].equals("*"))) sayac++;
                    if (gsatir < bombapanel.length - 1 && (bombapanel[gsatir + 1][gsutun].equals("*"))) sayac++;
                    panel[gsatir][gsutun] = String.valueOf(sayac);

                }
            }
            else {
                System.out.println("==============================");
                System.out.println("lütfen geçerli bir konum girin !");
            }
        }while ((this.satir*this.sutun)-((this.satir*this.sutun)/4)>oyunsayac && kontrol);

        if (oyunsayac==(this.satir*this.sutun)-((this.satir*this.sutun)/4)){
            System.out.println("Tebrikler oyunu kazandın...");
            for (int i= 0 ; i<panel.length;i++){
                for (int j = 0 ; j<panel[i].length;j++){
                    if (bombapanel[i][j].equals("*")){
                        panel[i][j] = "*";
                    }
                }
            }
            Yazdir(panel);
            this.kontrol=false;
        }

    }
}
