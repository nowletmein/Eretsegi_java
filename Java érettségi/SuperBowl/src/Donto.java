import java.util.HashMap;
import java.util.Map;

public class Donto {
    private RomaiSorszam Ssz;
    private String datum;
    private String gyoztes;
    private String eredmeny;
    private String vesztes;
    private String hely;
    private String VarosAllam;
    private int nezo;

    public int getNezo() {
        return nezo;
    }

    public String getDatum() {
        return datum;
    }

    public RomaiSorszam getSsz() {
        return Ssz;
    }

    public Integer getPontKulombseg(){
        int gyoztespont = Integer.parseInt((eredmeny.split("-")[0]));
        int vestespont = Integer.parseInt((eredmeny.split("-")[1]));
        return gyoztespont - vestespont;
    }
    public void kiir(){

        System.out.println("Győztes: " + gyoztes);
        System.out.println("Vesztes "+vesztes);
        System.out.println("Helyszín " + hely);
        System.out.println("Város, állam " + VarosAllam);
        System.out.println("Nézőszám " + nezo);
    }
    public Donto(String[] tmb){
     this.Ssz = new RomaiSorszam(tmb[0]);
     datum = tmb[1];
     gyoztes = tmb[2];
     eredmeny = tmb[3];
     vesztes = tmb[4];
     hely = tmb[5];
     VarosAllam = tmb[6];
     nezo = Integer.parseInt(tmb[7]);
}
    class RomaiSorszam {
        private String romaiSsz;

        public void setRomaiSsz(String ujErtek) {
            this.romaiSsz = ujErtek;
        }

        private static Map<Character, Integer> rómaiMap = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        public String getArabSsz() {
            int ertek = 0;
            String romaiSzam = romaiSsz.replace(".", "");
            for (int i = 0; i < romaiSzam.length(); i++) {
                if (i + 1 < romaiSzam.length() &&
                        rómaiMap.get(romaiSzam.charAt(i)) < rómaiMap.get(romaiSzam.charAt(i + 1))) {
                    ertek -= rómaiMap.get(romaiSzam.charAt(i));
                } else {
                    ertek += rómaiMap.get(romaiSzam.charAt(i));
                }
            }
            return ertek + ".";
        }

        public RomaiSorszam(String romaiSsz) {
            this.romaiSsz = romaiSsz.toUpperCase();
        }
    }



}
