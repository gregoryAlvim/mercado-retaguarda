package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Produto;
import com.mercadoComMaven.view.FormBuscaProduto;
import com.mercadoComMaven.service.ProdutoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ControllerBuscaProduto implements ActionListener{
    
    FormBuscaProduto formBuscaProduto;
    String quemChamou;

    public ControllerBuscaProduto(FormBuscaProduto formBuscaProduto) {
        this.formBuscaProduto = formBuscaProduto;
        
        this.formBuscaProduto.getCarregar().addActionListener(this);
        this.formBuscaProduto.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaProduto.getTabelaBusca().getModel();

        for (Produto objetoAtualDaLista : ProdutoService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricao(),
                objetoAtualDaLista.getValorCompra(),
                objetoAtualDaLista.getValorVenda(),
                objetoAtualDaLista.getStatus(),
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaProduto.getCarregar()){
           if (this.formBuscaProduto.getTabelaBusca().getValueAt(this.formBuscaProduto.getTabelaBusca().getSelectedRow(), 0) != null) {
                ControllerCadProduto.codigo = (int) this.formBuscaProduto.getTabelaBusca().getValueAt(this.formBuscaProduto.getTabelaBusca().getSelectedRow(), 0);
                formBuscaProduto.dispose();
               
            }
        }else if(acao.getSource() == this.formBuscaProduto.getSair()){
            this.formBuscaProduto.dispose();
        }
    }
}

