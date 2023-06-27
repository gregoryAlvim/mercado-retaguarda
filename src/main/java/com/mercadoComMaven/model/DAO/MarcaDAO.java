package com.mercadoComMaven.model.DAO;
import com.mercadoComMaven.modelBO.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaDAO implements InterfaceDAO<Marca>{
    
    private static MarcaDAO instance;
    protected EntityManager entityManager;
    
    public static MarcaDAO getInstance() {
        if (instance == null) {
            instance = new MarcaDAO();
        }
        
        return instance;
    }

    private MarcaDAO() {
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
    public void create(Marca objeto) {
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
    public Marca retrive(int codigo) {
        return entityManager.find(Marca.class, codigo);
    }

    @Override
    public Marca retrive(String descricao) {
        Marca marca = entityManager.createQuery("SELECT m FROM Marca m WHERE m.descricao = :parDescricao", Marca.class).setParameter("parDescricao", descricao).getSingleResult();

        return marca;
    }

    @Override
    public List<Marca> retrive() {
        List<Marca> marcas;
            
        marcas = entityManager.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
        
        return marcas;
    }

    @Override
    public void update(Marca objeto) {
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
    public void delete(Marca objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Marca.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
