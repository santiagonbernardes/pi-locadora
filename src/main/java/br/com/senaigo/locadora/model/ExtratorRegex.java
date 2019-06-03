package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtratorRegex {

	private static final String REGEX_EXTRAIR_OPERACAO_E_ID_DADOS = "^\\d+";
	private static final String REGEX_REMOVER_OPERACAO = "^\\d+#";
	private static final String REGEX_EXTRAIR_ENTIDADE = "^\\w+";
	private static final String REGEX_REMOVER_ENTIDADE = "^\\w+;";
	private static final String REGEX_EXTRAIR_OBJETOS_INTERNOS = "\\w+#\\d+";
	private static final String REGEX_EXTRAIR_ID_OBJETO_INTERNO = "\\d+$";


	public static int extraiaCodigoOperacao(String requisicaoComOperacao) {
		String idEncontrada = extraiaUmResultado(REGEX_EXTRAIR_OPERACAO_E_ID_DADOS, requisicaoComOperacao);
		return Utils.convertaParaInt(idEncontrada);
	}

	public static String extraiaIdDados(String dados) {
		return extraiaUmResultado(REGEX_EXTRAIR_OPERACAO_E_ID_DADOS, dados);
	}

	public static String extraiaIdObjetoInterno(String dadosObjetoInterno) {
		return extraiaUmResultado(REGEX_EXTRAIR_ID_OBJETO_INTERNO, dadosObjetoInterno);
	}

	public static String extraiaDadoPorId(String dados, String id) {
		String regex = monteRegexId(id);
		return extraiaUmResultado(regex, dados);
	}

	public static String extraiaNomeEntidade(String requisicaoComNomeEntidade) {
		return extraiaUmResultado(REGEX_EXTRAIR_ENTIDADE, requisicaoComNomeEntidade);
	}


	public static String removaDadosOperacao(String requisicaoComOperacao) {
		return remova(REGEX_REMOVER_OPERACAO, requisicaoComOperacao);
	}

	public static String removaNomeEntidade(String requisicaoComNomeEntidade) {
		return remova(REGEX_REMOVER_ENTIDADE, requisicaoComNomeEntidade);
	}

	public static List<String> extraiaObjetosInternos(String dados) {
		List<String> objetosInternos = new ArrayList<>();
		Matcher match = obtenhaMatcher(REGEX_EXTRAIR_OBJETOS_INTERNOS, dados);

		while (match.find()) {
			objetosInternos.add(match.group());
		}
		return objetosInternos;
	}

	private static String monteRegexId(String id) {
		return "^" + id + ".+?$";
	}

	private static String remova(String regex, String requisicao) {
		return requisicao.replaceFirst(regex, "");
	}

	private static String extraiaUmResultado(String regex, String requisicao) {
		Matcher match = obtenhaMatcher(regex, requisicao);

		boolean encontrouResultado = match.find();

		if (!encontrouResultado) {
			throw new RuntimeException("Requisição fora do padrão.");
		}

		return match.group();
	}

	private static Matcher obtenhaMatcher(String regex, String requisicao) {
		Pattern padrao = Pattern.compile(regex, Pattern.MULTILINE);
		return padrao.matcher(requisicao);
	}
}
