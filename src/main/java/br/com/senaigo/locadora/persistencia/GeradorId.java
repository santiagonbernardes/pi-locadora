package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.utils.ArquivoUtils;
import br.com.senaigo.locadora.utils.Utils;

import java.io.*;

public class GeradorId {

	//Atributos
	private static final String DIRETORIO = "Persistência/Id/";
	private static final String CAMINHO_ARQUIVO_ID = DIRETORIO + "Id.txt";
	private int ultimaIdGerada;


	//Construtores
	public GeradorId() throws IOException {
		ArquivoUtils.garantaExistenciaArquivo(DIRETORIO, true);
		ArquivoUtils.garantaExistenciaArquivo(CAMINHO_ARQUIVO_ID, false);
		FileReader leitorArquivo = new FileReader(CAMINHO_ARQUIVO_ID);
		BufferedReader leitorTexto = new BufferedReader(leitorArquivo);
		String linha = leitorTexto.readLine();
		this.ultimaIdGerada = linha == null ? 0 : Utils.convertaParaInt(linha);
		leitorTexto.close();
	}

	//Getters e Setters
	public int getUltimaIdGerada() {
		return ++ultimaIdGerada;
	}

	public void finalize() throws IOException {
		FileWriter escritorArquivo = new FileWriter(CAMINHO_ARQUIVO_ID, false);
		BufferedWriter escritorTexto = new BufferedWriter(escritorArquivo);

		escritorTexto.write(String.valueOf(ultimaIdGerada));
		escritorTexto.close();
	}
}
