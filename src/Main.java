import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Programmi tervitustekst
        System.out.println("Tere! Uue mängu jaoks kirjutage \"Uusmäng\"" +
                ", lõpetamiseks kirjutage \"lõpp\"");
        Mäng mäng;
        //Mängu tsükkel
        while(true){
            System.out.println("Tsüklialgus");
            Scanner sc = new Scanner(System.in);
            String sisend = sc.nextLine();
            if(sisend.toUpperCase().equals("LÕPP")||sisend.toUpperCase().equals("LOPP")){
                System.out.println("Lõpetan mängu");
                break;
            }
            if(sisend.toUpperCase().equals("UUSMÄNG")){
                System.out.println("Sisestage sõna pikkus (1-27) tähemärki");
                int pikkus = sc.nextInt();
                mäng = new Mäng(pikkus);
                mäng.PrindiProtsess();
                continue;
            }
            System.out.println("Tsüklilõpp");
        }

    }
}
