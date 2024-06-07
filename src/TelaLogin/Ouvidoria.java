package TelaLogin;

import java.awt.Cursor;
import javax.swing.*;

public class Ouvidoria extends javax.swing.JFrame {

    private final int userId;
    private final Principal principal;

    public Ouvidoria(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jLabel5 = new javax.swing.JLabel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ouvidoria");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(181, 194, 196));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lobster Two", 1, 36));
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Ouvidoria HealthTech");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 170, 335, 47);

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 2, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("(11) 2326-0000 – das 9h às 14h");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 250, 357, 32);

        jLabel3.setFont(new java.awt.Font("PoetsenOne", 2, 24));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("(11) 2326-0000 – das 14h às 19h ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 290, 356, 32);

        jLabel4.setFont(new java.awt.Font("PoetsenOne", 2, 24));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("healthtech@ret.com.br");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 390, 274, 32);

        jButtonVoltar.setBackground(new java.awt.Color(255, 1, 1));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);
        jPanel2.add(jButtonVoltar);
        jButtonVoltar.setBounds(120, 430, 150, 30);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage1);
        rSPanelImage1.setBounds(60, 20, 300, 130);

        jLabel5.setFont(new java.awt.Font("Lobster Two", 1, 24));
        jLabel5.setForeground(new java.awt.Color(60, 88, 93));
        jLabel5.setText("E-mail");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(160, 350, 90, 30);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 410, 470));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Design sem nome (8).png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Ouvidoria(0, null).setVisible(true));
    }

    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
}
