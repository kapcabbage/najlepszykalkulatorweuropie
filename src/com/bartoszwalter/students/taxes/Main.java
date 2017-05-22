package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class Main
{
	public static BigDecimal podstawa;
	public static char umowa;

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			System.out.print("Podaj kwotę dochodu: ");
			String kwota = br.readLine();
			podstawa = new BigDecimal(kwota);

		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}

		try {
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			umowa = br.readLine().charAt(0);
			SystemKalkulatorow system = new SystemKalkulatorow(umowa);
			List<Wynik> wyniki = system.Przelicz(podstawa);

			DecimalFormat df00 = new DecimalFormat("#.00");
			for (Wynik wynik: wyniki
				 )
			{
				System.out.println(wynik.getName() + ": " + df00.format(wynik.getAmount()));
			}

		} catch (IOException ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}
	}
}
