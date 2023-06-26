
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Classe;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClasseDAO implements InterfaceDAO<Classe>{
    
    private static ClasseDAO instance;
    protected EntityManager entityManager;
    
    public static ClasseDAO getInstance() {
        if (instance == null) {
            instance = new ClasseDAO();
        }
        
        return instance;
    }
    
    private ClasseDAO() {
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
    public void create(Classe objeto) {
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
    public Classe retrive(int codigo) {
        return entityManager.find(Classe.class, codigo);
    }

    @Override
    public Classe retrive(String descricao) {
        Classe classe = entityManager.createQuery("SELECT c FROM Classe c WHERE c.descricao = :parDescricao", Classe.class).setParameter("parDescricao", descricao).getSingleResult();

        return classe;
    }

    @Override
    public List<Classe> retrive() {
        List<Classe> classes;
            
        classes = entityManager.createQuery("SELECT c FROM Classe c", Classe.class).getResultList();
        
        return classes;
    }
    
    @Override
    public void update(Classe objeto) {
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
    public void delete(Classe objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Classe.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
