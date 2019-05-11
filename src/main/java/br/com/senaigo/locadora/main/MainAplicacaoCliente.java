package br.com.senaigo.locadora.main;


import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.model.Marca;
import br.com.senaigo.locadora.model.Veiculo;
import br.com.senaigo.locadora.view.TelaMarca;
import br.com.senaigo.locadora.view.TelaPrincipal;

import java.io.IOException;

public class MainAplicacaoCliente {
	public static void main(String[] args) throws IOException {

		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);

	}
}
