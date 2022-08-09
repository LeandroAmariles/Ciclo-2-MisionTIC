package Default;

import java.util.List;

public class PrecioTotal {
	
	private double totalComputadores =0;
	private double totalComputadoresMesa=0;
	private double totalComputadoresPortatiles=0;
	Computadores[] listaComputadores;
	
	
	public PrecioTotal(Computadores[] computadores) {
		this.listaComputadores=computadores;
	}
	
	public void mostrarTotales() {
		
		for(int i =0; i<listaComputadores.length;i++) {
				if(listaComputadores[i] instanceof Computadores) {
					totalComputadores += listaComputadores[i].calcularPrecio();
				}
				if(listaComputadores[i] instanceof ComputadoresMesa) {
					totalComputadoresMesa += listaComputadores[i].calcularPrecio();
			}
				if(listaComputadores[i] instanceof ComputadoresPortatiles) {
					totalComputadoresPortatiles += listaComputadores[i].calcularPrecio();
				}
		}
		
		System.out.println("La suma del precio de los computadores es de "+ totalComputadores );
		System.out.println("la suma del precio de los computadores de mesa es de "+totalComputadoresMesa);
		System.out.println("La suma del precio de los computadores portatiles es de "+ totalComputadoresPortatiles);
	}
}
	
	


