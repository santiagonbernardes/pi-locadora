package br.com.senaigo.locadora.comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTcp {

	private int porta;
	private ServerSocket ss;
	private Socket conexaoComCliente;

	//Modo Servidor
	public ServidorTcp(int porta) throws IOException {
		//TODO validar range da porta
		this.porta = porta;
		ss = new ServerSocket(this.porta);
	}

	public void aguardeConexaoComCliente() throws IOException {
		System.out.println("Aguardando conexão com o cliente. Escutando na porta: " + porta);
		conexaoComCliente = ss.accept();
		System.out.println("Conectado ao cliente:" + obtenhaIpCliente());
	}

	public String obtenhaIpCliente() {
		String ipSemFormatacao = conexaoComCliente.getRemoteSocketAddress().toString();
		return ipSemFormatacao.trim().replaceFirst("/", "");
	}

	public void enviarMensagem(String mensagem) throws IOException {
		System.out.println("Enviando mensagem: " + mensagem);
		DataOutputStream saida = new DataOutputStream(conexaoComCliente.getOutputStream());
		saida.writeUTF(mensagem);
		saida.flush();
		System.out.println("Mensagem enviada com sucesso.");
	}

	public String receberMensagem() throws IOException {
		DataInputStream entrada = new DataInputStream(conexaoComCliente.getInputStream());
		String requisicao = entrada.readUTF();
		System.out.println("Solicitação do cliente:" + requisicao);
		return requisicao;
	}
}
