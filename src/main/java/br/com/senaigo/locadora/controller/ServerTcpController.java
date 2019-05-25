package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.persistencia.Repositorio;
import br.com.senaigo.locadora.utils.Utils;

import java.io.IOException;
import java.util.List;

public class ServerTcpController {

	private Operacao operacao;
	private String nomeEntidade;
	private Repositorio repositorio;
	private String dados;

	public ServerTcpController(String requisicao) throws IOException {
		int codigoOperacao = ExtratorRegex.extraiaCodigoOperacao(requisicao);
		String requisicaoSemOperacao = ExtratorRegex.removaDadosOperacao(requisicao);
		this.operacao = Operacao.valueOf(codigoOperacao);
		if (this.operacao == null) {
			throw new IllegalArgumentException("Operacao inválida.");
		}
		String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(requisicaoSemOperacao);
		this.nomeEntidade = nomeEntidade;
		repositorio = new Repositorio(this.nomeEntidade);
		String dados = ExtratorRegex.removaNomeEntidade(requisicaoSemOperacao);
		this.dados = this.operacao == Operacao.LISTAR ? null : dados;
	}

	public String atendaRequisicao() throws Exception {
		String resposta = "";

		switch (this.operacao) {
			case INCLUIR:
				resposta = incluir();
				break;
			case ALTERAR:
				resposta = alterar();
				break;
			case EXCLUIR:
				resposta = excluir();
				break;
			case LISTAR:
				resposta = listar();
				break;
		}

		return resposta;
	}

	private String incluir() throws IOException {
		repositorio.incluir(dados);
		return this.nomeEntidade + " incluído com sucesso.";
	}

	private String listar() throws IOException {
		return repositorio.listar();
	}

	private String alterar() throws IOException {
		repositorio.alterar(dados);
 		return this.nomeEntidade + " alterado com sucesso.";
	}

	private String excluir() throws IOException {
		repositorio.excluir(dados);
		return this.nomeEntidade + "excluído com sucesso.";
	}
}
