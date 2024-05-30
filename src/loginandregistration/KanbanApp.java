/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandregistration;

/**
 *
 * @author donav
 */import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class KanbanApp extends JFrame {

    private JTextField taskNameField;
    private JTextField taskDescriptionField;
    private JTextField developerDetailsField;
    private JTextField taskDurationField;
    private JComboBox<String> taskStatusComboBox;
    private JTextArea outputArea;
    private Task[] tasks;
    private int taskIndex = 0;
    private String currentUser;

    public KanbanApp(String currentUser) {
        this.currentUser = currentUser;

        setTitle("EasyKanban");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Task Name:"));
        taskNameField = new JTextField();
        inputPanel.add(taskNameField);

        inputPanel.add(new JLabel("Task Description:"));
        taskDescriptionField = new JTextField();
        inputPanel.add(taskDescriptionField);

        inputPanel.add(new JLabel("Developer Details:"));
        developerDetailsField = new JTextField();
        inputPanel.add(developerDetailsField);

        inputPanel.add(new JLabel("Task Duration (hours):"));
        taskDurationField = new JTextField();
        inputPanel.add(taskDurationField);

        inputPanel.add(new JLabel("Task Status:"));
        taskStatusComboBox = new JComboBox<>(new String[]{"To Do", "Done", "Doing"});
        inputPanel.add(taskStatusComboBox);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        buttonPanel.add(addButton);

        JButton reportButton = new JButton("Show Report");
        reportButton.addActionListener((ActionEvent e) -> outputArea.setText("Coming Soon"));
        buttonPanel.add(reportButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
        buttonPanel.add(quitButton);

        JPanel outputPanel = new JPanel();
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        tasks = new Task[100];

        reportButton.addActionListener((ActionEvent e) -> outputArea.setText("Coming Soon"));

        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void addTask() {
        String taskName = taskNameField.getText();
        String taskDescription = taskDescriptionField.getText();
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(this, "Please enter a task description of less than 50 characters");
            return;
        }
        String developerDetails = developerDetailsField.getText();
        int taskDuration;
        try {
            taskDuration = Integer.parseInt(taskDurationField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for task duration");
            return;
        }
        String taskStatus = (String) taskStatusComboBox.getSelectedItem();

        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        tasks[taskIndex++] = task;

        JOptionPane.showMessageDialog(this, "Task successfully captured");
        outputArea.append(task.printTaskDetails() + "\n\n");
        JOptionPane.showMessageDialog(this, task.printTaskDetails());

        taskNameField.setText("");
        taskDescriptionField.setText("");
        developerDetailsField.setText("");
        taskDurationField.setText("");
        taskStatusComboBox.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            KanbanApp kanbanApp = new KanbanApp("DefaultUser");
            kanbanApp.setVisible(true);
            kanbanApp.setLocationRelativeTo(null);
        });
    }
}
