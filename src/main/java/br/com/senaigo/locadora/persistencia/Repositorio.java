package br.com.senaigo.locadora.persistencia;

import br.com.senaigo.locadora.model.ExtratorRegex;
import br.com.senaigo.locadora.utils.ArquivoUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.List;

public class Repositorio {

	private static final String NOME_PASTA_NA_RAIZ_DO_PROJETO = "Persistência";
	private final String diretorio;
	private final String caminhoParaArquivoComDados;
	private final String caminhoPadraoParaImagem;
	private final boolean armazenaImagem;

	public Repositorio(String nomeEntidade) throws IOException {
		this.diretorio = obtenhaDiretorio(nomeEntidade);
		ArquivoUtils.garantaExistenciaArquivo(this.diretorio, true);
		this.caminhoParaArquivoComDados = obtenhaCaminhoParaArquivoComDados(nomeEntidade);
		ArquivoUtils.garantaExistenciaArquivo(this.caminhoParaArquivoComDados, false);
		this.caminhoPadraoParaImagem = obtenhaCaminhoPadraoParaImagem(nomeEntidade);
		this.armazenaImagem = ArquivoUtils.obtenhaQtdArquivosNoDiretorio(this.diretorio) != 1;
	}

	private String obtenhaDiretorio(String nomeEntidade) {
		return NOME_PASTA_NA_RAIZ_DO_PROJETO + "/" + nomeEntidade + "/";
	}

	private String obtenhaCaminhoParaArquivoComDados(String nomeEntidade) {
		return diretorio + nomeEntidade + ".txt";
	}

	private String obtenhaCaminhoPadraoParaImagem(String nomeEntidade) {
		return diretorio + nomeEntidade;
	}

	public void incluir(String dadosDoObjeto) throws Exception {
		GeradorId geradorId = new GeradorId();
		int id = geradorId.getUltimaIdGerada();
		String dadosImagem = ExtratorRegex.extraiaImagem(dadosDoObjeto);
		String dadosObjetoSemImagem = ExtratorRegex.removaImagem(dadosDoObjeto);
		String dadosDoObjetoComIdGerada = dadosObjetoSemImagem.replaceFirst("^\\d+", String.valueOf(id));
		String dadosDoObjetoComIdQuebraLinha = dadosDoObjetoComIdGerada + "\n";
		escrevaDadosNoRepositorio(dadosDoObjetoComIdQuebraLinha, true);
		if (!dadosImagem.isEmpty()) {
			escrevaImagemNoRepositorio(dadosImagem, id);
		}
		geradorId.finalize();
	}

	public String listar() throws Exception {
		String dadosDoRepositorio = leiaTodosOsDadosArmazenadosNoRepositorio();

		while (dadosDoRepositorio.contains("#")) {
			List<String> referenciasObjetosInterno = ExtratorRegex.extraiaObjetosInternos(dadosDoRepositorio);
			for (String referenciaObjetoInterno : referenciasObjetosInterno) {
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
		try (BufferedWriter escritorTexto = new BufferedWriter(new FileWriter(caminhoParaArquivoComDados, manterDadosAntigos))) {
			escritorTexto.write(dados);
		} catch (Exception erro) {
			throw new Exception("Não foi possível escrever os dados no repositório: " + erro.getMessage());
		}
	}

	private void escrevaImagemNoRepositorio(String dadosDaImagem, int id) throws IOException {
		String caminhoParaImagem = this.caminhoPadraoParaImagem + id + ".png";
		ArquivoUtils.garantaExistenciaArquivo(caminhoParaImagem, false);
		byte[] imagemEmBytes = Base64.getDecoder().decode(dadosDaImagem);
		try (OutputStream stream = new FileOutputStream(caminhoParaImagem)) {
			stream.write(imagemEmBytes);
		}
	}

	public String busquePorId(String id, String dadosDoRepositorio) {
		return ExtratorRegex.extraiaDadoPorId(dadosDoRepositorio, id);
	}

	private String leiaTodosOsDadosArmazenadosNoRepositorio() throws Exception {
		try (BufferedReader leitorDados = new BufferedReader(new FileReader(caminhoParaArquivoComDados))) {
			StringBuilder dados = new StringBuilder();
			String linha = leitorDados.readLine();

			while (linha != null) {
				if (armazenaImagem) {
					String id = ExtratorRegex.extraiaIdDados(linha);
					String imagem = obtenhaImagemBase64(id);
					linha = linha + ";" + imagem;
				}

				dados.append(linha).append("\n");
				linha = leitorDados.readLine();
			}

			return dados.toString();
		} catch (Exception erro) {
			throw new Exception("Não foi possível ler os dados armazenados no repositório. " + erro.getMessage());
		}
	}

	private String obtenhaImagemBase64(String id) throws IOException {
		File file = new File(this.caminhoPadraoParaImagem + id + ".png");
		BufferedImage imagem = ImageIO.read(file);
		ByteArrayOutputStream bytesImagem = new ByteArrayOutputStream();
		ImageIO.write(imagem, "png", bytesImagem);
		return Base64.getEncoder().encodeToString(bytesImagem.toByteArray());
	}
}
