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

	public String execute(Object objeto, Operacao operacao) throws Exception {
		try {
			PersisteDados dados = (PersisteDados) objeto;
			String requisicao = operacao.getValor() + "#" + dados.desmonteObjeto();
			String resposta = comuniqueComServidor(requisicao);
			return resposta;
		} catch (Exception erro) {
			throw new Exception("Não foi possível " + operacao.getDescricao() + objeto.getClass().getSimpleName() + ": " + erro.getMessage());
		}
	}

	public <T extends PersisteDados> List<T> liste(String nomeEntidade) throws Exception {
		try {
			List<T> listaDeObjetos = new ArrayList<>();
			String dados = execute(nomeEntidade, Operacao.LISTAR);
			if (!dados.equals("")) {
				List<String> dadosObjetos = Arrays.asList(dados.split("\n"));
				T objeto;
				for (String dadosDeUmObjeto : dadosObjetos) {
					objeto = (T) PersisteDadosFactory.obtenhaInstancia(nomeEntidade);
					objeto.monteObjeto(dadosDeUmObjeto);
					listaDeObjetos.add(objeto);
				}
			}
			return listaDeObjetos;
		} catch (Exception erro) {
			throw new Exception("Não foi possível listar " + nomeEntidade + ": " + erro.getMessage());
		}
	}

	private String execute(String nomeEntidade, Operacao operacao) throws Exception {
		String requisicao = operacao.getValor() + "#" + nomeEntidade;
		String resposta = comuniqueComServidor(requisicao);
		return resposta;
	}

	private String comuniqueComServidor(String mensagem) throws Exception {
		try {
			System.out.println("Enviando requisição: " + mensagem);
			conexaoComCliente.enviarMensagem(mensagem);
			String resposta = conexaoComCliente.receberMensagem();

			if(resposta.startsWith("!")) {
				String respostaSemExclamacao = resposta.replaceFirst("!", "");
				throw new Exception(respostaSemExclamacao);
			}

			return resposta;
		} catch (IOException erro) {
			throw new IOException("Houve um erro na comunicação com o servidor causada por " + erro.getMessage());
		}

	}
}
