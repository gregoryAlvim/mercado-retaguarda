package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.modelBO.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Colaborador>{

    @Override
    public void create(Colaborador objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO colaborador (endereco_id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, login, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getEndereco().getId());
            pstm.setString(2, objeto.getNome());
            pstm.setString(3, objeto.getFone1());
            pstm.setString(4, objeto.getFone2());
            pstm.setString(5, objeto.getComplementoEndereco());
            pstm.setString(6, objeto.getEmail());
            pstm.setDate(7, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(8, objeto.getObservacao());
            pstm.setString(9, objeto.getStatus());
            pstm.setString(10, objeto.getLogin());
            pstm.setString(11, objeto.getSenha());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Colaborador retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, login, senha FROM colaborador WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            
            Colaborador colaborador = new Colaborador();
            
            while(rst.next()) {
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));
                colaborador.setFone1(rst.getString("fone1"));
                colaborador.setFone2(rst.getString("fone2"));
                colaborador.setComplementoEndereco(rst.getString("complementoEndereco"));
                colaborador.setEmail(rst.getString("email"));
                colaborador.setDataCadastro(rst.getDate("dataCadastro"));
                colaborador.setObservacao(rst.getString("observacao"));
                colaborador.setStatus(rst.getString("status"));
                colaborador.setLogin(rst.getString("login"));
                colaborador.setSenha(rst.getString("senha"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                colaborador.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return colaborador;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Colaborador retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, login, senha FROM colaborador WHERE nome = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            
            Colaborador colaborador = new Colaborador();
            
            while(rst.next()) {
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));
                colaborador.setFone1(rst.getString("fone1"));
                colaborador.setFone2(rst.getString("fone2"));
                colaborador.setComplementoEndereco(rst.getString("complementoEndereco"));
                colaborador.setEmail(rst.getString("email"));
                colaborador.setDataCadastro(rst.getDate("dataCadastro"));
                colaborador.setObservacao(rst.getString("observacao"));
                colaborador.setStatus(rst.getString("status"));
                colaborador.setLogin(rst.getString("login"));
                colaborador.setSenha(rst.getString("senha"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                colaborador.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return colaborador;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Colaborador> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, login, senha FROM colaborador";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Colaborador> listaColaborador = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Colaborador colaborador = new Colaborador();
                
                colaborador.setId(rst.getInt("id"));
                colaborador.setNome(rst.getString("nome"));
                colaborador.setFone1(rst.getString("fone1"));
                colaborador.setFone2(rst.getString("fone2"));
                colaborador.setComplementoEndereco(rst.getString("complementoEndereco"));
                colaborador.setEmail(rst.getString("email"));
                colaborador.setDataCadastro(rst.getDate("dataCadastro"));
                colaborador.setObservacao(rst.getString("observacao"));
                colaborador.setStatus(rst.getString("status"));
                colaborador.setLogin(rst.getString("login"));
                colaborador.setSenha(rst.getString("senha"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                colaborador.setEndereco(endereco);
                
                listaColaborador.add(colaborador);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaColaborador;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Colaborador objeto) {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE colaborador SET endereco_id = ?, nome = ?, fone1 = ?, fone2 = ?, complementoEndereco = ?, email = ?, dataCadastro = ?, observacao = ?, status = ?, login = ?, senha = ? WHERE id = ?";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getEndereco().getId());
            pstm.setString(2, objeto.getNome());
            pstm.setString(3, objeto.getFone1());
            pstm.setString(4, objeto.getFone2());
            pstm.setString(5, objeto.getComplementoEndereco());
            pstm.setString(6, objeto.getEmail());
            pstm.setDate(7, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(8, objeto.getObservacao());
            pstm.setString(9, objeto.getStatus());
            pstm.setString(10, objeto.getLogin());
            pstm.setString(11, objeto.getSenha());
            pstm.setInt(12, objeto.getId());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Colaborador objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM colaborador WHERE id = ?";
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
