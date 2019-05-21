package br.com.senaigo.locadora.main;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.model.Marca;
import br.com.senaigo.locadora.persistencia.Operacao;

import java.io.IOException;

public class MainTestes {

	public static void main(String[] args) {

		try {
			Marca marca = new Marca();
			marca.setNome("Ford");
			ClienteTcpController controller = new ClienteTcpController();
			controller.execute(marca, Operacao.INCLUIR);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
}
