package Default;

public class ComputadoresPortatiles extends Computadores{
	
	private final static int PULGADAS_BASE=20;

	private int pulgadas;
	private boolean camaraITG;
	
	public ComputadoresPortatiles() {
		this(PRECIO_BASE, PESO_BASE, CONSUMO_W, PULGADAS_BASE, false);
	}
	public ComputadoresPortatiles(double precioBase, int peso) {
		this(precioBase, peso, CONSUMO_W, PULGADAS_BASE, false);
	}
	
	public ComputadoresPortatiles(double precioBase, int peso, char consumoW, int pulgadas, boolean camaraITG) {
		super(precioBase, peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;
	}
		
	public Double CalcularPrecio() {
		double adicion = super.calcularPrecio();
		if(camaraITG) {
			adicion+=50;
		}
		if(pulgadas>40) {
			adicion+=(precioBase*0.3);
		}
		
		return adicion;
	}

}
