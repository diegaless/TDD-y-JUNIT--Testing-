package juego.Geometria;


/** La clase Punto representa un punto inmutable en el espacio bidimensional.
 * Una vez creado el objeto no puede cambiar de estado
 *(los valores de sus atributos).
 */
public class Punto implements Cloneable {
    public static final int DEFAULTVALUE= 0;


   private  final int x;
   private final int y;

    /** Devuelve el valor de la coordenada x
     * @return
     */
    public int getX() {
        return x;
    }

    /** Devuelve el valor de la coordenada x
     */
    public int getY() {
        return y;
    }

	// Constructor por defecto
	public Punto() {
		this.x = 0;
		this.y = 0;
	}

	// Constructor
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Constructor de copia
	public Punto(Punto otra) {
		this.x = otra.x;
		this.y = otra.y;
	}


	/** Devuelve un nuevo objeto Posicion que
	 * representa el valor de la posición
	 *  adyacente a la instancia actual en la
	 *   dirección pasada como parámetro.
	 *  @param direccion
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
		default:
			break;
		}

		return null;
	}

	/**
	 * Informa si la posición pasada como parámetro
	 * es adyacente a la instancia actual
	 * en la dirección indicada.
	 * @param otra
	 * @param direccion
	 * @return true si es adyacente y false en caso contrario.
	 */
	public boolean isAdyacente(Punto otra, Direccion direccion) {

	    //return otra.equals(this.adyacente(direccion));

	    switch (direccion) {
	    case ARRIBA:
	        if (otra.y - this.y == 1) {
				return otra.x - this.x == 0;
			} else {
				return false;
			}
	    case ABAJO:
	        if (this.y - otra.y == 1) {
				return otra.x - this.x == 0;
			} else {
				return false;
			}
	    case IZQUIERDA:
	        if (this.y - otra.y == 0) {
				return this.x - otra.x == 1;
			} else {
				return false;
			}
	    case DERECHA:
	        if (this.y - otra.y == 0) {
				return otra.x - this.x == 1;
			} else {
				return false;
			}
		default:
			break;

	    }
	    return false;

	}

	/**
	 * Devuelve la situación relativa de la instancia
	 * actual respecto a la posición que se pasa como parámetro.
	 * En el caso de no ser posiciones adyacentes
	 * el valor de retorno es null.
	 * @param otra
	 * @return
	 */
	public Direccion situacionRelativa(Punto otra) {
	    int difX = x - otra.x;
	    int difY = y - otra.y;

		if (otra.y - this.y == 1 && otra.x - this.x == 0) {
			return Direccion.ARRIBA;
		}
		if (this.y - otra.y == 1 && otra.x - this.x == 0) {
			return Direccion.ABAJO;
		}
		if (this.y - otra.y == 0 && this.x - otra.x == 1) {
			return Direccion.IZQUIERDA;
		}
		if (this.y - otra.y == 0 && otra.x - this.x == 1) {
			return Direccion.DERECHA;
		}

		return null;
	}

	public Punto desplazar(int incX, int incY) {
	    return new Punto(x + incX, y + incY);
	}

	/** Calcula la distancia entre dos posiciones.
	 * @param posicion
	 * @return
	 */
	public double distancia(Punto posicion) {
		return Math.sqrt(Math.pow(this.x - posicion.x, 2)
				+ Math.pow(this.y - posicion.y, 2));
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Punto other = (Punto) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public Punto clone() {
		Punto copia = null;

		try {
			copia = (Punto) super.clone();
			} catch (CloneNotSupportedException e) {

		}

		return copia;
	}


}
