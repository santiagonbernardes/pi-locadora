package br.com.senaigo.locadora.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

	public static int convertaParaInt(String valor) {
		return Integer.parseInt(valor);
	}

	public static long convertaParaLong(String valor) {
		return Long.parseLong(valor);
	}

	public static float convertaParaFloat(String valor) {
		return Float.parseFloat(valor);
	}

	public static List<String> obtenhaCampos(String dadosDoObjeto) {
		List<String> campos;
		campos = Arrays.asList(dadosDoObjeto.split(";"));
		return campos;
	}

	public static List<String> obtenhaParametros(String dadosDoObjeto) {
		List<String> campos;
		campos = Arrays.asList(dadosDoObjeto.split("\\|"));
		return campos;
	}
}
