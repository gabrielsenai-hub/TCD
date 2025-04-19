public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salarioBase) {
        super(nome, salarioBase);

    }

    @Override
    public void calcularSalario() {

        salarioBase *= 1.1;

    }

}
