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

	public void incluir(String dadosDoObjeto) throws Exception {
		GeradorId geradorId = new GeradorId();
		int id = geradorId.getUltimaIdGerada();
		String dadosDoObjetoComIdGerada = dadosDoObjeto.replaceFirst("^\\d+", String.valueOf(id));
		String dadosDoObjetoComIdQuebraLinha = dadosDoObjetoComIdGerada + "\n";
		escrevaDadosNoRepositorio(dadosDoObjetoComIdQuebraLinha, true);
		geradorId.finalize();
	}

	public String listar() throws Exception {
		String dadosDoRepositorio = leiaTodosOsDadosArmazenadosNoRepositorio();

		while (dadosDoRepositorio.contains("#")) {
			List<String> referenciasObjetosInterno = ExtratorRegex.extraiaObjetosInternos(dadosDoRepositorio);
			for(String referenciaObjetoInterno : referenciasObjetosInterno) {
				String nomeEntidadeObjetoInterno = ExtratorRegex.extraiaNomeEntidade(referenciaObjetoInterno);
				String idObjetoInterno = ExtratorRegex.extraiaIdObjetoInterno(referenciaObjetoInterno);
				Repositorio repositorioObjetoInterno = new Repositorio(nomeEntidadeObjetoInterno);
				String todosOsDadosDoRepositorioObjetoInterno = repositorioObjetoInterno.listar();
				String dadosCompletosObjetoInterno = repositorioObjetoInterno.busquePorId(idObjetoInterno, todosOsDadosDoRepositorioObjetoInterno);
				dadosDoRepositorio = dadosDoRepositorio.replace(referenciaObjetoInterno, dadosCompletosObjetoInterno);
			}
		}
		return dadosDoRepositorio;
	}

	public void alterar(String novosDados) throws Exception {
		String todosOsDadosSalvos = leiaTodosOsDadosArmazenadosNoRepositorio();
		String id = ExtratorRegex.extraiaIdDados(novosDados);
		String dadosAntigos = busquePorId(id, todosOsDadosSalvos);
		String todosOsDadosSalvosComAlteracoes = todosOsDadosSalvos.replace(dadosAntigos, novosDados);
		escrevaDadosNoRepositorio(todosOsDadosSalvosComAlteracoes, false);
	}

	public void excluir(String dadosExcluir) throws Exception {
		String todosOsDadosSalvos = leiaTodosOsDadosArmazenadosNoRepositorio();
		String todosOsDadosComExclusoes = todosOsDadosSalvos.replace(dadosExcluir + "\n", "");
		escrevaDadosNoRepositorio(todosOsDadosComExclusoes, false);
	}

	private void escrevaDadosNoRepositorio(String dados, boolean manterDadosAntigos) throws Exception {
		try (BufferedWriter escritorTexto = new BufferedWriter(new FileWriter(caminhoParaArquivo, manterDadosAntigos))) {
			escritorTexto.write(dados);
		} catch (Exception erro) {
			throw new Exception("Não foi possível escrever os dados no repositório: " + erro.getMessage());
		}
	}

	public String busquePorId(String id, String dadosDoRepositorio) {
		return ExtratorRegex.extraiaDadoPorId(dadosDoRepositorio, id);
	}

	private String leiaTodosOsDadosArmazenadosNoRepositorio() throws Exception {
		try(BufferedReader leitorDados = new BufferedReader(new FileReader(caminhoParaArquivo))) {
			StringBuilder dados = new StringBuilder();
			String linha = leitorDados.readLine();

			while(linha != null) {
				dados.append(linha).append("\n");
				linha = leitorDados.readLine();
			}

			return dados.toString();
		} catch (Exception erro) {
			throw new Exception("Não foi possível ler os dados armazenados no repositório. " + erro.getMessage());
		}
	}
}
