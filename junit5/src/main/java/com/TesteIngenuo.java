package com;

/**
 * Teste ingenuo com falhas de padronização
 */

public class TesteIngenuo {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        if (erroSoma(calculadora)) {
            System.exit(1);
        }

        if (subtracaoOk(calculadora) == false) {
            System.out.println("\n\n## Houve erro na validação da soma ##\n\n");
            System.exit(0);
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

    private static boolean subtracaoOk(Calculadora calculadora) {
        if (calculadora.subtracao(3, 2) != 1) {
            return false;
        }
        if (calculadora.subtracao(2, 2) != 0) {
            return false;
        }
        return true;
    }

}
