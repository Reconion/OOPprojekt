import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

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

    public void lisatulemus() throws IOException {
        File tulemusfail = new File("tulemused.txt");
        System.out.println(tulemusfail.exists());
        try (FileWriter fw = new FileWriter (tulemusfail, true)) {
            fw.append(toString());
        }
    }
}
