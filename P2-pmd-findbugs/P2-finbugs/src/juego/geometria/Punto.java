package juego.geometria;

import java.lang.Math;
import java.util.Random;

/** La clase Punto representa un punto inmutable en el espacio bidimensional.
 *  Una vez creado el objeto no puede cambiar de estado.
 *
 */
public class Punto implements Cloneable {
     final int x;
     final int y;


	// Constructor por defecto
	public Punto() {
		this (0, 0);
	
	}

	// Constructor
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Constructor de copia
	public Punto(Punto otra) {
		this(otra.x, otra.y);
	}

    /** Devuelve el valor de la coordenada x
     * 
     */
    public int getX() {
        return x;
    }

    /** Devuelve el valor de la coordenada x
     * 
     */
    public int getY() {
        return y;
    }

	/** Devuelve un nuevo objeto Posicion que representa el valor de la posici�n
	 *  adyacente a la instancia actual en la direcci�n pasada como par�metro.
	 */
	public Punto adyacente(Direccion direccion) {

		switch (direccion) {
		case DERECHA:
			return new Punto(x + 1, y); 
		case IZQUIERDA:
			return new Punto(x - 1, y); 
		case ARRIBA:
		    return new Punto(x, y + 1); 
		case ABAJO:
		    return new Punto(x, y - 1); 
		}

		return null;
	}

	/**
	 * Informa si la posici�n pasada como par�metro es adyacente a la instancia actual
	 * en la direcci�n indicada.
	 * 
	 * @return true si es adyacente y false en caso contrario.
	 */
	public boolean isAdyacente(Punto otra, Direccion direccion) {

	    Punto adyacente = this.adyacente(direccion);
        if (adyacente != null) 
            return otra.equals(adyacente);
        else 
            return false;
	}

	/**
	 * Devuelve la situaci�n relativa de la instancia actual respecto a la posici�n que se pasa como par�metro.
	 * En el caso de no ser posiciones adyacentes el valor de retorno es null. 
	 */
	public Direccion situacion_relativa(Punto otra){
	    int difX = Math.abs(x - otra.x);
	    int difY = Math.abs(y - otra.y);

		if (difY == 1 && difX == 0)
			return Direccion.ARRIBA;
		if (difY == 1 && difX == 0)
			return Direccion.ABAJO;
		if (difY == 0 && difX == 1)
			return Direccion.IZQUIERDA;
		if (difY == 0 && difX == 1)
			return Direccion.DERECHA;
		
		return null;
	}
	
	public Punto desplazar(int incX, int incY){
	    return new Punto(x+incX,y+incY);
	}
	
	public Punto desplazar(Direccion direccion){
	    switch (direccion){
	    case ARRIBA : return desplazar(0,1);
	    case ABAJO: return desplazar(0,-1);
	    case DERECHA: return desplazar(1, 0);
	    case IZQUIERDA: return desplazar(-1,0);
	    default:
	        return null;
	    }
	}

	
	@Override
	public String toString() {
		return getClass().getName() + " [x=" + x + ", y=" + y + "]";
	}

	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(null == obj)
            return false;
        
        Punto other = new Punto();
       if(obj instanceof Punto)
           other = (Punto) obj;

        return (x == other.x && y == other.y);
   // return false;
    }

	@Override
	public Punto clone(){
		Punto copia;

		try{
			copia = (Punto)super.clone();
			return copia;
		}
		catch(CloneNotSupportedException e){ }

		return null;
	}
	

}
