package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Endereco extends PersisteDados {
    
    //Atributos
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    
    //Construtores
    public Endereco() {
        super();
        this.logradouro = "";
        this.numero = "";
        this.complemento = "";
        this.bairro = "";
        this.cep = "";
    }
    
    //Getters e Setters
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
    public void monteObjeto(String dadosDoObjeto) {
        List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

        this.logradouro = campos.get(0);
        this.numero = campos.get(1);
        this.complemento = campos.get(2);
        this.bairro = campos.get(3);
        this.cep = campos.get(4);
    }

    @Override
    public String desmonteObjeto(boolean comParametro) {
        StringBuilder dadosSeparadosPorPontoVirgula = new StringBuilder();

        if(comParametro) {
            dadosSeparadosPorPontoVirgula.append(obtenhaParametros());
        }

        dadosSeparadosPorPontoVirgula.append(this.logradouro).append(";");
        dadosSeparadosPorPontoVirgula.append(this.numero).append(";");
        dadosSeparadosPorPontoVirgula.append(this.complemento).append(";");
        dadosSeparadosPorPontoVirgula.append(this.bairro).append(";");
        dadosSeparadosPorPontoVirgula.append(this.cep);

        return dadosSeparadosPorPontoVirgula.toString();
    }
}
