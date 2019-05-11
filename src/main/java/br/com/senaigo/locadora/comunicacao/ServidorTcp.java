package br.com.senaigo.locadora.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTcp {
	private ServerSocket ss;
	private Socket socket;
	private DataInputStream entrada;
	private DataOutputStream saida;


	//Modo Servidor
	public ServidorTcp(int portaServer) throws IOException {
		ss = new ServerSocket(portaServer);
		socket = ss.accept();
		entrada = new DataInputStream(socket.getInputStream());
		saida = new DataOutputStream(socket.getOutputStream());
	}

	public void enviarMensagem(String mensagem) throws IOException {
		saida.writeUTF(mensagem);
		saida.flush();
	}

	public String receberMensagem() throws IOException {
		return entrada.readUTF();
	}
}
