package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.interfaces.PersisteDados;

import java.io.*;

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

	public String listar() throws IOException {
		FileReader fr = new FileReader(caminhoParaArquivoEntidade);
		BufferedReader br  = new BufferedReader(fr);
		StringBuilder dados = new StringBuilder();
		String linha = "";

		while((linha = br.readLine()) != null){
			dados.append(linha).append("\n");
		}

		br.close();

		return dados.toString();
	}

	public void alterar(String novosDados) throws IOException {
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivoEntidade, false);
		BufferedWriter escritoTexto = new BufferedWriter(escritorArquivo);
		escritoTexto.write(novosDados);
		escritoTexto.close();
	}

}
