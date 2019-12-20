package juego.pruebas;

import juego.Geometria.Punto;

public final class Programa {

	 public static final int X = 4;

	 private Programa() {
	}

    public static void main(String[] args) {
      Punto punto1 = new Punto();
      Punto punto2 = new Punto(2, X);

      Punto[] puntos = new Punto[2];
      puntos[0] = punto1;

      String info = "";

      for (Punto punto : puntos){
          info.concat(punto.toString());
      }
     String mensaje;
	if ("".equals(info)) {
		mensaje = "no hay puntos";
	} else {
		mensaje = info;
	}

     System.out.println(mensaje);

    }

}
