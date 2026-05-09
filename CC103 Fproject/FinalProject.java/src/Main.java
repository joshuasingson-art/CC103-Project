import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }

        SwingUtilities.invokeLater(() -> {
            showLogin();
        });
    }

    public static void showLogin() {
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }

    public static void openLibrary(String studentName) {
        MainFrame library = new MainFrame(studentName);
        library.setVisible(true);
    }
}