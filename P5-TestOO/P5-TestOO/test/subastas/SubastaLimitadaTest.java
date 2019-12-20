package subastas;

import org.junit.Before;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubastaLimitadaTest extends SubastaTest {

	private Usuario propietario;
	private String producto;
	private SubastaLimitada subasta2;
	
	@Before
	public void setUp(){
		propietario = new Usuario("User",50);
		producto = new String("Producto1");
		subasta = new SubastaLimitada(propietario,producto,3);
		subasta2 = new SubastaLimitada(propietario,producto,3);
	}
	
	@Test
	public void testPujar1(){
		Usuario user = new Usuario("user2",500);
		assertTrue(subasta2.pujar(user));
	}
	
	@Test
	public void testPujar2(){
		Usuario user = new Usuario("user2",500);
		Usuario user1 = new Usuario("user3",500);
		Usuario user2 = new Usuario("user4",500);
		Usuario user3 = new Usuario("user5",500);
		subasta2.pujar(user);
		subasta2.pujar(user1);
		subasta2.pujar(user2);
		assertFalse(subasta2.pujar(user3));
	}
	
	@Test
	public void testGetPujasPermitidas(){
		assertNotNull(subasta2.getPujasPermitidas());
	}
}
