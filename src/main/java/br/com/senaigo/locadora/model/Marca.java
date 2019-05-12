package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;
import br.com.senaigo.locadora.utils.Utils;

import java.util.List;

public class Marca extends PersisteDados {
    
    //Atributos
    private String nome;
    
    //Construtores
    public Marca() {
        super();
        this.nome = "";
    }
    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //Métodos Próprios
    
    //Métodos Herdados
    @Override
    public void monteObjeto(String dadosDoObjeto) {
        List<String> campos = Utils.obtenhaCampos(dadosDoObjeto);

        this.id = Utils.convertaParaInt(campos.get(0));
        this.nome = campos.get(1);
    }

    @Override
    public String desmonteObjeto(boolean comParametro) {
        StringBuilder dadosSeparadosPorVirgula = new StringBuilder();

        if(comParametro) {
            dadosSeparadosPorVirgula.append(obtenhaParametros());
        }

        dadosSeparadosPorVirgula.append(this.id).append(";");
        dadosSeparadosPorVirgula.append(this.nome);

        return dadosSeparadosPorVirgula.toString();
    }

}
