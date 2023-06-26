package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Colaborador;
import com.mercadoComMaven.view.FormBuscaColaborador;
import com.mercadoComMaven.service.ColaboradorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ControllerBuscaColaborador implements ActionListener {

    FormBuscaColaborador formBuscarColaborador;

    public ControllerBuscaColaborador(FormBuscaColaborador formBuscarColaborador) {
        this.formBuscarColaborador = formBuscarColaborador;

        this.formBuscarColaborador.getCarregar().addActionListener(this);
        this.formBuscarColaborador.getSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.formBuscarColaborador.getTabelaBusca().getModel();

        for (Colaborador objetoAtualDaLista : ColaboradorService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getNome(),
                objetoAtualDaLista.getEmail(),
                objetoAtualDaLista.getStatus(),});
        }
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.formBuscarColaborador.getCarregar()) {
            if (this.formBuscarColaborador.getTabelaBusca().getValueAt(this.formBuscarColaborador.getTabelaBusca().getSelectedRow(), 0) != null) {
                ControllerCadColaborador.codigo = (int) this.formBuscarColaborador.getTabelaBusca().getValueAt(this.formBuscarColaborador.getTabelaBusca().getSelectedRow(), 0);
                formBuscarColaborador.dispose();
            }
        } else if (acao.getSource() == this.formBuscarColaborador.getSair()) {
            this.formBuscarColaborador.dispose();
        }
    }
}
