package br.unicesumar.restserver.pessoa;

import javax.persistence.Entity;

@Entity
public class Fisica extends Pessoa{
    private String cpf;

    public Fisica() {
    }

    public Fisica(String nome) {
        super(nome);
    }

    public Fisica(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
