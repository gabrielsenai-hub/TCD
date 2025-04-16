
public class Celular {

    private String marca;      
    private String cor;        
    private String modelo;     
    private double valor;      
    private Capa capa;         

    
    public Celular(String marca, String cor, String modelo, double valor, Capa capa) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.valor = valor;
        this.capa = capa;
    }

    
    public void calcularTotal() {
        double valorTotal;
        valorTotal = this.valor + capa.getPreco(); 
        
        System.out.println("O valor total do celular " + this.modelo + " com a capa " + capa.getCor() + 
            " de " + capa.getMaterial() + " totalizou: R$" + valorTotal);
    }

    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Capa getCapa() {
        return capa;
    }

    public void setCapa(Capa capa) {
        this.capa = capa;
    }
}