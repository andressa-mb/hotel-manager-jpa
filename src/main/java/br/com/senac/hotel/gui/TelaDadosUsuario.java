package br.com.senac.hotel.gui;

import br.com.senac.hotel.web.persistencia.UsuariosDAO;
import br.com.senac.hotel.web.Models.Usuarios;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaDadosUsuario extends javax.swing.JFrame {

    UsuariosDAO usuariosDAO = new UsuariosDAO();
    public static Usuarios usuario;
    private static TelaPrincipalAdmin telaAdmin;

    public TelaDadosUsuario(Usuarios u, TelaPrincipalAdmin telaAdmin) {
        initComponents();
        this.usuario = u;
        this.telaAdmin = telaAdmin;
        preencheCampos();

    }

    public void preencheCampos() {
        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());
        txtEndereco.setText(usuario.getEndereco());
        txtTelefone.setText(usuario.getTelefone());
        txtPerfilUsuario.setText(String.valueOf(usuario.getPerfilUsuarioId()));
        txtPreferencias.setText(usuario.getPreferencias());
        txtSenha.setText(usuario.getSenha());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTela1 = new javax.swing.JPanel();
        pnlTela2 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblPerfilUsuario = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPreferencias = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblPreferencias = new javax.swing.JLabel();
        txtPerfilUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTela1.setBackground(new java.awt.Color(194, 208, 255));

        pnlTela2.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Perpetua", 0, 36)); // NOI18N
        lblUsuario.setText("USUÁRIO:");

        lblEndereco.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblEndereco.setText("* ENDEREÇO:");

        lblTelefone.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblTelefone.setText("* TELEFONE:");

        lblEmail.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblEmail.setText("* E-MAIL:");

        lblSenha.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblSenha.setText("* SENHA:");

        lblNome.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblNome.setText("* NOME:");

        lblPerfilUsuario.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblPerfilUsuario.setText("* PERFIL DE USUÁRIO:");

        txtNome.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        txtEndereco.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        txtTelefone.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        txtPreferencias.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        btnSalvar.setBackground(new java.awt.Color(22, 60, 251));
        btnSalvar.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.setBorderPainted(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblPreferencias.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblPreferencias.setText("PREFERÊNCIAS:");

        txtPerfilUsuario.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlTela2Layout = new javax.swing.GroupLayout(pnlTela2);
        pnlTela2.setLayout(pnlTela2Layout);
        pnlTela2Layout.setHorizontalGroup(
            pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela2Layout.createSequentialGroup()
                .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTela2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTela2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTela2Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(59, 59, 59)
                                .addComponent(lblUsuario))
                            .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPreferencias, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addComponent(lblSenha)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addComponent(lblEmail)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addComponent(lblTelefone)
                                .addComponent(lblEndereco)
                                .addComponent(lblPerfilUsuario)
                                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                            .addComponent(lblPreferencias)
                            .addComponent(txtPerfilUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlTela2Layout.setVerticalGroup(
            pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTela2Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(27, 27, 27))
                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblPerfilUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPreferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTela1Layout = new javax.swing.GroupLayout(pnlTela1);
        pnlTela1.setLayout(pnlTela1Layout);
        pnlTela1Layout.setHorizontalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(pnlTela2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        pnlTela1Layout.setVerticalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTela2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String senha = txtSenha.getText();
        String perfil = txtPerfilUsuario.getText();
        String preferencias = txtPreferencias.getText();

        try {

            if (!nome.isEmpty() && !endereco.isEmpty() && !telefone.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
                List<Usuarios> listaUsuarios = usuariosDAO.getUsuarios();
                System.out.println("ID do usuário logado tela Dados: " + usuario.getId());
                for (Usuarios user : listaUsuarios) {
                    if (user.getId() == usuario.getId()) {
                        System.out.println("ID na lista: " + user.getId());
                        user.setNome(nome);
                        user.setEndereco(endereco);
                        user.setTelefone(telefone);
                        user.setEmail(email);
                        user.setSenha(senha);
                        user.setPerfilUsuarioId(Integer.parseInt(perfil));
                        user.setPreferencias(preferencias);
                        usuariosDAO.adminEdita(user);
                        JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        telaAdmin.atualizarUsuarios();
                        this.dispose();

                        return;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!",
                        "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados. " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDadosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDadosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDadosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDadosUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaDadosUsuario editUsuario = new TelaDadosUsuario(usuario, telaAdmin);
                editUsuario.setVisible(true);
                editUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfilUsuario;
    private javax.swing.JLabel lblPreferencias;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlTela1;
    private javax.swing.JPanel pnlTela2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPerfilUsuario;
    private javax.swing.JTextField txtPreferencias;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
