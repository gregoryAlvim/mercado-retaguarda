
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.modelBO.Pagar;
import com.mercadoComMaven.modelBO.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ProdutoDAO implements InterfaceDAO<Produto> {

    private static ProdutoDAO instance;
    protected EntityManager entityManager;
    
    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        
        return instance;
    }

    private ProdutoDAO() {
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
    public void create(Produto objeto) {
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
    public Produto retrive(int codigo) {
        return entityManager.find(Produto.class, codigo);
    }

    @Override
    public Produto retrive(String descricao) {
        Produto produto = entityManager.createQuery("SELECT p FROM Produto p WHERE p.descruicao = :parDesc", Produto.class).setParameter("parDesc", descricao).getSingleResult();

        return produto;
    }

    @Override
    public List<Produto> retrive() {
        List<Produto> produtos;
            
        produtos = entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        
        return produtos;
    }

    @Override
    public void update(Produto objeto) {
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
    public void delete(Produto objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Produto.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
