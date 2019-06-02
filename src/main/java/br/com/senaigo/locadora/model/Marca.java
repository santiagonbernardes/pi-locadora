package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;
import java.util.Objects;

public class Marca implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private String logo;

	//Construtores
	public Marca() {
		this.id = 0;
		this.nome = "";
		this.logo = "";
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
		this.logo = campos.get(2);
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.nome).append(";");
		dadosDoObjeto.append("Imagem#").append(this.logo);

		return dadosDoObjeto.toString();
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object outraMarca) {
		if (this == outraMarca) {
			return true;
		}
		if (outraMarca == null || this.getClass() != outraMarca.getClass()) {
			return false;
		}
		Marca marca = (Marca) outraMarca;
		return this.id == marca.id &&
			this.nome.equals(marca.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.nome);
	}
}
