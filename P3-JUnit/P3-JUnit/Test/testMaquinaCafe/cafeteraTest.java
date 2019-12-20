package testMaquinaCafe;

import static org.junit.Assert.*;
import maquinacafe.Cafetera;
import maquinacafe.Receta;

import org.junit.Before;
import org.junit.Test;

public class cafeteraTest {

	private Cafetera cafetera;
	private Receta receta1;
	private Receta receta2;
	private Receta receta3;
	private Receta receta4;
	
	@Before
	public void setUp() throws Exception{
		cafetera = new Cafetera();
		receta1 = new Receta("receta1",2,5,5,5,5);
		receta2 = new Receta("receta2",2,5,5,7,5);
		receta3 = new Receta("receta3",2,5,6,5,5);
		receta4 = new Receta("receta4",2,5,8,5,9);
		
		cafetera.addReceta(receta1);
		cafetera.addReceta(receta2);
		cafetera.addReceta(receta3);
		cafetera.addReceta(receta4);
		
	}
	@Test
	public void testAddReceta() {
		
		
		assertFalse( "El nombre de la receta debe ser distinto",cafetera.addReceta(receta1));
		
		
		assertFalse(cafetera.getRecetas().size() < 3);
		
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	
	public void testEditarReceta() {
		Receta receta5 = new Receta("receta5",2,4,7,5,9);
		Receta receta6 = new Receta("receta5",2,4,7,5,9);
		//Receta receta2 = null;
		
		assertNull(cafetera.editarReceta("receta5", receta5));
		
		
		cafetera.addReceta(receta5);
		cafetera.editarReceta("receta4", receta5);
		
	}
	
	@Test
	public void testHacerCafe() {
		
		boolean b = true;
		
		assertEquals(50, cafetera.hacerCafe("NOESTA", 50));
		
		assertEquals(0, cafetera.hacerCafe("receta2", 0));
		
		TestInventario inventario = new TestInventario(b);
		
		cafetera.setInventario(inventario);
		
		assertEquals(1, cafetera.hacerCafe("receta1", 3));
		
		TestInventario inventario1 = new TestInventario(false);
		
		cafetera.setInventario(inventario1);
		
		assertEquals(3, cafetera.hacerCafe("receta1", 3));
		
		
		
		
		
	}

}
