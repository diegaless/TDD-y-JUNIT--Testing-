package subastas;

/**
 * Una subasta m�nima es un tipo de subasta que se caracteriza porque s�lo podr� ejecutarse 
 * si la puja mayor alcanza una cantidad m�nima fijada en el momento de construir la subasta.
 */
public class SubastaMinima extends Subasta {
	private double cantidadMinima;

	public SubastaMinima(Usuario propietario, String producto,
			double cantidadMinima) {
		super(propietario, producto);
		
		this.cantidadMinima = cantidadMinima;
	}
	
	public double getCantidadMinima() {
		return cantidadMinima;
	}
	
	public void setCantidadMinima(double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	
	@Override
	public boolean ejecutar() {
		if (getPujaMayor() == null || 
				getPujaMayor().getCantidad() < cantidadMinima){
			//No se puede ejecutar si no se alcanza la cantidad m�nima		
			return false;
		}
		else{
			//He alcanzado el m�nimo fijado en el constructor
			return super.ejecutar();
		}
	}
	
	/**
	 * Una subasta m�nima puede ser cerrada en cualquier momento
	 */
	public void cerrar(){
		if (!isAbierta())	//Este metodo no esta cubierto porque falla la prueba unitaria
			throw new IllegalArgumentException("La subasta ya est� cerrada");
		
		setAbierta(false);
	}
	
}
