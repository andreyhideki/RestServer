package br.unicesumar.restserver.pessoa;

import javax.persistence.Entity;

@Entity
public class Juridica extends Pessoa{
    private String cnpj;

    public Juridica() {
    }

    public Juridica(String nome) {
        super(nome);
    }

    public Juridica(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
