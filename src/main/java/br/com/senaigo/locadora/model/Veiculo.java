package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

import java.util.List;

import static br.com.senaigo.locadora.utils.Utils.*;

public class Veiculo implements PersisteDados {

	//Atributos
	private int id;
	private String placa;
	private long renavam;
	private int anoFabricacao;
	private float valorCompra;
	private int kmAtual;
	private Categoria categoria;
	private Estado estado;
	private Modelo modelo;

	//Construtores
	public Veiculo() {
		this.id = 0;
		this.placa = "";
		this.renavam = 0;
		this.anoFabricacao = 0;
		this.valorCompra = 0;
		this.kmAtual = 0;
		this.categoria = null;
		this.estado = null;
		this.modelo = null;
	}

	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public long getRenavam() {
		return renavam;
	}

	public void setRenavam(long renavam) {
		this.renavam = renavam;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public int getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(int kmAtual) {
		this.kmAtual = kmAtual;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	//Métodos próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = obtenhaCampos(dadosDoObjeto);

		this.id = convertaParaInt(campos.get(0));
		this.placa = campos.get(1);
		this.renavam = convertaParaLong(campos.get(2));
		this.anoFabricacao = convertaParaInt(campos.get(3));
		this.valorCompra = convertaParaFloat(campos.get(4));
		this.kmAtual = convertaParaInt(campos.get(5));

	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.placa).append(";");
		dadosDoObjeto.append(this.renavam).append(";");
		dadosDoObjeto.append(this.anoFabricacao).append(";");
		dadosDoObjeto.append(this.valorCompra).append(";");
		dadosDoObjeto.append(this.kmAtual).append(";");
		dadosDoObjeto.append(this.categoria.getId()).append(";");
		dadosDoObjeto.append(this.estado.getValor()).append(";");
		dadosDoObjeto.append(this.modelo.getId());

		return dadosDoObjeto.toString();
	}
}
