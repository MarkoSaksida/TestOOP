package MarkoSaksida;

public class Planina {
    private String ime;
    private double visina;

    public Planina(String ime, double visina) {
        this.ime = ime;
        this.visina = visina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "{" +
                "ime='" + ime +
                ", visina=" + visina +
                '}';
    }
}
