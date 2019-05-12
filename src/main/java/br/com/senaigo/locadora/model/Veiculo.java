package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

import java.util.List;

import static br.com.senaigo.locadora.utils.Utils.*;

public class Veiculo extends PersisteDados {

	//Atributos
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
		super();
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
	public String desmonteObjeto(boolean comParametro) {
		StringBuilder dadosSeparadosPontoVirgula = new StringBuilder();

		dadosSeparadosPontoVirgula.append(this.obtenhaParametros());
		dadosSeparadosPontoVirgula.append(this.id).append(";");
		dadosSeparadosPontoVirgula.append(this.placa).append(";");
		dadosSeparadosPontoVirgula.append(this.renavam).append(";");
		dadosSeparadosPontoVirgula.append((this.anoFabricacao)).append(";");
		dadosSeparadosPontoVirgula.append(this.valorCompra).append(";");
		dadosSeparadosPontoVirgula.append(this.kmAtual).append(";");
		dadosSeparadosPontoVirgula.append(this.categoria.getNome()).append(";");
		dadosSeparadosPontoVirgula.append(this.estado).append(";");
		dadosSeparadosPontoVirgula.append(this.modelo.getNome());

		return dadosSeparadosPontoVirgula.toString();
	}
}
