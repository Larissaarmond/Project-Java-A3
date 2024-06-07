package TelaLogin;

import java.awt.Cursor;
import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author breno
 */
public class Localizacao extends javax.swing.JFrame {

    private final int userId;
    private final Principal principal;
    
    public Localizacao(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Localização");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(181, 194, 196));
        jPanel1.setLayout(null);

        rSPanelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Captura de tela 2024-05-16 141112.png")));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 756, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
                rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 286, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage1);
        rSPanelImage1.setBounds(160, 220, 760, 290);

        jButton1.setBackground(new java.awt.Color(255, 1, 1));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Conferir localização");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 530, 300, 50);

        jLabel1.setFont(new java.awt.Font("PoetsenOne", 0, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nossa unidade está localizada no seguinte endereço:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 120, 450, 22);

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 2, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("R Labatut, 523, Ipiranga, São Paulo - SP, 04214-000");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 150, 440, 22);

        jLabel3.setFont(new java.awt.Font("Lobster Two", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Para mais informações detalhadas sobre nossa unidade, você pode estar conferindo no botão logo abaixo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 180, 730, 23);

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pixelcut-export-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 340, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
                rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(rSPanelImage2);
        rSPanelImage2.setBounds(360, -10, 340, 150);

        jButtonVoltar.setBackground(new java.awt.Color(0, 102, 204));
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar);
        jButtonVoltar.setBounds(40, 530, 150, 50);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String[] args;
        try {
            URI link = new URI("https://www.google.com.br/maps/place/R.+Labatut,+523+-+Ipiranga,+S%C3%A3o+Paulo+-+SP,+04214-000/@-23.5935434,-46.6027525,17z/data=!4m6!3m5!1s0x94ce5bf2c817b16f:0x56206264456f243a!8m2!3d-23.5933959!4d-46.6017333!16s%2Fg%2F11b8v6w8r0?entry=ttu");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Localizacao(0, null).setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
// End of variables declaration                   
}
