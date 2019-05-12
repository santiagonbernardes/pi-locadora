package br.com.senaigo.locadora.persistencia;

import java.util.Map;

public enum Operacao {

	INCLUIR(1),
	EXCLUIR(2),
	ALTERAR(3),
	LISTAR(4);

	private int valor;

	private Operacao(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static Operacao valueOf(int valor) {
		Operacao operacaoEncontrada = null;
		for (Operacao operacao : Operacao.values()) {
			if (operacao.valor == valor) {
				operacaoEncontrada = operacao;
			}
		}
		return operacaoEncontrada;
	}
}
