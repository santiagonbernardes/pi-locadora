package br.com.senaigo.locadora.main;

import br.com.senaigo.locadora.comunicacao.ServidorTcp;
import br.com.senaigo.locadora.controller.ServerTcpController;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			ServidorTcp servidor = new ServidorTcp(7777);
			System.out.println("Servidor online.");
			servidor.aguardeConexaoComCliente();
			while (true) {
				String requisicao = servidor.receberMensagem();
				ServerTcpController controller = new ServerTcpController(requisicao);
				String resposta = controller.atendaRequisicao();
				servidor.enviarMensagem(resposta);
			}
		} catch (Exception e) {
			System.out.println("Erro no servidor: " + e.getMessage());
		}
	}
}
