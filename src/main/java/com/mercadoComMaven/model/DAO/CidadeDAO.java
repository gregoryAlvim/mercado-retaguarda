package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Cidade> {

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cidade (descricao) VALUES (?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Cidade retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM cidade WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();
            
            while(rst.next()) {
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidade;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Cidade retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM cidade WHERE descricao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();
            
            while(rst.next()) {
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidade;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Cidade> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM cidade";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Cidade> listaCidade = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                
                listaCidade.add(cidade);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCidade;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE cidade SET descricao = ? WHERE id = ?";
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
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE cidade WHERE id = ?";
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
