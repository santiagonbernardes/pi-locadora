package br.com.senaigo.locadora.model;

public enum Estado {
	LOCADO(1),
	LIVRE(2),
	RETIRADO_DA_FROTA(3);

	private int valor;

	Estado(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
