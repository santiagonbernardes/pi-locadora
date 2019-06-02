package br.com.senaigo.locadora.utils;

import java.io.File;
import java.io.IOException;

public class ArquivoUtils {

	public static void garantaExistenciaArquivo(String caminhoParaArquivo, boolean ehDiretorio) throws IOException {
		File file = new File(caminhoParaArquivo);
		if (!file.exists()) {
			if (ehDiretorio) {
				file.mkdirs();
			} else {
				file.createNewFile();
			}
		}
	}

	public static int obtenhaQtdArquivosNoDiretorio(String diretorio) {
		File file = new File(diretorio);
		File[] todosArquivosDoDiretorio = file.listFiles();
		return todosArquivosDoDiretorio == null ? 0 : todosArquivosDoDiretorio.length;
	}
}
