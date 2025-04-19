import java.text.DecimalFormat;

public abstract class Funcionario {

    DecimalFormat df = new DecimalFormat("#,###.##");

    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract void calcularSalario();

    public void exibirDados() {

        System.out.println(nome + " recebe R$" + df.format(salarioBase) + ".");
    }

    ;

}
