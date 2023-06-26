package com.mercadoComMaven.view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewCadastroFornecedor extends javax.swing.JFrame {

    public ViewCadastroFornecedor() {
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

    public JComboBox<String> getComboBoxStatus() {
        return ComboBoxStatus;
    }

    public void setComboBoxStatus(JComboBox<String> ComboBoxStatus) {
        this.ComboBoxStatus = ComboBoxStatus;
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

    public JTextField getTextoCnpj() {
        return textoCnpj;
    }

    public void setTextoCnpj(JTextField textoCnpj) {
        this.textoCnpj = textoCnpj;
    }

    public JTextField getTextoContato() {
        return textoContato;
    }

    public void setTextoContato(JTextField textoContato) {
        this.textoContato = textoContato;
    }

    public JTextField getTextoCpf() {
        return textoCpf;
    }

    public void setTextoCpf(JTextField textoCpf) {
        this.textoCpf = textoCpf;
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

    public void setTextoEmail(JTextField textoEmail) {
        this.textoEmail = textoEmail;
    }

    public JTextField getTextoInsc() {
        return textoInsc;
    }

    public void setTextoInsc(JTextField textoInsc) {
        this.textoInsc = textoInsc;
    }

    public JTextField getTextoNome() {
        return textoNome;
    }

    public void setTextoNome(JTextField textoNome) {
        this.textoNome = textoNome;
    }

    public JTextField getTextoRazao() {
        return textoRazao;
    }

    public void setTextoRazao(JTextField textoRazao) {
        this.textoRazao = textoRazao;
    }

    public JTextField getTextoRg() {
        return textoRg;
    }

    public void setTextoRg(JTextField textoRg) {
        this.textoRg = textoRg;
    }

    public JButton getBotaoBuscarEndereco() {
        return botaoBuscarEndereco;
    }

    public void setBotaoBuscarEndereco(JButton botaoBuscarEndereco) {
        this.botaoBuscarEndereco = botaoBuscarEndereco;
    }

    public JTextField getTextoComplemento() {
        return textoComplemento;
    }

    public void setTextoComplemento(JTextField textoComplemento) {
        this.textoComplemento = textoComplemento;
    }

    public JTextField getTextoEndereco() {
        return textoEndereco;
    }

    public void setTextoEndereco(JTextField textoEndereco) {
        this.textoEndereco = textoEndereco;
    }

    public JTextField getTextoTelefone1() {
        return textoTelefone1;
    }

    public void setTextoTelefone1(JTextField textoTelefone1) {
        this.textoTelefone1 = textoTelefone1;
    }

    public JTextField getTextoTelefone2() {
        return textoTelefone2;
    }

    public void setTextoTelefone2(JTextField textoTelefone2) {
        this.textoTelefone2 = textoTelefone2;
    }

    public JTextField getTextoId() {
        return textoId;
    }

    public void setTextoId(JTextField textoId) {
        this.textoId = textoId;
    }

    public JTextField getTextoObservacao() {
        return textoObservacao;
    }

    public void setTextoObservacao(JTextField textoObservacao) {
        this.textoObservacao = textoObservacao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkbox1 = new java.awt.Checkbox();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        textoRazao = new javax.swing.JTextField();
        textoCnpj = new javax.swing.JTextField();
        textoRg = new javax.swing.JTextField();
        textoContato = new javax.swing.JTextField();
        textoInsc = new javax.swing.JTextField();
        textoCpf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboBoxStatus = new javax.swing.JComboBox<>();
        textoNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoComplemento = new javax.swing.JTextField();
        textoEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textoTelefone1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        botaoBuscarEndereco = new javax.swing.JButton();
        textoTelefone2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textoId = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textoObservacao = new javax.swing.JTextField();
        painelBotoes = new javax.swing.JPanel();
        Novo = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Gravar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Sair = new javax.swing.JButton();

        checkbox1.setLabel("checkbox1");

        jLabel9.setText("Email:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel2.setText("Cadastro de Fornecedor");
        jPanel2.add(jLabel2);

        painelDados.setBackground(new java.awt.Color(255, 255, 255));
        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textoRazao.setBackground(new java.awt.Color(204, 204, 204));
        textoRazao.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoRazao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRazaoActionPerformed(evt);
            }
        });

        textoCnpj.setBackground(new java.awt.Color(204, 204, 204));
        textoCnpj.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCnpjActionPerformed(evt);
            }
        });

        textoRg.setBackground(new java.awt.Color(204, 204, 204));
        textoRg.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRgActionPerformed(evt);
            }
        });

        textoContato.setBackground(new java.awt.Color(204, 204, 204));
        textoContato.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoContatoActionPerformed(evt);
            }
        });

        textoInsc.setBackground(new java.awt.Color(204, 204, 204));
        textoInsc.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoInscActionPerformed(evt);
            }
        });

        textoCpf.setBackground(new java.awt.Color(204, 204, 204));
        textoCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCpfActionPerformed(evt);
            }
        });

        jLabel1.setText("INSC Estadual:");

        jLabel3.setText("CNPJ:");

        jLabel4.setText("CPF:");

        jLabel5.setText("RG:");

        jLabel6.setText("Razão Social:");

        jLabel7.setText("Contato:");

        textoEmail.setBackground(new java.awt.Color(204, 204, 204));
        textoEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEmailActionPerformed(evt);
            }
        });

        jLabel8.setText("Email:");

        jLabel10.setText("Status:");

        ComboBoxStatus.setBackground(new java.awt.Color(204, 204, 204));
        ComboBoxStatus.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStatusActionPerformed(evt);
            }
        });

        textoNome.setBackground(new java.awt.Color(204, 204, 204));
        textoNome.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNomeActionPerformed(evt);
            }
        });

        jLabel11.setText("Nome:");

        jLabel12.setText("Telefone 1:");

        textoComplemento.setBackground(new java.awt.Color(204, 204, 204));
        textoComplemento.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoComplementoActionPerformed(evt);
            }
        });

        textoEndereco.setEditable(false);
        textoEndereco.setBackground(new java.awt.Color(204, 204, 204));
        textoEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoEndereco.setEnabled(false);
        textoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEnderecoActionPerformed(evt);
            }
        });

        jLabel13.setText("Telefone 2:");

        textoTelefone1.setBackground(new java.awt.Color(204, 204, 204));
        textoTelefone1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTelefone1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Endereço");

        botaoBuscarEndereco.setBackground(new java.awt.Color(204, 204, 204));
        botaoBuscarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        botaoBuscarEndereco.setText("jButton6");

        textoTelefone2.setBackground(new java.awt.Color(204, 204, 204));
        textoTelefone2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoTelefone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTelefone2ActionPerformed(evt);
            }
        });

        jLabel15.setText("Complemento:");

        textoId.setEditable(false);
        textoId.setText("jTextField1");
        textoId.setEnabled(false);
        textoId.setFocusable(false);
        textoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoIdActionPerformed(evt);
            }
        });

        jLabel16.setText("Obsevação:");

        textoObservacao.setBackground(new java.awt.Color(204, 204, 204));
        textoObservacao.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textoObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoObservacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(textoInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(textoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                            .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addGap(222, 222, 222))
                        .addGroup(painelDadosLayout.createSequentialGroup()
                            .addComponent(textoContato, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                            .addComponent(textoRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                            .addComponent(textoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoBuscarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                            .addComponent(textoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(textoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(textoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(textoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoContato, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(textoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(botaoBuscarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        painelBotoes.setBackground(new java.awt.Color(204, 204, 204));
        painelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Novo.setBackground(new java.awt.Color(153, 153, 153));
        Novo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Novo.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\NetBeansProjects\\mercadoComMaven\\src\\test\\java\\images\\Create.png")); // NOI18N
        Novo.setText("Novo");
        Novo.setActionCommand("0");
        Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        painelBotoes.add(Novo);

        Cancelar.setBackground(new java.awt.Color(153, 153, 153));
        Cancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Cancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\NetBeansProjects\\mercadoComMaven\\src\\test\\java\\images\\Delete.png")); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.setActionCommand("1");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        painelBotoes.add(Cancelar);

        Gravar.setBackground(new java.awt.Color(153, 153, 153));
        Gravar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Gravar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\NetBeansProjects\\mercadoComMaven\\src\\test\\java\\images\\OK.png")); // NOI18N
        Gravar.setText("Gravar");
        Gravar.setActionCommand("1");
        Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravarActionPerformed(evt);
            }
        });
        painelBotoes.add(Gravar);

        Buscar.setBackground(new java.awt.Color(153, 153, 153));
        Buscar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Buscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\NetBeansProjects\\mercadoComMaven\\src\\test\\java\\images\\Find.png")); // NOI18N
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
        Sair.setIcon(new javax.swing.ImageIcon("C:\\Users\\aluno\\Documents\\NetBeansProjects\\mercadoComMaven\\src\\test\\java\\images\\Exit.png")); // NOI18N
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCnpjActionPerformed

    private void textoRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRgActionPerformed

    private void textoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoContatoActionPerformed

    private void textoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoInscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoInscActionPerformed

    private void textoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCpfActionPerformed

    private void textoRazaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRazaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRazaoActionPerformed

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

    private void textoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEmailActionPerformed

    private void ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxStatusActionPerformed

    private void textoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNomeActionPerformed

    private void textoComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoComplementoActionPerformed

    private void textoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEnderecoActionPerformed

    private void textoTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTelefone1ActionPerformed

    private void textoTelefone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTelefone2ActionPerformed

    private void textoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoIdActionPerformed

    private void textoObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoObservacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoObservacaoActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastroFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox<String> ComboBoxStatus;
    private javax.swing.JButton Gravar;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Sair;
    private javax.swing.JButton botaoBuscarEndereco;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTextField textoCnpj;
    private javax.swing.JTextField textoComplemento;
    private javax.swing.JTextField textoContato;
    private javax.swing.JTextField textoCpf;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoEndereco;
    private javax.swing.JTextField textoId;
    private javax.swing.JTextField textoInsc;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoObservacao;
    private javax.swing.JTextField textoRazao;
    private javax.swing.JTextField textoRg;
    private javax.swing.JTextField textoTelefone1;
    private javax.swing.JTextField textoTelefone2;
    // End of variables declaration//GEN-END:variables
}
