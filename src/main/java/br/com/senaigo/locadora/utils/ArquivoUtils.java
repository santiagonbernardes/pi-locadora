package br.com.senaigo.locadora.utils;

import java.io.File;
import java.io.IOException;

public class ArquivoUtils {

	public static void garantaExistenciaArquivo(String caminhoParaArquivo) throws IOException {
		File file = new File(caminhoParaArquivo);
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public static void garantaExistenciaDeDiretorio(String caminhoParaDiretorio) {
		File file = new File(caminhoParaDiretorio);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
