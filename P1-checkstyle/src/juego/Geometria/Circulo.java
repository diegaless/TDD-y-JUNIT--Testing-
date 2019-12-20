package juego.Geometria;

public class Circulo {
    private Punto centro;
    private int radio;

    public Circulo(Punto centroIni, int radioIni) {
        Punto centro = new Punto(centroIni);
        radio = radioIni;
    }

    public Punto getCentro() {
        return new Punto(centro);
    }

    public int getRadio() {
        return radio;
    }

    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
    public void desplazar(int incX, int incY) {
        centro = centro.desplazar(incX, incY);
    }
}
