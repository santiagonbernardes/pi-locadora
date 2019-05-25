package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.utils.ArquivoUtils;

import java.io.*;
import java.util.List;

public class Repositorio {

	private static final String NOME_PASTA_NA_RAIZ_DO_PROJETO = "Persistência";
	private final String caminhoParaArquivo;

	public Repositorio(String nomeEntidade) throws IOException {
		this.caminhoParaArquivo = obtenhaCaminhoParaArquivo(nomeEntidade);
		ArquivoUtils.garantaExistenciaArquivo(this.caminhoParaArquivo);
	}

	private String obtenhaCaminhoParaArquivo(String nomeEntidade) {
		return NOME_PASTA_NA_RAIZ_DO_PROJETO + "/" + nomeEntidade + ".txt";
	}

	public void incluir(String dadosDoObjeto) throws IOException {
		GeradorId geradorId = new GeradorId();
		int id = geradorId.getUltimaIdGerada();
		String dadosDoObjetoComIdGerada = dadosDoObjeto.replaceFirst("^\\d+", String.valueOf(id));
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivo, true);
		BufferedWriter escritorTexto = new BufferedWriter(escritorArquivo);
		String dadosDoObjetoComIdQuebraLinha = dadosDoObjetoComIdGerada + "\n";
		escritorTexto.write(dadosDoObjetoComIdQuebraLinha);
		escritorTexto.close();
		geradorId.finalize();
	}

	public String listar() throws IOException {
		String dadosSemObjetosInternos = leiaTodosOsDadosArmazenadosNoRepositorio();

		while (dadosSemObjetosInternos.contains("#")) {
			List<String> dadosDosObjetosInternos = ExtratorRegex.extraiaObjetosInternos(dadosSemObjetosInternos);
			for(String referenciaObjetoInterno : dadosDosObjetosInternos) {
				String nomeEntidade = ExtratorRegex.extraiaNomeEntidade(referenciaObjetoInterno);
				String id = ExtratorRegex.extraiaIdObjetoInterno(referenciaObjetoInterno);
				Repositorio repositorioAux = new Repositorio(nomeEntidade);
				String dadosCompletosObjetoInterno = repositorioAux.busquePorId(id);
				dadosSemObjetosInternos = dadosSemObjetosInternos.replace(referenciaObjetoInterno, dadosCompletosObjetoInterno);
			}
		}
		return dadosSemObjetosInternos;
	}

	public void alterar(String novosDados) throws IOException {
		String todosOsDadosSalvos = leiaTodosOsDadosArmazenadosNoRepositorio();
		String id = ExtratorRegex.extraiaIdDados(novosDados);
		String dadosAntigos = busquePorId(id);
		String todosOsDadosSalvosComAlteracoes = todosOsDadosSalvos.replace(dadosAntigos, novosDados);
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivo, false);
		BufferedWriter escritoTexto = new BufferedWriter(escritorArquivo);
		escritoTexto.write(todosOsDadosSalvosComAlteracoes);
		escritoTexto.close();
	}

	public void excluir(String dadosExcluir) throws IOException {
		String todosOsDadosSalvos = leiaTodosOsDadosArmazenadosNoRepositorio();
		String todosOsDadosComExclusoes = todosOsDadosSalvos.replace(dadosExcluir + "\n", "");
		FileWriter escritorArquivo = new FileWriter(caminhoParaArquivo, false);
		BufferedWriter escritoTexto = new BufferedWriter(escritorArquivo);
		escritoTexto.write(todosOsDadosComExclusoes);
		escritoTexto.close();
	}

	public String busquePorId(String id) throws IOException {
		String dadosDoRepositorio = leiaTodosOsDadosArmazenadosNoRepositorio();
		return ExtratorRegex.extraiaDadoPorId(dadosDoRepositorio, id);
	}

	private String leiaTodosOsDadosArmazenadosNoRepositorio() throws IOException {
		FileReader fr = new FileReader(caminhoParaArquivo);
		BufferedReader br  = new BufferedReader(fr);
		StringBuilder dados = new StringBuilder();
		String linha = "";

		while((linha = br.readLine()) != null){
			dados.append(linha).append("\n");
		}
		br.close();
		return dados.toString();
	}

}
