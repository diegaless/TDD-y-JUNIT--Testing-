package testMaquinaCafe;

import maquinacafe.Receta;

public class TestInventario implements Inventario{
	public boolean bool;
	
	public TestInventario(boolean b) {
		bool = b;
	}
	@Override
	public boolean hayIngredientes(Receta receta) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return bool;
	}

	@Override
	public void usarIngredientes(Receta receta) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}
	
	

}
