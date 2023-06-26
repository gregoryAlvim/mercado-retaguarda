package com.mercadoComMaven.service;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.model.DAO.EnderecoDAO;
import java.util.List;


public class EnderecoService {

    public static void criar(Endereco objeto) {
        EnderecoDAO.getInstance().create(objeto);
    }

    public static Endereco buscar(int codigo) {
        return EnderecoDAO.getInstance().retrive(codigo);
    }

    public static Endereco buscar(String descricao) {
        return EnderecoDAO.getInstance().retrive(descricao);       
    }

    public static List<Endereco> buscar() {
        return EnderecoDAO.getInstance().retrive(); 
    }

    public static void atualizar(Endereco objeto) {
        EnderecoDAO.getInstance().update(objeto);    
    }

    public static void excluir(Endereco objeto) {
        EnderecoDAO.getInstance().delete(objeto);  
    }
    
}
