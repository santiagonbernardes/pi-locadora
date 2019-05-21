package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Endereco implements PersisteDados {

	//Atributos
	private int id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private EstadosBrasil estado;

	//Construtores
	public Endereco() {
		this.id = 0;
		this.logradouro = "";
		this.numero = "";
		this.complemento = "";
		this.bairro = "";
		this.cidade = "";
		this.cep = "";
		this.estado = null;
	}

	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public EstadosBrasil getEstado() {
		return estado;
	}

	public void setEstado(EstadosBrasil estado) {
		this.estado = estado;
	}

	//Métodos Próprios

	//Métodos herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.logradouro = campos.get(0);
		this.numero = campos.get(1);
		this.complemento = campos.get(2);
		this.bairro = campos.get(3);
		this.cep = campos.get(4);
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.logradouro).append(";");
		dadosDoObjeto.append(this.numero).append(";");
		dadosDoObjeto.append(this.complemento).append(";");
		dadosDoObjeto.append(this.bairro).append(";");
		dadosDoObjeto.append(this.cidade).append(";");
		dadosDoObjeto.append(this.cep).append(";");
		dadosDoObjeto.append(this.estado.getValor());

		return dadosDoObjeto.toString();
	}
}
