package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Marca implements PersisteDados {

	//Atributos
	private int id;
	private String nome;

	//Construtores
	public Marca() {
		this.id = 0;
		this.nome = "";
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

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosSeparadosPorPontoVirgula = new StringBuilder();
		dadosSeparadosPorPontoVirgula.append(this.id).append(";");
		dadosSeparadosPorPontoVirgula.append(this.nome);

		return dadosSeparadosPorPontoVirgula.toString();
	}

}
