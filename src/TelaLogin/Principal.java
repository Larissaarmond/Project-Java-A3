package TelaLogin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Principal extends javax.swing.JFrame {

    private final int Id;
    private JLabel jLabelBemVindo;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangleDashboard;
    private JButton logoutButton;

    public Principal(int Id) {
        this.Id = Id;
        initComponents();
        loadUserName();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSPanelImage3 = new rojerusan.RSPanelImage();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSPanelImage4 = new rojerusan.RSPanelImage();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        rSPanelImage6 = new rojerusan.RSPanelImage();
        rSMaterialButtonConfiguracoes = new rojerusan.RSMaterialButtonRectangle();
        logoutButton = new JButton("Sair");
        logoutButton.setBackground(new java.awt.Color(255, 1, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(84, 117, 123));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(181, 194, 196));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.setLayout(null);

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(153, 153, 255));
        rSMaterialButtonRectangle5.setText("Minhas consultas");
        rSMaterialButtonRectangle5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle5);
        rSMaterialButtonRectangle5.setBounds(60, 100, 220, 60);

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 90, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage1);
        rSPanelImage1.setBounds(120, 10, 90, 80);

        javax.swing.GroupLayout rSPanelImage3Layout = new javax.swing.GroupLayout(rSPanelImage3);
        rSPanelImage3.setLayout(rSPanelImage3Layout);
        rSPanelImage3Layout.setHorizontalGroup(
                rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        rSPanelImage3Layout.setVerticalGroup(
                rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage3);
        rSPanelImage3.setBounds(120, 180, 90, 80);

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(153, 153, 255));
        rSMaterialButtonRectangle3.setText("Localização clínica");
        rSMaterialButtonRectangle3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle3);
        rSMaterialButtonRectangle3.setBounds(60, 270, 230, 60);

        javax.swing.GroupLayout rSPanelImage4Layout = new javax.swing.GroupLayout(rSPanelImage4);
        rSPanelImage4.setLayout(rSPanelImage4Layout);
        rSPanelImage4Layout.setHorizontalGroup(
                rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );
        rSPanelImage4Layout.setVerticalGroup(
                rSPanelImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage4);
        rSPanelImage4.setBounds(440, 180, 90, 80);

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(153, 153, 255));
        rSMaterialButtonRectangle2.setText("Meus dados");
        rSMaterialButtonRectangle2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle2);
        rSMaterialButtonRectangle2.setBounds(360, 100, 230, 60);

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage2);
        rSPanelImage2.setBounds(440, 10, 90, 80);

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(153, 153, 255));
        rSMaterialButtonRectangle4.setText("ouvidoria");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle4);
        rSMaterialButtonRectangle4.setBounds(360, 270, 230, 60);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(200, 130, 660, 360);

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 1, 1));
        rSMaterialButtonRectangle1.setText("Solicitar Consulta");
        rSMaterialButtonRectangle1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1);
        rSMaterialButtonRectangle1.setBounds(370, 520, 300, 70);
        if (Id == 1) {
            rSMaterialButtonRectangleDashboard = new rojerusan.RSMaterialButtonRectangle();
            rSMaterialButtonRectangleDashboard.setBackground(new java.awt.Color(0, 102, 204));
            rSMaterialButtonRectangleDashboard.setText("Dashboard");
            rSMaterialButtonRectangleDashboard.setBounds(50, 520, 300, 70);
            rSMaterialButtonRectangleDashboard.addActionListener(this::rSMaterialButtonRectangleDashboardActionPerformed);
            jPanel1.add(rSMaterialButtonRectangleDashboard);
        }
        if (Id == 1) {
            rSMaterialButtonRectangleAdmin = new rojerusan.RSMaterialButtonRectangle();
            rSMaterialButtonRectangleAdmin.setBackground(new java.awt.Color(0, 153, 0));
            rSMaterialButtonRectangleAdmin.setText("Configurações");
            rSMaterialButtonRectangleAdmin.setBounds(680, 520, 300, 70);
            rSMaterialButtonRectangleAdmin.addActionListener(this::rSMaterialButtonRectangleAdminActionPerformed);
            jPanel1.add(rSMaterialButtonRectangleAdmin);
        }

        // Adicionando o botão de logout
        logoutButton.setBounds(950, 20, 100, 40); // Posicionando o botão próximo ao logo
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutButton);

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

        jPanel1.add(jPanel3);
        jPanel3.setBounds(390, 0, 270, 110);
        jLabelBemVindo = new javax.swing.JLabel();
        jPanel1.add(jLabelBemVindo);
        jLabelBemVindo.setBounds(20, 20, 300, 70);
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
    }

    private void loadUserName() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthtech", "root", "Mudar123");
            String sql = "SELECT nome, sobrenome FROM users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                jLabelBemVindo.setText("Bem-vindo, " + nome + " " + sobrenome);
                jLabelBemVindo.setForeground(Color.WHITE);
                jLabelBemVindo.setFont(new Font("Arial", Font.BOLD, 18));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {
        MinhasConsultas minhasconsultas = new MinhasConsultas(Id, Principal.this);
        minhasconsultas.setVisible(true);
        this.setVisible(false);
    }

    public void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        Dados dados = new Dados(Id, Principal.this);
        dados.setVisible(true);
    }

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {
        Localizacao localizacao = new Localizacao(Id, Principal.this);
        localizacao.setVisible(true);
        this.setVisible(false);
    }

    private void rSMaterialButtonRectangle4ActionPerformed(ActionEvent evt) {
        setVisible(false);
        Ouvidoria ouvidoria = new Ouvidoria(Id, Principal.this);
        ouvidoria.setVisible(true);
    }

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {
        Consulta consulta = new Consulta(Id, Principal.this);
        consulta.setVisible(true);
        this.setVisible(false);
    }

    private void rSMaterialButtonRectangleAdminActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        AdminUsers adminUsers = new AdminUsers(Id, Principal.this);
        adminUsers.setVisible(true);
    }

    private void rSMaterialButtonRectangleDashboardActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        Dashboard dashboard = new Dashboard(Id, Principal.this);
        dashboard.setVisible(true);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new Login().setVisible(true); // Direcionar para a tela de login
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Principal(1).setVisible(true);
        });
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangleAdmin;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonConfiguracoes;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
    private rojerusan.RSPanelImage rSPanelImage3;
    private rojerusan.RSPanelImage rSPanelImage4;
    private rojerusan.RSPanelImage rSPanelImage6;
}