package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItensCompra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    @Column
    private float qntProduto;
    
    @Column
    private float valorUnitarioProduto;
    
    @Column
    private char status;

    public ItensCompra() {
    }

    public ItensCompra(UUID id, float qntProduto, float valorUnitarioProduto, char status) {
        this.id = id;
        this.qntProduto = qntProduto;
        this.valorUnitarioProduto = valorUnitarioProduto;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(float qntProduto) {
        this.qntProduto = qntProduto;
    }

    public float getValorUnitarioProduto() {
        return valorUnitarioProduto;
    }

    public void setValorUnitarioProduto(float valorUnitarioProduto) {
        this.valorUnitarioProduto = valorUnitarioProduto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "ItensCupomFiscal:" + this.getId() + 
                "; \n qntProduto:" + this.getQntProduto() + 
                ";\n valorUnitarioProduto:" + this.getValorUnitarioProduto() +";";
    }
}
