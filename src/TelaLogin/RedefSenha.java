package TelaLogin;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RedefSenha extends javax.swing.JFrame {

    public RedefSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        
        cpfField = new javax.swing.JTextField();
        userCodeField = new javax.swing.JTextField();
        cpfLabel = new javax.swing.JLabel();
        userCodeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Redefinir senha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(84, 117, 123));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 24));
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Redefina a sua senha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 250, 30);

        cpfLabel.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        cpfLabel.setForeground(new java.awt.Color(60, 88, 93));
        cpfLabel.setText("CPF:");
        jPanel1.add(cpfLabel);
        cpfLabel.setBounds(30, 80, 100, 30);
        
        cpfField.setBounds(30, 110, 360, 40);
        jPanel1.add(cpfField);

        userCodeLabel.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        userCodeLabel.setForeground(new java.awt.Color(60, 88, 93));
        userCodeLabel.setText("Código de Usuário:");
        jPanel1.add(userCodeLabel);
        userCodeLabel.setBounds(30, 160, 200, 30);
        
        userCodeField.setBounds(30, 190, 360, 40);
        jPanel1.add(userCodeField);

        jButton1.setBackground(new java.awt.Color(255, 1, 1));
        jButton1.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ENVIAR");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 230, 100, 40);
        jButton1.addActionListener((ActionEvent e) -> {
            verificarUsuario();
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton2);
        jButton2.setBounds(280, 230, 100, 40);
        jButton2.addActionListener((ActionEvent e) -> {
            new Login().setVisible(true);
            dispose();
        });

        jLabel2.setFont(new java.awt.Font("Lobster Two", 0, 18));
        jLabel2.setForeground(new java.awt.Color(111, 141, 146));
        jLabel2.setText("Insira seu CPF e seu código de usuário.");
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
    }// </editor-fold>                        

    private void verificarUsuario() {
        String cpf = cpfField.getText().trim();
        String userCode = userCodeField.getText().trim();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthtech", "root", "Mudar123");
            String sql = "SELECT id FROM users WHERE cpf = ? AND codigo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, userCode);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                new RedefinirSenha(userId).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "CPF ou Código de Usuário inválido.");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new RedefSenha().setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField userCodeField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel userCodeLabel;
    private rojerusan.RSPanelImage rSPanelImage1;
}