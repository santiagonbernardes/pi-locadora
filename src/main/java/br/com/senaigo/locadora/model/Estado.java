package br.com.senaigo.locadora.model;

public enum Estado {
	LOCADO(1, "Locado"),
	LIVRE(2, "Livre"),
	RETIRADO_DA_FROTA(3, "Retirado da Frota");

	private int valor;
        private String descricao;

	Estado(int valor, String descricao) {
		this.valor = valor;
                this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

        public String getDescricao() {
            return descricao;
        }     

	public static Estado valueOf(int valor) {
		Estado estadoEncontrado = null;
		for(Estado estado : Estado.values()) {
			if(estado.valor == valor) {
				estadoEncontrado = estado;
			}
		}
		return estadoEncontrado;
	}

        @Override
        public String toString() {
            return this.descricao;
        }
}
