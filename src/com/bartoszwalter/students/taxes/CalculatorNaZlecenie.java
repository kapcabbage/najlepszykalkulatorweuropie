package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Mustrum on 19.05.2017.
 */
public class CalculatorNaZlecenie implements ICalculator
{

    private BigDecimal podstawa;
    private ArrayList<Wynik> wyniki = new ArrayList<>();

    private BigDecimal skladkaEmerytalna;
    private BigDecimal skladkaRentowa;
    private BigDecimal ubezpieczenieChorobowe;
    private BigDecimal podstawaWymiaruNaZdrowotne;
    private BigDecimal swiadczenieZdrowotne7;
    private BigDecimal swiadczenieZdrowotne9;
    private BigDecimal kosztyUzyskania;
    private BigDecimal podstawaOpodatkowania;
    private BigDecimal podstawaOpodatkowaniaZaokraglona;
    private BigDecimal zaliczkaNaPodatek;
    private BigDecimal zaliczkaDoUS;
    private BigDecimal zaliczkaDoUSZaokraglona;
    private BigDecimal wynagrodzenie;

    @Override
    public void setPodstawa(BigDecimal kwota)
    {
        podstawa = kwota;
    }

    private void zapiszWyniki()
    {
        wyniki.add(new Wynik("Podstawa wymiaru składek", podstawa));
        wyniki.add(new Wynik("Skladka na ubezpieczenie emerytalne", skladkaEmerytalna));
        wyniki.add(new Wynik("Składka na ubezpieczenie rentowe", skladkaRentowa));
        wyniki.add(new Wynik("Składka na ubezpieczenie chorobowe", ubezpieczenieChorobowe));
        wyniki.add(new Wynik("Podstawa wymiaru składki na ubezpieczenie zdrowotne", podstawaWymiaruNaZdrowotne));
        wyniki.add(new Wynik("Składka na ubezpieczenie zdrowotne 9%", swiadczenieZdrowotne9));
        wyniki.add(new Wynik("Składka na ubezpieczenie zdrowotne 7,75%", swiadczenieZdrowotne7));
        wyniki.add(new Wynik("Koszty uzyskania przychodu", kosztyUzyskania));
        wyniki.add(new Wynik("Podstawa opodatkowania", podstawaOpodatkowania));
        wyniki.add(new Wynik("Podstawa opodatkowania zaokrąglona", podstawaOpodatkowaniaZaokraglona));
        wyniki.add(new Wynik("Zaliczka na podatek dochodowy 18%", zaliczkaNaPodatek));
        wyniki.add(new Wynik("Zaliczka do urzędu skarbowego", zaliczkaDoUS));
        wyniki.add(new Wynik("Zaliczka do urzędu skarbowego zaokrąglona", zaliczkaDoUSZaokraglona));
        wyniki.add(new Wynik("Wynagrodzenie", wynagrodzenie));
    }

    @Override
    public void oblicz()
    {
        skladkaEmerytalna = podstawa.multiply(new BigDecimal("0.0976")).setScale(2, RoundingMode.HALF_UP);
        skladkaRentowa = podstawa.multiply(new BigDecimal("0.015")).setScale(2, RoundingMode.HALF_UP);
        ubezpieczenieChorobowe = podstawa.multiply(new BigDecimal("0.0245")).setScale(2, RoundingMode.HALF_UP);
        podstawaWymiaruNaZdrowotne = podstawa.subtract(skladkaEmerytalna).subtract(skladkaRentowa).subtract(ubezpieczenieChorobowe);
        swiadczenieZdrowotne9 = podstawaWymiaruNaZdrowotne.multiply(new BigDecimal("0.09")).setScale(2, RoundingMode.HALF_UP);
        swiadczenieZdrowotne7 = podstawaWymiaruNaZdrowotne.multiply(new BigDecimal("0.0775")).setScale(2, RoundingMode.HALF_UP);
        kosztyUzyskania = podstawaWymiaruNaZdrowotne.multiply(new BigDecimal("0.2")).setScale(2, RoundingMode.HALF_UP);
        podstawaOpodatkowania = podstawaWymiaruNaZdrowotne.subtract(kosztyUzyskania);
        podstawaOpodatkowaniaZaokraglona = podstawaOpodatkowania.setScale(0, RoundingMode.HALF_UP);
        zaliczkaNaPodatek = podstawa.multiply(new BigDecimal("0.18")).setScale(2, RoundingMode.HALF_UP);
        zaliczkaDoUS = zaliczkaNaPodatek.subtract(swiadczenieZdrowotne7);
        zaliczkaDoUSZaokraglona = zaliczkaDoUS.setScale(0, RoundingMode.HALF_UP);
        wynagrodzenie = podstawa.subtract(skladkaEmerytalna.add(skladkaRentowa).add(ubezpieczenieChorobowe).add(swiadczenieZdrowotne9).add(zaliczkaDoUSZaokraglona));
        zapiszWyniki();
    }

    @Override
    public ArrayList<Wynik> getWyniki()
    {
        return wyniki;
    }
}
