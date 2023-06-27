package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.view.FormBuscaMarca;
import com.mercadoComMaven.view.ViewCadastroMarca;
import com.mercadoComMaven.service.MarcaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControllerCadMarca implements ActionListener{
    
    ViewCadastroMarca telaMarca;  
    public static int codigo;
    
    public ControllerCadMarca(ViewCadastroMarca telaMarca){
        
        this.telaMarca = telaMarca;
        
        telaMarca.getNovo().addActionListener(this);
        telaMarca.getCancelar().addActionListener(this);
        telaMarca.getGravar().addActionListener(this);
        telaMarca.getBuscar().addActionListener(this);
        telaMarca.getSair().addActionListener(this);
        
        telaMarca.getTextoId().setEnabled(false);
        
        utilities.Utils.ativa(true, telaMarca.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaMarca.getPainelDados());
        telaMarca.getTextoDescricao().setEnabled(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == telaMarca.getNovo()){
            utilities.Utils.ativa(false, telaMarca.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaMarca.getPainelDados());
            telaMarca.getTextoId().setEnabled(false);
            telaMarca.getTextoDescricao().setEnabled(true);
            telaMarca.getTextoDescricao().requestFocus();

            
        }else if(acao.getSource() == telaMarca.getCancelar()){
            telaMarca.getTextoId().setText("");
            telaMarca.getTextoDescricao().setText("");
            utilities.Utils.ativa(true, telaMarca.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaMarca.getPainelDados());
            telaMarca.getTextoDescricao().setEnabled(false);
            
        
        }else if(acao.getSource() == telaMarca.getBuscar()){
            
            this.codigo = 0;
            
            FormBuscaMarca telaBuscaMarca = new FormBuscaMarca(telaMarca, true);
            ControllerBuscaMarca controllerBuscaMarca = new ControllerBuscaMarca(telaBuscaMarca);
            controllerBuscaMarca.quemChamou = "MARCA";
            telaBuscaMarca.setVisible(true);
            
            if (codigo != 0) {

                Marca marca = new Marca();
                marca = MarcaService.buscar(codigo);

                utilities.Utils.ativa(false, telaMarca.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaMarca.getPainelDados());

                telaMarca.getTextoId().setText(marca.getId() + "");
                telaMarca.getTextoDescricao().setText(marca.getDescricao());
                telaMarca.getTextoId().setEnabled(false);
                telaMarca.getTextoDescricao().setEnabled(true);
            }
            
        }else if(acao.getSource() == telaMarca.getGravar()){
            if(telaMarca.getTextoDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            }else{
                
                Marca marca = new Marca();
                marca.setDescricao(telaMarca.getTextoDescricao().getText());

                if (this.telaMarca.getTextoId().getText().equalsIgnoreCase("")) {
                    MarcaService.criar(marca);
                } else {
                    marca.setId(Integer.parseInt(telaMarca.getTextoId().getText()));
                    MarcaService.atualizar(marca);
                }
                telaMarca.getTextoId().setText("");
                telaMarca.getTextoDescricao().setText("");
                   
                telaMarca.getTextoDescricao().setEnabled(false);
                
                utilities.Utils.ativa(true, telaMarca.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaMarca.getPainelDados());
            }
        
        }else if(acao.getSource() == telaMarca.getSair()){
            telaMarca.dispose();
                    
        }
    
    }
}
