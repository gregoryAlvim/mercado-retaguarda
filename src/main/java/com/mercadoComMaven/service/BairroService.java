package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.model.DAO.BairroDAO;
import java.util.List;

public class BairroService {

    public static void criar(Bairro objeto) {
        BairroDAO.getInstance().create(objeto);
    }

    public static Bairro buscar(int codigo) {
        return BairroDAO.getInstance().retrive(codigo);
    }

    public static Bairro buscar(String descricao) {
        return BairroDAO.getInstance().retrive(descricao);
    }

    public static List<Bairro> buscar() {
        return BairroDAO.getInstance().retrive();
    }

    public static void atualizar(Bairro objeto) {
        BairroDAO.getInstance().update(objeto);
    }

    public static void excluir(Bairro objeto) {
        BairroDAO.getInstance().delete(objeto);  
    }
    
}
