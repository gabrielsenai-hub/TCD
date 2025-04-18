package Negocios;

public class Velho extends Imovel implements iCalculaValor {

	private double desconto;

	public Velho() {
		super();
	}

	public Velho(String endereco, double preco, double desconto) {
		super(endereco, preco);
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public void calculoTotal() {
		
		double valor = getPreco();

		valor -= (valor * getDesconto());

		System.out.println("Valor total: R$" + valor);

	}

}
