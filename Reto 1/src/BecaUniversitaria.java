
public class BecaUniversitaria {
	
	double pMonto =0;
	double pInteres=0;
	int pTiempo=0;
	
	public BecaUniversitaria() {
		
	}
	
	public BecaUniversitaria( int pTiempo,double pMonto, double pInteres) {
		this.pInteres=pInteres;
		this.pMonto=pMonto;
		this.pTiempo=pTiempo;
	}
	
	public double calcularInteresSimple() {
		this.pInteres=pInteres;
		this.pMonto=pMonto;
		this.pTiempo=pTiempo;
		double interesSimple= pMonto*(pInteres/100)*pTiempo;
		return Math.round(interesSimple);
	}
	public double calcularInteresCompuesto() {
		this.pInteres=pInteres;
		this.pMonto=pMonto;
		this.pTiempo=pTiempo;
		double interesCompuesto= pMonto*((Math.pow((1+pInteres/100),pTiempo)-1));
		return Math.round(interesCompuesto);
	}
	public String compararInversion(int pTiempo, double pMonto, double pInteres) {
		this.pInteres=pInteres;
		this.pMonto=pMonto;
		this.pTiempo=pTiempo;
		double resultado = (double) (calcularInteresCompuesto() -calcularInteresSimple() );
		return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + resultado;	
		
	}
	public String compararInversion() {
		double resultado = (double) (calcularInteresCompuesto() -calcularInteresSimple() );
		if(resultado>1) {
			return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + resultado;	
		}
		else {
			return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
	}

}
}
