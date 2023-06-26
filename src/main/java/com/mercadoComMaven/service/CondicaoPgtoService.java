package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.CondicaoPgto;
import com.mercadoComMaven.model.DAO.CondicaoPgtoDAO;
import java.util.List;


public class CondicaoPgtoService {

    public static void criar(CondicaoPgto objeto) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgtoDAO.create(objeto);
    }

    public static CondicaoPgto buscar(int codigo) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.retrive(codigo);
    }

    public static CondicaoPgto buscar(String descricao) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.retrive(descricao);    
    }

    public static List<CondicaoPgto> buscar() {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.retrive();   
    }

    public static void atualizar(CondicaoPgto objeto) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgtoDAO.update(objeto);   
    }

    public static void excluir(CondicaoPgto objeto) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgtoDAO.delete(objeto);   
    }
    
}
