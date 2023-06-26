package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Marca;
import com.mercadoComMaven.view.FormBuscaMarca;
import com.mercadoComMaven.service.MarcaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;



public class ControllerBuscaMarca implements ActionListener{
    
    FormBuscaMarca formBuscaMarca;
    String quemChamou;

    public ControllerBuscaMarca(FormBuscaMarca formBuscaMarca) {
        this.formBuscaMarca = formBuscaMarca;
        
        this.formBuscaMarca.getCarregar().addActionListener(this);
        this.formBuscaMarca.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaMarca.getTabelaBusca().getModel();

        for (Marca objetoAtualDaLista : MarcaService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricao()
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaMarca.getCarregar()){
            if (this.formBuscaMarca.getTabelaBusca().getValueAt(this.formBuscaMarca.getTabelaBusca().getSelectedRow(), 0) != null) {
               if (quemChamou.equalsIgnoreCase("MARCA")) {
                    ControllerCadMarca.codigo = (int) this.formBuscaMarca.getTabelaBusca().getValueAt(this.formBuscaMarca.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaMarca.dispose();
               }else if (quemChamou.equalsIgnoreCase("PRODUTO")) {
                    ControllerCadProduto.marca = (String) this.formBuscaMarca.getTabelaBusca().getValueAt(this.formBuscaMarca.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaMarca.dispose();
               }
            }
        }else if(acao.getSource() == this.formBuscaMarca.getSair()){
           this.formBuscaMarca.dispose();
        }
    }
}