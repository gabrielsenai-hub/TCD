package Vendas;

public class Acessorios {

	private String tipo;
	private String marca;
	private String material;
	private double preço;

	public Acessorios(String tipo, String marca, String material, double preço) {

		this.tipo = tipo;
		this.marca = marca;
		this.material = material;
		this.preço = preço;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

}
