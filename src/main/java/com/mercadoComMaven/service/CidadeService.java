package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.model.DAO.CidadeDAO;
import java.util.List;

public class CidadeService {

    public static void criar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.create(objeto);
    }

    public static Cidade buscar(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrive(codigo);
    }

    public static Cidade buscar(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrive(descricao);    
    }

    public static List<Cidade> buscar() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        return cidadeDAO.retrive();   
    }

    public static void atualizar(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(objeto);   
    }

    public static void excluir(Cidade objeto) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(objeto);   
    }
    
}
