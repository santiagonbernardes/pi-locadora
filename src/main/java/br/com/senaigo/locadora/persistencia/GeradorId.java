package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.utils.ArquivoUtils;
import java.io.*;

public class GeradorId {

	//Atributos
	private final String caminhoArquivoId = "Persistência/Id.txt";
	private int ultimaIdGerada;


	//Construtores
	public GeradorId() throws IOException {
		ArquivoUtils.garantaExistenciaArquivo(caminhoArquivoId);
		FileReader leitorArquivo = new FileReader(caminhoArquivoId);
		BufferedReader leitorTexto = new BufferedReader(leitorArquivo);
		String linha = leitorTexto.readLine();
		this.ultimaIdGerada = linha == null ? 0 : Integer.valueOf(linha);
		leitorTexto.close();
	}

	//Getters e Setters
	public int getUltimaIdGerada() {
		return ++ultimaIdGerada;
	}

	public void finalize() throws IOException {
		FileWriter escritorArquivo = new FileWriter(caminhoArquivoId, false);
		BufferedWriter escritorTexto = new BufferedWriter(escritorArquivo);

		escritorTexto.write(String.valueOf(ultimaIdGerada));
		escritorTexto.close();
	}
}
