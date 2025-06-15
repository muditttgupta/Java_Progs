import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeManager extends JFrame {
    JTextField idField, nameField, deptField, salaryField;
    JButton insertButton;
    JTable table;
    DefaultTableModel model;

    Connection conn;

    public EmployeeManager() {
        // DB Connection
        try {
            conn = DriverManager.getConnection("jdbc:mysql:/Users/muditgupta/Desktop/javaprogs/EXP10/sql.SQL", "root", "password");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed");
            e.printStackTrace();
        }

        // UI Setup
        setTitle("Employee Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel for input
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        insertButton = new JButton("Insert");
        inputPanel.add(insertButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Department", "Salary"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Action
        insertButton.addActionListener(e -> insertEmployee());

        // Load data on start
        loadEmployees();

        setVisible(true);
    }

    void insertEmployee() {
        try {
            String sql = "INSERT INTO employees VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setString(2, nameField.getText());
            stmt.setString(3, deptField.getText());
            stmt.setDouble(4, Double.parseDouble(salaryField.getText()));
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee Added!");
            loadEmployees();
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    void loadEmployees() {
        model.setRowCount(0); // Clear table
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeManager::new);
    }
}
