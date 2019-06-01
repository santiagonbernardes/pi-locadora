package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Modelo implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private Marca marca;

	//Construtores
	public Modelo() {
		this.id = 0;
		this.nome = "";
		this.marca = null;
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
		String dadosMarca = campos.get(2) + ";" + campos.get(3);
		Marca marca = (Marca) PersisteDadosFactory.obtenhaInstancia("Marca");
		marca.monteObjeto(dadosMarca);
		this.marca = marca;
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.nome).append(";");
		dadosDoObjeto.append(this.marca.getClass().getSimpleName()).append("#");
		dadosDoObjeto.append(this.marca.getId());

		return dadosDoObjeto.toString();
	}

    @Override
    public String toString() {
        return this.nome;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Modelo modelo = (Modelo) o;

		if (id != modelo.id) {
			return false;
		}
		if (!nome.equals(modelo.nome)) {
			return false;
		}
		return marca.equals(modelo.marca);

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + nome.hashCode();
		result = 31 * result + marca.hashCode();
		return result;
	}
}
