/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.hotel.gui;

import br.com.senac.hotel.web.persistencia.QuartosDAO;
import br.com.senac.hotel.web.Models.Quartos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aulas
 */
public class TelaAdicionarQuarto extends javax.swing.JFrame {

    private static TelaPrincipalAdmin telaPrincipal;
    private static List<Quartos> quartosList;

    /**
     * Creates new form TelaAdicionarQuarto
     */
    public TelaAdicionarQuarto(List<Quartos> quartosList, TelaPrincipalAdmin telaPrincipal) {
        initComponents();
        this.quartosList = quartosList;
        this.telaPrincipal = telaPrincipal;
        carregarProximoId();
    }

    private void carregarProximoId() {
        QuartosDAO dao = new QuartosDAO();
        Integer proximoId = dao.obterProximoId();
        txtId.setText(proximoId.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        lblQuartos = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblDisponivel = new javax.swing.JLabel();
        cbxDisponivel = new javax.swing.JComboBox<>();
        lblValorDiaria = new javax.swing.JLabel();
        lblComodidades = new javax.swing.JLabel();
        txtComodidades = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtValorDiaria = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQuartos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblQuartos.setText("Quartos");

        lblId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblId.setText("ID:");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumero.setText("Número:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        lblDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDisponivel.setText("Disponível");

        cbxDisponivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        lblValorDiaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorDiaria.setText("Valor diária:");

        lblComodidades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblComodidades.setText("Comodidades:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtValorDiaria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorDiaria.setText("000,00");
        txtValorDiaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDiariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblQuartos))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblId)
                            .addComponent(lblTipo)
                            .addComponent(lblDisponivel)
                            .addComponent(lblValorDiaria)
                            .addComponent(lblComodidades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumero)
                            .addComponent(txtId)
                            .addComponent(txtTipo)
                            .addComponent(cbxDisponivel, 0, 222, Short.MAX_VALUE)
                            .addComponent(txtComodidades)
                            .addComponent(txtValorDiaria))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(49, 49, 49))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuartos)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponivel)
                    .addComponent(cbxDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorDiaria)
                    .addComponent(txtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComodidades)
                    .addComponent(txtComodidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSalvar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            String tipo = txtTipo.getText();
            double valorDiaria = ((Number) txtValorDiaria.getValue()).doubleValue();
            String comodidades = txtComodidades.getText();
            boolean disponivel = cbxDisponivel.getSelectedItem().equals("Sim");
            String text = txtId.getText();

            Integer id = (text == null || text.isEmpty()) ? 0 : Integer.valueOf(text);

            Quartos novoQuarto = new Quartos(id, numero, tipo, disponivel, valorDiaria, comodidades);
            QuartosDAO dao = new QuartosDAO();
            dao.cadastrar(novoQuarto);
            telaPrincipal.adicionarQuarto(novoQuarto);

            JOptionPane.showMessageDialog(this, "Quarto cadastrado com sucesso. ");
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha os campos corretamente. " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtValorDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDiariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDiariaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdicionarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarQuarto(quartosList, telaPrincipal).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxDisponivel;
    private javax.swing.JLabel lblComodidades;
    private javax.swing.JLabel lblDisponivel;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblQuartos;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValorDiaria;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtComodidades;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JFormattedTextField txtValorDiaria;
    // End of variables declaration//GEN-END:variables
}
