package Default;

public class ComputadoresMesa extends Computadores{
	
	private final static int ALMACENAMIENTO_BASE = 50;
	int almacenamiento;
	
	
	public ComputadoresMesa() {
		 this(PRECIO_BASE, PESO_BASE, CONSUMO_W, ALMACENAMIENTO_BASE);
	}
	public ComputadoresMesa(double precioBase, int peso) {
		this(precioBase, peso, CONSUMO_W, ALMACENAMIENTO_BASE);
	}
	
	public ComputadoresMesa(double precioBase, int peso, char consumoW, int almacenamiento) {
		super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
	}
	public double CalcularPrecio() {
		double adicion = super.calcularPrecio();
		if (almacenamiento>100) {
			adicion=50;
		}else {
			almacenamiento = ALMACENAMIENTO_BASE;
		}
		return adicion;
	}
	public int getalmecenamiento() {
		return almacenamiento;
	}

}
