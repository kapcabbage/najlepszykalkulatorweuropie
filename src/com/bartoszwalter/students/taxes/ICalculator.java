package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Mustrum on 19.05.2017.
 */
public interface ICalculator
{
    public void setPodstawa(BigDecimal podstawa);
    public void oblicz();
    public List<Wynik> getWyniki();
}
