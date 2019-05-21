package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import java.util.Date;

public class Motorista implements PersisteDados {
    
    //Atributos
	private int id;
    private String nome;
    private Date dataNascimento;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desmonteObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
