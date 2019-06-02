package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.persistencia.Repositorio;

import java.io.IOException;

public class ServerTcpController {

	private Operacao operacao;
	private String nomeEntidade;
	private Repositorio repositorio;
	private String dados;
	private String imagem;

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

	private String incluir() throws Exception {
		String resposta = "";
		try {
			repositorio.incluir(dados);
			resposta = this.nomeEntidade + " incluído com sucesso.";
		} catch (Exception erro) {
			resposta = obtenhaRespostaComErro(erro);
		}
		return resposta;
	}

	private String listar() throws Exception {
		String resposta = "";
		try {
			resposta = repositorio.listar();
		} catch (Exception erro) {
			resposta = obtenhaRespostaComErro(erro);
		}
		return resposta;
	}

	private String alterar() throws Exception {
		String resposta = "";
		try {
			repositorio.alterar(dados);
			resposta = this.nomeEntidade + " alterado com sucesso.";
		} catch (Exception erro) {
			resposta = obtenhaRespostaComErro(erro);
		}
		return resposta;
	}

	private String excluir() throws Exception {
		String resposta = "";
		try {
			repositorio.excluir(dados);
			resposta = this.nomeEntidade + "excluído com sucesso.";
		} catch (Exception erro) {
			resposta = obtenhaRespostaComErro(erro);
		}
		return resposta;
	}

	private String obtenhaRespostaComErro(Exception erro) {
		return "!Não foi possível " + this.operacao.getDescricao() + this.nomeEntidade + ": " + erro.getMessage();
	}
}
