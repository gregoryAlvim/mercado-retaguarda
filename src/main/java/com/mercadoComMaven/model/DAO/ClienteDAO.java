
package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Cliente;
import com.mercadoComMaven.modelBO.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Cliente>{

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cliente (endereco_id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, cpf, rg, dataNascimento, sexo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
            pstm.setString(10, objeto.getCpf());
            pstm.setString(11, objeto.getRg());
            pstm.setDate(12, new java.sql.Date(objeto.getDataNascimento().getTime()));
            pstm.setString(13, String.valueOf(objeto.getSexo()));
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Cliente retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, cpf, rg, dataNascimento, sexo FROM cliente WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            
            Cliente cliente = new Cliente();
            
            while(rst.next()) {
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDataCadastro(rst.getDate("dataCadastro"));
                cliente.setObservacao(rst.getString("observacao"));
                cliente.setStatus(rst.getString("status"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setDataNascimento(rst.getDate("dataNascimento"));
                
                String sexoString = rst.getString("sexo");
                char sexoChar = sexoString.charAt(0);
                cliente.setSexo(sexoChar);
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                cliente.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cliente;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Cliente retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, cpf, rg, dataNascimento, sexo FROM cliente WHERE nome = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            
            Cliente cliente = new Cliente();
            
            while(rst.next()) {
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDataCadastro(rst.getDate("dataCadastro"));
                cliente.setObservacao(rst.getString("observacao"));
                cliente.setStatus(rst.getString("status"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setDataNascimento(rst.getDate("dataNascimento"));
                
                String sexoString = rst.getString("sexo");
                char sexoChar = sexoString.charAt(0);
                cliente.setSexo(sexoChar);
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                cliente.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cliente;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Cliente> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT endereco_id, id, nome, fone1, fone2, complementoEndereco, email, dataCadastro, observacao, status, cpf, rg, dataNascimento, sexo FROM cliente";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Cliente> listaCliente = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rst.getInt("id"));
                cliente.setNome(rst.getString("nome"));
                cliente.setFone1(rst.getString("fone1"));
                cliente.setFone2(rst.getString("fone2"));
                cliente.setComplementoEndereco(rst.getString("complementoEndereco"));
                cliente.setEmail(rst.getString("email"));
                cliente.setDataCadastro(rst.getDate("dataCadastro"));
                cliente.setObservacao(rst.getString("observacao"));
                cliente.setStatus(rst.getString("status"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setRg(rst.getString("rg"));
                cliente.setDataNascimento(rst.getDate("dataNascimento"));
                
                String sexoString = rst.getString("sexo");
                char sexoChar = sexoString.charAt(0);
                cliente.setSexo(sexoChar);
                
                Endereco endereco = new Endereco();
                EnderecoDAO  enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                cliente.setEndereco(endereco);
                
                listaCliente.add(cliente);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            
            return listaCliente;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE cliente SET endereco_id = ?, nome = ?, fone1 = ?, fone2 = ?, complementoEndereco = ?, email = ?, dataCadastro = ?, observacao = ?, status = ?, cpf = ?, rg = ?, dataNascimento = ?, sexo = ? WHERE id = ?";
        
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
            pstm.setString(10, objeto.getCpf());
            pstm.setString(11, objeto.getRg());
            pstm.setDate(12, new java.sql.Date(objeto.getDataNascimento().getTime()));
            pstm.setString(13, String.valueOf(objeto.getSexo()));
            pstm.setInt(14, objeto.getId());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cliente WHERE id = ?";
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
