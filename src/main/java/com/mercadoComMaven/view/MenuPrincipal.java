package com.mercadoComMaven.view;

import com.mercadoComMaven.view.ViewCadastroBairro;
import com.mercadoComMaven.view.ViewCadastroCidade;
import com.mercadoComMaven.view.ViewCadastroCliente;
import com.mercadoComMaven.view.ViewCadastroColaborador;
import com.mercadoComMaven.view.ViewCadastroCondicaoPgto;
import com.mercadoComMaven.view.ViewCadastroEndereco;
import com.mercadoComMaven.view.ViewCadastroFornecedor;
import com.mercadoComMaven.controller.ControllerCadBairro;
import com.mercadoComMaven.controller.ControllerCadCidade;
import com.mercadoComMaven.controller.ControllerCadClasse;
import com.mercadoComMaven.controller.ControllerCadCliente;
import com.mercadoComMaven.controller.ControllerCadColaborador;
import com.mercadoComMaven.controller.ControllerCadCondicaoPgto;
import com.mercadoComMaven.controller.ControllerCadEndereco;
import com.mercadoComMaven.controller.ControllerCadFornecedor;
import com.mercadoComMaven.controller.ControllerCadMarca;
import com.mercadoComMaven.controller.ControllerCadProduto;

/**
 *
 * @author aluno
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemBairro = new javax.swing.JMenuItem();
        jMenuItemCidade = new javax.swing.JMenuItem();
        jMenuItemEndereco = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemColaborador = new javax.swing.JMenuItem();
        jMenuItemFornecedor = new javax.swing.JMenuItem();
        jMenuItemCondicaoPagamento = new javax.swing.JMenuItem();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenuItemMarca = new javax.swing.JMenuItem();
        jMenuItemClasse = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastros");

        jMenuItemBairro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemBairro.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Component.png")); // NOI18N
        jMenuItemBairro.setText("Bairro");
        jMenuItemBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBairroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemBairro);

        jMenuItemCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCidade.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Company.png")); // NOI18N
        jMenuItemCidade.setText("Cidade");
        jMenuItemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCidadeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCidade);

        jMenuItemEndereco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEndereco.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Home.png")); // NOI18N
        jMenuItemEndereco.setText("Endereço");
        jMenuItemEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnderecoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEndereco);
        jMenu1.add(jSeparator1);

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\People.png")); // NOI18N
        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCliente);

        jMenuItemColaborador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemColaborador.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Briefcase.png")); // NOI18N
        jMenuItemColaborador.setText("Colaborador");
        jMenuItemColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColaboradorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemColaborador);

        jMenuItemFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemFornecedor.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Boss.png")); // NOI18N
        jMenuItemFornecedor.setText("Fornecedor");
        jMenuItemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFornecedor);

        jMenuItemCondicaoPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCondicaoPagamento.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Dollar.png")); // NOI18N
        jMenuItemCondicaoPagamento.setText("Condição Pagamento");
        jMenuItemCondicaoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCondicaoPagamentoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCondicaoPagamento);

        jMenuItemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemProduto.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Blue tag.png")); // NOI18N
        jMenuItemProduto.setText("Produto");
        jMenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProduto);

        jMenuItemMarca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemMarca.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Green bookmark.png")); // NOI18N
        jMenuItemMarca.setText("Marca");
        jMenuItemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMarcaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemMarca);

        jMenuItemClasse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemClasse.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Blue pin.png")); // NOI18N
        jMenuItemClasse.setText("Classe");
        jMenuItemClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClasseActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClasse);
        jMenu1.add(jSeparator2);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Exit.png")); // NOI18N
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimentos");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Relatórios");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ajuda");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColaboradorActionPerformed
        ViewCadastroColaborador telaColaborador = new ViewCadastroColaborador();
        ControllerCadColaborador controllerEndereco = new ControllerCadColaborador(telaColaborador);
        telaColaborador.setVisible(true);
    }//GEN-LAST:event_jMenuItemColaboradorActionPerformed

    private void jMenuItemEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnderecoActionPerformed
        ViewCadastroEndereco telaEndereco = new ViewCadastroEndereco();
        ControllerCadEndereco controllerEndereco = new ControllerCadEndereco(telaEndereco);
        telaEndereco.setVisible(true);
    }//GEN-LAST:event_jMenuItemEnderecoActionPerformed

    private void jMenuItemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedorActionPerformed
        ViewCadastroFornecedor telaFornecedor = new ViewCadastroFornecedor();
        ControllerCadFornecedor controllerFornecedor= new ControllerCadFornecedor(telaFornecedor);
        telaFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItemFornecedorActionPerformed

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        ViewCadastroCliente telaCliente = new ViewCadastroCliente();
        ControllerCadCliente controllerCliente = new ControllerCadCliente(telaCliente);
        telaCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBairroActionPerformed
        ViewCadastroBairro telaBairro = new ViewCadastroBairro();
        ControllerCadBairro controllerBairro = new ControllerCadBairro(telaBairro);
        telaBairro.setVisible(true);
    }//GEN-LAST:event_jMenuItemBairroActionPerformed

    private void jMenuItemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCidadeActionPerformed
        ViewCadastroCidade telaCidade = new ViewCadastroCidade();
        ControllerCadCidade controllerCidade = new ControllerCadCidade(telaCidade);
        telaCidade.setVisible(true);
    }//GEN-LAST:event_jMenuItemCidadeActionPerformed

    private void jMenuItemCondicaoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCondicaoPagamentoActionPerformed
        ViewCadastroCondicaoPgto telaCondicaoPgto = new ViewCadastroCondicaoPgto();
        ControllerCadCondicaoPgto controllerCondicaoPgto = new ControllerCadCondicaoPgto(telaCondicaoPgto);
        telaCondicaoPgto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCondicaoPagamentoActionPerformed

    private void jMenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutoActionPerformed
        ViewCadastroProduto telaProduto = new ViewCadastroProduto();
        ControllerCadProduto controllerProduto = new ControllerCadProduto(telaProduto);
        telaProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemProdutoActionPerformed

    private void jMenuItemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMarcaActionPerformed
        ViewCadastroMarca telaMarca = new ViewCadastroMarca();
        ControllerCadMarca controllerMarca = new ControllerCadMarca(telaMarca);
        telaMarca.setVisible(true);
    }//GEN-LAST:event_jMenuItemMarcaActionPerformed

    private void jMenuItemClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClasseActionPerformed
        ViewCadastroClasse telaClasse = new ViewCadastroClasse();
        ControllerCadClasse controllerClasse = new ControllerCadClasse(telaClasse);
        telaClasse.setVisible(true);
    }//GEN-LAST:event_jMenuItemClasseActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBairro;
    private javax.swing.JMenuItem jMenuItemCidade;
    private javax.swing.JMenuItem jMenuItemClasse;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemColaborador;
    private javax.swing.JMenuItem jMenuItemCondicaoPagamento;
    private javax.swing.JMenuItem jMenuItemEndereco;
    private javax.swing.JMenuItem jMenuItemFornecedor;
    private javax.swing.JMenuItem jMenuItemMarca;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
