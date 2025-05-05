package br.com.senac.hotel.gui;

import br.com.senac.hotel.web.persistencia.QuartosDAO;
import br.com.senac.hotel.web.persistencia.ReservaDAO;
import br.com.senac.hotel.web.persistencia.UsuariosDAO;
import br.com.senac.hotel.web.Models.Quartos;
import br.com.senac.hotel.web.Models.Reserva;
import br.com.senac.hotel.web.Models.Usuarios;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipalAdmin extends javax.swing.JFrame {

    QuartosDAO quartosDAO = new QuartosDAO();
    private List<Quartos> quartosList = quartosDAO.getQuartos();
    UsuariosDAO usuariosDAO = new UsuariosDAO();
    private List<Usuarios> usuariosList = usuariosDAO.getUsuarios();
    private static Usuarios usuarioLogado = TelaLogin.getUsuarioLogado();
    ReservaDAO reservaDAO = new ReservaDAO();
    private List<Reserva> reservasList = reservaDAO.getReservas();

    public TelaPrincipalAdmin(Usuarios usuario) {
        initComponents();
        this.usuarioLogado = usuario;
        lblBemVindo.setText("Bem-vindo, " + usuarioLogado.getNome() + " " + usuarioLogado.getPerfilUsuarioNome());
        if (usuarioLogado.getPerfilUsuarioId() == 2) {
            btnRelatEstatistica.setVisible(false);
        } else {
            btnRelatEstatistica.setVisible(true);
        }
        btnAdicionarQuarto.setVisible(false);
        btnEditarQuarto.setVisible(false);
        btnExcluirQuarto.setVisible(false);
        btnAdicionarUsuario.setVisible(false);
        btnExcluirUsuario.setVisible(false);
        btnEditarUsuario.setVisible(false);
        btnAdicionarReservas.setVisible(false);
        btnEditarReservas.setVisible(false);
        btnExcluirReservas.setVisible(false);
    }

    public void preencheTabelaReservas(List<Reserva> reservasList) {
        String colunas[] = {"ID", "HospedeId", "QuartoId", "Check-in", "Previsão Check-out", "Check-out", "Status da Reserva", "Pagamento"};
        String dados[][] = new String[reservasList.size()][colunas.length];

        int i = 0;
        for (Reserva reserva : reservasList) {
            dados[i] = new String[]{
                String.valueOf(reserva.getId()),
                String.valueOf(reserva.getHospedeId()),
                String.valueOf(reserva.getQuartoId()),
                String.valueOf(reserva.getDataCheckin()),
                String.valueOf(reserva.getDataPrevCheckout()),
                String.valueOf(reserva.getDataCheckout()),
                String.valueOf(reserva.getStatus()),
                String.valueOf(reserva.getDetalhesPagamento())
            };
            i++;
        }
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        tblResults.setModel(modeloTabela);

        if (usuarioLogado.getPerfilUsuarioId() != 1) {
            btnAdicionarUsuario.setVisible(false);
            btnExcluirUsuario.setVisible(false);
            btnEditarUsuario.setVisible(false);
            btnAdicionarQuarto.setVisible(false);
            btnEditarQuarto.setVisible(false);
            btnExcluirQuarto.setVisible(false);
            btnAdicionarReservas.setVisible(true);
            btnEditarReservas.setVisible(true);
            btnExcluirReservas.setVisible(true);
        } else {
            btnAdicionarUsuario.setVisible(false);
            btnExcluirUsuario.setVisible(false);
            btnEditarUsuario.setVisible(false);
            btnAdicionarQuarto.setVisible(false);
            btnEditarQuarto.setVisible(false);
            btnExcluirQuarto.setVisible(false);
            btnAdicionarReservas.setVisible(true);
            btnEditarReservas.setVisible(true);
            btnExcluirReservas.setVisible(true);
        }
    }

    public void preencheTabelaQuartos(List<Quartos> quartosList) {

        String colunas[] = {"Id", "Número", "Tipo", "Disponível", "Valor da diária", "Comodidades"};
        String dados[][] = new String[quartosList.size()][colunas.length];

        int i = 0;
        for (Quartos quarto : quartosList) {
            dados[i] = new String[]{
                String.valueOf(quarto.getId()),
                String.valueOf(quarto.getNumero()),
                quarto.getTipo(),
                String.valueOf(quarto.getDisponivel()),
                String.valueOf(quarto.getValor_diaria()),
                quarto.getComodidades()
            };
            i++;
        }
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        tblResults.setModel(modeloTabela);

        if (usuarioLogado.getPerfilUsuarioId() != 1) {
            btnAdicionarUsuario.setVisible(false);
            btnExcluirUsuario.setVisible(false);
            btnEditarUsuario.setVisible(false);
            btnAdicionarQuarto.setVisible(false);
            btnEditarQuarto.setVisible(true);
            btnExcluirQuarto.setVisible(false);
            btnAdicionarReservas.setVisible(false);
            btnEditarReservas.setVisible(false);
            btnExcluirReservas.setVisible(false);
        } else {
            btnAdicionarUsuario.setVisible(false);
            btnExcluirUsuario.setVisible(false);
            btnEditarUsuario.setVisible(false);
            btnAdicionarQuarto.setVisible(true);
            btnEditarQuarto.setVisible(true);
            btnExcluirQuarto.setVisible(true);
            btnAdicionarReservas.setVisible(false);
            btnEditarReservas.setVisible(false);
            btnExcluirReservas.setVisible(false);
        }
    }

    public void preencheTabelaUsuarios(List<Usuarios> usuariosList) {
        String colunas[] = {"Id", "Nome", "Perfil de Usuário", "Endereço", "Telefone", "Email", "Preferências"};
        String dados[][] = new String[usuariosList.size()][colunas.length];

        int i = 0;
        for (Usuarios u : usuariosList) {
            dados[i] = new String[]{
                String.valueOf(u.getId()),
                u.getNome(),
                u.getPerfilUsuarioNome(),
                u.getEndereco(),
                u.getTelefone(),
                u.getEmail(),
                u.getPreferencias()
            };
            i++;
        }

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        tblResults.setModel(modeloTabela);

        if (usuarioLogado.getPerfilUsuarioId() != 1) {
            btnAdicionarUsuario.setVisible(true);
            btnExcluirUsuario.setVisible(false);
            btnEditarUsuario.setVisible(true);
            btnAdicionarQuarto.setVisible(false);
            btnEditarQuarto.setVisible(false);
            btnExcluirQuarto.setVisible(false);
            btnAdicionarReservas.setVisible(false);
            btnEditarReservas.setVisible(false);
            btnExcluirReservas.setVisible(false);
        } else {
            btnAdicionarUsuario.setVisible(true);
            btnExcluirUsuario.setVisible(true);
            btnEditarUsuario.setVisible(true);
            btnAdicionarQuarto.setVisible(false);
            btnEditarQuarto.setVisible(false);
            btnExcluirQuarto.setVisible(false);
            btnAdicionarReservas.setVisible(false);
            btnEditarReservas.setVisible(false);
            btnExcluirReservas.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTela1 = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnlTelaMain = new javax.swing.JPanel();
        pnsMain = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        btnQuartos = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnRelatEstatistica = new javax.swing.JButton();
        btnAdicionarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnExcluirUsuario = new javax.swing.JButton();
        btnAdicionarQuarto = new javax.swing.JButton();
        btnEditarQuarto = new javax.swing.JButton();
        btnExcluirQuarto = new javax.swing.JButton();
        btnAdicionarReservas = new javax.swing.JButton();
        btnEditarReservas = new javax.swing.JButton();
        btnExcluirReservas = new javax.swing.JButton();
        lblLogoF = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTela1.setBackground(new java.awt.Color(194, 208, 255));

        lblBemVindo.setFont(new java.awt.Font("Perpetua", 2, 24)); // NOI18N
        lblBemVindo.setText("Bem vindo");

        lblLogo.setText("LOGO");

        pnlTelaMain.setBackground(new java.awt.Color(115, 129, 255));

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        pnsMain.setViewportView(tblResults);

        btnQuartos.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnQuartos.setText("Quartos");
        btnQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuartosActionPerformed(evt);
            }
        });

        btnReservas.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnReservas.setText("Reservas");
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        btnUsuarios.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnUsuarios.setText("Usuários");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnRelatEstatistica.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        btnRelatEstatistica.setText("Relatórios e Estatísticas");
        btnRelatEstatistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatEstatisticaActionPerformed(evt);
            }
        });

        btnAdicionarUsuario.setText("ADICIONAR USUÁRIO");
        btnAdicionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarUsuarioActionPerformed(evt);
            }
        });

        btnEditarUsuario.setText("EDITAR USUÁRIO");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnExcluirUsuario.setText("EXCLUIR USUÁRIO");
        btnExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirUsuarioActionPerformed(evt);
            }
        });

        btnAdicionarQuarto.setText("ADICIONAR QUARTO");
        btnAdicionarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarQuartoActionPerformed(evt);
            }
        });

        btnEditarQuarto.setText("EDITAR QUARTO");
        btnEditarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarQuartoActionPerformed(evt);
            }
        });

        btnExcluirQuarto.setText("EXCLUIR QUARTO");
        btnExcluirQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirQuartoActionPerformed(evt);
            }
        });

        btnAdicionarReservas.setText("ADICIONAR RESERVAS");
        btnAdicionarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarReservasActionPerformed(evt);
            }
        });

        btnEditarReservas.setText("EDITAR RESERVAS");
        btnEditarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarReservasActionPerformed(evt);
            }
        });

        btnExcluirReservas.setText("EXCLUIR RESERVAS");
        btnExcluirReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirReservasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaMainLayout = new javax.swing.GroupLayout(pnlTelaMain);
        pnlTelaMain.setLayout(pnlTelaMainLayout);
        pnlTelaMainLayout.setHorizontalGroup(
            pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnsMain)
                    .addGroup(pnlTelaMainLayout.createSequentialGroup()
                        .addComponent(btnReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(74, 74, 74)
                        .addComponent(btnRelatEstatistica)
                        .addGap(74, 74, 74)
                        .addComponent(btnQuartos)
                        .addGap(74, 74, 74)
                        .addComponent(btnUsuarios)))
                .addContainerGap())
            .addGroup(pnlTelaMainLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdicionarQuarto)
                        .addComponent(btnAdicionarUsuario))
                    .addComponent(btnAdicionarReservas))
                .addGap(169, 169, 169)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarUsuario)
                    .addComponent(btnEditarQuarto)
                    .addComponent(btnEditarReservas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluirUsuario)
                    .addComponent(btnExcluirQuarto)
                    .addComponent(btnExcluirReservas))
                .addGap(77, 77, 77))
        );
        pnlTelaMainLayout.setVerticalGroup(
            pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuartos)
                    .addComponent(btnReservas)
                    .addComponent(btnUsuarios)
                    .addComponent(btnRelatEstatistica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(pnsMain, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarQuarto)
                    .addComponent(btnEditarQuarto)
                    .addComponent(btnExcluirQuarto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarUsuario)
                    .addComponent(btnEditarUsuario)
                    .addComponent(btnExcluirUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarReservas)
                    .addComponent(btnEditarReservas)
                    .addComponent(btnExcluirReservas))
                .addContainerGap())
        );

        lblLogoF.setText("LOGO");

        lblEndereco.setFont(new java.awt.Font("Perpetua", 2, 24)); // NOI18N
        lblEndereco.setText("ENDEREÇO");

        javax.swing.GroupLayout pnlTela1Layout = new javax.swing.GroupLayout(pnlTela1);
        pnlTela1.setLayout(pnlTela1Layout);
        pnlTela1Layout.setHorizontalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTela1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 683, Short.MAX_VALUE)
                .addComponent(lblBemVindo)
                .addGap(70, 70, 70))
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTelaMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTela1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblLogoF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEndereco)
                .addGap(59, 59, 59))
        );
        pnlTela1Layout.setVerticalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBemVindo)
                    .addComponent(lblLogo))
                .addGap(29, 29, 29)
                .addComponent(pnlTelaMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoF)
                    .addComponent(lblEndereco))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTela1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuartosActionPerformed
        pnsMain.setViewportView(null);
        tblResults.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(tblResults); // Adiciona a tabela em um JScrollPane
        pnsMain.setViewportView(scrollPane); // Coloca o JScrollPane no painel principal
        pnsMain.revalidate(); // Atualiza o painel
        pnsMain.repaint();
        preencheTabelaQuartos(quartosList);
    }//GEN-LAST:event_btnQuartosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        pnsMain.setViewportView(null);
        tblResults.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(tblResults); // Adiciona a tabela em um JScrollPane
        pnsMain.setViewportView(scrollPane); // Coloca o JScrollPane no painel principal
        pnsMain.revalidate(); // Atualiza o painel
        pnsMain.repaint();

        preencheTabelaUsuarios(usuariosList);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnRelatEstatisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatEstatisticaActionPerformed
        // Certifique-se de que a tabela está invisível
        tblResults.setVisible(false);
        pnsMain.setViewportView(null);

        // Criação do painel de relatórios
        JPanel pnsRelatorio = new JPanel();
        pnsRelatorio.setLayout(new BoxLayout(pnsRelatorio, BoxLayout.Y_AXIS));

        // Label para indicar qual tipo de relatório
        JLabel relatorioLabel = new JLabel("Selecione os filtros para gerar o relatório:");
        pnsRelatorio.add(relatorioLabel);

        // ComboBox para selecionar o mês de reserva
        JLabel reservaMes = new JLabel("Selecione o mês de reserva:");
        pnsRelatorio.add(reservaMes);

        // Criação do ComboBox para o mês
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        JComboBox<String> comboMes = new JComboBox<>(meses);
        pnsRelatorio.add(comboMes);

        // ComboBox para selecionar o ano de reserva
        JLabel reservaAno = new JLabel("Selecione o ano de reserva:");
        pnsRelatorio.add(reservaAno);

        // Criação do ComboBox para o ano
        Integer[] anos = {2020, 2021, 2022, 2023, 2024};
        JComboBox<Integer> comboAno = new JComboBox<>(anos);
        pnsRelatorio.add(comboAno);

        // Botão para gerar o relatório
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter mês e ano selecionados
                int mesSelecionado = comboMes.getSelectedIndex() + 1; // +1 para ajustar para o formato de 1 a 12
                int anoSelecionado = (Integer) comboAno.getSelectedItem();

                // Gerar relatório com base no mês e ano selecionados
                gerarRelatorio(mesSelecionado, anoSelecionado);
            }
        });
        pnsRelatorio.add(btnGerarRelatorio);

        // Aqui, substituímos o painel atual do JScrollPane com o novo painel de relatórios
        pnsMain.setViewportView(pnsRelatorio);

        // Atualizar o layout e garantir que o painel de rolagem seja reajustado
        pnsMain.revalidate();
        pnsMain.repaint();

        btnAdicionarUsuario.setVisible(false);
        btnExcluirUsuario.setVisible(false);
        btnEditarUsuario.setVisible(false);
        btnAdicionarQuarto.setVisible(false);
        btnEditarQuarto.setVisible(false);
        btnExcluirQuarto.setVisible(false);
        btnAdicionarReservas.setVisible(false);
        btnEditarReservas.setVisible(false);
        btnExcluirReservas.setVisible(false);
    }//GEN-LAST:event_btnRelatEstatisticaActionPerformed

    private void gerarRelatorio(int mesSelecionado, int anoSelecionado) {
        try {
            // Criar o relatório com informações formatadas
            String relatorio = "Relatório de Reservas\n";
            relatorio += "---------------------\n";

            // Contar reservas no mês e ano selecionados
            int reservasNoPeriodo = contarReservasPorMesEAno(mesSelecionado, anoSelecionado);
            relatorio += "Reservas no mês " + mesSelecionado + " de " + anoSelecionado + ": " + reservasNoPeriodo + "\n";
            relatorio += "Usuários no ano: " + contarUsuariosNoAno();
            relatorio += "Quarto mais reservado: " + quartoMaisReservado();
            relatorio += "Quarto menos reservado: " + quartoMenosReservado();

            // Exibir o relatório no console (ou em outro componente)
            System.out.println(relatorio);

            // Opcional: Mostrar o relatório em um `JOptionPane`
            JOptionPane.showMessageDialog(null, relatorio, "Relatório de Reservas", JOptionPane.INFORMATION_MESSAGE);

            // Gerar o arquivo de relatório
            String nomeArquivo = "relatorio_reservas_" + LocalDate.now().toString() + ".txt";
            File arquivoRelatorio = new File(nomeArquivo);
            FileWriter writer = new FileWriter(arquivoRelatorio);
            writer.write(relatorio);
            writer.close();

            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso! Arquivo: " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + e.getMessage());
        }
    }

    private int contarReservasPorMesEAno(int mesSelecionado, int anoSelecionado) {
        int count = 0;
        for (Reserva reserva : reservasList) {
            if (reserva.getDataCheckin().getMonthValue() == mesSelecionado
                    && reserva.getDataCheckin().getYear() == anoSelecionado) {
                count++;
            }
        }
        return count;
    }

    private int contarUsuariosNoAno() {
        int count = 0;
        LocalDate hoje = LocalDate.now();
        for (Usuarios usuario : usuariosList) {
            if (usuario.getDataCadastro().getYear() == hoje.getYear()) {
                count++;
            }
        }
        return count;
    }

    private String quartoMaisReservado() {
        int maxReservas = 0;
        int quartoIdMaisReservado = -1;

        for (Reserva reserva : reservasList) {
            int quartoId = reserva.getQuartoId();
            int contadorReservas = 0;

            for (Reserva r : reservasList) {
                if (r.getQuartoId() == quartoId) {
                    contadorReservas++;
                }
            }

            if (contadorReservas > maxReservas) {
                maxReservas = contadorReservas;
                quartoIdMaisReservado = quartoId;
            }
        }

        return "Quarto ID: " + quartoIdMaisReservado + " com " + maxReservas + " reservas.";
    }

    private String quartoMenosReservado() {
        int minReservas = Integer.MAX_VALUE;
        int quartoIdMenosReservado = -1;

        for (Reserva reserva : reservasList) {
            int quartoId = reserva.getQuartoId();
            int contadorReservas = 0;

            for (Reserva r : reservasList) {
                if (r.getQuartoId() == quartoId) {
                    contadorReservas++;
                }
            }

            if (contadorReservas < minReservas) {
                minReservas = contadorReservas;
                quartoIdMenosReservado = quartoId;
            }
        }

        return "Quarto ID: " + quartoIdMenosReservado + " com " + minReservas + " reservas.";
    }

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        pnsMain.setViewportView(null);
        tblResults.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(tblResults); // Adiciona a tabela em um JScrollPane
        pnsMain.setViewportView(scrollPane); // Coloca o JScrollPane no painel principal
        pnsMain.revalidate(); // Atualiza o painel
        pnsMain.repaint();

        preencheTabelaReservas(reservasList);
    }//GEN-LAST:event_btnReservasActionPerformed

    private void btnAdicionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarUsuarioActionPerformed
        TelaCriarUsuario criarUsuario = new TelaCriarUsuario(usuarioLogado);
        criarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdicionarUsuarioActionPerformed

    public void atualizarUsuarios() {
        usuariosList = usuariosDAO.getUsuarios(); // Recarrega do banco
        preencheTabelaUsuarios(usuariosList); // Atualiza a tabela
    }

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        int linhaSelecionada = tblResults.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int usuarioId = Integer.parseInt(tblResults.getValueAt(linhaSelecionada, 0).toString());
            Usuarios usuarioSelecionado = null;

            for (Usuarios u : usuariosList) {
                if (u.getId() == usuarioId) {
                    usuarioSelecionado = u;
                    break;
                }
            }

            if (usuarioSelecionado != null) {
                TelaDadosUsuario dadosUsuario = new TelaDadosUsuario(usuarioSelecionado, this);
                dadosUsuario.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuário para editar.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Erro ao editar o usuário.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirUsuarioActionPerformed
        try {
            int linhaSelecionada = tblResults.getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idUsuario = Integer.parseInt((String) tblResults.getValueAt(linhaSelecionada, 0));
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o usuário: " + idUsuario + " ?");
                if (resposta == JOptionPane.YES_OPTION) {
                    Usuarios userSelecionado = null;
                    for (Usuarios u : usuariosList) {
                        if (u.getId() == idUsuario) {
                            userSelecionado = u;
                            break;
                        }
                    }

                    List<Reserva> reservasUsuario = new ArrayList<>();
                    reservasUsuario = reservaDAO.getReservasUsuario(idUsuario);

                    if (userSelecionado != null) {
                        if (reservasUsuario.isEmpty()) {
                            int id = userSelecionado.getId();
                            usuariosDAO.excluir(id);
                            usuariosList.removeIf(u -> u.getId() == idUsuario);
                            preencheTabelaUsuarios(usuariosList);
                            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário tem reservas cadastradas e não pode ser excluído do banco.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir usuário. " + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirUsuarioActionPerformed

    private void btnAdicionarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarQuartoActionPerformed
        TelaAdicionarQuarto telaAddQuarto = new TelaAdicionarQuarto(quartosList, this);
        telaAddQuarto.setVisible(true);
        telaAddQuarto.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                preencheTabelaQuartos(quartosList);

            }
        });
    }//GEN-LAST:event_btnAdicionarQuartoActionPerformed

    public void adicionarQuarto(Quartos novoQuarto) {
        quartosList.add(novoQuarto);
    }

    private void btnEditarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarQuartoActionPerformed
        try {
            int linhaSelecionada = tblResults.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int idQuarto = Integer.parseInt((String) tblResults.getValueAt(linhaSelecionada, 0));

                Quartos quartoSelecionado = null;
                for (Quartos q : quartosList) {
                    if (q.getId() == idQuarto) {
                        quartoSelecionado = q;
                        break;
                    }
                }

                if (quartoSelecionado != null) {
                    TelaEditarQuarto telaEditar = new TelaEditarQuarto(quartoSelecionado);
                    telaEditar.setVisible(true);

                    telaEditar.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent we) {
                            preencheTabelaQuartos(quartosList);
                        }
                    });

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um quarto para editar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar um quarto. " + e.getMessage());
        }

    }//GEN-LAST:event_btnEditarQuartoActionPerformed

    private void btnExcluirQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirQuartoActionPerformed
        try {
            int linhaSelecionada = tblResults.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int idQuarto = Integer.parseInt((String) tblResults.getValueAt(linhaSelecionada, 0));
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o usuário: " + idQuarto + " ?");

                if (resposta == JOptionPane.YES_OPTION) {
                    Quartos quartoSelecionado = null;
                    for (Quartos q : quartosList) {
                        if (q.getId() == idQuarto) {
                            quartoSelecionado = q;
                            break;
                        }
                    }

                    List<Quartos> quartosReservados = reservaDAO.getQuartosReservados(idQuarto);

                    if (quartoSelecionado != null) {
                        if (quartosReservados.isEmpty()) {
                            int id = quartoSelecionado.getId();
                            QuartosDAO dao = new QuartosDAO();
                            dao.excluir(id);
                            JOptionPane.showMessageDialog(null, "Quarto excluído com sucesso.");
                            quartosList.remove(quartoSelecionado);
                            preencheTabelaQuartos(quartosList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Quarto está reservado não é possível excluir.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Quarto não encontrado.");

                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um quarto para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um quarto. " + e.getMessage());
        }

    }//GEN-LAST:event_btnExcluirQuartoActionPerformed

    private void btnAdicionarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarReservasActionPerformed
        TelaAdicionarReserva telaAddReserva = new TelaAdicionarReserva(reservasList, this);
        telaAddReserva.setVisible(true);

        telaAddReserva.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                preencheTabelaReservas(reservasList);

            }
        });
    }//GEN-LAST:event_btnAdicionarReservasActionPerformed

    public void adicionarReserva(Reserva novaReserva) {
        reservasList.add(novaReserva);
    }

    private void btnEditarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarReservasActionPerformed
        try {
            int linhaSelecionada = tblResults.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int idReserva = Integer.parseInt((String) tblResults.getValueAt(linhaSelecionada, 0));

                Reserva reservaSelecionada = null;
                for (Reserva r : reservasList) {
                    if (r.getId() == idReserva) {
                        reservaSelecionada = r;
                        break;
                    }
                }

                if (reservaSelecionada != null) {
                    TelaEditarReserva telaEditar = new TelaEditarReserva(reservaSelecionada);
                    telaEditar.setVisible(true);

                    telaEditar.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent we) {
                            preencheTabelaReservas(reservasList);

                        }
                    });

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma reserva para editar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar uma reserva. " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarReservasActionPerformed

    private void btnExcluirReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirReservasActionPerformed
        try {
            int linhaSelecionada = tblResults.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int idReserva = Integer.parseInt((String) tblResults.getValueAt(linhaSelecionada, 0));
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir a reserva: " + idReserva + " ?");
                if (resposta == JOptionPane.YES_OPTION) {
                    Reserva reservaSelecionada = null;
                    for (Reserva r : reservasList) {
                        if (r.getId() == idReserva) {
                            reservaSelecionada = r;
                            break;
                        }
                    }

                    reservasList.removeIf(r -> r.getId() == idReserva);
                    reservaDAO.excluirReserva(idReserva);
                    preencheTabelaReservas(reservasList);
                    JOptionPane.showMessageDialog(null, "Reserva excluída com sucesso.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma reserva para excluir.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir uma reserva. " + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirReservasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalAdmin(usuarioLogado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarQuarto;
    private javax.swing.JButton btnAdicionarReservas;
    private javax.swing.JButton btnAdicionarUsuario;
    private javax.swing.JButton btnEditarQuarto;
    private javax.swing.JButton btnEditarReservas;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnExcluirQuarto;
    private javax.swing.JButton btnExcluirReservas;
    private javax.swing.JButton btnExcluirUsuario;
    private javax.swing.JButton btnQuartos;
    private javax.swing.JButton btnRelatEstatistica;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoF;
    private javax.swing.JPanel pnlTela1;
    private javax.swing.JPanel pnlTelaMain;
    private javax.swing.JScrollPane pnsMain;
    private javax.swing.JTable tblResults;
    // End of variables declaration//GEN-END:variables
}
