package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.persistencia.Repositorio;
import br.com.senaigo.locadora.utils.Utils;

import java.io.IOException;
import java.util.List;

public class ServerTcpController {

	public String atendaRequisicao(String requisicaoComOperacao) throws Exception {
		int codigoOperacao = ExtratorRegex.extraiaCodigoOperacao(requisicaoComOperacao);
		String requisicaoTratada = ExtratorRegex.removaDadosOperacao(requisicaoComOperacao);
		Operacao operacao = Operacao.valueOf(codigoOperacao);
		String resposta = "";

		if (operacao == null) {
			throw new IllegalArgumentException("Operacao inválida.");
		}

		switch (operacao) {
			case INCLUIR:
				resposta = incluir(requisicaoTratada);
				break;
			case ALTERAR:
				resposta = alterar(requisicaoTratada);
				break;
			case EXCLUIR:
				resposta = excluir(requisicaoTratada);
				break;
			case LISTAR:
				resposta = listar(requisicaoComOperacao);
				break;
		}

		return resposta;
	}

	private String incluir(String requisicao) throws IOException {
		String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(requisicao);
		String requisicaoTratada = ExtratorRegex.removaNomeEntidade(requisicao);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		repositorio.incluir(requisicao);
		return nomeEntidade + " incluído com sucesso.";

	}

	private String listar(String requisicao) throws IOException {
		StringBuilder listaEmTexto = new StringBuilder();
		String nomeEntidade = parametros.get(1);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		return repositorio.listar();
	}

	private String alterar(String requisicao) throws IOException {
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

	private String excluir(String requisicao) throws IOException {
		String nomeEntidade = requisicao.get(1);
		String campoExcluir = requisicao.get(2);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		String dadosAtuais = repositorio.listar();
		String dadosNovos = dadosAtuais.replaceFirst(campoExcluir + "\n", "");
		repositorio.alterar(dadosNovos);
		return "Dados Alterados com sucesso!";
	}
}
