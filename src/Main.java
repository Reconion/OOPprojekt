//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Programmi tervitustekst
        System.out.println("Tere! Uue mängu jaoks kirjutage \"Uusmäng\"" +
                ", lõpetamiseks kirjutage \"lõpp\"");
        Mäng mäng = new Mäng(1);
        int i = 0;
        //Mängu tsükkel
        while(true){
            //System.out.println("Tsüklialgus");
            Scanner sc = new Scanner(System.in);
            String sisend = sc.nextLine().toUpperCase();
            //Programmi peatamine
            if(sisend.equals("LÕPP")||sisend.toUpperCase().equals("LOPP") | i==1){
                System.out.println("Lõpetan mängu");
                break;
            }
            //Puhtalt testimiseks
            if(sisend.equals("NÄITASÕNA")){
                System.out.println(mäng.getSõna());
            }
            //Uue mängu tegemine
            if(sisend.equals("UUSMÄNG")){
                System.out.println("Sisestage sõna pikkus (1-27) tähemärki");
                int pikkus = sc.nextInt();
                mäng = new Mäng(pikkus);
                mäng.PrindiProtsess();
                //arvamisi=0;
                continue;
            }
            //Tähe pakkumine
            if(sisend.length()==1){
                mäng.PakuTäht(sisend);
                mäng.PakutudTähed(sisend);
                mäng.ArvamisteSumma();
                mäng.PrindiProtsess();
            }
            // Lahenduse kontrollimine
            String arvamine = mäng.getArvamine().replace(" ","");
            if(arvamine.equals(mäng.getSõna())||sisend.equals(arvamine)){
                i+=1;
                Tulemus tulemus = new Tulemus(mäng.getSõna(), mäng.ArvamisteSumma()-1);
                tulemus.lisatulemus();
                System.out.println("Palju õnne, lahendasite sõna ära, kokku kulus " + (mäng.getArvamised()-1) + " arvamist.");
            }

            //System.out.println("Tsüklilõpp");
        }

    }
}
