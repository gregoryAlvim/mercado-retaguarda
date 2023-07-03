package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.modelBO.Produto;
import com.mercadoComMaven.view.FormBuscaClasse;
import com.mercadoComMaven.view.FormBuscaMarca;
import com.mercadoComMaven.view.FormBuscaProduto;
import com.mercadoComMaven.view.ViewCadastroProduto;
import com.mercadoComMaven.service.ClasseService;
import com.mercadoComMaven.service.MarcaService;
import com.mercadoComMaven.service.ProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;



public class ControllerCadProduto implements ActionListener{
    ViewCadastroProduto telaProd = new ViewCadastroProduto();
    public static int codigo;
    
    public static String classe;
    public static String marca;
    
    private static Classe classeLocal;
    private static Marca marcaLocal;
   

    public ControllerCadProduto(ViewCadastroProduto telaProd) {
        this.telaProd = telaProd;
        
        telaProd.getNovo().addActionListener(this);
        telaProd.getCancelar().addActionListener(this);
        telaProd.getGravar().addActionListener(this);
        telaProd.getBuscar().addActionListener(this);
        telaProd.getSair().addActionListener(this);
        telaProd.getjButtonBuscarMarca().addActionListener(this);
        telaProd.getjButtonBuscarClasse().addActionListener(this);
        
        telaProd.getTextoMarca().setEnabled(false);
        telaProd.getTextoClasse().setEnabled(false);
        
        utilities.Utils.ativa(true, telaProd.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaProd.getPainelDados());
        this.enableDisable(false);
       
    }
    
    public void enableDisable(boolean estado){
        telaProd.getTextoDescricao().setEnabled(estado);
        telaProd.getTextoEstoqueMin().setEnabled(estado);
        telaProd.getTextoEstoqueMax().setEnabled(estado);
        telaProd.getTextoBarraEntrada().setEnabled(estado);
        telaProd.getTextoBarraSaida().setEnabled(estado);
        telaProd.getTextoFator().setEnabled(estado);
        telaProd.getTextoUnidadeCompra().setEnabled(estado);
        telaProd.getTextoUnidadeVenda().setEnabled(estado);
        telaProd.getTextoValorCompra().setEnabled(estado);
        telaProd.getTextoValorVenda().setEnabled(estado);
        telaProd.getComboStatus().setEnabled(estado);
        telaProd.getjButtonBuscarMarca().setEnabled(estado);
        telaProd.getjButtonBuscarClasse().setEnabled(estado);
    }
    
    public void validarClasse(String classeParam) {
        if(classeParam.equalsIgnoreCase("")){
           classe = this.telaProd.getTextoClasse().getText();
        }
        
        classeLocal = new Classe();
        classeLocal = ClasseService.buscar(classe);

        telaProd.getTextoClasse().setText(classeLocal.getDescricao());
    }
    
    public void validarMarca(String marcaParam) {
        if(marcaParam.equalsIgnoreCase("")){
             this.telaProd.getTextoMarca().getText();
        }
        
        marcaLocal = new Marca();
        marcaLocal = MarcaService.buscar(marca);

        telaProd.getTextoMarca().setText(marcaLocal.getDescricao());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == telaProd.getNovo()){
            utilities.Utils.ativa(false, telaProd.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaProd.getPainelDados());
            
            this.enableDisable(true);
            
            telaProd.getTextoDescricao().requestFocus();
            telaProd.getTextoDescricao().setText("");
            telaProd.getTextoEstoqueMin().setText("");
            telaProd.getTextoEstoqueMax().setText("");
            telaProd.getTextoBarraEntrada().setText("");
            telaProd.getTextoBarraSaida().setText("");
            telaProd.getTextoFator().setText("");
            telaProd.getTextoUnidadeCompra().setText("");
            telaProd.getTextoUnidadeVenda().setText("");
            telaProd.getTextoValorCompra().setText("");
            telaProd.getTextoValorVenda().setText("");
            telaProd.getComboStatus().setSelectedIndex(0);
            
        }else if(acao.getSource() == telaProd.getCancelar()){
            utilities.Utils.ativa(true, telaProd.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaProd.getPainelDados());
            this.enableDisable(false);
        
        }else if(acao.getSource() == telaProd.getBuscar()){
            
            this.codigo = 0;
        
            FormBuscaProduto telaBuscaProduto = new FormBuscaProduto(telaProd, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(telaBuscaProduto);
            telaBuscaProduto.setVisible(true);
            
            if(codigo != 0){
                
                Produto produto = new Produto();
                produto = ProdutoService.buscar(codigo);
                
                //JOptionPane.showMessageDialog(null, produto.toString());
                
                DecimalFormat df = new DecimalFormat("#.##"); 
                
                utilities.Utils.ativa(false, telaProd.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaProd.getPainelDados());
                
                telaProd.getjTextFieldId().setText(produto.getId() + "");
                                
                telaProd.getTextoDescricao().setText(produto.getDescricao());
                telaProd.getTextoValorCompra().setText(df.format(produto.getValorCompra()));
                telaProd.getTextoValorVenda().setText(df.format(produto.getValorVenda()));
                telaProd.getTextoUnidadeCompra().setText(produto.getUnidadeCompra());
                telaProd.getTextoUnidadeVenda().setText(produto.getUnidadeVenda());
                telaProd.getTextoBarraEntrada().setText(produto.getBarraEntrada());
                telaProd.getTextoBarraSaida().setText(produto.getBarraSaida());
                telaProd.getTextoEstoqueMin().setText(df.format(produto.getEstoqueMinimo()));
                telaProd.getTextoEstoqueMax().setText(df.format(produto.getEstoqueMaximo()));
                telaProd.getTextoFator().setText(Integer.toString(produto.getFatorConversao()));
                telaProd.getTextoClasse().setText(produto.getClasse().getDescricao());
                telaProd.getTextoMarca().setText(produto.getMarca().getDescricao());

                if(produto.getStatus().equals("1")) {
                    telaProd.getComboStatus().setSelectedIndex(0);
                }else{
                    telaProd.getComboStatus().setSelectedIndex(1);
                }
                
                this.enableDisable(true);
            }
            
        }else if(acao.getSource() == telaProd.getGravar()){

            if(telaProd.getTextoDescricao().getText().trim().equalsIgnoreCase("") || 
               telaProd.getTextoValorCompra().getText().trim().equalsIgnoreCase("") || 
               telaProd.getTextoValorVenda().getText().trim().equalsIgnoreCase("") ||
               telaProd.getTextoFator().getText().trim().equalsIgnoreCase("") ||
               telaProd.getTextoUnidadeCompra().getText().trim().equalsIgnoreCase("") ||
               telaProd.getTextoUnidadeVenda().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Há campos obrigatórios não preenchidos");
            }else{
                
                Produto produto = new Produto();
                produto.setDescricao(telaProd.getTextoDescricao().getText());
                produto.setUnidadeCompra(telaProd.getTextoUnidadeCompra().getText());
                produto.setUnidadeVenda(telaProd.getTextoUnidadeVenda().getText());
                produto.setBarraEntrada(telaProd.getTextoBarraEntrada().getText());
                produto.setBarraSaida(telaProd.getTextoBarraSaida().getText());
                
                marcaLocal = MarcaService.buscar(telaProd.getTextoMarca().getText());
                classeLocal = ClasseService.buscar(telaProd.getTextoClasse().getText());
                
                produto.setMarca(marcaLocal);
                produto.setClasse(classeLocal);
                
                if(telaProd.getComboStatus().getSelectedIndex() == 0){
                    produto.setStatus("1");
                }else{                   
                    produto.setStatus("0");
                }
                
                try {
                   float valorCompra = Float.parseFloat(telaProd.getTextoValorCompra().getText());
                   produto.setValorCompra(valorCompra);
                   
                   float valorVenda = Float.parseFloat(telaProd.getTextoValorVenda().getText());
                   produto.setValorVenda(valorVenda);
                   
                   float estoqueMin = Float.parseFloat(telaProd.getTextoEstoqueMin().getText());
                   produto.setEstoqueMinimo(estoqueMin);
                   
                   float estoqueMax = Float.parseFloat(telaProd.getTextoEstoqueMax().getText());
                   produto.setEstoqueMaximo(estoqueMax);
                   
                   int fator = Integer.parseInt(telaProd.getTextoFator().getText());
                   produto.setFatorConversao(fator);
                   
                } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "Valores de fator conversão, compra, venda e estoque devem ser numeros");
                }
              

                Date data = new Date();
                produto.setDataCadastro(data);
                                                                  
                if (telaProd.getjTextFieldId().getText().equalsIgnoreCase("")) {
                    ProdutoService.criar(produto);
                } else {
                    produto.setId(Integer.parseInt(telaProd.getjTextFieldId().getText()));
                    ProdutoService.atualizar(produto);
                }
                
                utilities.Utils.ativa(true, telaProd.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaProd.getPainelDados());

                this.enableDisable(false);
            }
        
        } else if (acao.getSource() == telaProd.getjButtonBuscarMarca()) {
            this.codigo = 0;

            FormBuscaMarca formBuscaMarca= new FormBuscaMarca(null, true);
            ControllerBuscaMarca controllerBuscaMarca= new ControllerBuscaMarca(formBuscaMarca);
            controllerBuscaMarca.quemChamou = "PRODUTO";
            formBuscaMarca.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            this.validarMarca(marca);
        } else if (acao.getSource() == telaProd.getjButtonBuscarClasse()) {
            this.codigo = 0;

            FormBuscaClasse formBuscaClasse = new FormBuscaClasse(null, true);
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(formBuscaClasse);
            controllerBuscaClasse.quemChamou = "PRODUTO";
            formBuscaClasse.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            this.validarClasse(classe);
        }else if(acao.getSource() == telaProd.getSair()){
            telaProd.dispose();
                    
        }
        
    
    }
    
}
