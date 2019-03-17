import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Programmi tervitustekst
        System.out.println("Tere! Uue mängu jaoks kirjutage \"Uusmäng\"" +
                ", lõpetamiseks kirjutage \"lõpp\"");
        Mäng mäng = new Mäng(1);
        int arvamisi = 0;
        //Mängu tsükkel
        while(true){
            System.out.println("Tsüklialgus");
            Scanner sc = new Scanner(System.in);
            String sisend = sc.nextLine().toUpperCase();
            //Programmi peatamine
            if(sisend.equals("LÕPP")||sisend.toUpperCase().equals("LOPP")){
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
                continue;
            }
            //Tähe pakkumine
            if(sisend.length()==1){
                mäng.PakuTäht(sisend);
                mäng.PrindiProtsess();
            }
            // Lahenduse kontrollimine

            System.out.println(sisend);
            String arvamine = mäng.getArvamine().replace(" ","");
            if(arvamine.equals(mäng.getSõna())||sisend.equals(arvamine)){
                System.out.println("Palju õnne, lahendasite sõna ära, kokku kulus " + arvamisi + " arvamist.");
            }
            System.out.println("Tsüklilõpp");
        }

    }
}
