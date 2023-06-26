package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Colaborador extends Pessoa implements Serializable{
    
    @Column
    private String login;
    
    @Column
    private String senha;

    public Colaborador() {
    }

    public Colaborador(String login, String senha, int id, String nome, String fone1, String fone2, String email, String complementoEndereco, String observacao, String status, Date dtCadastro, Endereco endereco) {
        super(id, nome, fone1, fone2, email, complementoEndereco, observacao, status, dtCadastro, endereco);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getLogin() + "; \n" + this.getSenha() + "; \n" + super.toString();
    }
    
    
}
