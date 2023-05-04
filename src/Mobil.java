public class Mobil {
    private String nama;
    private int kecepatan;
    private int arah;
    private int posisiX;
    private int posisiY;

    public Mobil(String nama, int kecepatan, int arah, int posisiX, int posisiY) {
        this.nama = nama;
        this.kecepatan = kecepatan;
        this.arah = arah;
        this.posisiX = posisiX;
        this.posisiY = posisiY;
    }

    public void maju() {
        posisiX += kecepatan * Math.cos(Math.toRadians(arah));
        posisiY += kecepatan * Math.sin(Math.toRadians(arah));
    }

    public void mundur() {
        posisiX -= kecepatan * Math.cos(Math.toRadians(arah));
        posisiY -= kecepatan * Math.sin(Math.toRadians(arah));
    }

    public void belokKiri() {
        arah -= 10;
        setArah(arah);
    }

    public void belokKanan() {
        arah += 10;
        setArah(arah);
    }

    public String getNama() {
        return nama;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public int getArah() {
        return arah;
    }

    public void setArah(int arah) {
        this.arah = arah;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }
}

class RemoteControl {
    private Mobil mobil;

    public RemoteControl(Mobil mobil) {
        this.mobil = mobil;
    }

    public void tekanTombolMaju() {
        mobil.setKecepatan(mobil.getKecepatan() + 10);
        mobil.maju();
    }

    public void tekanTombolMundur() {
        mobil.setKecepatan(mobil.getKecepatan() - 10);
        mobil.mundur();
    }

    public void tekanTombolBelokKiri() {
        mobil.belokKiri();
    }

    public void tekanTombolBelokKanan() {
        mobil.belokKanan();
    }

    public void lepasTombol() {
        mobil.setKecepatan(0);
    }
    
    public Mobil getMobil() {
        return mobil;
    }

}

class Pengendali {
    private RemoteControl remoteControl;
    private int jarakKendali;

    public Pengendali(RemoteControl remoteControl, String tipeMobil, int jarakKendali) {
        this.remoteControl = remoteControl;
        this.jarakKendali = jarakKendali;
    }

    public void kendalikan() {
        System.out.println("Mengendalikan mobil " + remoteControl.getMobil().getNama() + " dengan jarak kendali " + jarakKendali + "m.");
        remoteControl.tekanTombolMaju();
        remoteControl.tekanTombolBelokKanan();
        remoteControl.tekanTombolMaju();
        remoteControl.tekanTombolBelokKanan();
        remoteControl.tekanTombolMundur();
        remoteControl.lepasTombol();
        System.out.println("Mobil " + remoteControl.getMobil().getNama() + " berada pada posisi (" + remoteControl.getMobil().getPosisiX() + ", " + remoteControl.getMobil().getPosisiY() + ")");
    }
    
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Avanza", 20, 90, 0, 0);
        RemoteControl remoteControl = new RemoteControl(mobil);
        Pengendali pengendali = new Pengendali(remoteControl, "SUV", 50);
        pengendali.kendalikan();
    }

}
