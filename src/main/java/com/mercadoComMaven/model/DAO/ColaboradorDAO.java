package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.modelBO.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ColaboradorDAO implements InterfaceDAO<Colaborador>{
    
    private static ColaboradorDAO instance;
    protected EntityManager entityManager;
    
    public static ColaboradorDAO getInstance() {
        if (instance == null) {
            instance = new ColaboradorDAO();
        }
        
        return instance;
    }

    private ColaboradorDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Mercado_PU");
        
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }

    @Override
    public void create(Colaborador objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO colaborador (endereco_id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, login, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getEndereco().getId());
            pstm.setString(2, objeto.getNome());
            pstm.setString(3, objeto.getFone1());
            pstm.setString(4, objeto.getFone2());
            pstm.setString(5, objeto.getComplementoEndereco());
            pstm.setString(6, objeto.getEmail());
            pstm.setDate(7, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(8, objeto.getObservacao());
            pstm.setString(9, objeto.getStatus());
            pstm.setString(10, objeto.getLogin());
            pstm.setString(11, objeto.getSenha());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Colaborador retrive(int codigo) {
        return entityManager.find(Colaborador.class, codigo);
    }


    @Override
    public Colaborador retrive(String descricao) {
        Colaborador colaborador = entityManager.createQuery("SELECT c FROM Colaborador e WHERE c.descricao = :parDesc", Colaborador.class).setParameter("parDesc", descricao).getSingleResult();

        return colaborador;
    }

    @Override
    public List<Colaborador> retrive() {
        List<Colaborador> colaboradores;
            
        colaboradores = entityManager.createQuery("SELECT c FROM Colaborador c", Colaborador.class).getResultList();
        
        return colaboradores;
    }

    @Override
    public void update(Colaborador objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }

    @Override
    public void delete(Colaborador objeto) {  
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Colaborador.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
