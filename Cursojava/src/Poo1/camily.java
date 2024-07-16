package Poo1;

import java.util.Scanner;

public class camily {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean camily = false;

		System.out.println("Camily vc secou a louça? ");
		String resp = sc.next();

		if (resp.equals("y")) {
			camily = true;
		} else {
			System.out.println("\nEstou desapontada filha...");
		}

		if (camily) {
			System.out.println("\nVocê ta pronta pra viajar o mundo filha!!!!");
		} else {
			System.out.println("\nCOMO VOCÊ QUER VIAJAR O MUNDO ASSIM MINHA FILHA??????????");
		}

		sc.close();

	}

}
