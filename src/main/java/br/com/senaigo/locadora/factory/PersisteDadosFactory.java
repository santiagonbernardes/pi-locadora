package br.com.senaigo.locadora.factory;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.model.*;
import com.sun.org.apache.xpath.internal.operations.Mod;

public enum  PersisteDadosFactory {
	CATEGORIA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Categoria();
		}
	},
	CLIENTE {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Cliente();
		}
	},
	ENDERECO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Endereco();
		}
	},
	FUNCIONARIO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Funcionario();
		}
	},
	MARCA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Marca();
		}
	},
	MODELO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Modelo();
		}
	},
	MOTORISTA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Motorista();
		}
	},
	TELEFONE {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Telefone();
		}
	},
	VEICULO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Veiculo();
		}
	};

	public static PersisteDados obtenhaInstancia(String nomeEntidade) {
		return PersisteDadosFactory.valueOf(nomeEntidade.toUpperCase()).obtenhaInstancia();
	}

	abstract PersisteDados obtenhaInstancia();
}
