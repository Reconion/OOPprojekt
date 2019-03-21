import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mäng {
    private String sõna;
    private String arvamine;
    private int arvamised;
    private ArrayList tähtedeList = new ArrayList();
    
    public ArrayList getPakutud() { 
        return tähtedeList; 
    }
    public int getArvamised() { 
        return arvamised; 
    }
    public String getSõna() {
        return sõna;
    }
    public String getArvamine() {
        return arvamine;
    }
    public void setArvamine(String täht, int indeks) {
        this.arvamine = arvamine.substring(0,indeks*2) + täht + arvamine.substring(indeks*2+1);
    }
    public Mäng(int sõnasuurus) throws FileNotFoundException {
        this.sõna = UusSõna(sõnasuurus).toUpperCase();
        this.arvamine = "_ ".repeat(sõnasuurus);
    }


    /**
     * Prindib sõna arvamise protsessi
     */
    public void PrindiProtsess(){
        System.out.println("Sõna: " + this.getArvamine() + "\nPakutud tähed: " + getPakutud());
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
    public void PakuTäht(String täht){
        String[] sõnalahku = sõna.split("");
        for (int i = 0; i < sõna.length() ; i++) {
            String vaadatav = sõnalahku[i];
            if(vaadatav.equals(täht)){
                setArvamine(täht,i);
            }
        }
    }
    public int ArvamisteSumma(){
        return arvamised+=1;
    }
    //Kontrollib, kas täht on pakutud tähtede loendis ja kui ei ole, siis lisab
    public ArrayList PakutudTähed(String täht) {
        if (tähtedeList.contains(täht)) {
        } else tähtedeList.add(täht);
        return tähtedeList;
    }
}
