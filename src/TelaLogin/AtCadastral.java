package TelaLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Cursor;
import java.util.Date;
import javax.swing.JOptionPane;

public class AtCadastral extends javax.swing.JFrame {

    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private final Principal principal;
    private final Dados dados;
    private final int userId;

    public AtCadastral(int userId, Principal principal, Dados dados) {
        this.userId = userId;
        this.principal = principal != null ? principal : new Principal(userId);
        this.dados = dados;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(181, 194, 196));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 24));
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Alterar dados cadastrais");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 10, 300, 50);

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite seu nome:"));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(30, 70, 310, 58);

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite seu sobrenome:"));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(30, 130, 310, 58);

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite seu novo E-mail:"));
        jPanel2.add(jTextField3);
        jTextField3.setBounds(30, 190, 310, 58);

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite o novo telefone:"));
        jPanel2.add(jTextField4);
        jTextField4.setBounds(30, 250, 310, 58);

        rSDateChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escolha sua nova data de nascimento:"));
        jPanel2.add(rSDateChooser1);
        rSDateChooser1.setBounds(30, 310, 310, 100);

        jButton1.setBackground(new java.awt.Color(255, 1, 1));
        jButton1.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ATUALIZAR");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), null, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(130, 440, 120, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(350, 100, 450, 510);

        jButtonVoltar.setBackground(new java.awt.Color(84, 117, 123));
        jButtonVoltar.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar);
        jButtonVoltar.setBounds(40, 50, 110, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    String novoEmail = jTextField3.getText();
    String novoTelefone = jTextField4.getText();
    String novoNome = jTextField1.getText();
    String novoSobrenome = jTextField2.getText();
    Date novaDataNascimento = rSDateChooser1.getDatoFecha();

    atualizarDadosUsuario(novoNome, novoSobrenome, novaDataNascimento, novoEmail, novoTelefone);
    this.dispose();
    Principal principal = new Principal(userId);
    principal.setVisible(true);
}

    private void atualizarDadosUsuario(String novoNome, String novoSobrenome, Date novaDataNascimento, String novoEmail, String novoTelefone) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthtech", "root", "Mudar123");
            String sql = "UPDATE users SET nome = ?, sobrenome = ?, dataNascimento = ?, email = ?, telefone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoNome);
            stmt.setString(2, novoSobrenome);
            stmt.setDate(3, new java.sql.Date(novaDataNascimento.getTime()));
            stmt.setString(4, novoEmail);
            stmt.setString(5, novoTelefone);
            stmt.setInt(6, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar os dados do usuário.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar os dados do usuário: " + ex.getMessage());
        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        if (dados != null) {
            dados.setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AtCadastral(1, null, null).setVisible(true);
        });
    }

    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.componentes.RSDateChooser rSDateChooser;
}
