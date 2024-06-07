package TelaLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import rojerusan.RSPanelImage;

public class ConfirmaCadastro extends javax.swing.JFrame {

    private final String userCode;

    public ConfirmaCadastro(String userCode) {
        this.userCode = userCode;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        userCodeLabel = new javax.swing.JLabel();
        userCodeField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmação de Cadastro");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(84, 117, 123));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 24)); 
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Cadastro Realizado com Sucesso!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 400, 30);

        userCodeLabel.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        userCodeLabel.setForeground(new java.awt.Color(60, 88, 93));
        userCodeLabel.setText("Seu Código de Recuperação de senha:");
        jPanel1.add(userCodeLabel);
        userCodeLabel.setBounds(30, 80, 200, 30);

        userCodeField.setBounds(30, 110, 360, 40);
        userCodeField.setText(this.userCode);
        userCodeField.setEditable(false);
        jPanel1.add(userCodeField);

        jButton1.setBackground(new java.awt.Color(255, 1, 1));
        jButton1.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 230, 100, 40);
        jButton1.addActionListener((ActionEvent e) -> {
            new Login().setVisible(true);
            dispose();
        });

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ConfirmaCadastro("123456").setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField userCodeField;
    private javax.swing.JLabel userCodeLabel;
    private rojerusan.RSPanelImage rSPanelImage1;
}
