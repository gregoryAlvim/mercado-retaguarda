package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Fornecedor;
import com.mercadoComMaven.model.DAO.FornecedorDAO;
import java.util.List;


public class FornecedorService {

    public static void criar(Fornecedor objeto) {
        FornecedorDAO.getInstance().create(objeto);
    }

    public static Fornecedor buscar(int codigo) {
        return FornecedorDAO.getInstance().retrive(codigo);
    }

    public static Fornecedor buscar(String descricao) {
        return FornecedorDAO.getInstance().retrive(descricao);    
    }

    public static List<Fornecedor> buscar() {
        return FornecedorDAO.getInstance().retrive();    
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorDAO.getInstance().update(objeto); 
    }

    public static void excluir(Fornecedor objeto) {
        FornecedorDAO.getInstance().delete(objeto);   
    }
    
}
