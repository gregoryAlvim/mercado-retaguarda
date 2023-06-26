package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Produto;
import com.mercadoComMaven.model.DAO.ProdutoDAO;
import java.util.List;

public class ProdutoService {

    public static void criar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(objeto);
    }

    public static Produto buscar(int codigo) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrive(codigo);
    }

    public static Produto buscar(String descricao) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrive(descricao);    
    }

    public static List<Produto> buscar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.retrive();   
    }

    public static void atualizar(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.update(objeto);   
    }

    public static void excluir(Produto objeto) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(objeto);   
    }
    
}
