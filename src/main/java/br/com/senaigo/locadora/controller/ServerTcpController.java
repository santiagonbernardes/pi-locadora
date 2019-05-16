package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.model.PersisteDadosFactory;
import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.persistencia.Repositorio;
import br.com.senaigo.locadora.utils.Utils;

import java.io.IOException;
import java.util.List;

public class ServerTcpController {

	public String atendaRequisicao(String requisicao) throws Exception {
		List<String> parametros = Utils.obtenhaParametros(requisicao);
		int codigoOperacao = Utils.convertaParaInt(parametros.get(0));
		Operacao operacao = Operacao.valueOf(codigoOperacao);
		String resposta = "";

		if (parametros == null) {
			throw new IllegalArgumentException("Parametros invalidos.");
		}

		if (operacao == null) {
			throw new IllegalArgumentException("Operacao inválida.");
		}


		switch (operacao) {
			case INCLUIR:
				resposta = incluir(parametros);
				break;
			case ALTERAR:
				resposta = alterar(parametros);
				break;
			case EXCLUIR:
				resposta = excluir(parametros);
				break;
			case LISTAR:
				resposta = listar(parametros);
				break;
		}

		return resposta;
	}

	private String incluir(List<String> parametros) throws IOException {
		String nomeEntidade = parametros.get(1);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		PersisteDados objeto = PersisteDadosFactory.obtenhaInstancia(nomeEntidade);
		objeto.monteObjeto(parametros.get(2));
		repositorio.incluir(objeto);
		return nomeEntidade + " incluído com sucesso.";

	}

	private String listar(List<String> parametros) throws IOException {
		StringBuilder listaEmTexto = new StringBuilder();
		String nomeEntidade = parametros.get(1);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		return repositorio.listar();
	}

	private String alterar(List<String> parametros) throws IOException {
		String nomeEntidade = parametros.get(1);
		String campoAlterado = parametros.get(2);
		String id = Utils.obtenhaCampos(campoAlterado).get(0);
		String regex = "(?<!.)" + id + ";.*";
		Repositorio repositorio = new Repositorio(nomeEntidade);
		String dadosAtuais = repositorio.listar();
		String dadosNovos = dadosAtuais.replaceFirst(regex, campoAlterado);
		repositorio.alterar(dadosNovos);
		return "Dados Alterados com sucesso!";
	}

	private String excluir(List<String> parametros) throws IOException {
		String nomeEntidade = parametros.get(1);
		String campoExcluir = parametros.get(2);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		String dadosAtuais = repositorio.listar();
		String dadosNovos = dadosAtuais.replaceFirst(campoExcluir + "\n", "");
		repositorio.alterar(dadosNovos);
		return "Dados Alterados com sucesso!";
	}
}
