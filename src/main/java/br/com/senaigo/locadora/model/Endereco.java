package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

public class Endereco implements PersisteDados{
    
    //Atributos
    private int id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    
    //Construtores
    public Endereco() {
        this.id = 0;
        this.logradouro = "";
        this.numero = "";
        this.complemento = "";
        this.bairro = "";
        this.cep = "";
    }
    
    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    //Métodos Próprios
    
    //Métodos herdados
    @Override
    public Object monteObjeto(String dadosDoObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desmonteObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
