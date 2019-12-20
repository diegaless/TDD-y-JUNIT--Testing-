package juego.pruebas;

import juego.geometria.Punto;

public final class  Programa {

    private Programa(){}
    public static void main(String args[]) {
      Punto punto1 = new Punto();

      Punto puntos[] = new Punto[2]; 
      puntos[0] = punto1;
      
      String info = ""; 

      for (Punto punto : puntos)
          info.concat(punto.toString()); // NOPMD by Alumno on 3/10/18 18:25 Invocacion del metodo de la clase String sobre el objeto info

     boolean param1 = "".equals(info);
     String mensaje = param1 ? "no hay puntos" : info; 

     System.out.println(mensaje); // NOPMD by Alumno on 3/10/18 18:28 Imprime informacion esencial para el correcto funcionamiento del programa
    }
}
