import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mäng {
    private String sõna;

    public Mäng(int sõnasuurus) throws FileNotFoundException {
        this.sõna = Uussõna(sõnasuurus);
    }

    public static String Uussõna(int n) throws FileNotFoundException {
        //Kontrollime, et poleks liiga suur sõna
        if(n>27){
            return null;
        }
        File tekstifail = new File("sonad.txt");
        ArrayList<String> sõnad = new ArrayList<String>();
        //Loeme sõnad loetelusse
        try (java.util.Scanner loetudfail = new java.util.Scanner(tekstifail, "UTF-8")) {
            while (loetudfail.hasNextLine()){
                String rida = loetudfail.nextLine();
                rida.replace("\n", "");
                if(rida.length() == n)
                sõnad.add(rida);
            }
        }
        System.out.println(sõnad);
        String valitudsõna = sõnad.get((int)(Math.random()*sõnad.size()));
        return valitudsõna;

    }
}
