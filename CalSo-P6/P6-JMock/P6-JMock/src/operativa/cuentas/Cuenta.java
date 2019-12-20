package operativa.cuentas;

public class Cuenta {
	private final static Divisa DEFAULT_DIVISA = Divisa.EURO;
	private final static double DEFAULT_SALDO = 100d;
	private static int nextNumeroCuenta = 1;
	
	private int numeroCuenta;
	private String titular;
	private double saldo;
	private Divisa divisa;
	
	public Cuenta(String titular){
		this(titular, DEFAULT_SALDO, DEFAULT_DIVISA);
	}
	
	public Cuenta(String titular, double saldo){
		this(titular, saldo, DEFAULT_DIVISA);
	}
	
	public Cuenta(String titular, double saldo, Divisa divisa){
		this.numeroCuenta = nextNumeroCuenta++;
		this.titular = titular;
		this.saldo = saldo;
		this.divisa = divisa;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Divisa getDivisa() {
		return divisa;
	}
	
	public void ingresar(double cantidad){
		saldo += cantidad;
	}
	
	public void sacar(double cantidad){
		//La cuenta puede quedar al descubierto
		saldo -= cantidad;
	}
}
