package TV;

import java.util.Scanner;

public class Controle {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Televisor tv1 = new Televisor();

		do {
			System.out.println(tv1.status());

			System.out.println("\n\n=\tControle\t=\n");

			System.out.println("1 - Escolher canal");

			System.out.println("2 - Mudar de canal p/ frente");

			System.out.println("3 - Mudar de canal p/ trás");

			System.out.println("4 - Volume +");

			System.out.println("5 - Volume -");

			System.out.println("6 - Escolher volume");

			System.out.println("7 - Mudo");

			System.out.println("0 - Desligar/ligar");

			System.out.print("\nOpção desejada: ");

			int opcao = scanner.nextInt();

			switch (opcao) {

			case 1:

				tv1.trocarCanalteclas();

				break;

			case 2:

				tv1.trocarCanalfrente();

				break;

			case 3:

				tv1.trocarCanaltraz();

				break;

			case 4:

				tv1.volumeMais();

				break;

			case 5:

				tv1.volumeMenos();

				break;

			case 6:

				tv1.escolherVolume();

				break;

			case 7:

				tv1.mudo();

				break;

			case 0:

				tv1.power();
				System.out.println(tv1.status());

				break;

			default:

				System.out.println("\nOpção inválida! Tente novamente.\n");

			}

		}

		while (tv1.ligada);

		scanner.close();

	}
}
