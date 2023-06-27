package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.model.DAO.CidadeDAO;
import java.util.List;

public class CidadeService {

    public static void criar(Cidade objeto) {
        CidadeDAO.getInstance().create(objeto);
    }

    public static Cidade buscar(int codigo) {
        return CidadeDAO.getInstance().retrive(codigo);
    }

    public static Cidade buscar(String descricao) {
        return CidadeDAO.getInstance().retrive(descricao);   
    }

    public static List<Cidade> buscar() {
        return CidadeDAO.getInstance().retrive(); 
    }

    public static void atualizar(Cidade objeto) {
        CidadeDAO.getInstance().update(objeto);  
    }

    public static void excluir(Cidade objeto) {
        CidadeDAO.getInstance().delete(objeto);  
    }
    
}
