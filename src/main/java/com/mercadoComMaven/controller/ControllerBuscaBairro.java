package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Bairro;
import com.mercadoComMaven.view.FormBuscaBairro;
import com.mercadoComMaven.service.BairroService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaBairro implements ActionListener {

    FormBuscaBairro formBuscaBairro;
    String quemChamou;

    public ControllerBuscaBairro(FormBuscaBairro formBuscaBairro) {
        this.formBuscaBairro = formBuscaBairro;

        this.formBuscaBairro.getCarregar().addActionListener(this);
        this.formBuscaBairro.getSair().addActionListener(this);

        //Carregar os dados para a jTable
        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaBairro.getTabelaBusca().getModel();

        for (Bairro objetoAtualDaLista : BairroService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricao()
            });
        }

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.formBuscaBairro.getCarregar()) {
            if (this.formBuscaBairro.getTabelaBusca().getValueAt(this.formBuscaBairro.getTabelaBusca().getSelectedRow(), 0) != null) {
                if (quemChamou.equalsIgnoreCase("BAIRRO")) {
                    ControllerCadBairro.codigo = (int) this.formBuscaBairro.getTabelaBusca().getValueAt(this.formBuscaBairro.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaBairro.dispose();
                } else if (quemChamou.equalsIgnoreCase("ENDERECO")) {
                    ControllerCadEndereco.bairro = (String) this.formBuscaBairro.getTabelaBusca().getValueAt(this.formBuscaBairro.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaBairro.dispose();
                }
            }

        } else if (acao.getSource() == this.formBuscaBairro.getSair()) {
            formBuscaBairro.dispose();
        }
    }
}
