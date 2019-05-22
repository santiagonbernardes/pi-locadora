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
				resposta = listar(requisicaoTratada);
				break;
		}

		return resposta;
	}

	private String incluir(String requisicao) throws IOException {
		String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(requisicao);
		String requisicaoTratada = ExtratorRegex.removaNomeEntidade(requisicao);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		repositorio.incluir(requisicaoTratada);
		return nomeEntidade + " incluído com sucesso.";
	}

	private String listar(String requisicao) throws IOException {
		Repositorio repositorio = new Repositorio(requisicao);
		return repositorio.listar();
	}

	private String alterar(String requisicao) throws IOException {
		String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(requisicao);
		String campoAlterado = ExtratorRegex.removaNomeEntidade(requisicao);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		String dadosAtuais = repositorio.listar();
		return "Dados Alterados com sucesso!";
	}

	private String excluir(String requisicao) throws IOException {
		String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(requisicao);
		String campoExcluir = ExtratorRegex.removaNomeEntidade(requisicao);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		String dadosAtuais = repositorio.listar();
		String dadosNovos = dadosAtuais.replaceFirst(campoExcluir + "\n", "");
		repositorio.alterar(dadosNovos);
		return "Dados Alterados com sucesso!";
	}
}
