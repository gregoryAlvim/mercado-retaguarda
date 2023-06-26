
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Classe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Classe>{

    @Override
    public void create(Classe objeto) {
Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO classe (descricao) VALUES (?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);    }

    @Override
    public Classe retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM classe WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            
            while(rst.next()) {
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return classe;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Classe retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM classe WHERE descricao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            
            while(rst.next()) {
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return classe;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Classe> retrive() {
Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM classe";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Classe> listaClasse = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Classe classe = new Classe();
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
                
                listaClasse.add(classe);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaClasse;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }    }

    @Override
    public void update(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE classe SET descricao = ? WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE classe WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }
    
}
