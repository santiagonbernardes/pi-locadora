package br.com.senaigo.locadora.main;

import br.com.senaigo.locadora.comunicacao.ServidorTcp;
import br.com.senaigo.locadora.controller.ServerTcpController;

import java.io.IOException;

public class MainAplicacaoServidor {

	public static void main(String[] args) throws IOException {

		ServidorTcp servidor = new ServidorTcp(7777);

		while (true) {
			try {
				String requisicao = servidor.receberMensagem();
				System.out.println("Solicitação do cliente:" + requisicao);
				ServerTcpController controller = new ServerTcpController();
				String resposta = controller.atendaRequisicao(requisicao);
				servidor.enviarMensagem(resposta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
