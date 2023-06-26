package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Endereco;
import com.mercadoComMaven.view.FormBuscaEndereco;
import com.mercadoComMaven.service.EnderecoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaEndereco implements ActionListener{
    FormBuscaEndereco formBuscaEndereco;
    String quemChamou;

    public ControllerBuscaEndereco(FormBuscaEndereco formBuscaEndereco) {
        this.formBuscaEndereco = formBuscaEndereco;
        
        this.formBuscaEndereco.getCarregar().addActionListener(this);
        this.formBuscaEndereco.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaEndereco.getTabelaBusca().getModel();


        for (Endereco objetoAtualDaLista : EnderecoService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getLogradouro(),
                objetoAtualDaLista.getCep(),
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaEndereco.getCarregar()){
           if (this.formBuscaEndereco.getTabelaBusca().getValueAt(this.formBuscaEndereco.getTabelaBusca().getSelectedRow(), 0) != null) {
                if (quemChamou.equalsIgnoreCase("ENDERECO")) {
                    ControllerCadEndereco.codigo = (int) this.formBuscaEndereco.getTabelaBusca().getValueAt(this.formBuscaEndereco.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaEndereco.dispose();
                } else if (quemChamou.equalsIgnoreCase("CLIENTE")) {
                    ControllerCadCliente.endereco = (String) this.formBuscaEndereco.getTabelaBusca().getValueAt(this.formBuscaEndereco.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaEndereco.dispose();
                } else if (quemChamou.equalsIgnoreCase("COLABORADOR")) {
                    ControllerCadColaborador.endereco = (String) this.formBuscaEndereco.getTabelaBusca().getValueAt(this.formBuscaEndereco.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaEndereco.dispose();
                } else if (quemChamou.equalsIgnoreCase("FORNECEDOR")) {
                    ControllerCadFornecedor.endereco = (String) this.formBuscaEndereco.getTabelaBusca().getValueAt(this.formBuscaEndereco.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaEndereco.dispose();
                }
            }
        }else if(acao.getSource() == this.formBuscaEndereco.getSair()){
           this.formBuscaEndereco.dispose();
        }
    }
}
