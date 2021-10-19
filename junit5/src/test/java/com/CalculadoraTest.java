package com;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    static Calculadora calculadora;

    @Test
    public void testeSoma() {
        Calculadora myCalc = new Calculadora();
        boolean temErro = false;

        if (myCalc.soma(2, 2) != 4) {
            temErro = true;
        }
        if (myCalc.soma(5, 5) != 10) {
            temErro = true;
        }
        if (myCalc.soma(2, -2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(3, 3) != 6) {
            temErro = true;
        }
        if (myCalc.soma(-5, -5) != -10) {
            temErro = true;
        }
        if (temErro) {
            fail("==> Há um erro na soma <==");
        }
    }

    @Test
    public void testeSubtracao() {
        Calculadora myCalc = new Calculadora();
        boolean temErro = false;

        if (myCalc.subtracao(2, 2) != 0) {
            temErro = true;
        }
        if (myCalc.subtracao(5, 5) != 0) {
            temErro = true;
        }
        if (myCalc.subtracao(100, 50) != 50) {
            temErro = true;
        }
        if (myCalc.subtracao(3, 5) != -2) {
            temErro = true;
        }
        if (myCalc.subtracao(5, 2) != 3) {
            temErro = true;
        }
        if (temErro) {
            fail("==> Há um erro na subtração <==");
        }
    }

    @Test
    public void testeMultiplicacao() {
        Calculadora myCalc = new Calculadora();
        boolean temErro = false;

        if (myCalc.multiplicacao(2, 2) != 4) {
            temErro = true;
        }
        if (myCalc.multiplicacao(5, 5) != 25) {
            temErro = true;
        }
        if (myCalc.multiplicacao(10, 50) != 500) {
            temErro = true;
        }
        if (myCalc.multiplicacao(2, 4) != 8) {
            temErro = true;
        }
        if (myCalc.multiplicacao(5, 2) != 10) {
            temErro = true;
        }
        if (temErro) {
            fail("==> Há um erro na multiplicação <==");
        }
    }

    @Test
    public void testeDivisao() {
        Calculadora myCalc = new Calculadora();
        boolean temErro = false;

        if (myCalc.divisao(2, 2) != 1) {
            temErro = true;
        }
        if (myCalc.divisao(5, 1) != 5) {
            temErro = true;
        }
        if (myCalc.divisao(20, 10) != 2) {
            temErro = true;
        }
        if (myCalc.divisao(8, 2) != 4) {
            temErro = true;
        }
        if (temErro) {
            fail("==> Há um erro na divisão <==");
        }
    }
}
