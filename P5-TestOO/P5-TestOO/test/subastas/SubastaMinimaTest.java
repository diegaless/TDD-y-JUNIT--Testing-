package subastas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubastaMinimaTest extends SubastaTest{
	
	private Usuario propietario;
	private String producto;
	private SubastaMinima subasta2;
	
	@Before
	public void setUp(){
		propietario = new Usuario("User",50);
		producto = new String("Producto1");
		this.subasta = new SubastaMinima(propietario,producto,3);
		subasta2 = new SubastaMinima(propietario,producto,3);
	}
	
	
	@Test(expected = Exception.class)
	public void testCerrar(){
		subasta2.setAbierta(false);
		subasta2.cerrar();
	}
	
	@Test
	public void testCerrar2(){
		subasta2.setAbierta(true);
		subasta2.cerrar();
		assertFalse(subasta2.isAbierta());
	}
	
	@Test
	public void testEjecutarSubastaSinPujas(){
		assertFalse(subasta2.ejecutar());
	}

	@Test
	public void testEjecutarPujaMayorCantidadMinima(){
		Usuario user = new Usuario("user",10);
		subasta2.pujar(user,9);
		assertTrue(subasta2.ejecutar());
	}
	
	@Test
	public void testEjecutarPujaMenorCantidadMinima(){
		Usuario user = new Usuario("user",10);
		subasta2.pujar(user,2);
		assertFalse(subasta2.ejecutar());
	}
	
	@Test
	public void testGetCantidadMinima(){
		assertNotNull(subasta2.getCantidadMinima());
	}
	
	@Test
	public void testSetCantidadMinima(){
		subasta2.setCantidadMinima(5);
		assertTrue(subasta2.getCantidadMinima()==5);
	}
	
	@Test
	public void testEjecutarSubastaCerrada(){
		Usuario user = new Usuario("user1",5);
		subasta2.pujar(user, 4);
		subasta2.ejecutar();
	}
	
	public void testAleatorio3(){
		Usuario user = new Usuario("User5",600);
		subasta.pujar(user,400);
		subasta.ejecutar();
		assertFalse(subasta.isAbierta());
	}
	
}

	
