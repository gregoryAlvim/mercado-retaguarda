package com.mercadoComMaven.controller;

import com.mercadoComMaven.modelBO.Cidade;
import com.mercadoComMaven.view.FormBuscaCidade;
import com.mercadoComMaven.service.CidadeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControllerBuscaCidade implements ActionListener {

    FormBuscaCidade formBuscaCidade;
    String quemChamou;

    public ControllerBuscaCidade(FormBuscaCidade formBuscaCidade) {
        this.formBuscaCidade = formBuscaCidade;

        this.formBuscaCidade.getCarregar().addActionListener(this);
        this.formBuscaCidade.getSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.formBuscaCidade.getTabelaBusca().getModel();

        for (Cidade objetoAtualDaLista : CidadeService.buscar()) {
            tabela.addRow(new Object[]{
                objetoAtualDaLista.getId(),
                objetoAtualDaLista.getDescricao()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.formBuscaCidade.getCarregar()) {
            if (this.formBuscaCidade.getTabelaBusca().getValueAt(this.formBuscaCidade.getTabelaBusca().getSelectedRow(), 0) != null) {
                if (quemChamou.equalsIgnoreCase("CIDADE")) {
                    ControllerCadCidade.codigo = (int) this.formBuscaCidade.getTabelaBusca().getValueAt(this.formBuscaCidade.getTabelaBusca().getSelectedRow(), 0);
                    formBuscaCidade.dispose();
                } else if (quemChamou.equalsIgnoreCase("ENDERECO")) {
                    ControllerCadEndereco.cidade = (String) this.formBuscaCidade.getTabelaBusca().getValueAt(this.formBuscaCidade.getTabelaBusca().getSelectedRow(), 1);
                    formBuscaCidade.dispose();
                }
            }
        } else if (acao.getSource() == this.formBuscaCidade.getSair()) {
            this.formBuscaCidade.dispose();
        }
    }
}
