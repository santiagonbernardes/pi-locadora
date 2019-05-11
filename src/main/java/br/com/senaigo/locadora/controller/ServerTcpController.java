package br.com.senaigo.locadora.controller;

import br.com.senaigo.locadora.factory.PersisteDadosFactory;
import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.persistencia.Repositorio;
import br.com.senaigo.locadora.utils.Utils;

import java.io.IOException;
import java.util.List;

public class ServerTcpController {

	public void atendaRequisicao(String requisicao) throws IOException {
		List<String> parametros = Utils.obtenhaParametros(requisicao);
		int operacao = Utils.convertaParaInt(parametros.get(0));
		String nomeEntidade = parametros.get(1);
		Repositorio repositorio = new Repositorio(nomeEntidade);
		PersisteDados objeto = PersisteDadosFactory.obtenhaInstancia(nomeEntidade);
		objeto.monteObjeto(parametros.get(2));
		repositorio.incluir(objeto);
	}
}
