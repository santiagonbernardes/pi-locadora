package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.utils.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtratorRegex {

	private static final String REGEX_EXTRAIR_OPERACAO = "^\\d+";
	private static final String REGEX_REMOVER_OPERACAO = "^\\d+#";


	public static int extraiaCodigoOperacao(String requisicaoComOperacao) {
		String idEncontrada = extraiaUmResultado(REGEX_EXTRAIR_OPERACAO, requisicaoComOperacao);
		return Utils.convertaParaInt(idEncontrada);
	}


	public static String removaDadosOperacao(String requisicaoComOperacao) {
		return requisicaoComOperacao.replaceFirst(REGEX_REMOVER_OPERACAO, "");
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
		Pattern padrao = Pattern.compile(regex);
		return padrao.matcher(requisicao);
	}


}
