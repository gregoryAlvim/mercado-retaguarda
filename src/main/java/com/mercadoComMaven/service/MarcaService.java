package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.model.DAO.MarcaDAO;
import java.util.List;


public class MarcaService {

    public static void criar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.create(objeto);
    }

    public static Marca buscar(int codigo) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrive(codigo);
    }

    public static Marca buscar(String descricao) {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrive(descricao);    
    }

    public static List<Marca> buscar() {
        MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrive();   
    }

    public static void atualizar(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.update(objeto);   
    }

    public static void excluir(Marca objeto) {
        MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.delete(objeto);   
    }
    
}
