
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.CondicaoPagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CondicaoPgtoDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.CondicaoPagamento>{

        //Novo ---------------------------
    private static CondicaoPgtoDAO instance;
    protected EntityManager entityManager;
    
    public static CondicaoPgtoDAO getInstance() {
        if (instance == null) {
            instance = new CondicaoPgtoDAO();
        }
        
        return instance;
    }

    private CondicaoPgtoDAO() {
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
    public void create(CondicaoPagamento objeto) {
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
    public CondicaoPagamento retrive(int codigo) {
        return entityManager.find(CondicaoPagamento.class, codigo);
    }

    @Override
    public CondicaoPagamento retrive(String descricao) {
        CondicaoPagamento condicaoPgto = entityManager.createQuery("SELECT cp FROM CondicaoPagamento cp WHERE cp.descricaoCondicao = :parDescricao", CondicaoPagamento.class).setParameter("parDescricao", descricao).getSingleResult();

        return condicaoPgto;
    }

    @Override
    public List<CondicaoPagamento> retrive() {
        List<CondicaoPagamento> condicoesPgto;
            
        condicoesPgto = entityManager.createQuery("SELECT cp FROM CondicaoPagamento cp", CondicaoPagamento.class).getResultList();
        
        return condicoesPgto;
    }

    @Override
    public void update(CondicaoPagamento objeto) {
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
    public void delete(CondicaoPagamento objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(CondicaoPagamento.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
