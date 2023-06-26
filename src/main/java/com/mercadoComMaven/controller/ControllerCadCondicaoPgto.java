package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.CondicaoPgto;
import com.mercadoComMaven.view.FormBuscaCondicaoPgto;
import com.mercadoComMaven.view.ViewCadastroCondicaoPgto;
import com.mercadoComMaven.service.CondicaoPgtoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControllerCadCondicaoPgto implements ActionListener {

    ViewCadastroCondicaoPgto telaCondicaoPgto;
    public static int codigo;
    
    public void enableDisable(boolean estado) {;
        telaCondicaoPgto.getjTextFieldDescricao().setEnabled(estado);
        telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setEnabled(estado);
        telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setEnabled(estado);
        telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setEnabled(estado);
        telaCondicaoPgto.getjComboBoxStatus().setEnabled(estado);
    }
    
    public ControllerCadCondicaoPgto(ViewCadastroCondicaoPgto telaCondicaoPgto) {
        
        this.telaCondicaoPgto = telaCondicaoPgto;
        
        telaCondicaoPgto.getNovo().addActionListener(this);
        telaCondicaoPgto.getCancelar().addActionListener(this);
        telaCondicaoPgto.getGravar().addActionListener(this);
        telaCondicaoPgto.getBuscar().addActionListener(this);
        telaCondicaoPgto.getSair().addActionListener(this);
        
        utilities.Utils.ativa(true, telaCondicaoPgto.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaCondicaoPgto.getPainelDados());
        
        enableDisable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCondicaoPgto.getNovo()) {
            utilities.Utils.ativa(false, telaCondicaoPgto.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaCondicaoPgto.getPainelDados());
            
            telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setEnabled(true);
            telaCondicaoPgto.getjTextFieldDescricao().setEnabled(true);
            telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setEnabled(true);
            telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setEnabled(true);
            telaCondicaoPgto.getjComboBoxStatus().setEnabled(true);
            
            telaCondicaoPgto.getjTextFieldDescricao().requestFocus();
            
            telaCondicaoPgto.getjTextFieldDescricao().setText("");
            telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setValue(0);
            telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(0);
            
        } else if (acao.getSource() == telaCondicaoPgto.getCancelar()) {
            utilities.Utils.ativa(true, telaCondicaoPgto.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaCondicaoPgto.getPainelDados());
            
            telaCondicaoPgto.getjTextFieldDescricao().setText("");
            telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setValue(0);
            telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(0);
            
            telaCondicaoPgto.getjTextFieldId().setText("");
            telaCondicaoPgto.getjTextFieldDescricao().setText("");
            telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setValue(0);
            telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setValue(0);
            telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(0);
            
            enableDisable(false);
            
        } else if (acao.getSource() == telaCondicaoPgto.getBuscar()) {
            
            this.codigo = 0;
            
            FormBuscaCondicaoPgto telaBuscaPgto = new FormBuscaCondicaoPgto(telaCondicaoPgto, true);
            ControllerBuscaCondicaoPgto controllerBuscaPgto = new ControllerBuscaCondicaoPgto(telaBuscaPgto);
            telaBuscaPgto.setVisible(true);
            
            if(codigo != 0){
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                condicaoPgto = CondicaoPgtoService.buscar(codigo);
                
                utilities.Utils.ativa(false, telaCondicaoPgto.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCondicaoPgto.getPainelDados());
                
                telaCondicaoPgto.getjTextFieldId().setText(condicaoPgto.getId() + "");
                telaCondicaoPgto.getjTextFieldDescricao().setText(condicaoPgto.getDescricaoCondicao());
                telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setValue(condicaoPgto.getNumeroParcelas());
                telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setValue(condicaoPgto.getDiasPrimeiraParcela());
                telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setValue(condicaoPgto.getDiaEntreParcela());
                
                if (condicaoPgto.getStatus().equals("1")) {
                    telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(0);
                } else {
                    telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(1);
                }
                
                telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setEnabled(true);
                telaCondicaoPgto.getjTextFieldDescricao().setEnabled(true);
                telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setEnabled(true);
                telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setEnabled(true);
                telaCondicaoPgto.getjComboBoxStatus().setEnabled(true);
            }
        
        } else if (acao.getSource() == telaCondicaoPgto.getGravar()) {
             
            if (telaCondicaoPgto.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else if (telaCondicaoPgto.getjSpinnerQuantidadeParcelas().getValue().equals(null)) {
                JOptionPane.showMessageDialog(null, "Atributo Quantidade de Parcelas é Obrigatório");
            } else if (telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().getValue().equals(null)) {
                JOptionPane.showMessageDialog(null, "Atributo Dias (Primeiras parcela) é Obrigatório");
            } else if (telaCondicaoPgto.getjSpinnerDiasEntreParcelas().getValue().equals(null)) {
                JOptionPane.showMessageDialog(null, "Atributo Dias (Entre parcelas) é Obrigatório");
            } else {
                
                CondicaoPgto condicaoPgto = new CondicaoPgto();
              
                condicaoPgto.setDescricaoCondicao(telaCondicaoPgto.getjTextFieldDescricao().getText());
                
                try{
                    condicaoPgto.setNumeroParcelas((int) telaCondicaoPgto.getjSpinnerQuantidadeParcelas().getValue());
                    condicaoPgto.setDiasPrimeiraParcela((int) telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().getValue());
                    condicaoPgto.setDiaEntreParcela((int) telaCondicaoPgto.getjSpinnerDiasEntreParcelas().getValue());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Houive um erro nas parcelas");
                }
                
                if(telaCondicaoPgto.getjComboBoxStatus().getSelectedIndex() == 0){
                    condicaoPgto.setStatus("1");
                }else{                   
                    condicaoPgto.setStatus("0");
                }
                
                if (this.telaCondicaoPgto.getjTextFieldId().getText().equalsIgnoreCase("")) {
                    CondicaoPgtoService.criar(condicaoPgto);
                } else {
                    condicaoPgto.setId(Integer.parseInt(telaCondicaoPgto.getjTextFieldId().getText()));
                    CondicaoPgtoService.atualizar(condicaoPgto);  
                }
                
                utilities.Utils.ativa(true, telaCondicaoPgto.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCondicaoPgto.getPainelDados());
                
                enableDisable(false);
                
                telaCondicaoPgto.getjTextFieldId().setText("");
                telaCondicaoPgto.getjTextFieldDescricao().setText("");
                telaCondicaoPgto.getjSpinnerQuantidadeParcelas().setValue(0);
                telaCondicaoPgto.getjSpinnerDiasPrimeiraPercela().setValue(0);
                telaCondicaoPgto.getjSpinnerDiasEntreParcelas().setValue(0);
                telaCondicaoPgto.getjComboBoxStatus().setSelectedIndex(0);
            }
        } else if(acao.getSource() == telaCondicaoPgto.getSair()) {
            telaCondicaoPgto.dispose();        
        }
    }
    
}
