import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Donto> be = new ArrayList<>();
        try{
            BufferedReader beOlvas = new BufferedReader(new FileReader("SuperBowl.txt"));
            beOlvas.readLine();
            String line;
            while ((line = beOlvas.readLine())!= null){
                Donto egySor = new Donto(line.split(";"));
                be.add(egySor);

            }

        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println("4.feladat "+be.size());
        //5.feladat
        double pontatlag =0.0;
        for (Donto in:be) {
            pontatlag += in.getPontKulombseg();
        }
        double eredmeny = pontatlag / be.size();
        double kerekit = Math.round(eredmeny*10.0)/10.0;
        System.out.println("5. feladat: átlagos pont külömbség"+kerekit);
        //6.feladat
        int max = 0;
        for (int i = 0; i < be.size(); i++) {
            if (be.get(i).getNezo() > be.get(max).getNezo()) {
                max = i;
            }
        }
        System.out.println("6.feladat: legmagasabb nézőszám a döntők során");
        System.out.println("Sorszám (dátum)" + be.get(max).getSsz().getArabSsz() + be.get(max).getDatum());
        be.get(max).kiir();

    }
}