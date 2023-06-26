package com.mercadoComMaven.modelBO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private int fatorConversao;
    
    @Column
    private float valorCompra;
    
    @Column
    private float valorVenda;
    
    @Column
    private float estoqueMinimo;
    
    @Column
    private float estoqueMaximo;
    
    @Column
    private String undCompra;
    
    @Column
    private String undVenda;
    
    @Column
    private String barraEntrada;
    
    @Column
    private String barraSaida;
    
    @Column
    private String descricao;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    
    @Column
    private String status;
    
    @JoinColumn
    @ManyToOne
    private Classe classe;
    
    @JoinColumn
    @ManyToOne
    private Marca marca;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(int fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(float estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public float getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(float estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public String getUndCompra() {
        return undCompra;
    }

    public void setUndCompra(String undCompra) {
        this.undCompra = undCompra;
    }

    public String getUndVenda() {
        return undVenda;
    }

    public void setUndVenda(String undVenda) {
        this.undVenda = undVenda;
    }

    public String getBarraEntrada() {
        return barraEntrada;
    }

    public void setBarraEntrada(String barraEntrada) {
        this.barraEntrada = barraEntrada;
    }

    public String getBarraSaida() {
        return barraSaida;
    }

    public void setBarraSaida(String barraSaida) {
        this.barraSaida = barraSaida;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id:" + this.getId() 
                + "; \n descrição: " + this.getDescricao() 
                + "; \n fatorConversao: " + this.getFatorConversao() 
                + ";\n valorCompra: " + this.getValorCompra() 
                + ";\n valorVenda: " + this.getValorVenda() 
                + ";\n estoqueMinimo: " + this.getEstoqueMinimo() 
                + ";\n estoqueMaximo: " + this.getEstoqueMaximo() 
                + ";\n undCompra: " + this.getUndCompra() 
                + ";\n undVenda: " + this.getUndVenda() 
                + ";\n barraEntrada: " + this.getBarraEntrada() 
                + ";\n barraSaida: " + this.getBarraSaida() 
                + ";\n dataCadastro: " + this.getDataCadastro() 
                + ";\n status: " + this.getStatus() ;
    }
    
}
