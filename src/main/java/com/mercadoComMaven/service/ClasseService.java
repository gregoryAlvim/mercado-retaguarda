package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.model.DAO.ClasseDAO;
import java.util.List;

public class ClasseService {

    public static void criar(Classe objeto) {
        ClasseDAO classeDAO = new ClasseDAO();
        classeDAO.create(objeto);
    }

    public static Classe buscar(int codigo) {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.retrive(codigo);
    }

    public static Classe buscar(String descricao) {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.retrive(descricao);    
    }

    public static List<Classe> buscar() {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.retrive();   
    }

    public static void atualizar(Classe objeto) {
        ClasseDAO classeDAO = new ClasseDAO();
        classeDAO.update(objeto);   
    }

    public static void excluir(Classe objeto) {
        ClasseDAO classeDAO = new ClasseDAO();
        classeDAO.delete(objeto);   
    }
    
}
