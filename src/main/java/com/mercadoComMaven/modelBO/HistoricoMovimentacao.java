package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.UUID;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoricoMovimentacao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column
    private String hora;
    
    @Column
    private float qnt;
    
    @Column
    private char tipo;
    
    @Column
    private char status;

    public HistoricoMovimentacao() {
    }

    public HistoricoMovimentacao(UUID id, Date data, String hora, float qnt, char tipo, char status) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.qnt = qnt;
        this.tipo = tipo;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getQnt() {
        return qnt;
    }

    public void setQnt(float qnt) {
        this.qnt = qnt;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id:" + this.getId() + ";\n data:" + this.getData() 
                + "; \n hora:" + this.getHora() + ";\n qnt:" 
                + this.getQnt() + ";\n tipo:" + this.getTipo() + ";\n status:" + this.getStatus();
    }
    
    
    
}
