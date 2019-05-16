package br.com.senaigo.locadora.interfaces;

public abstract class PersisteDados {

    //Atributos
    protected int id;

    //Contrutores
    public PersisteDados() {
        this.id = 0;
    }

    public PersisteDados(int id) {
        this.id = id;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Métodos
    public abstract void monteObjeto(String dadosDoObjeto);

    public abstract String desmonteObjeto(boolean comParametro);

    protected String obtenhaParametros() {
        StringBuilder parametros = new StringBuilder();

        parametros.append(this.getClass().getSimpleName());
        parametros.append("|");

        return parametros.toString();
    }
}
