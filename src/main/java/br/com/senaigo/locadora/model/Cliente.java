package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class Cliente implements PersisteDados {

	//Atributos
	private int id;
	private String nome;
	private String razaoSocial;
	private String nomeFantasia;
	private LocalDate dataNascimento;
	private String cpf;
	private String cnpj;
	private Endereco endereco;
	private Telefone telefonePrincipal;
	private Telefone telefoneAlternativo;
	private String email;

	//Construtores
	public Cliente() {
		this.id = 0;
		this.nome = "";
		this.razaoSocial = "";
		this.nomeFantasia = "";
		this.dataNascimento = null;
		this.cpf = "";
		this.cnpj = "";
		this.endereco = null;
		this.telefonePrincipal = null;
		this.telefoneAlternativo = null;
		this.email = "";
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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


	//Métodos Próprios

	//Métodos herdados
	@Override
	public void monteObjeto(String dadosDoObjeto) {
		List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

		this.id = Utils.convertaParaInt(campos.get(0));
		this.nome = campos.get(1);
		this.razaoSocial = campos.get(2);
		this.nomeFantasia = campos.get(3);
		this.dataNascimento = DataUtils.convertaStringParaLocalDate(campos.get(4));
		this.cpf = campos.get(5);
		this.cnpj = campos.get(6);
		Endereco endereco = new Endereco();
		endereco.setLogradouro(campos.get(7));
		endereco.setNumero(campos.get(8));
		endereco.setComplemento(campos.get(9));
		endereco.setBairro(campos.get(10));
		endereco.setCidade(campos.get(11));
		endereco.setCep(campos.get(12));
		EstadosBrasil estado = EstadosBrasil.valueOf(Utils.convertaParaInt(campos.get(13)));
		endereco.setEstado(estado);
		this.endereco = endereco;
		this.telefonePrincipal = Telefone.obtenhaInstancia(campos.get(14));
		this.telefoneAlternativo = Telefone.obtenhaInstancia(campos.get(15));
		this.email = campos.get(16);
	}

	@Override
	public String desmonteObjeto() {
		StringBuilder dadosDoObjeto = new StringBuilder();

		String nomeDaClasse = this.getClass().getSimpleName();

		dadosDoObjeto.append(nomeDaClasse).append(";");
		dadosDoObjeto.append(this.id).append(";");
		dadosDoObjeto.append(this.nome).append(";");
		dadosDoObjeto.append(this.razaoSocial).append(";");
		dadosDoObjeto.append(this.nomeFantasia).append(";");
		String dataFormatada = DataUtils.convertaLocalDateParaStringFormatada(this.dataNascimento);
		dadosDoObjeto.append(dataFormatada).append(";");
		dadosDoObjeto.append(this.cpf).append(";");
		dadosDoObjeto.append(this.cnpj).append(";");
		dadosDoObjeto.append(this.endereco.getLogradouro()).append(";");
		dadosDoObjeto.append(this.endereco.getNumero()).append(";");
		dadosDoObjeto.append(this.endereco.getComplemento()).append(";");
		dadosDoObjeto.append(this.endereco.getBairro()).append(";");
		dadosDoObjeto.append(this.endereco.getCidade()).append(";");
		dadosDoObjeto.append(this.endereco.getCep()).append(";");
		dadosDoObjeto.append(this.endereco.getEstado().getValor()).append(";");
		dadosDoObjeto.append(this.telefonePrincipal.toString()).append(";");
		dadosDoObjeto.append(this.telefoneAlternativo.toString()).append(";");
		dadosDoObjeto.append(this.email);

		return dadosDoObjeto.toString();
	}

}
