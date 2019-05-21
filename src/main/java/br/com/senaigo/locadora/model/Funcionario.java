package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.DataUtils;

import java.time.LocalDate;

public class Funcionario implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private Endereco endereco;
	private Telefone telefonePrincipal;
	private Telefone telefoneAlternativo;
	private String email;
	private String rg;
	private String carteiraDeTrabalho;
	private String login;
	private String senha;

	public Funcionario() {
		this.id = 0;
		this.nome = "";
		this.dataNascimento = null;
		this.cpf = "";
		this.endereco = null;
		this.telefonePrincipal = null;
		this.telefoneAlternativo = null;
		this.email = "";
		this.rg = "";
		this.carteiraDeTrabalho = "";
		this.login = "";
		this.senha = "";
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	//Métodos Próprios

	//Métodos Herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
		dadosDoObjeto.append(this.endereco.getId()).append(";");
		dadosDoObjeto.append(this.telefonePrincipal.toString()).append(";");
		dadosDoObjeto.append(this.telefoneAlternativo.toString()).append(";");
		dadosDoObjeto.append(this.email).append(";");
		dadosDoObjeto.append(this.rg).append(";");
		dadosDoObjeto.append(this.carteiraDeTrabalho).append(";");
		dadosDoObjeto.append(this.login).append(";");
		dadosDoObjeto.append(this.senha);

		return dadosDoObjeto.toString();
	}
}
