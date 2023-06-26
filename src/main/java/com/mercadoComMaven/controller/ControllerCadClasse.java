package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.view.FormBuscaClasse;
import com.mercadoComMaven.view.ViewCadastroClasse;
import com.mercadoComMaven.service.ClasseService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControllerCadClasse implements ActionListener{ 
    ViewCadastroClasse telaClasse;
    public static int codigo;
    
    public ControllerCadClasse(ViewCadastroClasse telaClasse){
        
        this.telaClasse = telaClasse;
       
        telaClasse.getNovo().addActionListener(this);
        telaClasse.getCancelar().addActionListener(this);
        telaClasse.getGravar().addActionListener(this);
        telaClasse.getBuscar().addActionListener(this);
        telaClasse.getSair().addActionListener(this);
        
        telaClasse.getTextoId().setEnabled(false);
        
        utilities.Utils.ativa(true, telaClasse.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaClasse.getPainelDados());
        
        telaClasse.getTextoDescricao().setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == telaClasse.getNovo()){
            utilities.Utils.ativa(false, telaClasse.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaClasse.getPainelDados());
            telaClasse.getTextoId().setEnabled(false);
            telaClasse.getTextoDescricao().setEnabled(true);
            telaClasse.getTextoDescricao().requestFocus();
            
        }else if(acao.getSource() == telaClasse.getCancelar()){
            
            telaClasse.getTextoId().setText("");
            telaClasse.getTextoDescricao().setText("");
            utilities.Utils.ativa(true, telaClasse.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaClasse.getPainelDados());
            telaClasse.getTextoDescricao().setEnabled(false);
            
        }else if(acao.getSource() == telaClasse.getBuscar()){
            this.codigo = 0;
            
            FormBuscaClasse telaBuscaClasse= new FormBuscaClasse(telaClasse, true);
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(telaBuscaClasse);
            controllerBuscaClasse.quemChamou = "CLASSE";
            telaBuscaClasse.setVisible(true);
            
            if (codigo != 0) {

                Classe classe = new Classe();
                classe = ClasseService.buscar(codigo);

                utilities.Utils.ativa(false, telaClasse.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaClasse.getPainelDados());

                telaClasse.getTextoId().setText(classe.getId() + "");
                telaClasse.getTextoDescricao().setText(classe.getDescricao());
                telaClasse.getTextoId().setEnabled(false);
                telaClasse.getTextoDescricao().setEnabled(true);
            }
        
        }else if(acao.getSource() == telaClasse.getGravar()){
            if(telaClasse.getTextoDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            }else{
                
                Classe classe = new Classe();
                classe.setDescricao(telaClasse.getTextoDescricao().getText());
                
                if (this.telaClasse.getTextoId().getText().equalsIgnoreCase("")) {
                    ClasseService.criar(classe);
                } else {
                    classe.setId(Integer.parseInt(telaClasse.getTextoId().getText()));
                    ClasseService.atualizar(classe);
                }
                
                telaClasse.getTextoId().setText("");
                telaClasse.getTextoDescricao().setText("");
                
                telaClasse.getTextoDescricao().setEnabled(false);
                                
                utilities.Utils.ativa(true, telaClasse.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaClasse.getPainelDados());
                
            }
        
        }else if(acao.getSource() == telaClasse.getSair()){
            telaClasse.dispose();
                    
        } 
    }
}
