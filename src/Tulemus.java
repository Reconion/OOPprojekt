import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Tulemus {
    private String sõna;
    private int katseid;

    public Tulemus(String sõna, int katseid) {
        this.sõna = sõna;
        this.katseid = katseid;
    }

    @Override
    public String toString() {
        return "sõna='" + sõna + '\'' +
                ", katseid=" + katseid + "\n";
    }

    public void lisatulemus() throws FileNotFoundException, UnsupportedEncodingException {
        File tulemusfail = new File("tulemused.txt");
        System.out.println(tulemusfail.exists());
        try (java.io.PrintWriter loetudfail = new java.io.PrintWriter(tulemusfail, "UTF-8")) {
            loetudfail.println(toString());
        }
    }
}
