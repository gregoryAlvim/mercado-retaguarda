package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Cliente;
import com.mercadoComMaven.view.FormBuscaCliente;
import com.mercadoComMaven.service.ClienteService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaCliente implements ActionListener{
    
    FormBuscaCliente formBuscaCliente;

    public ControllerBuscaCliente(FormBuscaCliente formBuscaCliente) {
        this.formBuscaCliente = formBuscaCliente;
        
        this.formBuscaCliente.getCarregar().addActionListener(this);
        this.formBuscaCliente.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaCliente.getTabelaBusca().getModel();
        
        for (Cliente objetoAtualDaLista : ClienteService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getNome(),
                objetoAtualDaLista.getCpf(),
                objetoAtualDaLista.getDataNascimento(),
                objetoAtualDaLista.getStatus(),
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaCliente.getCarregar()){
             if (this.formBuscaCliente.getTabelaBusca().getValueAt(this.formBuscaCliente.getTabelaBusca().getSelectedRow(), 0) != null) {
                 ControllerCadCliente.codigo = (int) this.formBuscaCliente.getTabelaBusca().getValueAt(this.formBuscaCliente.getTabelaBusca().getSelectedRow(), 0);
                 formBuscaCliente.dispose();
             }
        }else if(acao.getSource() == this.formBuscaCliente.getSair()){
           this.formBuscaCliente.dispose();
        }
    }
}
