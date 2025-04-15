package Vendas;

public class Bikes {

	private String marca;
	private String modelo;
	private String tipo;
	private double valor;
	private Acessorios acessorio;

	public Bikes(String marca, String modelo, String tipo, double valor, Acessorios acessorio) {

		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.valor = valor;
		this.acessorio = acessorio;
	}

	public double calcularValorTotal() {
		
		double valorTotal;

		valorTotal = this.valor + acessorio.getPreço();

		return valorTotal;
	}

	double valorCompleto;

	public double aplicarDesconto(double percentual) {

		double valorTotal = calcularValorTotal();
		
		valorTotal -= (valorTotal *= percentual);
		
		return valorCompleto = valorTotal;

	}
	
	public void exibirDetalhes() {

		System.out.println("O valor total da bicicleta " + this.marca + " com o " + acessorio.getTipo()
				+ " resultou: R$" + valorCompleto + ".");

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		
		this.valor = valor;
		
		}

	public Acessorios getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorios acessorio) {
		this.acessorio = acessorio;
	}

}
