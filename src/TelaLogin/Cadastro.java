package TelaLogin;

import TelaLogin.ConfirmaCadastro;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;


public class Cadastro extends javax.swing.JFrame {

    public Cadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        rSDateChooser1 = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("PoetsenOne", 0, 36));
        jLabel2.setForeground(new java.awt.Color(60, 88, 93));
        jLabel2.setText("Cadastre-se ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 230, 44);

        jLabel3.setFont(new java.awt.Font("PoetsenOne", 0, 14));
        jLabel3.setForeground(new java.awt.Color(60, 88, 93));
        jLabel3.setText("Rápido e fácil");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 70, 140, 17);

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster Two", 0, 14)));
        jTextField1.setCaretColor(new java.awt.Color(140, 140, 140));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 120, 180, 60);

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sobrenome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster Two", 0, 14)));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(220, 120, 180, 60);

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster Two", 0, 14)));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(20, 180, 270, 60);

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "E-mail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster Two", 0, 14)));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(20, 250, 270, 60);

        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lobster Two", 0, 14)));
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(20, 320, 270, 60);

        rSDateChooser1.setToolTipText("");
        rSDateChooser1.setColorBackground(new java.awt.Color(60, 88, 93));
        rSDateChooser1.setColorForeground(new java.awt.Color(60, 88, 93));
        rSDateChooser1.setFormatoFecha("dd/MM/yyyy");
        rSDateChooser1.setPlaceholder("Data de nascimento");
        jPanel1.add(rSDateChooser1);
        rSDateChooser1.setBounds(20, 400, 270, 40);

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 1, 1));
        rSMaterialButtonRectangle1.setText("Cadastre-se");
        rSMaterialButtonRectangle1.addActionListener(this::rSMaterialButtonRectangle1ActionPerformed);
        jPanel1.add(rSMaterialButtonRectangle1);
        rSMaterialButtonRectangle1.setBounds(90, 460, 230, 50);

        jButtonVoltar.setBackground(new java.awt.Color(255, 1, 1));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);
        jPanel1.add(jButtonVoltar);
        jButtonVoltar.setBounds(330, 20, 80, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 420, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\breno\\Downloads\\VID"));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }

  private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = jTextField1.getText();
        String sobrenome = jTextField2.getText();
        String cpf = jTextField3.getText();
        String email = jTextField4.getText();
        String senha = new String(jPasswordField1.getPassword());

        String senhaMD5 = DigestUtils.md5Hex(senha);

        Date dataNascimentoDate = rSDateChooser1.getDatoFecha();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataNascimento = dateFormat.format(dataNascimentoDate);

        String typeUser = "cliente";
        String userCode = DatabaseConnection.generateCodigo();
        System.out.println("Código gerado para o usuário: " + userCode);

        String result = DatabaseConnection.insertUser(nome, sobrenome, cpf, email, senhaMD5, dataNascimento, typeUser, userCode);
        System.out.println("Resultado da tentativa de cadastro: " + userCode);
        new ConfirmaCadastro(userCode).setVisible(true);
        this.setVisible(false);
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Cadastro().setVisible(true);
        });
    }

    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private rojeru_san.componentes.RSDateChooser rSDateChooser1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
}