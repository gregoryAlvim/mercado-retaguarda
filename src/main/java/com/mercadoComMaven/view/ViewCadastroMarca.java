package com.mercadoComMaven.view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ViewCadastroMarca extends javax.swing.JFrame {
    
    public ViewCadastroMarca() {
        initComponents();
    }

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public void setPainelBotoes(JPanel painelBotoes) {
        this.painelBotoes = painelBotoes;
    }

    public JPanel getPainelDados() {
        return painelDados;
    }

    public void setPainelDados(JPanel painelDados) {
        this.painelDados = painelDados;
    }
    
    public JButton getBuscar() {
        return Buscar;
    }

    public void setBuscar(JButton Buscar) {
        this.Buscar = Buscar;
    }

    public JButton getCancelar() {
        return Cancelar;
    }

    public void setCancelar(JButton Cancelar) {
        this.Cancelar = Cancelar;
    }

    public JButton getGravar() {
        return Gravar;
    }

    public void setGravar(JButton Gravar) {
        this.Gravar = Gravar;
    }

    public JButton getNovo() {
        return Novo;
    }

    public void setNovo(JButton Novo) {
        this.Novo = Novo;
    }

    public JButton getSair() {
        return Sair;
    }

    public void setSair(JButton Sair) {
        this.Sair = Sair;
    }

    public JTextField getTextoDescricao() {
        return TextoDescricao;
    }

    public void setTextoDescricao(JTextField textoDescricao) {
        this.TextoDescricao = textoDescricao;
    }

    public JTextField getTextoId() {
        return TextoId;
    }

    public void setTextoId(JTextField textoId) {
        this.TextoId = textoId;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        painelDados = new javax.swing.JPanel();
        TextoId = new javax.swing.JTextField();
        TextoDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        Novo = new javax.swing.JButton();
        Gravar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel3.setText("Cadastro de Marca");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Id");
        jTextField1.setPreferredSize(new java.awt.Dimension(64, 35));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.setText("Descrição");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel3.add(jPanel4);

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TextoId.setBackground(new java.awt.Color(204, 204, 204));
        TextoId.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        TextoId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TextoId.setPreferredSize(new java.awt.Dimension(64, 35));
        TextoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoIdActionPerformed(evt);
            }
        });

        TextoDescricao.setBackground(new java.awt.Color(204, 204, 204));
        TextoDescricao.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        TextoDescricao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TextoDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoDescricaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Descrição");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14))
        );

        painelBotoes.setBackground(new java.awt.Color(204, 204, 204));
        painelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Novo.setBackground(new java.awt.Color(153, 153, 153));
        Novo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Novo.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Create.png")); // NOI18N
        Novo.setText("Novo");
        Novo.setActionCommand("0");
        Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        painelBotoes.add(Novo);

        Gravar.setBackground(new java.awt.Color(153, 153, 153));
        Gravar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Gravar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\OK.png")); // NOI18N
        Gravar.setText("Gravar");
        Gravar.setActionCommand("1");
        Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravarActionPerformed(evt);
            }
        });
        painelBotoes.add(Gravar);

        Cancelar.setBackground(new java.awt.Color(153, 153, 153));
        Cancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Cancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Cancel.png")); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.setActionCommand("1");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        painelBotoes.add(Cancelar);

        Buscar.setBackground(new java.awt.Color(153, 153, 153));
        Buscar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Buscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Find.png")); // NOI18N
        Buscar.setText("Buscar");
        Buscar.setActionCommand("0");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        painelBotoes.add(Buscar);

        Sair.setBackground(new java.awt.Color(153, 153, 153));
        Sair.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Sair.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Desktop\\jp\\mercado-retaguarda\\src\\test\\java\\images\\Exit.png")); // NOI18N
        Sair.setText("Sair");
        Sair.setActionCommand("0");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        painelBotoes.add(Sair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 853, Short.MAX_VALUE)
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void TextoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoIdActionPerformed

    private void TextoDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoDescricaoActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NovoActionPerformed

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GravarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SairActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastroMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Gravar;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Sair;
    private javax.swing.JTextField TextoDescricao;
    private javax.swing.JTextField TextoId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDados;
    // End of variables declaration//GEN-END:variables
}
