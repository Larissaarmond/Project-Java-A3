package TelaLogin;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RedefinirSenha extends javax.swing.JFrame {

    private int userId;

    public RedefinirSenha(int userId) {
        this.userId = userId;
        initComponents();
    }

    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        novaSenhaField = new javax.swing.JPasswordField();
        confirmarSenhaField = new javax.swing.JPasswordField();
        novaSenhaLabel = new javax.swing.JLabel();
        confirmarSenhaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Redefinir senha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(84, 117, 123));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Redefina a sua senha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 250, 30);

        novaSenhaLabel.setFont(new java.awt.Font("PoetsenOne", 0, 18)); // NOI18N
        novaSenhaLabel.setForeground(new java.awt.Color(60, 88, 93));
        novaSenhaLabel.setText("Nova Senha:");
        jPanel1.add(novaSenhaLabel);
        novaSenhaLabel.setBounds(30, 80, 150, 30);

        novaSenhaField.setBounds(30, 110, 360, 40);
        jPanel1.add(novaSenhaField);

        confirmarSenhaLabel.setFont(new java.awt.Font("PoetsenOne", 0, 18)); // NOI18N
        confirmarSenhaLabel.setForeground(new java.awt.Color(60, 88, 93));
        confirmarSenhaLabel.setText("Digite novamente a senha:");
        jPanel1.add(confirmarSenhaLabel);
        confirmarSenhaLabel.setBounds(30, 160, 250, 30);

        confirmarSenhaField.setBounds(30, 190, 360, 40);
        jPanel1.add(confirmarSenhaField);

        jButtonAlterar.setBackground(new java.awt.Color(255, 1, 1));
        jButtonAlterar.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButtonAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAlterar);
        jButtonAlterar.setBounds(400, 230, 100, 40);

        jButtonCancelar.setBackground(new java.awt.Color(153, 153, 255));
        jButtonCancelar.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(280, 230, 100, 40);

        jLabel2.setFont(new java.awt.Font("Lobster Two", 0, 18));
        jLabel2.setForeground(new java.awt.Color(111, 141, 146));
        jLabel2.setText("Insira a nova senha e confirme.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 50, 480, 30);

        jSeparator1.setBackground(new java.awt.Color(84, 117, 123));
        jSeparator1.setForeground(new java.awt.Color(84, 117, 123));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 210, 530, 10);

        jSeparator2.setBackground(new java.awt.Color(84, 117, 123));
        jSeparator2.setForeground(new java.awt.Color(84, 117, 123));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 60, 530, 10);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(270, 190, 530, 290);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 260, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage1);
        rSPanelImage1.setBounds(0, -20, 260, 110);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 0, 1070, 70);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        String novaSenha = new String(novaSenhaField.getPassword());
        String confirmarSenha = new String(confirmarSenhaField.getPassword());

        if (!novaSenha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hashedSenha = hashSenha(novaSenha);

        atualizarSenhaUsuario(hashedSenha);
    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        new Login().setVisible(true);
        dispose();
    }

    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void atualizarSenhaUsuario(String novaSenha) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthtech", "root", "Mudar123");
            String sql = "UPDATE users SET senha = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novaSenha);
            stmt.setInt(2, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Senha alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                new Login().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao alterar a senha.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao alterar a senha: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new RedefinirSenha(1).setVisible(true);
        });
    }

    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField novaSenhaField;
    private javax.swing.JPasswordField confirmarSenhaField;
    private javax.swing.JLabel novaSenhaLabel;
    private javax.swing.JLabel confirmarSenhaLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private rojerusan.RSPanelImage rSPanelImage1;
}
