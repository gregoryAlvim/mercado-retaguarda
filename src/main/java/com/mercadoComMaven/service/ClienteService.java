package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Cliente;
import com.mercadoComMaven.model.DAO.ClienteDAO;
import java.util.List;

public class ClienteService {

    public static void criar(Cliente objeto) {
        ClienteDAO.getInstance().create(objeto);
    }

    public static Cliente buscar(int codigo) {
        return ClienteDAO.getInstance().retrive(codigo);
    }

    public static Cliente buscar(String descricao) {
        return ClienteDAO.getInstance().retrive(descricao);   
    }

    public static List<Cliente> buscar() {
        return ClienteDAO.getInstance().retrive();  
    }

    public static void atualizar(Cliente objeto) {
        ClienteDAO.getInstance().update(objeto);  
    }

    public static void excluir(Cliente objeto) {
        ClienteDAO.getInstance().delete(objeto); 
    }
    
}
