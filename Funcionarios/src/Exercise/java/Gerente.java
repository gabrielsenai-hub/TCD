public class Gerente extends Funcionario implements iAutenticavel {

    private String senha;

    public Gerente(String nome, double salarioBase, String senha) {
        super(nome, salarioBase);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void calcularSalario() {
        salarioBase *= 1.2;
    }

    @Override
    public boolean autenticavel(String senha) {

        if (this.senha.equals(senha))
            return true;

        return false;

    }

}
