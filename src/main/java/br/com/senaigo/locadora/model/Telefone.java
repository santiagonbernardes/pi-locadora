package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

public class Telefone implements PersisteDados {
    
    //Atributos
    private int id;
    private int ddd;
    private int numero;
    
    //Construtores
    public Telefone() {
        this.id = 0;
        this.ddd = 0;
        this.numero = 0;
    }
    
    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //Métodos Próprios
    
    //Métodos Herdados
    @Override
    public Object monteObjeto(String dadosDoObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String desmonteObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
