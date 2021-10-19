package com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculadoraTestMenosIngenuo {
    static Calculadora calculadora;

    @BeforeAll
    public static void setup() {
     calculadora = new Calculadora();
    }

    @Test
    public void deveResultarEm4() {
        assertEquals(4.0, calculadora.soma(2, 2));
    }

    @Test
    public void deveResultarEm10() {
        assertEquals(10, calculadora.soma(7, 3));
    }
}
