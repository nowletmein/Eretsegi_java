import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Diszek> be = new ArrayList<>();

        try {
            BufferedReader beOlvas = new BufferedReader(new FileReader("diszek.txt"));
            String line;
            while ((line = beOlvas.readLine()) != null){

                be.add(new Diszek(line));

            }

        }catch (IOException e){
            System.out.println(e);
        }
        int összes = 0;
        for (int i = 0; i < be.size() ; i++) {
            összes += be.get(i).getAngyalkaKesz() + be.get(i).getHarangKesz() + be.get(i).getFenyofaKesz();
        }
        System.out.println("4.feladat " + összes);
        //5.feladat
        boolean van = false;
        for (Diszek in :be) {
            if ((in.getFenyofaKesz() + in.getHarangKesz() + in.getAngyalkaKesz()) == 0){
                System.out.println("5. feladat volt olyan nap hogy egy dísz sem készült ");
                van = true;
                break;

            }
        }
        if (!van){
            System.out.println(" 5. feladat nem volt olyan nap ahol egy dísz se készült volna");
        }
        //6.feladat
        Scanner sc = new Scanner(System.in);
        int beker;
        do {
            System.out.println("adjon meg egy számot 1-től 40-ig ");
            beker = sc.nextInt();
        }while (beker >= 40 || beker<=1 );



        int[] darabszamok = new int[3];
        for (Diszek nap : be) {
            darabszamok[0] += nap.getHarangKesz() + nap.getHarangEladott();
            darabszamok[1] += nap.getAngyalkaKesz() + nap.getAngyalkaEladott();
            darabszamok[2] += nap.getFenyofaKesz() + nap.getFenyofaEladott();
            if (nap.getNap() == beker) {
                break;
            }
        }
        System.out.println(beker + ". napon enyi " + darabszamok[0] +"db Harang "+darabszamok[1]+ "db Angyalka és " +darabszamok[2]+"db fenyőfa maradt" );
        //7.fel

        int[] eladasok = new int[3];
        for (Diszek nap : be) {
            eladasok[0] -= nap.getHarangEladott();
            eladasok[1] -= nap.getAngyalkaEladott();
            eladasok[2] -= nap.getFenyofaEladott();
        }
        int max = Integer.max(Integer.max(eladasok[0], eladasok[1]), eladasok[2]);
        System.out.println("7.feladat: Legtöbbet eladott dísz: " + max + " darab");
        if (eladasok[0] == max) {
            System.out.println("      Harang");
        }
        if (eladasok[1] == max) {
            System.out.println("      Angyalka");
        }
        if (eladasok[2] == max) {
            System.out.println("      Fenyőfa");
        }

            try {
                    int szamlalo = 0;
                    FileWriter file = new FileWriter("bevetel.txt");
                for (Diszek in:be) {
                    if (in.napiBevetel() > 10000){
                        szamlalo++;
                        file.write(in.getNap() +";" + in.napiBevetel() + "\n");
                    }
                }
               file.write(szamlalo + " napon volt legalább 10000Ft bevétel");
               file.close();
            }catch (IOException e){
                System.out.println(e);
            }
    }
}