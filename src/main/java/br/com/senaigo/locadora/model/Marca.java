package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

public class Marca implements PersisteDados {
    
    //Atributos
    private int id;
    private String nome;
    
    //Construtores
    public Marca() {
        this.id = 0;
        this.nome = "";
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
