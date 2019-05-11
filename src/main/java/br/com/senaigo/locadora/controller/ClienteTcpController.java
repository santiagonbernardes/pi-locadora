package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.comunicacao.ClienteTcp;
import br.com.senaigo.locadora.interfaces.PersisteDados;

import java.io.IOException;

public class ClienteTcpController {

	private ClienteTcp conexaoComCliente;

	public ClienteTcpController() throws IOException {
		conexaoComCliente = new ClienteTcp("127.0.0.1", 7777);
	}

	public void incluir(Object objeto, int operacao) throws IOException {
		try {
			PersisteDados dados = (PersisteDados) objeto;
			String mensagem = operacao + "|" + dados.desmonteObjeto(true);
			System.out.println("Enviando requisição: " + mensagem);
			conexaoComCliente.enviarMensagem(mensagem);
			String resposta = conexaoComCliente.receberMensagem();
			System.out.println(resposta);
		} catch (Exception erro) {
			throw erro;
		}
	}
}
