package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.utils.Utils;

import java.io.*;
import java.util.List;

public class GeradorId {

	//Atributos
	private final String caminhoArquivoId = "Persistência/Id.txt";
	private int ultimaIdGerada;


	//Construtores
	public GeradorId() throws IOException {
		//Precisa criar o arquivo no diretório e colocar 0 na primeira vez que rodar senão dá exceção
		//TODO Verificar uma forma para que caso o arquivo não exista, seja criado e inicializado com 0
		FileReader leitorArquivo = new FileReader(caminhoArquivoId);
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
		FileWriter escritorArquivo = new FileWriter(caminhoArquivoId, false);
		BufferedWriter escritorTexto = new BufferedWriter(escritorArquivo);

		escritorTexto.write(String.valueOf(ultimaIdGerada));
		escritorTexto.close();

	}
}
