import java.awt.*;
import javax.swing.*;

public class ToDoListApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create components
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        // Panel for controls
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        panel.add(buttonPanel, BorderLayout.EAST);

        // Add components to frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add button action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        // Remove button action
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}

