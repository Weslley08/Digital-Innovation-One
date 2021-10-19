package com.teste_junit;

public class CalculadoraNova {

	public int somar(int... valores) {
		int soma = 0;
		for (int valor : valores) {
			soma += valor;
		}
		return soma;
	}
}
