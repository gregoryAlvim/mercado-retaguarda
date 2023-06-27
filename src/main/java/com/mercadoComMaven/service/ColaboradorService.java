package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.model.DAO.ColaboradorDAO;
import java.util.List;


public class ColaboradorService {

    public static void criar(Colaborador objeto) {
        ColaboradorDAO.getInstance().create(objeto);
    }

    public static Colaborador buscar(int codigo) {
        return ColaboradorDAO.getInstance().retrive(codigo);
    }

    public static Colaborador buscar(String descricao) {
        return ColaboradorDAO.getInstance().retrive(descricao);    
    }

    public static List<Colaborador> buscar() {
        return ColaboradorDAO.getInstance().retrive();   
    }

    public static void atualizar(Colaborador objeto) {
        ColaboradorDAO.getInstance().update(objeto);   
    }

    public static void excluir(Colaborador objeto) {
        ColaboradorDAO.getInstance().delete(objeto);   
    }
    
}
