
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
import javax.swing.JOptionPane;

public class ProdutoDAO implements InterfaceDAO<com.mercadoComMaven.modelBO.Produto> {

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO produto (descricao, valorCompra, valorVenda, "
                + "unidadeCompra, unidadeVenda, fatorConversao, dataCadastro, "
                + "status, barraEntrada, barraSaida, estoqueMinimo, estoqueMaximo, classe_id, marca_id) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValorCompra());
            pstm.setFloat(3, objeto.getValorVenda());
            pstm.setString(4, objeto.getUndCompra());
            pstm.setString(5, objeto.getUndVenda());
            pstm.setInt(6, objeto.getFatorConversao());
            pstm.setDate(7, new java.sql.Date(objeto.getDataCadastro().getTime()));
            pstm.setString(8, objeto.getStatus());
            pstm.setString(9, objeto.getBarraEntrada());
            pstm.setString(10, objeto.getBarraSaida());
            pstm.setFloat(11, objeto.getEstoqueMinimo());
            pstm.setFloat(12, objeto.getEstoqueMaximo());
            pstm.setInt(13, objeto.getClasse().getId());
            pstm.setInt(14, objeto.getMarca().getId());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Produto retrive(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao, valorCompra, valorVenda, "
                + "unidadeCompra, unidadeVenda, fatorConversao, dataCadastro, "
                + "status, barraEntrada, barraSaida, estoqueMinimo, estoqueMaximo, classe_id, marca_id FROM produto WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Produto produto = new Produto();
            
            while(rst.next()) {
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setValorCompra(rst.getFloat("valorCompra"));
                produto.setValorVenda(rst.getFloat("valorVenda"));
                produto.setUndCompra(rst.getString("unidadeCompra"));
                produto.setUndVenda(rst.getString("unidadeVenda"));
                produto.setBarraSaida(rst.getString("barraSaida"));
                produto.setBarraEntrada(rst.getString("barraEntrada"));
                produto.setFatorConversao(rst.getInt("fatorConversao"));
                produto.setEstoqueMinimo(rst.getInt("estoqueMinimo"));
                produto.setEstoqueMaximo(rst.getInt("estoqueMaximo"));
                produto.setDataCadastro(rst.getDate("dataCadastro"));
                produto.setStatus(rst.getString("status"));
                
                
                Marca marca = new Marca();
                marca = MarcaDAO.getInstance().retrive(rst.getInt("marca_id"));         
                produto.setMarca(marca);
                
                Classe classe = new Classe();
                ClasseDAO classeDAO = ClasseDAO.getInstance();
                classe = classeDAO.retrive(rst.getInt("classe_id"));
                produto.setClasse(classe);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Produto retrive(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao, valorCompra, valorVenda, "
                + "unidadeCompra, unidadeVenda, fatorConversao, dataCadastro, "
                + "status, barraEntrada, barraSaida, estoqueMinimo, estoqueMaximo, classe_id, marca_id FROM produto WHERE descricao = descricao";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Produto produto = new Produto();
            
            while(rst.next()) {
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setValorCompra(rst.getFloat("valorCompra"));
                produto.setValorVenda(rst.getFloat("valorVenda"));
                produto.setUndCompra(rst.getString("unidadeCompra"));
                produto.setUndVenda(rst.getString("unidadeVenda"));
                produto.setBarraSaida(rst.getString("barraSaida"));
                produto.setBarraEntrada(rst.getString("barraEntrada"));
                produto.setFatorConversao(rst.getInt("fatorConversao"));
                produto.setEstoqueMinimo(rst.getInt("estoqueMinimo"));
                produto.setEstoqueMaximo(rst.getInt("estoqueMaximo"));
                produto.setDataCadastro(rst.getDate("dataCadastro"));
                produto.setStatus(rst.getString("status"));
                
                
                Marca marca = new Marca();
                marca = MarcaDAO.getInstance().retrive(rst.getInt("marca_id"));         
                produto.setMarca(marca);
                
                Classe classe = new Classe();
                ClasseDAO classeDAO = ClasseDAO.getInstance();
                classe = classeDAO.retrive(rst.getInt("classe_id"));
                produto.setClasse(classe);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return produto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }    }

    @Override
    public List<Produto> retrive() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao, valorCompra, valorVenda, "
                + "unidadeCompra, unidadeVenda, fatorConversao, dataCadastro, "
                + "status, barraEntrada, barraSaida, estoqueMinimo, estoqueMaximo, classe_id, marca_id FROM produto";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Produto> listaProduto = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()) {
                Produto produto = new Produto();
                
                produto.setId(rst.getInt("id"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setValorCompra(rst.getFloat("valorCompra"));
                produto.setValorVenda(rst.getFloat("valorVenda"));
                produto.setUndCompra(rst.getString("unidadeCompra"));
                produto.setUndVenda(rst.getString("unidadeVenda"));
                produto.setFatorConversao(rst.getInt("fatorConversao"));
                produto.setEstoqueMinimo(rst.getInt("estoqueMinimo"));
                produto.setEstoqueMaximo(rst.getInt("estoqueMaximo"));
                
                Marca marca = new Marca();
                marca = MarcaDAO.getInstance().retrive(rst.getInt("marca_id"));         
                produto.setMarca(marca);
                
                Classe classe = new Classe();
                ClasseDAO classeDAO = ClasseDAO.getInstance();
                classe = classeDAO.retrive(rst.getInt("classe_id"));
                produto.setClasse(classe);

                listaProduto.add(produto);
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaProduto;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE produto SET descricao = ?, valorCompra = ?, valorVenda = ?,"
                + "unidadeCompra = ?, unidadeVenda = ?, fatorConversao = ?,"
                + "status = ?, barraEntrada = ?, barraSaida = ?, estoqueMinimo = ?, estoqueMaximo = ?, classe_id = ?, marca_id = ? WHERE id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
                
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
           
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValorCompra());
            pstm.setFloat(3, objeto.getValorVenda());
            pstm.setString(4, objeto.getUndCompra());
            pstm.setString(5, objeto.getUndVenda());
            pstm.setInt(6, objeto.getFatorConversao());
            pstm.setString(7, objeto.getStatus());
            pstm.setString(8, objeto.getBarraEntrada());
            pstm.setString(9, objeto.getBarraSaida());
            pstm.setFloat(10, objeto.getEstoqueMinimo());
            pstm.setFloat(11, objeto.getEstoqueMaximo());
            pstm.setInt(12, objeto.getClasse().getId());
            pstm.setInt(13, objeto.getMarca().getId());
            pstm.setInt(14, objeto.getId());
            
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
        ConnectionFactory.closeConnection(conexao, pstm);

    }

    @Override
    public void delete(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM produto WHERE id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);    }
    
}
