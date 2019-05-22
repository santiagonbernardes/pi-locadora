package br.com.senaigo.locadora.main;

import br.com.senaigo.locadora.comunicacao.ServidorTcp;
import br.com.senaigo.locadora.controller.ServerTcpController;
import br.com.senaigo.locadora.view.TelaSelecaoAplicacao;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
            
            TelaSelecaoAplicacao tela = new TelaSelecaoAplicacao();
            tela.setVisible(true);

	}
}
