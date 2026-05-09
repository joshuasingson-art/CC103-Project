import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LoginFrame extends JFrame {
    private HashMap<String, String> studentDatabase;

    public LoginFrame() {
        // Mock Database
        studentDatabase = new HashMap<>();
        studentDatabase.put("59844200", "Joshua Singson");
        studentDatabase.put("59844201", "Lord Voldimort");
        studentDatabase.put("59844202", "Shawn Micheal Madenancil");

        setTitle("Library Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel label = new JLabel("Enter Student ID:", SwingConstants.CENTER);
        JTextField idField = new JTextField();
        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            if (studentDatabase.containsKey(id)) {
                String name = studentDatabase.get(id);
                dispose(); // Close login window
                Main.openLibrary(name); // Open library dashboard
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Student ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(idField);
        panel.add(loginBtn);
        add(panel);
    }
}