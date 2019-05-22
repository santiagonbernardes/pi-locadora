package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.utils.ArquivoUtils;

import java.io.*;
import java.util.List;

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

	public void incluir(String dadosDoObjeto) throws IOException {
		ArquivoUtils.garantaExistenciaArquivo(caminhoParaArquivoEntidade);
		//int id = geradorId.getUltimaIdGerada();
		//String dadosDoObjetoComIdGerada = dadosDoObjeto.replaceFirst("^\\d+", String.valueOf(id));
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivoEntidade, true);
		BufferedWriter escritorTexto = new BufferedWriter(escritorArquivo);
		String dadosDoObjetoComIdQuebraLinha = dadosDoObjeto + "\n";
		escritorTexto.write(dadosDoObjetoComIdQuebraLinha);
		escritorTexto.close();
		geradorId.finalize();
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

		String dadosSemObjetosInternos = dados.toString();

		while (dadosSemObjetosInternos.contains("#")) {
			List<String> dadosDosObjetosInternos = ExtratorRegex.extraiaObjetosInternos(dadosSemObjetosInternos);
			for(String referenciaObjetoInterno : dadosDosObjetosInternos) {
				String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(referenciaObjetoInterno);
				String id = ExtratorRegex.extraiaIdObjetoInterno(referenciaObjetoInterno);
				String dadosCompletosObjetoInterno = busquePorId(nomeEntidade, id);
				dadosSemObjetosInternos = dadosSemObjetosInternos.replace(referenciaObjetoInterno, dadosCompletosObjetoInterno);
			}
		}
		return dadosSemObjetosInternos;
	}

	public void alterar(String novosDados) throws IOException {
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivoEntidade, false);
		BufferedWriter escritoTexto = new BufferedWriter(escritorArquivo);
		escritoTexto.write(novosDados);
		escritoTexto.close();
	}

	public String busquePorId(String nomeEntidade, String id) throws IOException {
		String caminhoArquivo = obtenhaCaminhoParaArquivo(nomeEntidade);
		FileReader fr = new FileReader(caminhoArquivo);
		BufferedReader br  = new BufferedReader(fr);
		StringBuilder dados = new StringBuilder();
		String linha = "";

		while((linha = br.readLine()) != null){
			dados.append(linha).append("\n");
		}
		br.close();

		return ExtratorRegex.extraiaDadoPorId(dados.toString(), id);
	}

}
