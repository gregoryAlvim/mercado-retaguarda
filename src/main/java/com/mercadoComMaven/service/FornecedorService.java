package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Fornecedor;
import com.mercadoComMaven.model.DAO.FornecedorDAO;
import java.util.List;


public class FornecedorService {

    public static void criar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    public static Fornecedor buscar(int codigo) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrive(codigo);
    }

    public static Fornecedor buscar(String descricao) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrive(descricao);    
    }

    public static List<Fornecedor> buscar() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrive();   
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(objeto);   
    }

    public static void excluir(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(objeto);   
    }
    
}
