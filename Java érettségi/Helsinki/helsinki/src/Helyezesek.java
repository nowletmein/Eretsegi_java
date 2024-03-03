public class Helyezesek {
    private int hely;
    private int db;
    private String Sporttag;
    private String Versenyszam;

    private int pontszam;
    public  Helyezesek(String[] tomb){
        hely = Integer.parseInt(tomb[0]);
        db = Integer.parseInt(tomb[1]);
        Sporttag= tomb[2];
        Versenyszam = tomb[3];
    }
    public int getHely(){
        return hely;

    }
    public int getDb(){
        return db;
    }
    public String getSporttag(){
        return Sporttag;
    }
    public String getVersenyszam(){
        return Versenyszam;
    }
    public int getPontszam(){
        return pontszam;
    }
    public void setPontszam(int pontszam){
        this.pontszam = pontszam;
    }

    public String toString()
    {
        return "Helyezes{" + "hely=" + hely + ", db=" + db + ", sportag="
                + Sporttag + ", versenyszam=" + Versenyszam + ", pontszam=" + pontszam + '}';
    }
   public String eredmeny(){
        String nev = Sporttag;
        if (Sporttag.equals("kajakkenu")){
            nev = "kajak-kenu";
        }
        return hely + " " + db + " " + pontszam + " " + nev + " "  + Versenyszam;
   }
}
