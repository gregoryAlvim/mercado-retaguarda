package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.view.FormBuscaColaborador;
import com.mercadoComMaven.view.FormBuscaEndereco;
import com.mercadoComMaven.view.ViewCadastroColaborador;
import com.mercadoComMaven.service.ColaboradorService;
import com.mercadoComMaven.service.EnderecoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;



public class ControllerCadColaborador implements ActionListener {
    
    ViewCadastroColaborador telaColaborador;
    public static int codigo;
    
    //Tentando buscar dados de outra tela
    public static String endereco;

    String fullAddress;
    String dataFormatada;

    private static Endereco enderecoLocal;

    //-----------------------------------------------
    
    public void validarEndereco(String enderecoParam) {
        if (enderecoParam.equalsIgnoreCase("")) {
            endereco = this.telaColaborador.getjTextFieldEndereco().getText();
        }

        enderecoLocal = new Endereco();
        enderecoLocal = EnderecoService.buscar(endereco);

        fullAddress = enderecoLocal.getLogradouro()
                + ", " + enderecoLocal.getBairro().getDescricao()
                + ", " + enderecoLocal.getCidade().getDescricao()
                + ", " + enderecoLocal.getCep();

        telaColaborador.getjTextFieldEndereco().setText(fullAddress);
    }
    
    public void enableDisable(boolean estado) {;
        telaColaborador.getjTextFieldNome().setEnabled(estado);
        telaColaborador.getjTextFieldEmail().setEnabled(estado);
        telaColaborador.getjTextFieldTelefone().setEnabled(estado);
        telaColaborador.getjTextFieldCelular().setEnabled(estado);
        telaColaborador.getjTextFieldLogin().setEnabled(estado);
        telaColaborador.getjTextFieldSenha().setEnabled(estado);
        telaColaborador.getjTextFieldVerificaSenha().setEnabled(estado);
        telaColaborador.getjTextFieldEndereco().setEnabled(false);
        telaColaborador.getjButtonBuscarEndereco().setEnabled(estado);
        telaColaborador.getjTextFieldComplemento().setEnabled(estado);
        telaColaborador.getjTextFieldObservacao().setEnabled(estado);
        telaColaborador.getjTextFieldDataCadastro().setEnabled(false);
        telaColaborador.getjComboBoxStatus().setEnabled(estado);
        telaColaborador.getjTextFieldDataCadastro().setEnabled(false);
    }
    
    public void setAllInputsEmpty() {
        telaColaborador.getjTextFieldNome().setText("");
        telaColaborador.getjTextFieldEmail().setText("");
        telaColaborador.getjTextFieldTelefone().setText("");
        telaColaborador.getjTextFieldCelular().setText("");
        telaColaborador.getjTextFieldLogin().setText("");
        telaColaborador.getjTextFieldSenha().setText("");
        telaColaborador.getjTextFieldVerificaSenha().setText("");
        telaColaborador.getjTextFieldEndereco().setText("");
        telaColaborador.getjTextFieldComplemento().setText("");
        telaColaborador.getjTextFieldObservacao().setText("");
        telaColaborador.getjTextFieldDataCadastro().setText("");
        telaColaborador.getjComboBoxStatus().setSelectedIndex(0);
        telaColaborador.getjTextFieldId().setText("");
    }
    
     public static String formatarData(String dataParam) {
        DateTimeFormatter formatoAtual = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        DateTimeFormatter formatoDesejado = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime data = LocalDateTime.parse(dataParam, formatoAtual);
        String dataFormatada = data.format(formatoDesejado);
        return dataFormatada;
    }
    
    public ControllerCadColaborador(ViewCadastroColaborador telaColaborador) {
        
        this.telaColaborador = telaColaborador;
        
        telaColaborador.getNovo().addActionListener(this);
        telaColaborador.getCancelar().addActionListener(this);
        telaColaborador.getGravar().addActionListener(this);
        telaColaborador.getBuscar().addActionListener(this);
        telaColaborador.getSair().addActionListener(this);
        telaColaborador.getjButtonBuscarEndereco().addActionListener(this);
        
        utilities.Utils.ativa(true, telaColaborador.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaColaborador.getPainelDados());
        enableDisable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaColaborador.getNovo()) {
            
            utilities.Utils.ativa(false, telaColaborador.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaColaborador.getPainelDados());
            enableDisable(true);
            
            DateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            dataFormatada = dataCadastro.format(data);
            telaColaborador.getjTextFieldDataCadastro().setText(dataFormatada);
            
        } else if (acao.getSource() == telaColaborador.getCancelar()) {
            utilities.Utils.ativa(true, telaColaborador.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaColaborador.getPainelDados());
            enableDisable(false);
            setAllInputsEmpty();
            
        } else if (acao.getSource() == telaColaborador.getBuscar()) {
            
            this.codigo = 0;
            
            FormBuscaColaborador telaBuscaColaborador = new FormBuscaColaborador(telaColaborador, true);
            ControllerBuscaColaborador controllerBuscaColaborador = new ControllerBuscaColaborador(telaBuscaColaborador);
            telaBuscaColaborador.setVisible(true);
            
            if (codigo != 0) {
                Colaborador colaborador = new Colaborador();
                colaborador = ColaboradorService.buscar(codigo);
                
                utilities.Utils.ativa(false, telaColaborador.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaColaborador.getPainelDados());
                
                telaColaborador.getjTextFieldId().setText(colaborador.getId() + "");
                telaColaborador.getjTextFieldNome().setText(colaborador.getNome());
                telaColaborador.getjTextFieldEmail().setText(colaborador.getEmail());
                telaColaborador.getjTextFieldTelefone().setText(colaborador.getFone1());
                telaColaborador.getjTextFieldCelular().setText(colaborador.getFone2());             
                telaColaborador.getjTextFieldLogin().setText(colaborador.getLogin());
                telaColaborador.getjTextFieldSenha().setText(colaborador.getSenha());
                telaColaborador.getjTextFieldVerificaSenha().setText(colaborador.getSenha());
                
                fullAddress = colaborador.getEndereco().getLogradouro()
                        + ", " + colaborador.getEndereco().getBairro().getDescricao()
                        + ", " + colaborador.getEndereco().getCidade().getDescricao()
                        + ", " + colaborador.getEndereco().getCep();
                telaColaborador.getjTextFieldEndereco().setText(fullAddress);
                
                enderecoLocal = colaborador.getEndereco();
                
                telaColaborador.getjTextFieldDataCadastro().setText(formatarData(colaborador.getDataCadastro()+ ""));
                dataFormatada = telaColaborador.getjTextFieldDataCadastro().getText();
                
                if (colaborador.getStatus().equals("1")) {
                    telaColaborador.getjComboBoxStatus().setSelectedIndex(0);
                } else {
                    telaColaborador.getjComboBoxStatus().setSelectedIndex(1);
                }
                
                telaColaborador.getjTextFieldObservacao().setText(colaborador.getObservacao());
                telaColaborador.getjTextFieldComplemento().setText(colaborador.getComplementoEndereco());
                
                enableDisable(true);
            }
            
        } else if (acao.getSource() == telaColaborador.getGravar()) {
            if (telaColaborador.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            } else if (telaColaborador.getjTextFieldEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo E-mail é Obrigatório");
            } else if (telaColaborador.getjTextFieldLogin().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Login é Obrigatório");
            }else if (telaColaborador.getjTextFieldTelefone().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Telefone é Obrigatório");
            }else if (telaColaborador.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Telefone 2 é Obrigatório");
            } else if (telaColaborador.getjTextFieldSenha().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Senha é Obrigatório");
            } else if (telaColaborador.getjTextFieldVerificaSenha().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Verifica Senha é Obrigatório");
            } else {
                Colaborador colaborador = new Colaborador();
                
                colaborador.setNome(telaColaborador.getjTextFieldNome().getText());
                colaborador.setEmail(telaColaborador.getjTextFieldEmail().getText());
                colaborador.setFone1(telaColaborador.getjTextFieldTelefone().getText());
                colaborador.setFone2(telaColaborador.getjTextFieldCelular().getText());
                colaborador.setLogin(telaColaborador.getjTextFieldLogin().getText());

                //Tratativa verificar se senha confere com a repetição
                if (telaColaborador.getjTextFieldSenha().getText().equals(telaColaborador.getjTextFieldVerificaSenha().getText())) {
                    colaborador.setSenha(telaColaborador.getjTextFieldSenha().getText()); 

                    colaborador.setEndereco(enderecoLocal);
                    colaborador.setComplementoEndereco(telaColaborador.getjTextFieldComplemento().getText());
                    colaborador.setObservacao(telaColaborador.getjTextFieldObservacao().getText());

                    //Tratativa status 1 para verdadeiro e 0 para falso
                    if(telaColaborador.getjComboBoxStatus().getSelectedIndex() == 0){
                        colaborador.setStatus("1");
                    }else{                   
                        colaborador.setStatus("0");
                    }

                    //Tratativa data de cadastro
                    try {
                        DateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
                        colaborador.setDataCadastro(dataCadastro.parse(dataFormatada));
                    } catch (Exception ex) {
                    }

                    if (this.telaColaborador.getjTextFieldId().getText().equalsIgnoreCase("")) {
                        ColaboradorService.criar(colaborador);
                    } else {
                        colaborador.setId(Integer.parseInt(telaColaborador.getjTextFieldId().getText()));
                        ColaboradorService.atualizar(colaborador);
                    }

                    setAllInputsEmpty();
                    enableDisable(false);

                    utilities.Utils.ativa(true, telaColaborador.getPainelBotoes());
                    utilities.Utils.ligaDesliga(true, telaColaborador.getPainelDados());
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas não conferem!");
                }  
            }
        } else if (acao.getSource() == telaColaborador.getjButtonBuscarEndereco()) {
            this.codigo = 0;

            FormBuscaEndereco formBuscaEndereco = new FormBuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(formBuscaEndereco);
            controllerBuscaEndereco.quemChamou = "COLABORADOR";
            formBuscaEndereco.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            validarEndereco(endereco);
        } else if(acao.getSource() == telaColaborador.getSair()) {
            telaColaborador.dispose();        
        }
    }
}
