package TV;

import java.util.Scanner;

public class Televisor {

	Scanner scanner = new Scanner(System.in);

	String marca;
	int volume = 0;
	int canalAtual = 1;
	boolean ligada = true;

	void power() {
		if (this.ligada) {
			this.ligada = false;
			System.out.println("Desligando...");
		} else {
			this.ligada = true;
			System.out.println("Ligando!");
		}
	}

	void volumeMais() {
		if (this.ligada) {
			if (this.volume == 100) {
				System.out.println("\n\nVolume máximo alcançado");
			} else {
				this.volume++;

				System.out.println("\n\n////////Volume " + volume + "////////");
			}

		}
	}

	void volumeMenos() {
		if (this.ligada) {
			if (this.volume == 0) {
				System.out.println("\n\nVolume mudo alcançado!");
			} else {
				this.volume--;
				System.out.println("\n\n////////Volume " + volume + "////////");
			}

		}
	}

	void trocarCanalfrente() {
		if (this.ligada) {
			if (canalAtual == 999) {
				this.canalAtual = 1;
				System.out.println("\n\n-----------Canal " + canalAtual + "-----------");
			} else {
				this.canalAtual++;

				System.out.println("\n\n-----------Canal " + canalAtual + "-----------");
			}
		}
	}

	void trocarCanaltraz() {
		if (this.ligada) {
			if (canalAtual == 1) {
				this.canalAtual = 999;
				System.out.println("\n\n-----------Canal " + canalAtual + "-----------");
			} else {
				this.canalAtual--;

				System.out.println("\n\n-----------Canal " + canalAtual + "-----------");
			}

		}
	}

	void mudo() {

		if (volume > 0) {
			this.volume = 0;
		}

		else {
			System.out.println("O volume já encontra-se no mudo.");
		}

	}

	void escolherVolume() {

		System.out.println(" = Escolha um volume entre 0 e 100 =");
		System.out.print("Volume: ");
		int volumeEscolhido = scanner.nextInt();
		if (volumeEscolhido != this.volume) {

			this.volume = volumeEscolhido;

			System.out.println("\n\nVolume setado em: " + volume);
		} else {
			System.out.println("O volume já encontra-se em " + volume + "!");
		}

	}

	void trocarCanalteclas() {
		if (this.ligada) {
			System.out.println("\n\nInforme o canal desejado: ");
			int canal = scanner.nextInt();

			if (this.canalAtual != canal) {
				this.canalAtual = canal;

				System.out.println("\n\n-----------Canal " + canalAtual + "-----------");
			} else {

				System.out.println("A televisão já encontra-se neste canal.");
			}

		}

	}

	public String status() {

		if (this.ligada) {

			return "\nTelevisor ligado no volume " + volume + " e no canal " + canalAtual;
		}

		else {
			return "TV desligada.";
		}
	}

}
