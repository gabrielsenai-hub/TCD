package Vendas;

public class Principal {

	public static void main(String[] args) {
		
		Acessorios acessorio = new Acessorios("Capacete", "Bonder", "Cola", 250);
		
		Bikes bicicleta = new Bikes("Caloi", "Need Speed", "Elétrica", 1250, acessorio);
		
		bicicleta.calcularValorTotal();
		
		bicicleta.aplicarDesconto(0.25);
		
		bicicleta.exibirDetalhes();
		
	}

}
