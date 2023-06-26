package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.model.DAO.ColaboradorDAO;
import java.util.List;


public class ColaboradorService {

    public static void criar(Colaborador objeto) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaboradorDAO.create(objeto);
    }

    public static Colaborador buscar(int codigo) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrive(codigo);
    }

    public static Colaborador buscar(String descricao) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrive(descricao);    
    }

    public static List<Colaborador> buscar() {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        return colaboradorDAO.retrive();   
    }

    public static void atualizar(Colaborador objeto) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaboradorDAO.update(objeto);   
    }

    public static void excluir(Colaborador objeto) {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaboradorDAO.delete(objeto);   
    }
    
}
