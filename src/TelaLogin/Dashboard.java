package TelaLogin;
import TelaLogin.Dashboard;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Dashboard extends javax.swing.JFrame {

    private final int Id;
    private JLabel jLabelTitle;
    private JLabel jLabelNumUsuarios;
    private JLabel jLabelNumConsultas;
    private ChartPanel chartPanel;
    private final Principal principal;

    public Dashboard(int Id, Principal principal) {
        this.Id = Id;
        this.principal = principal;
        initComponents();
        loadDashboardData();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelNumUsuarios = new javax.swing.JLabel();
        jLabelNumConsultas = new javax.swing.JLabel();
        chartPanel = new ChartPanel(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(84, 117, 123));
        jPanel1.setLayout(null);

        jLabelTitle.setFont(new Font("Arial", Font.BOLD, 24));
        jLabelTitle.setForeground(Color.WHITE);
        jLabelTitle.setText("Dashboard");
        jPanel1.add(jLabelTitle);
        jLabelTitle.setBounds(280, 20, 150, 30);

        jLabelNumUsuarios.setFont(new Font("Arial", Font.BOLD, 16));
        jLabelNumUsuarios.setForeground(Color.WHITE);
        jLabelNumUsuarios.setText("Usuários:");
        jPanel1.add(jLabelNumUsuarios);
        jLabelNumUsuarios.setBounds(50, 80, 200, 30);

        jLabelNumConsultas.setFont(new Font("Arial", Font.BOLD, 16));
        jLabelNumConsultas.setForeground(Color.WHITE);
        jLabelNumConsultas.setText("Consultas:");
        jPanel1.add(jLabelNumConsultas);
        jLabelNumConsultas.setBounds(50, 130, 200, 30);
        jButtonVoltar = new javax.swing.JButton();
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar);
        jButtonVoltar.setBounds(50, 180, 100, 30);

        chartPanel.setBounds(380, 80, 300, 200);
        jPanel1.add(chartPanel);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }

    private void loadDashboardData() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthtech", "root", "Mudar123");

            // Consulta para contar usuários
            String countUsersQuery = "SELECT COUNT(*) AS total FROM users";
            PreparedStatement countUsersStmt = conn.prepareStatement(countUsersQuery);
            ResultSet countUsersResult = countUsersStmt.executeQuery();
            if (countUsersResult.next()) {
                int numUsuarios = countUsersResult.getInt("total");
                jLabelNumUsuarios.setText("Usuários: " + numUsuarios);
            }
            countUsersResult.close();
            countUsersStmt.close();

            // Consulta para contar consultas
            String countConsultasQuery = "SELECT COUNT(*) AS total FROM consultas";
            PreparedStatement countConsultasStmt = conn.prepareStatement(countConsultasQuery);
            ResultSet countConsultasResult = countConsultasStmt.executeQuery();
            if (countConsultasResult.next()) {
                int numConsultas = countConsultasResult.getInt("total");
                jLabelNumConsultas.setText("Consultas: " + numConsultas);
            }
            countConsultasResult.close();
            countConsultasStmt.close();

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Cria um conjunto de dados para o gráfico
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Usuários", Integer.parseInt(jLabelNumUsuarios.getText().split(": ")[1]));
        dataset.setValue("Consultas", Integer.parseInt(jLabelNumConsultas.getText().split(": ")[1]));

        // Cria o gráfico
        JFreeChart chart = ChartFactory.createPieChart(
                "Dados", // Título do gráfico
                dataset, // Dados
                true, // Incluir legenda
                true,
                false
        );

        chartPanel.setChart(chart);
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

    private void jButtonVoltarActionPerformed() {
        this.setVisible(false);
        principal.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Dashboard(0, null).setVisible(true));
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButtonVoltar;
}
