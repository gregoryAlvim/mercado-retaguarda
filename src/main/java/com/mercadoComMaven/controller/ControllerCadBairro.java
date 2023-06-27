package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.view.FormBuscaBairro;
import com.mercadoComMaven.view.ViewCadastroBairro;
import com.mercadoComMaven.service.BairroService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerCadBairro implements ActionListener {

    ViewCadastroBairro telaBairro;
    public static int codigo;

    public ControllerCadBairro(ViewCadastroBairro telaBairro) {

        this.telaBairro = telaBairro;

        telaBairro.getNovo().addActionListener(this);
        telaBairro.getCancelar().addActionListener(this);
        telaBairro.getGravar().addActionListener(this);
        telaBairro.getBuscar().addActionListener(this);
        telaBairro.getSair().addActionListener(this);

        utilities.Utils.ativa(true, telaBairro.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaBairro.getPainelDados());
        
        telaBairro.getTextoId().setEnabled(false);
        telaBairro.getTextoDescricao().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaBairro.getNovo()) {
            utilities.Utils.ativa(false, telaBairro.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaBairro.getPainelDados());
            
            telaBairro.getTextoId().setEnabled(false);
            telaBairro.getTextoDescricao().setEnabled(true);
            telaBairro.getTextoDescricao().requestFocus();

        } else if (acao.getSource() == telaBairro.getCancelar()) {
            telaBairro.getTextoId().setText("");
            telaBairro.getTextoDescricao().setText("");
            utilities.Utils.ativa(true, telaBairro.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaBairro.getPainelDados());
            telaBairro.getTextoDescricao().setEnabled(false);

        } else if (acao.getSource() == telaBairro.getBuscar()) {

            FormBuscaBairro telaBuscaBairro = new FormBuscaBairro(telaBairro,true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBuscaBairro);
            controllerBuscaBairro.quemChamou = "BAIRRO";
            telaBuscaBairro.setVisible(true);

            if (codigo != 0) {

                //carrega o Bairro para edição
                Bairro bairro = new Bairro();
                bairro = BairroService.buscar(codigo);

                utilities.Utils.ativa(false, telaBairro.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaBairro.getPainelDados());

                telaBairro.getTextoId().setText(bairro.getId() + "");
                telaBairro.getTextoDescricao().setText(bairro.getDescricao());
                telaBairro.getTextoId().setEnabled(false);
                telaBairro.getTextoDescricao().setEnabled(true);
                
                this.codigo = 0;
            }

        } else if (acao.getSource() == telaBairro.getGravar()) {
            if (telaBairro.getTextoDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                
                Bairro bairro = new Bairro();
                bairro.setDescricao(telaBairro.getTextoDescricao().getText());          

                if (this.telaBairro.getTextoId().getText().equalsIgnoreCase("")) {
                    BairroService.criar(bairro);
                } else {
                    bairro.setId(Integer.parseInt(telaBairro.getTextoId().getText()));
                    BairroService.atualizar(bairro);
                }
                telaBairro.getTextoId().setText("");
                telaBairro.getTextoDescricao().setText("");
                   
                telaBairro.getTextoDescricao().setEnabled(false);
                
                utilities.Utils.ativa(true, telaBairro.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaBairro.getPainelDados());
            }
        } else if (acao.getSource() == telaBairro.getSair()) {
            telaBairro.dispose();
        }
    }
}
