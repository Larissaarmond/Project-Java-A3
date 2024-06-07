package TelaLogin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MinhasConsultas extends JFrame {

    private final int userId;
    private final Principal principal;
    private JTable consultasTable;

    public MinhasConsultas(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
        initComponents();
        loadConsultas();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        consultasTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Sobrenome", "CPF", "Tipo Consulta", "Data", "Horário", "Doutor", "Ação"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        });

        JButton jButtonVoltar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minhas Consultas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(181, 194, 196));
        jPanel1.setLayout(null);

        jScrollPane1.setViewportView(consultasTable);
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 50, 960, 450);

        jButtonVoltar.setBackground(new Color(0, 102, 204));
        jButtonVoltar.setForeground(new Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVoltar);
        jButtonVoltar.setBounds(40, 530, 150, 50);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

        pack();
        setLocationRelativeTo(null);
    }

    private void loadConsultas() {
        DefaultTableModel model = (DefaultTableModel) consultasTable.getModel();
        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement("SELECT users.nome, users.sobrenome, users.cpf, consultas.tipoConsulta, consultas.dataConsulta, consultas.horario, consultas.doutor FROM users JOIN consultas ON users.id = consultas.userId WHERE users.id = ?")) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                model.setRowCount(0);

                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String cpf = rs.getString("cpf");
                    String tipoConsulta = rs.getString("tipoConsulta");
                    String dataConsulta = rs.getString("dataConsulta");
                    String horario = rs.getString("horario");
                    String doutor = rs.getString("doutor");
                    model.addRow(new Object[]{nome, sobrenome, cpf, tipoConsulta, dataConsulta, horario, doutor, "Cancelar"});
                }

                model.fireTableDataChanged();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        consultasTable.getColumn("Ação").setCellRenderer(new ButtonRenderer(new Color(255, 102, 102)));
        consultasTable.getColumn("Ação").setCellEditor(new ButtonEditor(new JCheckBox(), e -> {
            int row = consultasTable.getSelectedRow();
            String tipoConsulta = (String) consultasTable.getValueAt(row, 3);
            String dataConsulta = (String) consultasTable.getValueAt(row, 4);
            String horario = (String) consultasTable.getValueAt(row, 5);
            String doutor = (String) consultasTable.getValueAt(row, 6);
            cancelarConsulta(tipoConsulta, dataConsulta, horario, doutor);
        }, new Color(255, 102, 102)));
    }

    private void cancelarConsulta(String tipoConsulta, String dataConsulta, String horario, String doutor) {
        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";

        String sql = "DELETE FROM consultas WHERE tipoConsulta = ? AND dataConsulta = ? AND horario = ? AND doutor = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoConsulta);
            pstmt.setString(2, dataConsulta);
            pstmt.setString(3, horario);
            pstmt.setString(4, doutor);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Consulta cancelada com sucesso!");
                loadConsultas();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cancelar a consulta.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }
    
    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MinhasConsultas(0, null).setVisible(true));
    }

    // Classe para renderizar o botão na célula da tabela
    private class ButtonRenderer extends JButton implements TableCellRenderer {

        private final Color color;

        public ButtonRenderer(Color color) {
            setOpaque(true);
            this.color = color;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            setBackground(color);
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;
        private final ActionListener actionListener;
        private int row;

        public ButtonEditor(JCheckBox checkBox, ActionListener actionListener, Color color) {
            super(checkBox);
            this.actionListener = actionListener;
            button = new JButton();
            button.setOpaque(true);
            button.setBackground(color);
            button.addActionListener(e -> {
                fireEditingStopped();
                actionListener.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, ""));
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            this.row = row;
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(button.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
