import java.util.ArrayList;

public class Empresa {

    public static void main(String[] args) {

        ArrayList<Funcionario> Functions = new ArrayList<>();

        Gerente riachuelo = new Gerente("Simeon", 10000.3, "Linkedin");

        Desenvolvedor back = new Desenvolvedor("Gabriel", 4200.5);

        Functions.add(riachuelo);
        Functions.add(back);

        for (Funcionario funcionarios : Functions) {

            funcionarios.calcularSalario();
            funcionarios.exibirDados();

            if (funcionarios instanceof Gerente gerente) {
                if (gerente.autenticavel("Linkedin"))
                    System.out.println("Seja bem-vindo!");
                else
                    System.out.println("Senha incorreta.");

            }
        }

    }
}
