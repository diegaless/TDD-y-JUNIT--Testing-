package test.operativa.cuentas;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import operativa.cuentas.Cuenta;
import operativa.cuentas.Divisa;
import operativa.cuentas.GestorCuentas;
import operativa.cuentas.ServicioCuentas;
import operativa.cuentas.ServicioDivisas;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ServicioCuentasTest {

	
	private static String titular = "TITULAR";
	private static String titular2 = "titular2";
	private static double saldoInicial = 100;
	private static double saldo = 100;
	private static Divisa divisa = Divisa.EURO;
	private static Divisa divisa1 = Divisa.DOLAR;
	
	@Rule
	 public JUnitRuleMockery context = new JUnitRuleMockery();
	
	 final GestorCuentas gestorCuentasMock = context.mock(GestorCuentas.class);	//Mock
	 final ServicioDivisas servicioDivisasMock = context.mock(ServicioDivisas.class);
	 private static ServicioCuentas sc = new ServicioCuentas();

	
	 
	 @Test
	public void testAbrirCuenta1() {
		 context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).alta(with(any(Cuenta.class)));
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		assertThat(sc.abrirCuenta(titular,saldoInicial,divisa),instanceOf(Cuenta.class));
	}
	 
	@Test
	public void testAbrirCuenta2() {
		 context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).alta(with(any(Cuenta.class)));
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		assertThat(sc.abrirCuenta(titular,saldoInicial),instanceOf(Cuenta.class));
	}
	 
	@Test
	public void testAbrirCuenta3() {
		 context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).alta(with(any(Cuenta.class)));
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		assertThat(sc.abrirCuenta(titular),instanceOf(Cuenta.class));
	}
	 
	@Test
	public void testGetCuenta(){
		context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).getCuenta(titular);
			 will(returnValue(new Cuenta(titular)));
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		assertThat(sc.getCuenta(titular),instanceOf(Cuenta.class));
		
	}
	
	@Test
	public void testSetIntereses(){
		context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).getCuenta(titular);
			 will(returnValue(new Cuenta(titular)));
			 oneOf (gestorCuentasMock).salvar(with(any(Cuenta.class)));
			// will(returnValue(Cuenta.class));
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		assertEquals(5d,sc.setIntereses(titular), 0.001);
		
	}
	
	@Test
	public void testTransferencia(){
		context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).getCuenta(titular);
			 will(returnValue(new Cuenta(titular)));
			 oneOf (gestorCuentasMock).getCuenta(titular2);
			 will(returnValue(new Cuenta(titular2)));
			
			 oneOf(gestorCuentasMock).salvar(with(any(Cuenta.class)));
			 oneOf(gestorCuentasMock).salvar(with(any(Cuenta.class)));
			 
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		sc.transferencia(titular, titular2,saldo);
	}
	
	@Test
	public void testTransferencia2(){
		context.checking(new Expectations(){{
			 oneOf (gestorCuentasMock).getCuenta(titular);
			 will(returnValue(new Cuenta(titular,100d,Divisa.DOLAR)));
			 oneOf (gestorCuentasMock).getCuenta(titular2);
			 will(returnValue(new Cuenta(titular2,100d,Divisa.EURO)));
			 
			 oneOf (servicioDivisasMock).convertir(divisa,divisa1,saldo);
			
			 oneOf(gestorCuentasMock).salvar(with(any(Cuenta.class)));
			 oneOf(gestorCuentasMock).salvar(with(any(Cuenta.class)));
			 
		}});
		
		sc.setGestorCuentas(gestorCuentasMock);
		sc.setServicioDivisas(servicioDivisasMock);
		sc.transferencia(titular2, titular,saldo);
	}
	
	
	
	
	

	
	

}
