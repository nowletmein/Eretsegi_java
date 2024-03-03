public class Nobel {
   public int Ev;
   private String Nev;
   private String szuletesHalalozas;
   private String Orszagkod;
    public Nobel(String[] tmb ){
    Ev = Integer.parseInt( tmb[0]);
    Nev = tmb[1];
    szuletesHalalozas = tmb[2];
    Orszagkod = tmb[3];
}

        private int Tol;
        private int Ig;

        public int elethosszEvekben() {
            return Tol == -1 || Ig == -1 ? -1 : Ig - Tol;
        }

        public Boolean ismertElethossz() {
            return elethosszEvekben() != -1;
        }

        public Nobel(String szuletesHalalozas) {
            String[] m = szuletesHalalozas.split("-");
            try {
                Tol = Integer.parseInt(m[0]);
            } catch (Exception e) {
                Tol = -1;
            }
            try {
                Ig = Integer.parseInt(m[1]);
            } catch (Exception e) {
                Ig = -1;
            }
        }

    public int getEv() {
        return Ev;
    }
    public String getNev() {
        return Nev;
    }
    public int getIg() {
        return Ig;
    }
    public String getOrszagkod(){
            return Orszagkod;
    }

    public String getSzuletesHalalozas() {
        return szuletesHalalozas;
    }

}



