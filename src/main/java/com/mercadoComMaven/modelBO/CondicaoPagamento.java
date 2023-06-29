package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CondicaoPagamento implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @Column
   private int numeroParcelas;
   
   @Column
   private int diasPrimeiraParcela;
   
   @Column
   private int diasEntreParcela;
   
   @Column
   private String status;
   
   @Column
   private String descricaoCondicao;

    public CondicaoPagamento() {
    }

    public CondicaoPagamento(int id, int numeroParcelas, int diasPrimeiraParcela, int diaEntreParcela, String status, String descricaoCondicao) {
        this.id = id;
        this.numeroParcelas = numeroParcelas;
        this.diasPrimeiraParcela = diasPrimeiraParcela;
        this.diasEntreParcela = diaEntreParcela;
        this.status = status;
        this.descricaoCondicao = descricaoCondicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public int getDiasPrimeiraParcela() {
        return diasPrimeiraParcela;
    }

    public void setDiasPrimeiraParcela(int diasPrimeiraParcela) {
        this.diasPrimeiraParcela = diasPrimeiraParcela;
    }

    public int getDiaEntreParcela() {
        return diasEntreParcela;
    }

    public void setDiaEntreParcela(int diaEntreParcela) {
        this.diasEntreParcela = diaEntreParcela;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricaoCondicao() {
        return descricaoCondicao;
    }

    public void setDescricaoCondicao(String descricaoCondicao) {
        this.descricaoCondicao = descricaoCondicao;
    }

    @Override
    public String toString() {
        return this.getId() + ";\n" + 
                this.getNumeroParcelas() + ";\n" + 
                this.getDiasPrimeiraParcela() + "; \n" + 
                this.getDiaEntreParcela() + "; \n" + 
                this.getStatus() + "; \n" + 
                this.getDescricaoCondicao();
    }
   
   
}
