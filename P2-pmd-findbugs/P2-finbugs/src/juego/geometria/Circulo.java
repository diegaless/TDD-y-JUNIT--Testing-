package juego.geometria;

public class Circulo {

    private Punto centro;
    private int radio;

    public Circulo(Punto centroIni, int radioIni){
        radio = radioIni;
        centro = centroIni;
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
    
    public void desplazar(int incX, int incY){
        centro = centro.desplazar(incX, incY);
    }
}
