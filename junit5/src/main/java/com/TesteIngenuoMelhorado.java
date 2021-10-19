package com;

public class TesteIngenuoMelhorado {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        if (erroSoma(calculadora)) {
            System.exit(1);
        }

        if (erroSubtracao(calculadora)) {
            System.exit(1);
        }
        if (erroMultiplicacao(calculadora)) {
            System.exit(1);
        }
        if (erroDivisao(calculadora)) {
            System.exit(1);
        }
        System.out.println("Todos os teste passaram.");
        System.exit(0);
    }
 
    private static boolean erroSoma(Calculadora calculadora) {
        boolean erroSoma = false;
        if (calculadora.soma(2, 2) != 4) {
            erroSoma = true;
        }
        if (calculadora.soma(2, -2) != 0) {
            erroSoma = true;
        }
        if (erroSoma) {
            System.out.println("\n\n## Houve um erro na soma ##");
        }
        return erroSoma;
    }

    private static boolean erroSubtracao(Calculadora calculadora) {
        boolean erroSubtracao = false;
        if (calculadora.subtracao(3, 2) != 1) {
            erroSubtracao = true;
        }
        if (calculadora.subtracao(2, 2) != 0) {
            erroSubtracao = true;
        }
        if (erroSubtracao) {
            System.out.println("\n\n## Houve um erro na subtração ##");
        }
        return erroSubtracao;
    }

    private static boolean erroMultiplicacao(Calculadora calculadora) {
        boolean erroMultiplicacao = false;
        if (calculadora.multiplicacao(10, 2) != 20) {
            erroMultiplicacao = true; 
        }
        if (calculadora.multiplicacao(2, 4) != 8) {
            erroMultiplicacao = true;
        }
        if (erroMultiplicacao) {
            System.out.println("\n\n## Houve um erro na multiplicação ##");
        }
        return erroMultiplicacao;
    }

    private static boolean erroDivisao(Calculadora calculadora) {
        boolean erroDivisao = false;
        if (calculadora.divisao(10, 2) != 5) {
            erroDivisao = true; 
        }
        if (calculadora.divisao(20, 10) != 2) {
            erroDivisao = true;
        }
        if (erroDivisao) {
            System.out.println("\n\n## Houve um erro na divisão ##");
        }
        return erroDivisao;
    }
}
