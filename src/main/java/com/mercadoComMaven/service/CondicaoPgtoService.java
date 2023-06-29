package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.CondicaoPagamento;
import com.mercadoComMaven.model.DAO.CondicaoPgtoDAO;
import java.util.List;


public class CondicaoPgtoService {

    public static void criar(CondicaoPagamento objeto) {
        CondicaoPgtoDAO.getInstance().create(objeto);
    }

    public static CondicaoPagamento buscar(int codigo) {
        return CondicaoPgtoDAO.getInstance().retrive(codigo);
    }

    public static CondicaoPagamento buscar(String descricao) {
        return CondicaoPgtoDAO.getInstance().retrive(descricao);  
    }

    public static List<CondicaoPagamento> buscar() {
        return CondicaoPgtoDAO.getInstance().retrive();  
    }

    public static void atualizar(CondicaoPagamento objeto) {
        CondicaoPgtoDAO.getInstance().update(objeto); 
    }

    public static void excluir(CondicaoPagamento objeto) {
        CondicaoPgtoDAO.getInstance().delete(objeto);   
    }
    
}
