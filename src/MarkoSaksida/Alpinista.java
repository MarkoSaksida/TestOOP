package MarkoSaksida;

import java.util.ArrayList;

public class Alpinista extends Planinar{
    private int godineIskustva;

    public Alpinista(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, int godineIskustva) {
        super(id, ime, prezime, planine, maxUspon);
        this.godineIskustva = godineIskustva;
    }

    @Override
    public boolean uspesanUspon(Planina p) {
        boolean uspesan = false;
        if (getMaxUspon() >= p.getVisina()) {
            getPlanine().add(p);
            uspesan = true;
        }
        return uspesan;
    }

    @Override
    public double clanarina() {
        double iznosClanarine = 1500;
        for (Planina nekaPlanina : getPlanine()) {
            if (nekaPlanina.getVisina() > 2000) {
              iznosClanarine = iznosClanarine - 1500 * 0.05;
            }
        }
        return iznosClanarine;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }
}
