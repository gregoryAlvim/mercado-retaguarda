
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Cliente;
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

public class ClienteDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Cliente>{
    
    
    //Novo ---------------------------
    private static ClienteDAO instance;
    protected EntityManager entityManager;
    
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        
        return instance;
    }

    private ClienteDAO() {
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
    public void create(Cliente objeto) {
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
    public Cliente retrive(int codigo) {
        return entityManager.find(Cliente.class, codigo);
    }

    @Override
    public Cliente retrive(String descricao) {
        Cliente cliente = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome = :parDescricao", Cliente.class).setParameter("parDescricao", descricao).getSingleResult();

        return cliente;
    }

    @Override
    public List<Cliente> retrive() {
        List<Cliente> clientes;
            
        clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        
        return clientes;
    }

    @Override
    public void update(Cliente objeto) {
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
    public void delete(Cliente objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Cliente.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
