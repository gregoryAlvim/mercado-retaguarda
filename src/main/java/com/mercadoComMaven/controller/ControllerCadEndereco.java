package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.view.FormBuscaBairro;
import com.mercadoComMaven.view.FormBuscaCidade;
import com.mercadoComMaven.view.FormBuscaEndereco;
import com.mercadoComMaven.view.ViewCadastroEndereco;
import com.mercadoComMaven.service.BairroService;
import com.mercadoComMaven.service.CidadeService;
import com.mercadoComMaven.service.EnderecoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControllerCadEndereco implements ActionListener {
    
    ViewCadastroEndereco telaEndereco;
    public static int codigo;
    
    //Tentando buscar dados de outra tela
    public static String cidade;
    public static String bairro;
    
    private static Cidade cidadeLocal;
    private static Bairro bairroLocal;
    
    //-----------------------------------------
    
    public ControllerCadEndereco(ViewCadastroEndereco telaEndereco) {
        
        this.telaEndereco = telaEndereco;
        
        telaEndereco.getNovo().addActionListener(this);
        telaEndereco.getCancelar().addActionListener(this);
        telaEndereco.getGravar().addActionListener(this);
        telaEndereco.getBuscar().addActionListener(this);
        telaEndereco.getSair().addActionListener(this);
        telaEndereco.getjButtonBuscarBairro().addActionListener(this);
        telaEndereco.getjButtonBuscarCidade().addActionListener(this);

        utilities.Utils.ativa(true, telaEndereco.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaEndereco.getPainelDados());
        
        telaEndereco.getjTextFieldBairro().setEnabled(false);
        telaEndereco.getjTextFieldCidade().setEnabled(false);
        telaEndereco.getjTextFieldLogradouro().setEnabled(false);
        telaEndereco.getjTextFieldCEP().setEnabled(false);
        telaEndereco.getjButtonBuscarBairro().setEnabled(false);
        telaEndereco.getjButtonBuscarCidade().setEnabled(false);
    }
    
    public void validarCidade(String cidadeParam) {
        if(cidadeParam.equalsIgnoreCase("")){
           cidade = this.telaEndereco.getjTextFieldCidade().getText();
        }
        
        cidadeLocal = new Cidade();
        cidadeLocal = CidadeService.buscar(cidade);

        telaEndereco.getjTextFieldCidade().setText(cidadeLocal.getDescricao());
    }
    
    public void validarBairro(String bairroParam) {
        if(bairroParam.equalsIgnoreCase("")){
             this.telaEndereco.getjTextFieldBairro().getText();
        }
        
        bairroLocal = new Bairro();
        bairroLocal = BairroService.buscar(bairro);

        telaEndereco.getjTextFieldBairro().setText(bairroLocal.getDescricao());
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaEndereco.getNovo()) {
            utilities.Utils.ativa(false, telaEndereco.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaEndereco.getPainelDados());
            
            telaEndereco.getjTextFieldLogradouro().setEnabled(true);
            telaEndereco.getjTextFieldCEP().setEnabled(true);
            telaEndereco.getjButtonBuscarBairro().setEnabled(true);
            telaEndereco.getjButtonBuscarCidade().setEnabled(true);
            telaEndereco.getjTextFieldLogradouro().requestFocus();
            
        } else if (acao.getSource() == telaEndereco.getCancelar()) {
            utilities.Utils.ativa(true, telaEndereco.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaEndereco.getPainelDados());
            
            telaEndereco.getjTextFieldId().setText("");
            telaEndereco.getjTextFieldLogradouro().setText("");
            telaEndereco.getjTextFieldCEP().setText("");
            telaEndereco.getjTextFieldBairro().setText("");
            telaEndereco.getjTextFieldCidade().setText("");
            
            telaEndereco.getjTextFieldBairro().setEnabled(false);
            telaEndereco.getjTextFieldCidade().setEnabled(false);
            telaEndereco.getjTextFieldLogradouro().setEnabled(false);
            telaEndereco.getjTextFieldCEP().setEnabled(false);
            telaEndereco.getjButtonBuscarBairro().setEnabled(false);
            telaEndereco.getjButtonBuscarCidade().setEnabled(false);
            
        } else if (acao.getSource() == telaEndereco.getBuscar()) {
            
            this.codigo = 0;
           
            FormBuscaEndereco telaBuscaEndereco = new FormBuscaEndereco(telaEndereco, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(telaBuscaEndereco);
            controllerBuscaEndereco.quemChamou = "ENDERECO";
            telaBuscaEndereco.setVisible(true);
            
            if (codigo != 0) {
                
                Endereco endereco = new Endereco();
                endereco = EnderecoService.buscar(codigo);
                
                utilities.Utils.ativa(false, telaEndereco.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaEndereco.getPainelDados());

                telaEndereco.getjTextFieldId().setText(endereco.getId() + "");
                telaEndereco.getjTextFieldLogradouro().setText(endereco.getLogradouro());
                telaEndereco.getjTextFieldCEP().setText(endereco.getCep());
                telaEndereco.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
                telaEndereco.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
                
                telaEndereco.getjTextFieldId().setEnabled(false);
                telaEndereco.getjTextFieldLogradouro().setEnabled(true);
                telaEndereco.getjTextFieldCEP().setEnabled(true);
                telaEndereco.getjTextFieldBairro().setEnabled(false);
                telaEndereco.getjTextFieldCidade().setEnabled(false);
                telaEndereco.getjButtonBuscarBairro().setEnabled(true);
                telaEndereco.getjButtonBuscarCidade().setEnabled(true);
                
                bairroLocal = endereco.getBairro();
                cidadeLocal = endereco.getCidade();
            }
            
        } else if (acao.getSource() == telaEndereco.getGravar()) {
            if (telaEndereco.getjTextFieldLogradouro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Logradouro é Obrigatório");
            } else if (telaEndereco.getjTextFieldCEP().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo CEP é Obrigatório");
            } else {
                Endereco endereco = new Endereco();
                
                endereco.setLogradouro(telaEndereco.getjTextFieldLogradouro().getText());
                endereco.setCep(telaEndereco.getjTextFieldCEP().getText());
                
                endereco.setBairro(bairroLocal);
                endereco.setCidade(cidadeLocal);
                                
                if (this.telaEndereco.getjTextFieldId().getText().equalsIgnoreCase("")) {
                    EnderecoService.criar(endereco);
                } else {
                    endereco.setId(Integer.parseInt(telaEndereco.getjTextFieldId().getText()));
                    EnderecoService.atualizar(endereco);
                }
                
                telaEndereco.getjTextFieldId().setText("");
                telaEndereco.getjTextFieldLogradouro().setText("");
                telaEndereco.getjTextFieldCEP().setText("");
                telaEndereco.getjTextFieldBairro().setText("");
                telaEndereco.getjTextFieldCidade().setText("");
                
                telaEndereco.getjTextFieldBairro().setEnabled(false);
                telaEndereco.getjTextFieldCidade().setEnabled(false);
                telaEndereco.getjTextFieldLogradouro().setEnabled(false);
                telaEndereco.getjTextFieldCEP().setEnabled(false);
                telaEndereco.getjButtonBuscarBairro().setEnabled(false);
                telaEndereco.getjButtonBuscarCidade().setEnabled(false);
                
                utilities.Utils.ativa(true, telaEndereco.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaEndereco.getPainelDados());
                
            }
        } else if(acao.getSource() == telaEndereco.getSair()) {
            telaEndereco.dispose();        
        } else if (acao.getSource() == telaEndereco.getjButtonBuscarBairro()) {
            this.codigo = 0;

            FormBuscaBairro formBuscaBairro = new FormBuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(formBuscaBairro);
            controllerBuscaBairro.quemChamou = "ENDERECO";
            formBuscaBairro.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            validarBairro(bairro);
        } else if (acao.getSource() == telaEndereco.getjButtonBuscarCidade()) {
            this.codigo = 0;

            FormBuscaCidade formBuscaCidade = new FormBuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(formBuscaCidade);
            controllerBuscaCidade.quemChamou = "ENDERECO";
            formBuscaCidade.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            validarCidade(cidade);
        }
    }
}
