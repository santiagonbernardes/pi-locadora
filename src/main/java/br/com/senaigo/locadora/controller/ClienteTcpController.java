package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.comunicacao.ClienteTcp;
import br.com.senaigo.locadora.model.PersisteDadosFactory;
import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.persistencia.Operacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteTcpController {

	private ClienteTcp conexaoComCliente;

	public ClienteTcpController() throws IOException {
		conexaoComCliente = ClienteTcp.obtenhaInstancia();
	}

	public String execute(Object objeto, Operacao operacao) throws IOException {
		try {
			PersisteDados dados = (PersisteDados) objeto;
			String mensagem = operacao.getValor() + "#" + dados.desmonteObjeto();
			System.out.println("Enviando requisição: " + mensagem);
			conexaoComCliente.enviarMensagem(mensagem);
			String resposta = conexaoComCliente.receberMensagem();
			return resposta;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public String execute(String nomeEntidade, Operacao operacao) throws IOException {
		//TODO buscar solução melhor que passar String
		try {
			String mensagem = operacao.getValor() + "#" + nomeEntidade;
			System.out.println("Enviando requisição: " + mensagem);
			conexaoComCliente.enviarMensagem(mensagem);
			String resposta = conexaoComCliente.receberMensagem();
			return resposta;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public <T extends PersisteDados> List<T> liste(String nomeEntidade) throws IOException {
		List<T> listaDeObjetos = new ArrayList<>();
		String dados = execute(nomeEntidade, Operacao.LISTAR);
		if(!dados.equals("")) {
			List<String> dadosObjetos = Arrays.asList(dados.split("\n"));
			T objeto;
			for (String dadosDeUmObjeto : dadosObjetos) {
				objeto = (T) PersisteDadosFactory.obtenhaInstancia(nomeEntidade);
				objeto.monteObjeto(dadosDeUmObjeto);
				listaDeObjetos.add(objeto);
			}
		}

		return listaDeObjetos;

	}
}
