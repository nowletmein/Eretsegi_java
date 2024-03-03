import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Feladvany> be = new ArrayList<>();
        try{
            BufferedReader beolvas = new BufferedReader(new FileReader("Feladvanyok.txt"));
            String line;
            while (null != (line = beolvas.readLine())){
                Feladvany f = new Feladvany(line);
                be.add(f);
            }beolvas.close();

        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println(be.size());
        int beSzam;
        do {
            System.out.println("3.feladat: Kérem a feladvány méretét [4..9]:");
            beSzam = Integer.parseInt(scanner.next());
        } while (beSzam < 4 || beSzam > 9);


        ArrayList<Feladvany> feladvanyok = new ArrayList<>();
        int feladvanySzam = 0;
        for (int i = 0; i < be.size(); i++) {
            if (be.get(i).getMeret()== beSzam ){
              feladvanySzam++;
              feladvanyok.add(be.get(i));
            }
        }
        System.out.println("4.feladat "+beSzam+"x"+beSzam+"Méretű feladványból enny van: " + feladvanySzam + "db van tárolva");

        Random random = new Random();
        int kivalaszt = random.nextInt(feladvanySzam);
        int randomSzam = (int) ((Math.random() * (feladvanySzam - 0)) + 0);
        Feladvany kivalasztott = feladvanyok.get(randomSzam);
        System.out.println("A kiválasztott feladvány " + kivalasztott.kezdo);
        double uresDb = 0;
        for (char c : kivalasztott.kezdo.toCharArray()) {
            if (c != '0') {
                uresDb++;
            }
        }
        double megoldas = (uresDb / (kivalasztott.getMeret() * kivalasztott.getMeret())) * 100;
        int megoldasKerekitve =  (int) Math.round(megoldas);

        System.out.println("5.feladat: A feladvány kitöltöttsége: " + megoldasKerekitve + "%");
        System.out.println("6.feladat: A feladvány kirajzolva:");
        kivalasztott.kirajzol();
        String fajlnev = "sudoku" + beSzam + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fajlnev, false));
            for (Feladvany feladvany : be) {
                if (feladvany.getMeret() == beSzam) {
                    writer.write(feladvany.kezdo);
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            System.err.print("Hiba a fájlírás során!");
        }
        }
    }
