package com.BankAccountBalance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankBalance account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankGUI(double initialBalance) {
        this.account = new BankBalance(initialBalance);
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Bank Account GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        panel.add(balanceLabel);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositListener());
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawListener());
        panel.add(withdrawButton);

        amountField = new JTextField(10);
        panel.add(amountField);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                balanceLabel.setText("Balance: $" + account.getBalance());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        }
    }

    private class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                balanceLabel.setText("Balance: $" + account.getBalance());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> new BankGUI(1000.0));
    }
}
