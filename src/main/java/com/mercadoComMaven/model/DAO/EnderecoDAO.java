
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.modelBO.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EnderecoDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Endereco>{

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO endereco (cidade_id, bairro_id, logradouro, cep ) VALUES (?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getCidade().getId());
            pstm.setInt(2, objeto.getBairro().getId());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Endereco retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, logradouro, cep, cidade_id, bairro_id FROM endereco WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            
            Endereco endereco = new Endereco();
            
            while(rst.next()) {
                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setCep(rst.getString("cep"));
                
                Cidade cidade = new Cidade();
                CidadeDAO  cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrive(rst.getInt("cidade_id"));
                endereco.setCidade(cidade);
                
                Bairro bairro = new Bairro();
                BairroDAO  bairroDAO = BairroDAO.getInstance();
                bairro = bairroDAO.retrive(rst.getInt("bairro_id"));
                endereco.setBairro(bairro);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Endereco retrive(String cep) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, logradouro, cep, cidade_id, bairro_id FROM endereco WHERE logradouro = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, cep);
            rst = pstm.executeQuery();
            
            Endereco endereco = new Endereco();
            
            while(rst.next()) {
                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setCep(rst.getString("cep"));
                
                Cidade cidade = new Cidade();
                CidadeDAO  cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrive(rst.getInt("cidade_id"));
                endereco.setCidade(cidade);
                
                Bairro bairro = new Bairro();
                BairroDAO  bairroDAO = BairroDAO.getInstance();
                bairro = bairroDAO.retrive(rst.getInt("bairro_id"));
                endereco.setBairro(bairro);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Endereco> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, logradouro, cep, cidade_id, bairro_id FROM endereco";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Endereco> listaEndereco = new ArrayList<>(); 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while(rst.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rst.getInt("id"));
                endereco.setLogradouro(rst.getString("logradouro"));
                endereco.setCep(rst.getString("cep"));
                
                Cidade cidade = new Cidade();
                CidadeDAO  cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrive(rst.getInt("cidade_id"));
                endereco.setCidade(cidade);
                
                Bairro bairro = new Bairro();
                BairroDAO  bairroDAO = BairroDAO.getInstance();
                bairro = bairroDAO.retrive(rst.getInt("bairro_id"));
                endereco.setBairro(bairro);
                
                listaEndereco.add(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            
            return listaEndereco;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE endereco SET cidade_id = ?, bairro_id= ?, logradouro= ?, cep= ? WHERE id = ?";
        
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
                        
            pstm.setInt(1, objeto.getCidade().getId());
            pstm.setInt(2, objeto.getBairro().getId());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM endereco WHERE id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
    
}
