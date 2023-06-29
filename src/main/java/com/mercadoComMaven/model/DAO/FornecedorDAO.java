package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.modelBO.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecedorDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Fornecedor>{

    
        //Novo ---------------------------
    private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance() {
        if (instance == null) {
            instance = new FornecedorDAO();
        }
        
        return instance;
    }

    private FornecedorDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Mercado_PU");
        
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    //Novo ---------------------------
    
    @Override
    public void create(Fornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Fornecedor retrive(int codigo) {
        return entityManager.find(Fornecedor.class, codigo);   
    }

    @Override
    public Fornecedor retrive(String descricao) {
         Fornecedor fornecedor = entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.name = :parDescricao", Fornecedor.class).setParameter("parDescricao", descricao).getSingleResult();

        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrive() {
        List<Fornecedor> fornecedores;
            
        fornecedores = entityManager.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class).getResultList();
        
        return fornecedores;
    }

    @Override
    public void update(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }    

}
