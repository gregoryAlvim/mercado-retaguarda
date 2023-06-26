package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.model.DAO.EnderecoDAO;
import java.util.List;


public class EnderecoService {

    public static void criar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.create(objeto);
    }

    public static Endereco buscar(int codigo) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrive(codigo);
    }

    public static Endereco buscar(String descricao) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrive(descricao);    
    }

    public static List<Endereco> buscar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrive();   
    }

    public static void atualizar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(objeto);   
    }

    public static void excluir(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(objeto);   
    }
    
}
