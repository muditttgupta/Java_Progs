import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        // Create components
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel();

        // Add components to frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(new JLabel());  // empty cell
        frame.add(loginButton);
        frame.add(messageLabel);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if ("admin".equals(username) && "password".equals(password)) {
                    messageLabel.setText("Login successful!");
                } else {
                    messageLabel.setText("Invalid credentials.");
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
