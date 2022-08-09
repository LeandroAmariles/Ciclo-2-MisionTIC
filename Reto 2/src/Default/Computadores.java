package Default;

public class Computadores {
	
	protected final static char CONSUMO_W='F';
	protected final static double PRECIO_BASE=100.0;
	protected final static int PESO_BASE=5;
	
	
	Integer pesoBase =0;
	char consumoW;
	Double precioBase=0.0;
	
	public Computadores() {
		this(PRECIO_BASE, PESO_BASE, CONSUMO_W);
		
	}
	 public Computadores(Double precioBase, Integer peso) {
	        this(precioBase, peso, CONSUMO_W);
	    }
	public Computadores (double precioBase, int pesoBase) {
		
	}
	
	
	public Computadores(double precioBase, int pesoBase, char consumo_W_Base ) {
		super();
		this.pesoBase = pesoBase;
		this.consumoW = consumo_W_Base;
		this.precioBase = precioBase;
	}


	public double calcularPrecio() {
		
		int adicionPeso=0;
		int adicionW=0;
		
		switch (consumoW) {
		case 'A':{
			adicionW=100;
		}
		case 'B':{
			adicionW=80;
		}
		case 'C':{
			adicionW=60;
		}
		case 'D':{
			adicionW=50;
		}
		case 'E':{
			adicionW=30;
		}
		case 'F':{
			adicionW=10;	
		}
		}
			
		if(pesoBase>=0 && pesoBase<19) {
			adicionPeso=10;
		}else if(pesoBase>=20 && pesoBase<49) {
			adicionPeso=50;
		}else if(pesoBase>=50 && pesoBase<79) {
			adicionPeso=80;
		}else if(pesoBase>=80) {
			adicionPeso=100;
		}
		double precioTotal= (double)(adicionPeso+adicionW) + precioBase;
		return precioTotal;
	}
	
	
	public Integer getPesoBase() {
		return pesoBase;
	}
	public char getConsumo_W_Base() {
		return consumoW;
	}
	public Double getPrecioBase() {
		return precioBase;
	}
	

}
