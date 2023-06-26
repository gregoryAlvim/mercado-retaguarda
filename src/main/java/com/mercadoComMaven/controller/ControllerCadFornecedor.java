package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.modelBO.Fornecedor;
import com.mercadoComMaven.view.FormBuscaEndereco;
import com.mercadoComMaven.view.FormBuscaFornecedor;
import com.mercadoComMaven.view.ViewCadastroFornecedor;
import com.mercadoComMaven.service.EnderecoService;
import com.mercadoComMaven.service.FornecedorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;



public class ControllerCadFornecedor implements ActionListener {
    ViewCadastroFornecedor telaFornecedor;  
    
    public static int codigo;
    
    public static String endereco;
    
    private static Endereco enderecoLocal;
        
    public ControllerCadFornecedor(ViewCadastroFornecedor telaFornecedor){
        
        this.telaFornecedor = telaFornecedor;
        
        telaFornecedor.getNovo().addActionListener(this);
        telaFornecedor.getCancelar().addActionListener(this);
        telaFornecedor.getGravar().addActionListener(this);
        telaFornecedor.getBuscar().addActionListener(this);
        telaFornecedor.getSair().addActionListener(this);
        telaFornecedor.getBotaoBuscarEndereco().addActionListener(this);
        
        utilities.Utils.ativa(true, telaFornecedor.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaFornecedor.getPainelDados());
        
        this.enableDisable(false);

    }
    
    public void validarEndereco(String enderecoParam) {
        if(enderecoParam.equalsIgnoreCase("")){
            endereco = this.telaFornecedor.getTextoEndereco().getText();
        }
                
        enderecoLocal = new Endereco();
        enderecoLocal = EnderecoService.buscar(endereco);
 
        telaFornecedor.getTextoEndereco().setText(enderecoLocal.getCep());
        
    }
    
    public void enableDisable(boolean estado){
        telaFornecedor.getComboBoxStatus().setEnabled(estado);
        telaFornecedor.getTextoCnpj().setEnabled(estado);
        telaFornecedor.getTextoContato().setEnabled(estado);
        telaFornecedor.getTextoCpf().setEnabled(estado);
        telaFornecedor.getTextoEmail().setEnabled(estado);
        telaFornecedor.getTextoInsc().setEnabled(estado);
        telaFornecedor.getTextoNome().setEnabled(estado);
        telaFornecedor.getTextoRazao().setEnabled(estado);
        telaFornecedor.getTextoRg().setEnabled(estado);
        telaFornecedor.getBotaoBuscarEndereco().setEnabled(estado);
        telaFornecedor.getTextoComplemento().setEnabled(estado);
        telaFornecedor.getTextoTelefone1().setEnabled(estado);
        telaFornecedor.getTextoTelefone2().setEnabled(estado);
        telaFornecedor.getTextoObservacao().setEnabled(estado);
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == telaFornecedor.getNovo()){
            
            utilities.Utils.ativa(false, telaFornecedor.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaFornecedor.getPainelDados());
            
            telaFornecedor.getTextoNome().requestFocus();
            
            telaFornecedor.getTextoId().setText("");
            telaFornecedor.getTextoRg().setText("");
            telaFornecedor.getTextoNome().setText("");
            telaFornecedor.getTextoContato().setText("");
            telaFornecedor.getTextoInsc().setText("");
            telaFornecedor.getTextoCpf().setText("");
            telaFornecedor.getTextoRazao().setText("");
            telaFornecedor.getTextoCnpj().setText("");
            telaFornecedor.getTextoEmail().setText("");
            telaFornecedor.getTextoTelefone1().setText("");
            telaFornecedor.getTextoTelefone2().setText("");
            telaFornecedor.getTextoComplemento().setText("");
            telaFornecedor.getTextoObservacao().setText("");
            telaFornecedor.getTextoEndereco().setText("");
            telaFornecedor.getComboBoxStatus().setSelectedIndex(0);
            
            this.enableDisable(true);

        }else if(acao.getSource() == telaFornecedor.getCancelar()){
            utilities.Utils.ativa(true, telaFornecedor.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaFornecedor.getPainelDados());
            
            this.enableDisable(false);
        
        }else if(acao.getSource() == telaFornecedor.getBuscar()){
            
             this.codigo = 0;
            
            FormBuscaFornecedor telaBuscaFornecedor = new FormBuscaFornecedor(telaFornecedor, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor= new ControllerBuscaFornecedor(telaBuscaFornecedor);
            controllerBuscaFornecedor.quemChamou = "FORNECEDOR";
            telaBuscaFornecedor.setVisible(true);
            
            if(codigo != 0){
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = FornecedorService.buscar(codigo);
                
                //JOptionPane.showMessageDialog(null, produto.toString());
                
                utilities.Utils.ativa(false, telaFornecedor.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaFornecedor.getPainelDados());
                
                telaFornecedor.getTextoId().setText(fornecedor.getId() + "");
                
                telaFornecedor.getTextoRg().setText(fornecedor.getRg());
                telaFornecedor.getTextoNome().setText(fornecedor.getNome());
                telaFornecedor.getTextoContato().setText(fornecedor.getContato());
                telaFornecedor.getTextoInsc().setText(fornecedor.getInscEstadual());
                telaFornecedor.getTextoCpf().setText(fornecedor.getCpf());
                telaFornecedor.getTextoRazao().setText(fornecedor.getRazaoSocial());
                telaFornecedor.getTextoCnpj().setText(fornecedor.getCnpj());
                telaFornecedor.getTextoEmail().setText(fornecedor.getEmail());
                telaFornecedor.getTextoTelefone1().setText(fornecedor.getFone1());
                telaFornecedor.getTextoTelefone2().setText(fornecedor.getFone2());
                telaFornecedor.getTextoComplemento().setText(fornecedor.getComplementoEndereco());
                telaFornecedor.getTextoObservacao().setText(fornecedor.getObservacao());
                telaFornecedor.getTextoEndereco().setText(fornecedor.getEndereco().getCep());
                
                
                enderecoLocal = fornecedor.getEndereco();

                if(fornecedor.getStatus().equals("1")){
                    telaFornecedor.getComboBoxStatus().setSelectedIndex(0);
                }else{
                    telaFornecedor.getComboBoxStatus().setSelectedIndex(1);
                }
                
                
                this.enableDisable(true);
            }
            
        }else if(acao.getSource() == telaFornecedor.getGravar()){
            if(telaFornecedor.getTextoRg().getText().trim().equalsIgnoreCase("") || 
               telaFornecedor.getTextoCpf().getText().trim().equalsIgnoreCase("") || 
               telaFornecedor.getTextoNome().getText().trim().equalsIgnoreCase("") ||
               telaFornecedor.getTextoCnpj().getText().trim().equalsIgnoreCase("") ||
               telaFornecedor.getTextoEndereco().getText().trim().equalsIgnoreCase("") ||
               telaFornecedor.getTextoInsc().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Há campos obrigatórios não preenchidos");
            }else{
                
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setNome(telaFornecedor.getTextoNome().getText());
                fornecedor.setContato(telaFornecedor.getTextoContato().getText());
                fornecedor.setInscEstadual(telaFornecedor.getTextoInsc().getText());
                fornecedor.setCpf(telaFornecedor.getTextoCpf().getText());
                fornecedor.setEmail(telaFornecedor.getTextoEmail().getText());
                fornecedor.setRazaoSocial(telaFornecedor.getTextoRazao().getText());
                fornecedor.setCnpj(telaFornecedor.getTextoCnpj().getText());
                fornecedor.setRg(telaFornecedor.getTextoRg().getText());     
                fornecedor.setFone1(telaFornecedor.getTextoTelefone1().getText());     
                fornecedor.setFone2(telaFornecedor.getTextoTelefone2().getText());     
                fornecedor.setComplementoEndereco(telaFornecedor.getTextoComplemento().getText());     
                fornecedor.setObservacao(telaFornecedor.getTextoObservacao().getText());     
                
                 if (telaFornecedor.getComboBoxStatus().getSelectedIndex() == 0) {
                    fornecedor.setStatus("1");
                } else {
                    fornecedor.setStatus("0");
                }
                 
                Date data = new Date();
                fornecedor.setDataCadastro(data);
                
                fornecedor.setEndereco(enderecoLocal);
                
                if (telaFornecedor.getTextoId().getText().equalsIgnoreCase("")) {
                    FornecedorService.criar(fornecedor);
                } else {
                    fornecedor.setId(Integer.parseInt(telaFornecedor.getTextoId().getText()));
                    FornecedorService.atualizar(fornecedor);
                }
                
                utilities.Utils.ativa(true, telaFornecedor.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaFornecedor.getPainelDados());
                
               this.enableDisable(false);
            }
        
        }else if(acao.getSource() == telaFornecedor.getSair()){
            telaFornecedor.dispose();
                    
        } else if (acao.getSource() == telaFornecedor.getBotaoBuscarEndereco()) {
            this.codigo = 0;

            FormBuscaEndereco formBuscaEndereco = new FormBuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(formBuscaEndereco);
            controllerBuscaEndereco.quemChamou = "FORNECEDOR";
            formBuscaEndereco.setVisible(true);

            validarEndereco(endereco);
        }
        
    
    }
}
