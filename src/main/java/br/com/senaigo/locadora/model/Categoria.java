package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

public class Categoria extends PersisteDados {

    //Atributos
    private String nome;
    private float valorDiarioLocacao;
    
    //Construtores
    public Categoria() {
        super();
        this.nome = "";
        this.valorDiarioLocacao = 0;
    }
    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorDiarioLocacao() {
        return valorDiarioLocacao;
    }

    public void setValorDiarioLocacao(float valorDiarioLocacao) {
        this.valorDiarioLocacao = valorDiarioLocacao;
    }
    
    //Métodos Próprios
    
    //Métodos Herdados    
    @Override
    public void monteObjeto(String dadosDoObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desmonteObjeto(boolean comParametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
