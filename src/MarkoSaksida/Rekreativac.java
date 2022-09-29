package MarkoSaksida;

import java.util.ArrayList;

public class Rekreativac extends Planinar {
    private double tezinaOpreme;

    public Rekreativac(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, double tezinaOpreme) {
        super(id, ime, prezime, planine, maxUspon);
        this.tezinaOpreme = tezinaOpreme;
    }

    @Override
    public boolean uspesanUspon(Planina p) {
        boolean uspesan = false;
        if ((getMaxUspon()-(this.tezinaOpreme * 50)) >= p.getVisina()) {
            getPlanine().add(p);
            uspesan = true;
        }
        return uspesan;
    }

    @Override
    public double clanarina() {
        double iznosClanarine;
        iznosClanarine = 1000 - getPlanine().size() * 0.02 * 1000;
        return iznosClanarine;
    }
}
