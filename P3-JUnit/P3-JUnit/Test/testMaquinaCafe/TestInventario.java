package testMaquinaCafe;

import maquinacafe.Receta;

public class TestInventario implements Inventario{
	public boolean bool;
	
	public TestInventario(boolean b) {
		bool = b;
	}
	@Override
	public boolean hayIngredientes(Receta receta) {
		// TODO Apéndice de método generado automáticamente
		return bool;
	}

	@Override
	public void usarIngredientes(Receta receta) {
		// TODO Apéndice de método generado automáticamente
		
	}
	
	

}
