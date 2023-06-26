package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente extends Pessoa implements Serializable{
   
   @Column
   private String cpf;
   
   @Column
   private String rg;
   
   @Column
   @Temporal(TemporalType.DATE)
   private Date dtNascimento;
   
   @Column
   private char sexo;

    public Cliente(){
    }

    public Cliente(String cpf, String rg, Date dtNascimento, char sexo, int id, String nome, String fone1, String fone2, String email, String complementoEndereco, String observacao, String status, Date dataCadastro, Endereco endereco) {
        super(id, nome, fone1, fone2, email, complementoEndereco, observacao, status, dataCadastro, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
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

    public Date getDataNascimento() {
        return dtNascimento;
    }

    public void setDataNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return  this.getNome() +";\n" +
                this.getCpf() +";\n" + 
                this.getRg() + ";\n"+ 
                this.getDataNascimento() +";\n"+
                this.getSexo() +";\n"+
                super.toString();
    }
}
