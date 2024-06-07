package TelaLogin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class AdminUsers extends JFrame {

    private final int userId;
    private final Principal principal;
    private JTable usersTable;

    public AdminUsers(int userId, Principal principal) {
        this.userId = userId;
        this.principal = principal;
        initComponents();
        loadUsers();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        usersTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Email", "Tipo de Usuário", "Editar", "Deletar"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        });

        JButton jButtonVoltar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin - Users");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(181, 194, 196));
        jPanel1.setLayout(null);

        jScrollPane1.setViewportView(usersTable);
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

    private void jButtonVoltarActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        principal.setVisible(true);
    }

    private void loadUsers() {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, nome, email, type_user FROM users")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String tipoUsuario = rs.getString("type_user");

                model.addRow(new Object[]{nome, email, tipoUsuario, "Editar", "Deletar"});
            }

            usersTable.getColumn("Editar").setCellRenderer(new ButtonRenderer(new Color(173, 216, 230)));
            usersTable.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), e -> editarUsuario(usersTable.getSelectedRow()), new Color(173, 216, 230)));
            usersTable.getColumn("Deletar").setCellRenderer(new ButtonRenderer(Color.RED));
            usersTable.getColumn("Deletar").setCellEditor(new ButtonEditor(new JCheckBox(), e -> deletarUsuario(usersTable.getSelectedRow()), Color.RED));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void editarUsuario(int row) {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        String nome = (String) model.getValueAt(row, 0);

        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";
        int userIdToEdit = -1;

        String sql = "SELECT id FROM users WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userIdToEdit = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userIdToEdit != -1) {
            Dados dados = new Dados(userIdToEdit, principal);
            new AtCadastral(userIdToEdit, principal, dados).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao encontrar o usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deletarUsuario(int row) {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        String nome = (String) model.getValueAt(row, 0);

        String url = "jdbc:mysql://localhost:3306/healthtech";
        String user = "root";
        String password = "Mudar123";

        String sql = "DELETE FROM users WHERE nome = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.removeRow(row);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new AdminUsers(0, null).setVisible(true));
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        private Color color;

        public ButtonRenderer(Color color) {
            setOpaque(true);
            this.color = color;
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText((value == null) ? "" : value.toString());
            setBackground(color);
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

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

        public Object getCellEditorValue() {
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
