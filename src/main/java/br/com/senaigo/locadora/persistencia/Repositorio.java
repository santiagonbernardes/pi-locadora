package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.interfaces.PersisteDados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Repositorio {

	private final String caminhoParaArquivoEntidade;
	private final String nomeEntidade;
	private final GeradorId geradorId;

	public Repositorio(String nomeEntidade) throws IOException {
		this.caminhoParaArquivoEntidade = obtenhaCaminhoParaArquivo(nomeEntidade);
		this.nomeEntidade = nomeEntidade;
		this.geradorId = new GeradorId();
	}

	private String obtenhaCaminhoParaArquivo(String nomeEntidade) {
		return "Persistência/" + nomeEntidade + ".txt";
	}

	public void incluir(PersisteDados objeto) throws IOException {
		int id = geradorId.getUltimaIdGerada();
		objeto.setId(id);
		geradorId.finalize();
		String dadosParaIncluir = objeto.desmonteObjeto(false) + "\n";
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivoEntidade, true);
		BufferedWriter escritoTexto = new BufferedWriter(escritorArquivo);
		escritoTexto.write(dadosParaIncluir);
		escritoTexto.close();
	}

}
