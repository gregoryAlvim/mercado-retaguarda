package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.CondicaoPagamento;
import com.mercadoComMaven.view.FormBuscaCondicaoPgto;
import com.mercadoComMaven.service.CondicaoPgtoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaCondicaoPgto implements ActionListener{
    
    FormBuscaCondicaoPgto formBuscaPgto;

    public ControllerBuscaCondicaoPgto(FormBuscaCondicaoPgto formBuscaPgto) {
        this.formBuscaPgto = formBuscaPgto;
        
        this.formBuscaPgto.getCarregar().addActionListener(this);
        this.formBuscaPgto.getSair().addActionListener(this);
        
        //Carregar os dados para a jTable
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaPgto.getTabelaBusca().getModel();

        for (CondicaoPagamento objetoAtualDaLista : CondicaoPgtoService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricaoCondicao(),
                objetoAtualDaLista.getDiasPrimeiraParcela(),
                objetoAtualDaLista.getStatus(),
                
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.formBuscaPgto.getCarregar()) {
            if (this.formBuscaPgto.getTabelaBusca().getValueAt(this.formBuscaPgto.getTabelaBusca().getSelectedRow(), 0) != null) {
                ControllerCadCondicaoPgto.codigo = (int) this.formBuscaPgto.getTabelaBusca().getValueAt(this.formBuscaPgto.getTabelaBusca().getSelectedRow(), 0);
                formBuscaPgto.dispose();
            }

        } else if (acao.getSource() == this.formBuscaPgto.getSair()) {
            formBuscaPgto.dispose();
        }
    }
}
