package br.com.senaigo.locadora.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTcp {

	private Socket socket;
	private DataInputStream entrada;
	private DataOutputStream saida;
	private static ClienteTcp instancia;


	private ClienteTcp() throws IOException {
		socket = new Socket("127.0.0.1", 7777);
		entrada = new DataInputStream(socket.getInputStream());
		saida = new DataOutputStream(socket.getOutputStream());
	}

	public static ClienteTcp obtenhaInstancia() throws IOException {
		if(instancia == null) {
			instancia = new ClienteTcp();
		}
		return instancia;
	}

	public void enviarMensagem(String mensagem) throws IOException {
		saida.writeUTF(mensagem);
		saida.flush();
	}

	public String receberMensagem() throws IOException {
		return entrada.readUTF();
	}
}
