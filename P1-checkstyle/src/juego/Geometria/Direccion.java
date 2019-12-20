package juego.Geometria;

import java.util.Random;

public enum Direccion {
	ARRIBA, ABAJO, DERECHA, IZQUIERDA;

	 public static final int X = 4;

	public Direccion opuesta(Direccion direccion) {
		switch (direccion) {
		case ARRIBA: return ABAJO;
		case ABAJO: return ARRIBA;
		case IZQUIERDA: return DERECHA;
		case DERECHA: return IZQUIERDA;
		default: return null;
		}
	}

	public Direccion aleatoria() {
		Direccion[] arrayDirecciones = Direccion.values();

		Random rnd = new Random();
		int indice = rnd.nextInt(X);

		return arrayDirecciones[indice];
	}


}
