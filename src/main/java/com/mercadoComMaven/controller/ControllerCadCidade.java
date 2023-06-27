package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.view.FormBuscaCidade;
import com.mercadoComMaven.view.ViewCadastroCidade;
import com.mercadoComMaven.service.CidadeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerCadCidade implements ActionListener{
    
    ViewCadastroCidade telaCidade;
    public static int codigo;
    
    public ControllerCadCidade(ViewCadastroCidade telaCidade){
        
        this.telaCidade = telaCidade;
        
        telaCidade.getNovo().addActionListener(this);
        telaCidade.getCancelar().addActionListener(this);
        telaCidade.getGravar().addActionListener(this);
        telaCidade.getBuscar().addActionListener(this);
        telaCidade.getSair().addActionListener(this);
        
        utilities.Utils.ativa(true, telaCidade.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaCidade.getPainelDados());
        
        telaCidade.getTextoId().setEnabled(false);
        telaCidade.getTextoDescricao().setEnabled(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCidade.getNovo()) {
            utilities.Utils.ativa(false, telaCidade.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaCidade.getPainelDados());
            
            telaCidade.getTextoId().setEnabled(false);
            telaCidade.getTextoDescricao().setEnabled(true);
            telaCidade.getTextoDescricao().requestFocus();
            
        } else if (acao.getSource() == telaCidade.getCancelar()) {
            telaCidade.getTextoId().setText("");
            telaCidade.getTextoDescricao().setText("");
            utilities.Utils.ativa(true, telaCidade.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaCidade.getPainelDados());
            telaCidade.getTextoDescricao().setEnabled(false);
            
        } else if (acao.getSource() == telaCidade.getBuscar()) {
            
            FormBuscaCidade telaBuscaCidade = new FormBuscaCidade(telaCidade, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaBuscaCidade);
            controllerBuscaCidade.quemChamou = "CIDADE";
            telaBuscaCidade.setVisible(true);
            
            if (codigo != 0) {
                
                Cidade cidade = new Cidade();
                cidade = CidadeService.buscar(codigo);

                utilities.Utils.ativa(false, telaCidade.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCidade.getPainelDados());

                telaCidade.getTextoId().setText(cidade.getId() + "");
                telaCidade.getTextoDescricao().setText(cidade.getDescricao());
                telaCidade.getTextoId().setEnabled(false);
                telaCidade.getTextoDescricao().setEnabled(true);
                
                this.codigo = 0;
            }
        
        } else if (acao.getSource() == telaCidade.getGravar()) {
            if (telaCidade.getTextoDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Cidade cidade = new Cidade();
                cidade.setDescricao(telaCidade.getTextoDescricao().getText());
                
                
                if (this.telaCidade.getTextoId().getText().equalsIgnoreCase("")) {
                    CidadeService.criar(cidade);
                } else {
                    cidade.setId(Integer.parseInt(telaCidade.getTextoId().getText()));
                    CidadeService.atualizar(cidade);
                }
                
                telaCidade.getTextoId().setText("");
                telaCidade.getTextoDescricao().setText("");
                telaCidade.getTextoDescricao().setEnabled(false);
           
                
                utilities.Utils.ativa(true, telaCidade.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCidade.getPainelDados());
                                
            }
        } else if(acao.getSource() == telaCidade.getSair()) {
            telaCidade.dispose();        
        }
    }
}
