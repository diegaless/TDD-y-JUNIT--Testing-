package subastas;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubastaTest {
	
	private Usuario propietario;
	private String producto;
	protected Subasta subasta;
	

		
	@Before
	public void setUp(){
		propietario = new Usuario("User",50);
		producto = new String("Producto1");
		subasta = new Subasta(propietario,producto);
		
	}
	
	@Test
	public void testConstructorSubasta(){
		assertNotNull(subasta.getProducto());
		assertNotNull(subasta.getPropietario());
		assertNotNull(subasta.getPujas());
		assertTrue(subasta.isAbierta());
	}
	
	@Test
	public void testGetPropietario(){
		assertNotNull(subasta.getPropietario());
	}
	
	@Test
	public void testGetProducto(){
		assertNotNull(subasta.getProducto());
	}
	
	@Test
	public void testIsAbierta(){
		assertTrue(subasta.isAbierta());
	}
	
	@Test
	public void testGetPujas(){
		assertNotNull(subasta.getPujas());
	}
	
	@Test
	public void testSetAbiertaFalse(){
		subasta.setAbierta(false);
		
		assertFalse(subasta.isAbierta());
	}
	
	@Test
	public void TestGetPujaMayorVacia(){
		Subasta subasta = new Subasta(propietario,producto);
		assertNull(subasta.getPujaMayor());
		
	}
	@Test
	public void TestGetPujaMayor(){
		Usuario usuario = new Usuario("User1",60);
		subasta.pujar(usuario,50);
		assertNotNull(subasta.getPujaMayor());
		
	}
	
	@Test(expected = Exception.class)
	public void TestPujarSubastaCerrada(){
		subasta.setAbierta(false);
		Usuario user = new Usuario("user2",30);
		subasta.pujar(user);
	}
	
	@Test
	public void testPujarUsuarioEqualsPropietario(){
		Usuario propietario = new Usuario("User4",50);
		String producto = new String("Producto2");
		Subasta subasta = new Subasta(propietario,producto);
		assertFalse(subasta.pujar(propietario));
	}
	
	@Test
	public void testPujarUsuarioCredito(){
		Subasta subasta = new Subasta(propietario,producto);
		Usuario user = new Usuario("user2",30);
		assertFalse(subasta.pujar(user,60));
	}
	
	@Test
	public void testPujarUsuarioCredito2(){
		Usuario user = new Usuario("user2",30);
		Usuario user2 = new Usuario("user3",40);
		subasta.pujar(user,30);
		assertFalse(subasta.pujar(user2,20));
	}
	
	@Test
	public void testPujarUsuarioCredito3(){
		Usuario user2 = new Usuario("user3",40);
		assertFalse(subasta.pujar(user2,20));	//Cond mal en codigo, deberia ser pujaMayor() == null
	}
	
	@Test
	public void testPujarUsuarioCredito4(){
		Usuario user = new Usuario("user2",30);
		Usuario user2 = new Usuario("user3",400);
		subasta.pujar(user,30);
		assertTrue(subasta.pujar(user2,400));
	}
	
	@Test
	public void testPujar(){
		Usuario user1 = new Usuario("user2",0);
		assertFalse(subasta.pujar(user1));
	}
	
	@Test
	public void testPujar2(){
		Usuario user1 = new Usuario("user2",200);
		assertTrue(subasta.pujar(user1));
	}
	
	@Test
	public void testPujar3(){
		Usuario user1 = new Usuario("user1",200);
		Usuario user2 = new Usuario("user2",100);
		subasta.pujar(user1);
		assertTrue(subasta.pujar(user2));
	}
	
	@Test(expected = Exception.class)
	public void testEjecutarSubastaCerrada(){
		subasta.setAbierta(false);
		subasta.ejecutar();
	}
	
	@Test
	public void testEjecutarSubastaSinPujas(){
		assertFalse(subasta.ejecutar());
	}
	
	@Test
	public void testEjecutarSubastaConPujas(){
		Usuario user = new Usuario("User5",600);
		subasta.pujar(user,400);
		assertTrue(subasta.ejecutar());
	}
	
	@Test
	public void testAleatorio1(){
		assertTrue(subasta.isAbierta());
	}
	
	@Test
	public void testAleatorio2(){
		Usuario user = new Usuario("User5",600);
		subasta.pujar(user);
		assertTrue(subasta.isAbierta());
	}
	
	@Test
	public void testAleatorio3(){
		Usuario user = new Usuario("User5",600);
		subasta.pujar(user);
		subasta.ejecutar();
		assertFalse(subasta.isAbierta());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
