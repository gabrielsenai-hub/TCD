package Finanças;

public class Corrente extends Conta implements iOperacao {

	public Corrente() {
		super();
	}

	public Corrente(String numero, String agencia, double saldo) {
		super(numero, agencia, saldo);
	}

	@Override
	public void depositar(double saldoDepositar) {

		if (saldoDepositar > 0.00) {

			double saldoConta = getSaldo();

			saldoConta += saldoDepositar;

			setSaldo(saldoConta);

			System.out.println("Você adicionou: R$" + saldoDepositar);
		}

		else {

			System.out.println("Insira um valor maior que zero!");
		}
	}

	@Override
	public void sacar(double saldoASacar) {

		if (saldoASacar > 0.00) {

			if (saldoASacar > getSaldo()) {
				System.out.println("Não há saldo suficiente!");
			}

			else {

				double saldoSemTaxa, saldoConta;

				saldoConta = getSaldo();

				saldoSemTaxa = saldoASacar - (saldoASacar * 0.10);

				saldoConta -= saldoSemTaxa;

				setSaldo(saldoConta);

				System.out.println("Você sacou " + saldoSemTaxa);
			}
		}

		else {
			System.out.println("Insira um valor maior que zero!");
		}
	}

	@Override
	public void exibirSaldo() {

		double saldoConta = getSaldo();

		System.out.println("\nSeu saldo é de: R$" + saldoConta);

	}

}
