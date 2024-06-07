package TelaLogin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta extends javax.swing.JFrame {

    private final int userId;
    private final Principal principal;

    public Consulta(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(181, 194, 196));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 530, 100, 40);

        jButton2.setBackground(new java.awt.Color(255, 1, 1));
        jButton2.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CONFIRMAR");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(580, 530, 100, 40);

        jLabel1.setFont(new java.awt.Font("Lobster Two", 0, 48));
        jLabel1.setForeground(new java.awt.Color(60, 88, 93));
        jLabel1.setText("Agendamento");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 60, 400, 60);

        jSeparator1.setForeground(new java.awt.Color(84, 117, 123));
        jSeparator1.setAlignmentX(10.0F);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 130, 1070, 20);

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 0, 21));
        jLabel2.setForeground(new java.awt.Color(37, 69, 75));
        jLabel2.setText("Selecione a data:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(580, 200, 180, 30);

        jLabel3.setFont(new java.awt.Font("PoetsenOne", 0, 21));
        jLabel3.setForeground(new java.awt.Color(37, 69, 75));
        jLabel3.setText("Selecione o ramo da consulta:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 200, 300, 30);

        jLabel4.setFont(new java.awt.Font("PoetsenOne", 0, 21));
        jLabel4.setForeground(new java.awt.Color(37, 69, 75));
        jLabel4.setText("Selecione o horário:");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 390, 230, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Clínico geral", "Cardiologia", "Ortopedia", "Ginecologia", "Nutricionista", "Urologista"}));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(150, 250, 300, 40);

        rSDateChooser1.setColorBackground(new java.awt.Color(84, 117, 123));
        rSDateChooser1.setColorForeground(new java.awt.Color(111, 141, 146));
        rSDateChooser1.setFont(new java.awt.Font("PoetsenOne", 0, 12));
        rSDateChooser1.setFormatoFecha("dd/MM/yyyy\n");
        rSDateChooser1.setFuente(new java.awt.Font("Lobster Two", 1, 14));
        rSDateChooser1.setPlaceholder("Selecionar data");
        jPanel1.add(rSDateChooser1);
        rSDateChooser1.setBounds(580, 250, 300, 40);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30"}));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(150, 430, 300, 40);

        jLabel5.setFont(new java.awt.Font("PoetsenOne", 0, 21));
        jLabel5.setForeground(new java.awt.Color(37, 69, 75));
        jLabel5.setText("Selecione o Profissional:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(580, 380, 260, 40);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Dr. Alexander Schmidt", "Dra. Emily Chang", "Dr. Everton Santos", "Dra. Sofia Martinez", "Dr. Henrik Johansson", "Dra. Elena Petrov", "Dr. Javier Hernandez", "Dra. Natalia Ivanova", "Dr. Amir Khan", "Dra. Lina Nguyen", "Dr. Alessandro Costa", "Dra. Ingrid Schmidt"}));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(580, 430, 310, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String tipoConsulta = jComboBox1.getSelectedItem().toString();
        String horario = jComboBox2.getSelectedItem().toString();
        Date dataConsulta = rSDateChooser1.getDatoFecha();
        String doutor = jComboBox3.getSelectedItem().toString();

        if (dataConsulta != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataConsultaFormatted = sdf.format(dataConsulta);
            saveConsulta(tipoConsulta, horario, dataConsultaFormatted, doutor, userId);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma data válida.");
        }
    }

    private void saveConsulta(String tipoConsulta, String horario, String dataConsulta, String doutor, int userId) {
        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";

        String sql = "INSERT INTO consultas (tipoConsulta, horario, dataConsulta, doutor, userId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipoConsulta);
            pstmt.setString(2, horario);
            pstmt.setString(3, dataConsulta);
            pstmt.setString(4, doutor);
            pstmt.setInt(5, userId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
                this.dispose();
                this.setVisible(false);
                principal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar a consulta.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Consulta(0, null).setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    // End of variables declaration                   
}
