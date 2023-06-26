package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Fornecedor;
import com.mercadoComMaven.view.FormBuscaFornecedor;
import com.mercadoComMaven.service.FornecedorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ControllerBuscaFornecedor implements ActionListener{
    FormBuscaFornecedor formBuscaFornecedor;
    
    String quemChamou;

    public ControllerBuscaFornecedor(FormBuscaFornecedor formBuscaFornecedor) {
        this.formBuscaFornecedor = formBuscaFornecedor;
        
        this.formBuscaFornecedor.getCarregar().addActionListener(this);
        this.formBuscaFornecedor.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaFornecedor.getTabelaBusca().getModel();

        for (Fornecedor objetoAtualDaLista : FornecedorService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getNome(),
                objetoAtualDaLista.getCpf(),
                objetoAtualDaLista.getContato(),
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaFornecedor.getCarregar()){
           if (this.formBuscaFornecedor.getTabelaBusca().getValueAt(this.formBuscaFornecedor.getTabelaBusca().getSelectedRow(), 0) != null) {
                if (quemChamou.equalsIgnoreCase("FORNECEDOR")) {
                    ControllerCadFornecedor.codigo = (int) this.formBuscaFornecedor.getTabelaBusca().getValueAt(this.formBuscaFornecedor.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaFornecedor.dispose();
                }
            }
        }else if(acao.getSource() == this.formBuscaFornecedor.getSair()){
           this.formBuscaFornecedor.dispose();
        }
    }
}
