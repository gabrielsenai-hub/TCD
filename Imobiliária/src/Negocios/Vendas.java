package Negocios;

public class Vendas {

	public static void main(String[] args) {
		
		Novo guardaRoupas = new Novo("",1200,0.3);
		Velho cama = new Velho ("", 1000, 0.15);
		
		guardaRoupas.calculoTotal();
		cama.calculoTotal();
	}

}
