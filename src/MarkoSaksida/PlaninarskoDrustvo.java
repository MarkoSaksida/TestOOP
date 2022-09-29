package MarkoSaksida;

import java.util.ArrayList;

public class PlaninarskoDrustvo {
    private ArrayList<Planinar> planinari;

    public PlaninarskoDrustvo(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public ArrayList<Planinar> getPlaninari() {
        return planinari;
    }

    public void setPlaninari(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public void izbaciPlaninara(int id) {
        ArrayList<Planinar> planinariClone = new ArrayList<>(planinari);
        for (Planinar planinar : planinariClone) {
            if (planinar.getId() == id) {
                planinari.remove(planinar);
            }
        }
    }

    public int najuspesnijiPlaninar() {
        double maxZbirVisina = 0;
        double ukupnaVisina = 0;
        int najPlaninar = 0;
        for (Planinar nekiPlaninar : planinari) {
            for (Planina planina : nekiPlaninar.getPlanine()) {
                ukupnaVisina += planina.getVisina();
                if (ukupnaVisina > maxZbirVisina) {
                    maxZbirVisina = ukupnaVisina;
                    najPlaninar = nekiPlaninar.getId();
                }
            }
        }

        return najPlaninar;

    }

    public double prosecnaClanarinaPlaninara() {
        double sumaClanarina = 0;
        int brojac = 0;
        for (Planinar planinar : planinari) {
            sumaClanarina += planinar.clanarina();
            brojac++;
        }
        return sumaClanarina / brojac;
    }

    public boolean popniSeNaPlaninu(Planina planina) {
        boolean popniSe = false;
        int brojac = 0;
        for (Planinar nekiPlaninar : planinari) {
            if (nekiPlaninar.uspesanUspon(planina)) {
                brojac++;
            }
        }
        boolean jeAlpinistaSaIskustvom = false;
        for (Planinar nekiPlaninar : planinari) {
            if (nekiPlaninar instanceof Alpinista && ((Alpinista) nekiPlaninar).getGodineIskustva() > 5) {
                jeAlpinistaSaIskustvom = true;
            }
        }
        if (planinari.size() != 0 && ((brojac / planinari.size()) >= 2 / 3) && jeAlpinistaSaIskustvom) {
            popniSe = true;
        }
        return popniSe;
    }

    public void sortPlaninariPoClanarini() {
        for (int i = 0; i < planinari.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < planinari.size(); j++) {
                if (planinari.get(minIndex).clanarina() < planinari.get(j).clanarina()) {
                    minIndex = j;
                }
                Planinar privremeni = planinari.get(minIndex);
                planinari.set(minIndex, planinari.get(i));
                planinari.set(i, privremeni);

            }

        }
    }



    public static void main(String[] args) {
        ArrayList<Planina> planine1 = new ArrayList<>();
        ArrayList<Planina> planine2 = new ArrayList<>();
        ArrayList<Planina> planine3 = new ArrayList<>();
        ArrayList<Planinar> planinari = new ArrayList<>();

        Planina planina1 = new Planina("Kopaonik", 2000);
        Planina planina2 = new Planina("Zlatibor", 1500);
        Planina planina3 = new Planina("StaraPlanina", 2400);
        planine1.add(planina2);
        planine2.add(planina1);
        planine2.add(planina2);
        planine3.add(planina1);
        planine3.add(planina2);
        planine3.add(planina3);

        Planinar p1 = new Rekreativac(1, "Ivan", "Ivanovic", planine1, 1800, 4);
        Planinar p2 = new Rekreativac(2, "Sanja", "Jovanovic", planine2, 2500, 5);
        Planinar p3 = new Alpinista(3, "Jovan", "Milutinovic", planine3, 3000, 6);
        planinari.add(p1);
        planinari.add(p2);
        planinari.add(p3);

        PlaninarskoDrustvo drustvo = new PlaninarskoDrustvo(planinari);

//        System.out.println(planinari);
//        drustvo.izbaciPlaninara(2);
//        System.out.println(planinari);
//
//        System.out.println(drustvo.najuspesnijiPlaninar());
//
//        System.out.println(drustvo.prosecnaClanarinaPlaninara());
//
//        System.out.println(drustvo.popniSeNaPlaninu(planina1));

        //System.out.println(planinari);
        for (int i = 0; i < planinari.size(); i++) {
            System.out.println(planinari.get(i).clanarina());
        }
        drustvo.sortPlaninariPoClanarini();
        //System.out.println(planinari);
        for (int i = 0; i < planinari.size(); i++) {
            System.out.println(planinari.get(i).clanarina());
        }


    }
}
