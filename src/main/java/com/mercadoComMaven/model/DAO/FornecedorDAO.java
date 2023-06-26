package com.mercadoComMaven.model.DAO;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.modelBO.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO fornecedor (nome, email, inscricaoEstadual, cpf, rg, cnpj, " + 
                "razaoSocial, contato, fone1, fone2, complementoEndereco, observacao, dataCadastro, status, endereco_id)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getEmail());
            pstm.setString(3, objeto.getInscEstadual());
            pstm.setString(4, objeto.getCpf());
            pstm.setString(5, objeto.getRg());
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getRazaoSocial());
            pstm.setString(8, objeto.getContato());
            pstm.setString(9, objeto.getFone1());
            pstm.setString(10, objeto.getFone2());
            pstm.setString(11, objeto.getComplementoEndereco());
            pstm.setString(12, objeto.getObservacao());
            pstm.setDate(13, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(14, objeto.getStatus());
            pstm.setInt(15, objeto.getEndereco().getId());
            
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Fornecedor retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, nome, email, inscricaoEstadual, cpf, rg, cnpj, " 
                + "razaoSocial, contato, fone1, fone2, complementoEndereco, observacao, "
                + "dataCadastro, status, endereco_id FROM fornecedor WHERE id = ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Fornecedor fornecedor = new Fornecedor();
            
            while(rst.next()) {
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setInscEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setCpf(rst.getString("cpf"));
                fornecedor.setRg(rst.getString("rg"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedor.setContato(rst.getString("contato"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setObservacao(rst.getString("observacao"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setDataCadastro(rst.getDate("dataCadastro"));
                fornecedor.setStatus(rst.getString("status"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                fornecedor.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
        
    }

    @Override
    public Fornecedor retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, nome, email, inscricaoEstadual, cpf, rg, cnpj, " 
                + "razaoSocial, contato, fone1, fone2, complementoEndereco, observacao, "
                + "dataCadastro, status, endereco_id FROM fornecedor WHERE descricao = ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Fornecedor fornecedor = new Fornecedor();
            
            while(rst.next()) {
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setInscEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setCpf(rst.getString("cpf"));
                fornecedor.setRg(rst.getString("rg"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedor.setContato(rst.getString("contato"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setObservacao(rst.getString("observacao"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setDataCadastro(rst.getDate("dataCadastro"));
                fornecedor.setStatus(rst.getString("status"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                fornecedor.setEndereco(endereco);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
        
    }

    @Override
    public List<Fornecedor> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, nome, email, inscricaoEstadual, cpf, rg, cnpj, " 
                + "razaoSocial, contato, fone1, fone2, complementoEndereco, observacao, "
                + "dataCadastro, status, endereco_id FROM fornecedor";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Fornecedor fornecedor = new Fornecedor();
           
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setInscEstadual(rst.getString("inscricaoEstadual"));
                fornecedor.setCpf(rst.getString("cpf"));
                fornecedor.setRg(rst.getString("rg"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setRazaoSocial(rst.getString("razaoSocial"));
                fornecedor.setContato(rst.getString("contato"));
                fornecedor.setFone1(rst.getString("fone1"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setObservacao(rst.getString("observacao"));
                fornecedor.setComplementoEndereco(rst.getString("complementoEndereco"));
                fornecedor.setDataCadastro(rst.getDate("dataCadastro"));
                fornecedor.setStatus(rst.getString("status"));
                
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrive(rst.getInt("endereco_id"));
                fornecedor.setEndereco(endereco);
                
                listaFornecedor.add(fornecedor);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE fornecedor SET nome = ?, email = ?, inscricaoEstadual = ?, cpf = ?, rg = ?, cnpj = ?, "
                + "razaoSocial = ?, contato = ?, fone1 = ?, fone2 = ?, complementoEndereco = ?, observacao = ?, dataCadastro = ?, status = ?, endereco_id = ? WHERE id = ?"; 
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getEmail());
            pstm.setString(3, objeto.getInscEstadual());
            pstm.setString(4, objeto.getCpf());
            pstm.setString(5, objeto.getRg());
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getRazaoSocial());
            pstm.setString(8, objeto.getContato());
            pstm.setString(9, objeto.getFone1());
            pstm.setString(10, objeto.getFone2());
            pstm.setString(11, objeto.getComplementoEndereco());
            pstm.setString(12, objeto.getObservacao());
            pstm.setDate(13, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(14, objeto.getStatus());
            pstm.setInt(15, objeto.getEndereco().getId());
            pstm.setInt(16, objeto.getId());
            
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM fornecedor WHERE id = ?";
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
