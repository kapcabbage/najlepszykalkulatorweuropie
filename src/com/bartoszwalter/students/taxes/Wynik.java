package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by Mustrum on 19.05.2017.
 */
public class Wynik
{
    private BigDecimal amount;
    private String name;

    public Wynik(){

    }

    public Wynik(String nazwa, BigDecimal kwota){
        amount = kwota;
        name = nazwa;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
