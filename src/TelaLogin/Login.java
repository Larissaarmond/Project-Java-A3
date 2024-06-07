package TelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static org.apache.commons.codec.digest.DigestUtils.md5;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSPanelImage3 = new rojerusan.RSPanelImage();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel5 = new javax.swing.JLabel();
        rSPanelImage4 = new rojerusan.RSPanelImage();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jPanel2 = new javax.swing.JPanel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        rSPanelImage6 = new rojerusan.RSPanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(129, 121, 119));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Para acessar sua conta, faça seu login.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 160, 350, 22);

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bem-vindo ao HealthTech!");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 130, 220, 22);

        txtLogin.setBackground(new java.awt.Color(129, 121, 119));
        txtLogin.setFont(new java.awt.Font("Segoe UI", 1, 12));
        txtLogin.setForeground(new java.awt.Color(0, 0, 0));
        txtLogin.setToolTipText("");
        txtLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtLogin.setName("");
        txtLogin.addActionListener(this::txtLoginActionPerformed);
        jPanel1.add(txtLogin);
        txtLogin.setBounds(100, 240, 240, 30);
        txtLogin.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("PoetsenOne", 0, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 320, 50, 17);

        jLabel4.setFont(new java.awt.Font("PoetsenOne", 0, 14));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cpf:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 210, 28, 17);

        txtSenha.setBackground(new java.awt.Color(129, 121, 119));
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtSenha.addActionListener(this::txtSenhaActionPerformed);
        jPanel1.add(txtSenha);
        txtSenha.setBounds(100, 338, 240, 30);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Account_50px.png")));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage1);
        rSPanelImage1.setBounds(60, 240, 30, 30);

        rSPanelImage3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Secure_50px.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage3Layout = new javax.swing.GroupLayout(rSPanelImage3);
        rSPanelImage3.setLayout(rSPanelImage3Layout);
        rSPanelImage3Layout.setHorizontalGroup(
                rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );
        rSPanelImage3Layout.setVerticalGroup(
                rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage3);
        rSPanelImage3.setBounds(60, 340, 30, 30);

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(153, 153, 255));
        rSMaterialButtonCircle1.setText("Cadastro");
        rSMaterialButtonCircle1.addActionListener(this::rSMaterialButtonCircle1ActionPerformed);
        jPanel1.add(rSMaterialButtonCircle1);
        rSMaterialButtonCircle1.setBounds(80, 470, 290, 60);

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 1, 1));
        rSMaterialButtonCircle2.setText("Entrar");
        rSMaterialButtonCircle2.addActionListener(this::rSMaterialButtonCircle2ActionPerformed);
        jPanel1.add(rSMaterialButtonCircle2);
        rSMaterialButtonCircle2.setBounds(80, 400, 290, 60);

        jLabel5.setFont(new java.awt.Font("Lobster Two", 0, 14));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Esqueci minha senha");
        jLabel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RedefSenha().setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jLabel5.setForeground(new java.awt.Color(0, 102, 204));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 560, 150, 18);

        rSPanelImage4.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage4Layout = new javax.swing.GroupLayout(rSPanelImage4);
        rSPanelImage4.setLayout(rSPanelImage4Layout);
        rSPanelImage4Layout.setHorizontalGroup(
                rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 310, Short.MAX_VALUE)
        );
        rSPanelImage4Layout.setVerticalGroup(
                rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage4);
        rSPanelImage4.setBounds(60, -10, 310, 140);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 620));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/isometric-visual-young-man-was-a-meeting-with-a-doctor-to-treat-a-disease-vector.jpg")));

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 710, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 620, Short.MAX_VALUE)
        );

        getContentPane().add(rSPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 710, 620));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(84, 117, 123), 2));

        rSPanelImage6.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage6Layout = new javax.swing.GroupLayout(rSPanelImage6);
        rSPanelImage6.setLayout(rSPanelImage6Layout);
        rSPanelImage6Layout.setHorizontalGroup(
                rSPanelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 261, Short.MAX_VALUE)
        );
        rSPanelImage6Layout.setVerticalGroup(
                rSPanelImage6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rSPanelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rSPanelImage6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 270, 110));

        setSize(new java.awt.Dimension(1163, 659));
        setLocationRelativeTo(null);
    }                     

    private void rSMaterialButtonCircle2ActionPerformed(ActionEvent evt) {
        String login = txtLogin.getText();
        String senha = new String(txtSenha.getPassword());
        String senhaMD5 = md5(senha);
        int userId = validateLoginAndGetId(login, senhaMD5);

        if (userId != -1) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            new Principal(userId).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login ou senha não existe ou estão incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rSMaterialButtonCircle1ActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new Cadastro().setVisible(true);
    }

    private int validateLoginAndGetId(String cpf, String senhaMD5) {
        int userId = -1;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE cpf = ? AND senha = ?")) {

            stmt.setString(1, cpf);
            stmt.setString(2, senhaMD5);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }

    public static String md5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void txtLoginActionPerformed(ActionEvent evt) {
    }

    private void txtSenhaActionPerformed(ActionEvent evt) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

// Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
    private rojerusan.RSPanelImage rSPanelImage3;
    private rojerusan.RSPanelImage rSPanelImage4;
    private rojerusan.RSPanelImage rSPanelImage6;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtLogin;
// End of variables declaration                   
}
