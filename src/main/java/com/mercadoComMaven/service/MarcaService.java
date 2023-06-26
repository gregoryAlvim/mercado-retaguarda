package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.model.DAO.MarcaDAO;
import java.util.List;


public class MarcaService {

    public static void criar(Marca objeto) {
        MarcaDAO.getInstance().create(objeto);
    }

    public static Marca buscar(int codigo) {
        return MarcaDAO.getInstance().retrive(codigo);
    }

    public static Marca buscar(String descricao) {
        return MarcaDAO.getInstance().retrive(descricao);    
    }

    public static List<Marca> buscar() {
        return MarcaDAO.getInstance().retrive();   
    }

    public static void atualizar(Marca objeto) {
        MarcaDAO.getInstance().update(objeto);   
    }

    public static void excluir(Marca objeto) {
        MarcaDAO.getInstance().delete(objeto);   
    }
    
}
