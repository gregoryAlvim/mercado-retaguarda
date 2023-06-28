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
    public Colaborador retrive(int codigo) {
        return entityManager.find(Colaborador.class, codigo);
    }

    @Override
    public Colaborador retrive(String descricao) {
        Colaborador colaborador = entityManager.createQuery("SELECT c FROM Colaborador c WHERE c.descricao = :parDesc", Colaborador.class).setParameter("parDesc", descricao).getSingleResult();

        return colaborador;
    }
    @Override
    public List<Colaborador> retrive() {
        List<Colaborador> colaboradores;
            
        colaboradores = entityManager.createQuery("SELECT c FROM EnderecoColaborador c", Colaborador.class).getResultList();
        
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
