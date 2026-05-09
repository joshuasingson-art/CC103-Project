import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    private DefaultTableModel tableModel;
    private JTextField titleField, authorField;
    private JComboBox<String> statusBox;

    public MainFrame(String studentName) {
        setTitle("Centralized Library Management - Dashboard");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- 1. Header Area ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Logged in as: " + studentName + "  ");
        welcomeLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        headerPanel.add(welcomeLabel, BorderLayout.EAST);
        headerPanel.setBackground(new Color(230, 230, 230));

        // --- 2. Table Area ---
        String[] columns = {"Book Title", "Author", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Sample Data
        tableModel.addRow(new Object[]{"Clean Code", "Robert C. Martin", "Available"});
        tableModel.addRow(new Object[]{"The Mythical Man-Month", "Frederick Brooks", "Borrowed"});

        // --- 3. Management/Input Area ---
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Book Entry"));

        titleField = new JTextField(12);
        authorField = new JTextField(12);

        // Status dropdown for better UX
        String[] statuses = {"Available", "Borrowed", "Reserved", "Under Repair"};
        statusBox = new JComboBox<>(statuses);

        JButton addBtn = new JButton("Add to Inventory");
        addBtn.setBackground(new Color(70, 130, 180));
        addBtn.setForeground(Color.WHITE);

        // Logic to add the full row
        addBtn.addActionListener(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            if (!title.isEmpty() && !author.isEmpty()) {
                tableModel.addRow(new Object[]{title, author, status});
                // Clear fields after adding
                titleField.setText("");
                authorField.setText("");
                statusBox.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Please provide both Title and Author.");
            }
        });

        // Adding components to the input panel
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusBox);
        inputPanel.add(addBtn);

        // --- 4. Final Assembly ---
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }
}