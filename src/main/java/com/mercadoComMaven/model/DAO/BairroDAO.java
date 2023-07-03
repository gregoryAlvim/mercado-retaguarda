package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Bairro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BairroDAO implements InterfaceDAO<Bairro> {
    
    //Novo ---------------------------
    private static BairroDAO instance;
    protected EntityManager entityManager;
    
    public static BairroDAO getInstance() {
        if (instance == null) {
            instance = new BairroDAO();
        }
        
        return instance;
    }

    private BairroDAO() {
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
    
    //Novo ---------------------------
    @Override
    public void create(Bairro objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    //Novo ---------------------------
    
    //Novo ---------------------------
    @Override
    public Bairro retrive(int codigo) {
        return entityManager.find(Bairro.class, codigo);
    }
    //Novo ---------------------------
    
    //Novo ---------------------------
    @Override
    public Bairro retrive(String descricao) {
        Bairro bairro = entityManager.createQuery("SELECT b FROM Bairro b WHERE b.descricao = :parDescricao", Bairro.class).setParameter("parDescricao", descricao).getSingleResult();

        return bairro;
    }
    //Novo ---------------------------
    
    //Novo ---------------------------
    @Override
    public List<Bairro> retrive() {
        List<Bairro> bairros;
            
        bairros = entityManager.createQuery("SELECT b FROM Bairro b", Bairro.class).getResultList();
        
        return bairros;
    }
    //Novo ---------------------------
    
    @Override
    public void update(Bairro objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();   
        }
    }
    
    //Novo ---------------------------
    @Override
    public void delete(Bairro objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Bairro.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
