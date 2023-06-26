
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.CondicaoPgto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CondicaoPgtoDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.CondicaoPgto>{

    @Override
    public void create(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO condicaopagamento (descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.setInt(2, objeto.getNumeroParcelas());
            pstm.setInt(3, objeto.getDiasPrimeiraParcela());
            pstm.setInt(4, objeto.getDiaEntreParcela());
            pstm.setString(5, objeto.getStatus());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public CondicaoPgto retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status FROM condicaopagamento WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();
            
            while(rst.next()) {
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("numeroParcelas"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiaEntreParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPgto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public CondicaoPgto retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status FROM condicaopagamento WHERE descricaoCondicao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();
            
            while(rst.next()) {
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("numeroParcelas"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiaEntreParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPgto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<CondicaoPgto> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status FROM condicaopagamento";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<CondicaoPgto> listaCondicaoPgto = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            
            while(rst.next()) {
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("numeroParcelas"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiaEntreParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status"));
                
                listaCondicaoPgto.add(condicaoPgto);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCondicaoPgto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE condicaopagamento SET descricaoCondicao = ?, numeroParcelas = ?, diasPrimeiraParcela = ?, diasEntreParcela = ?, status = ? WHERE id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.setInt(2, objeto.getNumeroParcelas());
            pstm.setInt(3, objeto.getDiasPrimeiraParcela());
            pstm.setInt(4, objeto.getDiaEntreParcela());
            pstm.setString(5, objeto.getStatus());
            pstm.setInt(6, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE condicaopagamento WHERE id = ?";
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
