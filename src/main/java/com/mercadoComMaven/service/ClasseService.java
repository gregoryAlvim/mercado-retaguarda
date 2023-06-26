package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.model.DAO.ClasseDAO;
import java.util.List;

public class ClasseService {

    public static void criar(Classe objeto) {
        ClasseDAO.getInstance().create(objeto);
    }

    public static Classe buscar(int codigo) {
        return ClasseDAO.getInstance().retrive(codigo);
    }

    public static Classe buscar(String descricao) {
        return  ClasseDAO.getInstance().retrive(descricao);
    }

    public static List<Classe> buscar() {
        return  ClasseDAO.getInstance().retrive();
    }

    public static void atualizar(Classe objeto) {
         ClasseDAO.getInstance().update(objeto);
    }

    public static void excluir(Classe objeto) {
         ClasseDAO.getInstance().delete(objeto);
    }
    
}
