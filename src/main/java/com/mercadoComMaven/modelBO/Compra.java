package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private float valorDesconto;
    
    @Column
    private float valorAcrescimo;
    
    @Column
    private float totalNF;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    
    @Column
    private String hora;
    
    @Column
    private String numeroNF;
    
    @Column
    private String tipoNF;
    
    @Column
    private char status;

    public Compra() {
    }

    public Compra(int id, float valorDesconto, float valorAcrescimo, float totalNF, Date dataCompra, String hora, String numeroNF, String tipoNF, char status) {
        this.id = id;
        this.valorDesconto = valorDesconto;
        this.valorAcrescimo = valorAcrescimo;
        this.totalNF = totalNF;
        this.dataCompra = dataCompra;
        this.hora = hora;
        this.numeroNF = numeroNF;
        this.tipoNF = tipoNF;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float vlorDesconto) {
        this.valorDesconto = vlorDesconto;
    }

    public float getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(float valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public float getTotalNF() {
        return totalNF;
    }

    public void setTotalNF(float totalNF) {
        this.totalNF = totalNF;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }

    public String getTipoNF() {
        return tipoNF;
    }

    public void setTipoNF(String tipoNF) {
        this.tipoNF = tipoNF;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() +";\n"+
                this.getDataCompra() +";\n"+
                this.getNumeroNF() +";\n"+
                this.getTipoNF() +";\n"+
                this.getTotalNF() +";\n"+
                this.getValorAcrescimo() +";\n"+
                this.getValorDesconto() +";\n"+
                this.getHora() +";\n"+
                this.getStatus();
    }

    
 
}
