package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CidadeDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Cidade> {

    //Novo ---------------------------
    private static CidadeDAO instance;
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance() {
        if (instance == null) {
            instance = new CidadeDAO();
        }
        
        return instance;
    }

    private CidadeDAO() {
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
    public void create(Cidade objeto) {
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
    public Cidade retrive(int codigo) {
        return entityManager.find(Cidade.class, codigo);
    }

    @Override
    public Cidade retrive(String descricao) {
        Cidade cidade = entityManager.createQuery("SELECT c FROM Cidade c WHERE c.descricao = :parDescricao", Cidade.class).setParameter("parDescricao", descricao).getSingleResult();

        return cidade;
    }

    @Override
    public List<Cidade> retrive() {
        List<Cidade> cidades;
            
        cidades = entityManager.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
        
        return cidades;
    }

    @Override
    public void update(Cidade objeto) {
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
    public void delete(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Cidade.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
