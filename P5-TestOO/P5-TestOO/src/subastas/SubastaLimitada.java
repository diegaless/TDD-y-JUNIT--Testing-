package subastas;

/** Una subasta limitada es un tipo de subasta que se caracteriza porque s�lo admite un n�mero m�ximo de pujas fijado en el constructor. 
 *  Una vez que se alcanza el n�mero m�ximo de pujas la subasta se cierra y se ejecuta autom�ticamente.
 *
 */
public class SubastaLimitada extends Subasta {
	private final int pujasPermitidas;
	
	public SubastaLimitada(Usuario propietario, String producto, 
			int pujasPermitidas){
		super(propietario, producto);
		
		this.pujasPermitidas = pujasPermitidas;
	}

	public int getPujasPermitidas() {
		return pujasPermitidas;
	}
	
	public int getPujasRestantes(){
		return pujasPermitidas - getPujas().size();
	}
	
	@Override
	public boolean pujar(Usuario usuario, double cantidad) {

		if (getPujasRestantes() > 0) {
			boolean haPujado = super.pujar(usuario, cantidad);

			if (haPujado && getPujasRestantes() == 0){
				ejecutar();
			}

			return haPujado;
		}
		else
			return false;
	}

}
