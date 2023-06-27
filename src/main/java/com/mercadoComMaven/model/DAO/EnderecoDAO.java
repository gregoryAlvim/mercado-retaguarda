
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.modelBO.Cidade;
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
import javax.swing.JOptionPane;

public class EnderecoDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Endereco>{
    
    //Novo ---------------------------
    private static EnderecoDAO instance;
    protected EntityManager entityManager;
    
    public static EnderecoDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        
        return instance;
    }

    private EnderecoDAO() {
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
    public void create(Endereco objeto) {
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
    public Endereco retrive(int codigo) {
        return entityManager.find(Endereco.class, codigo);
    }

    @Override
    public Endereco retrive(String cep) {
        Endereco endereco = entityManager.createQuery("SELECT e FROM Endereco e WHERE e.logradouro = :parCep", Endereco.class).setParameter("parCep", cep).getSingleResult();

        return endereco;
    }

    @Override
    public List<Endereco> retrive() {
        List<Endereco> enderecos;
            
        enderecos = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        
        return enderecos;
    }

    @Override
    public void update(Endereco objeto) {
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
    public void delete(Endereco objeto) {  
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Endereco.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
