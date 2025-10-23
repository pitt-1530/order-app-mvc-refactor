/*
 * Created on 2025-10-23
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OrderApp extends JFrame {
    private JTextField productField = new JTextField(10);
    private JTextField quantityField = new JTextField(5);
    private JButton submitButton = new JButton("Save Order");
    private JTextArea outputArea = new JTextArea(8, 25);

    // Directly store orders in UI class to simulate a database
    private List<String> database = new ArrayList<>();

    public OrderApp() {
        setTitle("Order Screen");
        setLayout(new FlowLayout());

        add(new JLabel("Product:"));
        add(productField);
        add(new JLabel("quantity:"));
        add(quantityField);
        add(submitButton);
        add(new JScrollPane(outputArea));

        submitButton.addActionListener(e -> {
            String product = productField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            database.add(product + " x" + quantity);
            outputArea.append("Saved: " + product + " x" + quantity + "\n");

            if (submitButton.getText().equals("Save Order")) {
                System.out.println("Database commit simulated successfully");
            } else {
                System.out.println("Error: Database commit failed!");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OrderApp::new);
    }
}
