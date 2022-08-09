
public class Probar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BecaUniversitaria beca = new BecaUniversitaria();
		System.out.println(beca.compararInversion());
		System.out.println(beca.compararInversion(48,10000,2.0));
		

		BecaUniversitaria beca1 = new BecaUniversitaria(48,10000,2.0);
		System.out.println(beca1.compararInversion());
		System.out.println(beca1.compararInversion());
		
		
		
		
	}

}
