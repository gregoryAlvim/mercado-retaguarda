package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa implements Serializable{
    
    @Column
    private String cnpj;
    
    @Column
    private String inscEstadual;
    
    @Column
    private String contato;
    
    @Column
    private String razaoSocial;
    
    @Column
    private String cpf;
    
    @Column
    private String rg;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String inscEstadual, String contato, String razaoSocial, String cpf, String rg, int id, String nome, String fone1, String fone2, String email, String complementoEndereco, String observacao, String status, Date dtCadastro, Endereco endereco) {
        super(id, nome, fone1, fone2, email, complementoEndereco, observacao, status, dtCadastro, endereco);
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
        this.contato = contato;
        this.razaoSocial = razaoSocial;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return this.getCnpj() +";\n"+
                this.getInscEstadual() +";\n"+
                this.getContato() +";\n"+
                this.getRazaoSocial() +";\n"+
                this.getCpf() +";\n"+
                this.getRg() +";\n" +
                super.toString() +";\n";
    }
    
    
}
