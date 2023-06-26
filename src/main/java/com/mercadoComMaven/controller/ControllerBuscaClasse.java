package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Classe;
import com.mercadoComMaven.view.FormBuscaClasse;
import com.mercadoComMaven.service.ClasseService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaClasse implements ActionListener{
    FormBuscaClasse formBuscaClasse;
     String quemChamou;

    public ControllerBuscaClasse(FormBuscaClasse formBuscaClasse) {
        this.formBuscaClasse = formBuscaClasse;
        
        this.formBuscaClasse.getCarregar().addActionListener(this);
        this.formBuscaClasse.getSair().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaClasse.getTabelaBusca().getModel();

        for (Classe objetoAtualDaLista : ClasseService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricao()
            });
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao){
        if(acao.getSource() == this.formBuscaClasse.getCarregar()){
           if (this.formBuscaClasse.getTabelaBusca().getValueAt(this.formBuscaClasse.getTabelaBusca().getSelectedRow(), 0) != null) {
                if (quemChamou.equalsIgnoreCase("CLASSE")) {
                    ControllerCadClasse.codigo = (int) this.formBuscaClasse.getTabelaBusca().getValueAt(this.formBuscaClasse.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaClasse.dispose();
                }else if (quemChamou.equalsIgnoreCase("PRODUTO")) {
                    ControllerCadProduto.classe = (String) this.formBuscaClasse.getTabelaBusca().getValueAt(this.formBuscaClasse.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaClasse.dispose();
                }
            }
        }else if(acao.getSource() == this.formBuscaClasse.getSair()){
           this.formBuscaClasse.dispose();
        }
    }
}
