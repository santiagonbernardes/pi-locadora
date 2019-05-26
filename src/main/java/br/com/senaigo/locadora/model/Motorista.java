package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Motorista implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private Endereco endereco;
	private Telefone telefonePrincipal;
	private Telefone telefoneAlternativo;
	private String email;
	private String cnh;

	//Construtores
	public Motorista() {
		this.id = 0;
		this.nome = "";
		this.dataNascimento = null;
		this.cpf = "";
		this.endereco = null;
		this.telefonePrincipal = null;
		this.telefoneAlternativo = null;
		this.email = "";
		this.cnh = "";
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(Telefone telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public Telefone getTelefoneAlternativo() {
		return telefoneAlternativo;
	}

	public void setTelefoneAlternativo(Telefone telefoneAlternativo) {
		this.telefoneAlternativo = telefoneAlternativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
		this.dataNascimento = DataUtils.convertaStringParaLocalDate(campos.get(2));
		this.cpf = campos.get(3);
		Endereco endereco = new Endereco();
		endereco.setLogradouro(campos.get(4));
		endereco.setNumero(campos.get(5));
		endereco.setComplemento(campos.get(6));
		endereco.setBairro(campos.get(7));
		endereco.setCidade(campos.get(8));
		endereco.setCep(campos.get(9));
		EstadosBrasil estado = EstadosBrasil.valueOf(Utils.convertaParaInt(campos.get(10)));
		endereco.setEstado(estado);
		this.endereco = endereco;
		this.telefonePrincipal = Telefone.obtenhaInstancia(campos.get(11));
		this.telefoneAlternativo = Telefone.obtenhaInstancia(campos.get(12));
		this.email = campos.get(13);
		this.cnh = campos.get(14);
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.nome).append(";");
		String dataNascimentoFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataNascimento);
		dadosDoObjeto.append(dataNascimentoFormatada).append(";");
		dadosDoObjeto.append(this.cpf).append(";");
		dadosDoObjeto.append(this.endereco.getLogradouro()).append(";");
		dadosDoObjeto.append(this.endereco.getNumero()).append(";");
		dadosDoObjeto.append(this.endereco.getComplemento()).append(";");
		dadosDoObjeto.append(this.endereco.getBairro()).append(";");
		dadosDoObjeto.append(this.endereco.getCidade()).append(";");
		dadosDoObjeto.append(this.endereco.getCep()).append(";");
		dadosDoObjeto.append(this.endereco.getEstado().getValor()).append(";");
		dadosDoObjeto.append(this.telefonePrincipal.toString()).append(";");
		dadosDoObjeto.append(this.telefoneAlternativo.toString()).append(";");
		dadosDoObjeto.append(this.email).append(";");
		dadosDoObjeto.append(this.cnh);

		return dadosDoObjeto.toString();
	}

}
