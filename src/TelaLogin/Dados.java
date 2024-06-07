package TelaLogin;

import TelaLogin.DatabaseConnection;
import TelaLogin.Login;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class Dados extends javax.swing.JFrame {

    private final Principal principal;
    private final int userId;

    public Dados(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal != null ? principal : new Principal(userId);
        initComponents();
        preencherDadosUsuario();
        habilitarEdicaoCampos();
    }

    private void preencherDadosUsuario() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("Conexao estabelecida com sucesso!");

            String query = "SELECT nome, sobrenome, dataNascimento, email, telefone FROM users WHERE Id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            int userId = 0;
            statement.setInt(1, this.userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                jTextField3.setText(nome + " " + sobrenome);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dataNascimentoFormatted = dateFormat.format(resultSet.getDate("dataNascimento"));

                jTextField4.setText(dataNascimentoFormatted);
                jTextField5.setText(resultSet.getString("email"));
                jTextField6.setText(resultSet.getString("telefone"));
            } else {
                System.out.println("Usuário não encontrado!");
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados do usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void habilitarEdicaoCampos() {
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meus dados");

        jPanel1.setBackground(new java.awt.Color(181, 194, 196));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 138, 140), 4));
        jPanel2.setLayout(null);

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/73-730154_open-default-profile-picture-png.png")));

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage2);
        rSPanelImage2.setBounds(20, 40, 160, 170);

        jTextField3.setText("");
        jPanel2.add(jTextField3);
        jTextField3.setBounds(210, 30, 230, 30);

        jTextField4.setText("");
        jPanel2.add(jTextField4);
        jTextField4.setBounds(210, 80, 230, 30);

        jTextField5.setText("");
        jPanel2.add(jTextField5);
        jTextField5.setBounds(210, 130, 230, 30);

        jTextField6.setText("");
        jPanel2.add(jTextField6);
        jTextField6.setBounds(210, 180, 230, 30);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 470, 230));

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 0, 24));
        jLabel2.setForeground(new java.awt.Color(84, 117, 123));
        jLabel2.setText("Meus dados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 140, -1));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png")));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 350, 140));

        jButtonAtualizar.setBackground(new java.awt.Color(84, 117, 123));
        jButtonAtualizar.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jButtonAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtualizar.setText("Atualizar meus dados");
        jButtonAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 300, 40));

        jButtonVoltar.setBackground(new java.awt.Color(84, 117, 123));
        jButtonVoltar.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

   private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        AtCadastral atcadastral = new AtCadastral(this.userId, this.principal, this); // Passa userId, principal, e Dados para AtCadastral
        atcadastral.setVisible(true);
        this.dispose();
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        if (principal != null) {
            principal.setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Dados(0, null).setVisible(true));
    }

    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
}
