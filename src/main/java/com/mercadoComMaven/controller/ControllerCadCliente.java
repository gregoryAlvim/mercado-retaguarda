package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Cliente;
import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.view.FormBuscaCliente;
import com.mercadoComMaven.view.FormBuscaEndereco;
import com.mercadoComMaven.view.ViewCadastroCliente;
import com.mercadoComMaven.service.ClienteService;
import com.mercadoComMaven.service.EnderecoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;



public class ControllerCadCliente implements ActionListener {

    ViewCadastroCliente telaCliente;
    public static int codigo;

    //Tentando buscar dados de outra tela
    public static String endereco;

    String fullAddress;
    String dataFormatada;

    private static Endereco enderecoLocal;

    //-----------------------------------------------

    public void validarEndereco(String enderecoParam) {
        if (enderecoParam.equalsIgnoreCase("")) {
            endereco = this.telaCliente.getTextoEndereco().getText();
        }

        enderecoLocal = new Endereco();
        enderecoLocal = EnderecoService.buscar(endereco);

        fullAddress = enderecoLocal.getLogradouro()
                + ", " + enderecoLocal.getBairro().getDescricao()
                + ", " + enderecoLocal.getCidade().getDescricao()
                + ", " + enderecoLocal.getCep();

        telaCliente.getTextoEndereco().setText(fullAddress);
    }

    public void enableDisable(boolean estado) {;
        telaCliente.getTextoNome().setEnabled(estado);
        telaCliente.getTextoTelefone1().setEnabled(estado);
        telaCliente.getTextoTelefone2().setEnabled(estado);
        telaCliente.getTextoRG().setEnabled(estado);
        telaCliente.getTextoCPF().setEnabled(estado);
        telaCliente.getTextoEmail().setEnabled(estado);
        telaCliente.getjFormattedTextDataNascimento().setEnabled(estado);
        telaCliente.getTextoDataCadastro().setEnabled(false);
        telaCliente.getjButtonBuscarEndereco().setEnabled(estado);
        telaCliente.getComboSexo().setEnabled(estado);
        telaCliente.getComboStatus().setEnabled(estado);
        telaCliente.getTextoObservacao().setEnabled(estado);
        telaCliente.getTextoComplemento().setEnabled(estado);
        telaCliente.getTextoEndereco().setEnabled(false);
    }

    ;
    
    public void setAllInputsEmpty() {
        telaCliente.getTextoNome().requestFocus();
        telaCliente.getTextoNome().setText("");
        telaCliente.getTextoTelefone1().setText("");
        telaCliente.getTextoTelefone2().setText("");
        telaCliente.getTextoRG().setText("");
        telaCliente.getTextoCPF().setText("");
        telaCliente.getTextoEmail().setText("");
        telaCliente.getTextoEndereco().setText("");
        telaCliente.getjFormattedTextDataNascimento().setText("");
        telaCliente.getTextoDataCadastro().setText("");
        telaCliente.getComboStatus().setSelectedIndex(0);
        telaCliente.getTextoObservacao().setText("");
        telaCliente.getTextoComplemento().setText("");
        telaCliente.getTextoId().setText("");
    }

    ;
    
    public static String formatarData(String data) {
        // Verifica se a data tem o tamanho correto
        if (data.length() != 10) {
            return null;
        }

        // Extrai o dia, mês e ano da data
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8);

        // Formata a data com barras
        return dia + "/" + mes + "/" + ano;
    }

    public static String formatarCPF(String cpf) {
        // Remove todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem o tamanho correto
        if (cpf.length() != 11) {
            return null;
        }

        // Formata o CPF com pontos e traço
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    public ControllerCadCliente(ViewCadastroCliente telaCliente) {

        this.telaCliente = telaCliente;

        telaCliente.getNovo().addActionListener(this);
        telaCliente.getCancelar().addActionListener(this);
        telaCliente.getGravar().addActionListener(this);
        telaCliente.getBuscar().addActionListener(this);
        telaCliente.getSair().addActionListener(this);
        telaCliente.getjButtonBuscarEndereco().addActionListener(this);

        utilities.Utils.ativa(true, telaCliente.getPainelBotoes());
        utilities.Utils.ligaDesliga(false, telaCliente.getPainelDados());
        enableDisable(false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCliente.getNovo()) {
            utilities.Utils.ativa(false, telaCliente.getPainelBotoes());
            utilities.Utils.ligaDesliga(true, telaCliente.getPainelDados());
            enableDisable(true);

            DateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            dataFormatada = dataCadastro.format(data);
            telaCliente.getTextoDataCadastro().setText(dataFormatada);

        } else if (acao.getSource() == telaCliente.getCancelar()) {
            utilities.Utils.ativa(true, telaCliente.getPainelBotoes());
            utilities.Utils.ligaDesliga(false, telaCliente.getPainelDados());
            enableDisable(false);
            setAllInputsEmpty();

        } else if (acao.getSource() == telaCliente.getBuscar()) {

            this.codigo = 0;

            FormBuscaCliente telaBuscaCliente = new FormBuscaCliente(telaCliente, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCliente);
            telaBuscaCliente.setVisible(true);

            if (codigo != 0) {
                Cliente cliente = new Cliente();
                cliente = ClienteService.buscar(codigo);

                utilities.Utils.ativa(false, telaCliente.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCliente.getPainelDados());

                telaCliente.getTextoId().setText(cliente.getId() + "");
                telaCliente.getTextoNome().setText(cliente.getNome());
                telaCliente.getTextoTelefone1().setText(cliente.getFone1());
                telaCliente.getTextoTelefone2().setText(cliente.getFone2());
                telaCliente.getTextoRG().setText(cliente.getRg());
                telaCliente.getTextoCPF().setText(cliente.getCpf());
                telaCliente.getTextoEmail().setText(cliente.getEmail());

                fullAddress = cliente.getEndereco().getLogradouro()
                        + ", " + cliente.getEndereco().getBairro().getDescricao()
                        + ", " + cliente.getEndereco().getCidade().getDescricao()
                        + ", " + cliente.getEndereco().getCep();
                telaCliente.getTextoEndereco().setText(fullAddress);

                enderecoLocal = cliente.getEndereco();

                telaCliente.getjFormattedTextDataNascimento().setText(formatarData(cliente.getDataNascimento() + ""));
                
                telaCliente.getTextoDataCadastro().setText(formatarData(cliente.getDataCadastro() + ""));
                dataFormatada = telaCliente.getTextoDataCadastro().getText();
                
                if (cliente.getStatus().equals("1")) {
                    telaCliente.getComboStatus().setSelectedIndex(0);
                } else {
                    telaCliente.getComboStatus().setSelectedIndex(1);
                }
                
                telaCliente.getTextoObservacao().setText(cliente.getObservacao());
                telaCliente.getTextoComplemento().setText(cliente.getComplementoEndereco());

                if (cliente.getSexo() == 'M') {
                    telaCliente.getComboSexo().setSelectedIndex(0);
                } else {
                    telaCliente.getComboSexo().setSelectedIndex(1);
                }

                enableDisable(true);
            }

        } else if (acao.getSource() == telaCliente.getGravar()) {
            if (telaCliente.getTextoRG().getText().trim().equalsIgnoreCase("")
                    || telaCliente.getTextoCPF().getText().trim().equalsIgnoreCase("")
                    || telaCliente.getjFormattedTextDataNascimento().getText().trim().equalsIgnoreCase("")
                    || telaCliente.getTextoTelefone1().getText().trim().equalsIgnoreCase("")
                    || telaCliente.getTextoNome().getText().trim().equalsIgnoreCase("")
                    || telaCliente.getTextoEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Há campos obrigatórios não preenchidos");
            } else {

                Cliente cliente = new Cliente();

                cliente.setNome(telaCliente.getTextoNome().getText());
                cliente.setFone1(telaCliente.getTextoTelefone1().getText());
                cliente.setFone2(telaCliente.getTextoTelefone2().getText());
                cliente.setRg(telaCliente.getTextoRG().getText());
                cliente.setCpf(formatarCPF(telaCliente.getTextoCPF().getText()));
                cliente.setEmail(telaCliente.getTextoEmail().getText());
                cliente.setEndereco(enderecoLocal);
                cliente.setObservacao(telaCliente.getTextoObservacao().getText());
                cliente.setComplementoEndereco(telaCliente.getTextoComplemento().getText());

                //Tratativa data de nascimento
                try {
                    DateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
                    Date data = dataNascimento.parse(telaCliente.getjFormattedTextDataNascimento().getText());
                    cliente.setDataNascimento(data);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data de nascimento inválida!");
                }

                //Tratativa status 1 para verdadeiro e 0 para falso
                if (telaCliente.getComboStatus().getSelectedIndex() == 0) {
                    cliente.setStatus("1");
                } else {
                    cliente.setStatus("0");
                }

                //Tratativa sexo
                if (telaCliente.getComboSexo().getSelectedIndex() == 0) {
                    cliente.setSexo('M');
                } else {
                    cliente.setSexo('F');
                }

                //Tratativa data de cadastro
                try {
                    DateFormat dataCadastro = new SimpleDateFormat("dd/MM/yyyy");
                    cliente.setDataCadastro(dataCadastro.parse(dataFormatada));
                } catch (Exception ex) {
                }

                if (this.telaCliente.getTextoId().getText().equalsIgnoreCase("")) {
                    ClienteService.criar(cliente);
                } else {
                    cliente.setId(Integer.parseInt(telaCliente.getTextoId().getText()));
                    ClienteService.atualizar(cliente);
                }

                setAllInputsEmpty();
                enableDisable(false);

                utilities.Utils.ativa(true, telaCliente.getPainelBotoes());
                utilities.Utils.ligaDesliga(true, telaCliente.getPainelDados());

            }

        } else if (acao.getSource() == telaCliente.getjButtonBuscarEndereco()) {
            this.codigo = 0;

            FormBuscaEndereco formBuscaEndereco = new FormBuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(formBuscaEndereco);
            controllerBuscaEndereco.quemChamou = "CLIENTE";
            formBuscaEndereco.setVisible(true);

            //no retorno tratar e colocar os valores nos textfields devidos
            validarEndereco(endereco);
        } else if (acao.getSource() == telaCliente.getSair()) {
            telaCliente.dispose();
        }
    }
}