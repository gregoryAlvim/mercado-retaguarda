package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Produto;
import com.mercadoComMaven.model.DAO.ProdutoDAO;
import java.util.List;

public class ProdutoService {

    public static void criar(Produto objeto) {
        ProdutoDAO.getInstance().create(objeto);
    }

    public static Produto buscar(int codigo) {
        return ProdutoDAO.getInstance().retrive(codigo);
    }

    public static Produto buscar(String descricao) {
        return ProdutoDAO.getInstance().retrive(descricao);    
    }

    public static List<Produto> buscar() {
        return ProdutoDAO.getInstance().retrive();   
    }

    public static void atualizar(Produto objeto) {
        ProdutoDAO.getInstance().update(objeto);   
    }

    public static void excluir(Produto objeto) {
        ProdutoDAO.getInstance().delete(objeto);   
    }
    
}
