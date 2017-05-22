package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Mustrum on 19.05.2017.
 */
public class SystemKalkulatorow
{
    public static class Umowy{
        public static char OPrace = 'P';
        public static char NaZlecenie = 'Z';
    }

    private ICalculator calculator;

    public SystemKalkulatorow(char jakiKalkulator){
        switch (jakiKalkulator){
            case 'P':
                calculator = new CalculatorOPrace();
                break;
            case 'Z':
                calculator = new CalculatorNaZlecenie();
                break;
            default:
                throw  new IllegalArgumentException("Nie obsługujemy takiej umowy.");
        }
    }

    public List<Wynik> Przelicz(BigDecimal kwota){
        calculator.setPodstawa(kwota);
        calculator.oblicz();
        return  calculator.getWyniki();
    }
}
