import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Helyezesek> beOlvas = new ArrayList<>();
        try {
            BufferedReader be = new BufferedReader(new FileReader("helsinki.txt"));
            String line;

         while ((line = be.readLine()) != null ) {
             beOlvas.add(new Helyezesek(line.split(" ")));
         }

        }catch(IOException e){
            System.out.println(e);
        }

        System.out.println("3. feladat: " + beOlvas.size());
        //4.feladat
        int[] helydb = new int[7];
        for (int i = 0; i < beOlvas.size(); i++) {
            helydb[beOlvas.get(i).getHely()]++;
        }
        System.out.println("4.feladat:");
        System.out.println(" Arany " + helydb[1]);
        System.out.println("Ezüst "+ helydb[2]);
        System.out.println("Bronz "+ helydb[3]);
        System.out.println("Összes " + (helydb[1] + helydb[2] + helydb[3]));
        //5.feladat
        int osszerem = 0;
        for (int j = 0; j < beOlvas.size(); j++) {
            beOlvas.get(j).setPontszam(pontszam(beOlvas.get(j).getHely()));
            osszerem += beOlvas.get(j).getPontszam();
        }
        System.out.println("Olimpiai pontszámok" + osszerem);
//6.feladat
        int uszas= 0;
        int torna = 0;
        for (Helyezesek in:beOlvas) {
            if (in.getSporttag() == "uszas"){
                if (in.getHely() <= 3){
                    uszas++;
                }
            } else if (in.getSporttag() == "torna") {
                if (in.getHely() <= 3){
                    torna++;
                }
            }
        }
        if (uszas>torna){
            System.out.println("Úszas sportágban szereztek több érmét");
        } else if (uszas==torna) {
            System.out.println("Egyenlő volt az érmek száma");
        }else {
            System.out.println("Torna sportágban szereztek több érmét");
        }

//7.feladat
        try {
            RandomAccessFile ki = new RandomAccessFile("helsinki2.txt","rw");
            ki.setLength(0);
            for( int i = 0; i < beOlvas.size(); i++ )
            {
                ki.writeBytes(beOlvas.get(i).eredmeny() + "\n");
            }
            ki.close();

        }catch(IOException e){
            System.out.println(e);
        }


        //8.feladat


        Helyezesek max = beOlvas.get(0);
        for (int i = 0; i < beOlvas.size(); i++) {
            if (max.getDb() < beOlvas.get(i).getDb()){
                max = beOlvas.get(i);
            }
        }
        System.out.println("8.feladat: ");
        System.out.println("Helyezés: " + max.getHely());
        System.out.println("Sportág: " + max.getSporttag());
        System.out.println("Versenyszám: " + max.getVersenyszam());
        System.out.println("Sportolók száma: "+max.getDb());

    }









    public static int pontszam(int Helyezesek){
        int pont;
        if (Helyezesek == 1){
            pont = 7;
        } else if (Helyezesek == 2) {
            pont = 5;
        } else if (Helyezesek == 3) {
            pont = 4;
        } else if (Helyezesek == 4) {
            pont = 3;
        } else if (Helyezesek == 5) {
            pont = 2;
        }else {
            pont = 1;
        }
        return pont;
    }
}