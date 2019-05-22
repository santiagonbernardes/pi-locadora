package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Categoria implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private float valorDiarioLocacao;

	//Construtores
	public Categoria() {
		this.id = 0;
		this.nome = "";
		this.valorDiarioLocacao = 0;
	}

	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorDiarioLocacao() {
		return valorDiarioLocacao;
	}

	public void setValorDiarioLocacao(float valorDiarioLocacao) {
		this.valorDiarioLocacao = valorDiarioLocacao;
	}

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
		this.valorDiarioLocacao = Utils.convertaParaFloat(campos.get(2));
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.nome).append(";");
		dadosDoObjeto.append(this.valorDiarioLocacao);

		return dadosDoObjeto.toString();
	}
}
