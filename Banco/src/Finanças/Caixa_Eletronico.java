package Finanças;

public class Caixa_Eletronico {

	public static void main(String[] args) {
		
		Poupança contaPoupanca = new Poupança(" "," ",200);
		Corrente contaCorrente = new Corrente(" "," ",200);
		
		System.out.println("Corrente:\n");
		
		contaCorrente.exibirSaldo();
		contaCorrente.depositar(50);
		contaCorrente.exibirSaldo();
		contaCorrente.sacar(20);
		contaCorrente.exibirSaldo();
		
		System.out.println("\nPoupança:\n");
		
		contaPoupanca.exibirSaldo();
		contaPoupanca.depositar(40);
		contaPoupanca.exibirSaldo();
		contaPoupanca.sacar(50);
		contaPoupanca.exibirSaldo();
		
		
	}

}
