package br.com.senaigo.locadora.persistencia;

import java.util.Map;

public enum Operacao {

	INCLUIR(1, "Incluir"),
	EXCLUIR(2, "Excluir"),
	ALTERAR(3, "Alterar"),
	LISTAR(4, "Listar");

	private int valor;
	private String descricao;

	private Operacao(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
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
