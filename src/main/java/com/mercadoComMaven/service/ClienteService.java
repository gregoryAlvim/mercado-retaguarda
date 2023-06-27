package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Cliente;
import com.mercadoComMaven.model.DAO.ClienteDAO;
import java.util.List;

public class ClienteService {

    public static void criar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(objeto);
    }

    public static Cliente buscar(int codigo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrive(codigo);
    }

    public static Cliente buscar(String descricao) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrive(descricao);    
    }

    public static List<Cliente> buscar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.retrive();   
    }

    public static void atualizar(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(objeto);   
    }

    public static void excluir(Cliente objeto) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(objeto);   
    }
    
}
