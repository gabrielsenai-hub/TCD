package Negocios;

public class Novo extends Imovel implements iCalculaValor {

	private double adicional;

	public Novo() {
		super();

	}

	public Novo(String endereco, double preco, double adicional) {
		super(endereco, preco);
		this.adicional = adicional;
	}

	public double getAdicional() {
		return adicional;
	}

	public void setAdicional(double adicional) {
		this.adicional = adicional;
	}

	@Override
	public void calculoTotal() {

		double valor = getPreco();
		
		valor += (valor * getAdicional());

		System.out.println("Valor total: R$" + valor);

	}

}
