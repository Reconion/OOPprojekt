import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mäng {
    private String sõna;
    private String arvamine;

    public String getSõna() {
        return sõna;
    }
    public String getArvamine() {
        return arvamine;
    }
    public void setArvamine(String arvamine) {
        this.arvamine = arvamine;
    }
    public Mäng(int sõnasuurus) throws FileNotFoundException {
        this.sõna = UusSõna(sõnasuurus);
        this.arvamine = "_ ".repeat(sõnasuurus);
    }


    /**
     * Prindib sõna arvamise protsessi
     */
    public void PrindiProtsess(){
        System.out.println("Sõna: " + this.getArvamine());
    }

    /**
     * @param n sõna suurus
     * @return Failist sonad.txt suvaline n-pikkune sõna
     * @throws FileNotFoundException juhul kui faili sonad.txt ei leidu
     */
    private String UusSõna(int n) throws FileNotFoundException {
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
        String valitudsõna = sõnad.get((int)(Math.random()*sõnad.size()));
        return valitudsõna;

    }
}
