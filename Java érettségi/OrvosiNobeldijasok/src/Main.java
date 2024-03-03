import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Nobel> be = new ArrayList<>();

    try {
        BufferedReader beolvas = new BufferedReader(new FileReader("orvosi_nobeldijak.txt"));
        String line;
        beolvas.readLine();
        while ((line = beolvas.readLine())!= null){
            be.add(new Nobel(line.split(";")));
        }beolvas.close();
    }catch (IOException e){
        System.out.println(e);
    }
        System.out.println("3. feladat"+be.size());
        int max = 0;
        for (int i = 0; i < be.size(); i++) {
            if (be.get(i).getEv() > be.get(max).getEv()){
                max = i;
            }
        }
        System.out.println("4. feladat "+be.get(max).getEv());
        ArrayList<Nobel> Kivalaszt = new ArrayList<>();
       String Orszagkod = scanner.next();
        for (int j = 0; j < be.size(); j++) {
            if (be.get(j).getOrszagkod().equals(Orszagkod.toUpperCase())){
                Kivalaszt.add(be.get(j));
            }
        }
        if (Kivalaszt.size() == 1) {
            System.out.println(Kivalaszt.get(0).getNev());
            System.out.println(Kivalaszt.get(0).getEv());
            System.out.println(Kivalaszt.get(0).getSzuletesHalalozas());
        }
        else if (Kivalaszt.isEmpty()){
            System.out.println("A megadott országból nem volt díjazott!");
        }else {
            System.out.println("A megadott országból " + Kivalaszt.size() + " fő díjazott volt!");
        }

        int usa = 0;
        int HU = 0;
        int GB = 0;
        int S = 0;
        int CH = 0;
        int CDN;
        for (Nobel in :be) {




        }



 }
}