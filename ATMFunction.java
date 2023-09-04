package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ATMFunction extends JFrame implements ActionListener {

    JButton Deposit, Fast, Pin, Withdrawl, Mini, Enquiry, Exit;
    JLabel label, background;
    String Value = null;

    public ATMFunction(String Value) {
        this.Value = Value;
        setVisible(true);
        setSize(750, 750);
        setLocation(400, 50);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Please Select Your Transaction");
        label.setBounds(158, 320, 400, 20);
        label.setFont(new Font("Courier", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        add(label);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/cmachine.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        Deposit = new JButton("DEPOSIT");
        Deposit.setBackground(Color.BLACK);
        Deposit.setForeground(Color.WHITE);
        Deposit.setBounds(155, 355, 110, 28);
        background.add(Deposit);

        Withdrawl = new JButton("CASH WITHDRAWAL");
        Withdrawl.setBackground(Color.BLACK);
        Withdrawl.setForeground(Color.WHITE);
        Withdrawl.setBounds(270, 355, 160, 28);
        background.add(Withdrawl);

        Fast = new JButton("FAST CASH");
        Fast.setBackground(Color.BLACK);
        Fast.setForeground(Color.WHITE);
        Fast.setBounds(155, 390, 110, 28);
        background.add(Fast);

        Mini = new JButton("MINI STATEMENT");
        Mini.setBackground(Color.BLACK);
        Mini.setForeground(Color.WHITE);
        Mini.setBounds(270, 390, 160, 28);
        background.add(Mini);

        Pin = new JButton("PIN CHANGE");
        Pin.setBackground(Color.BLACK);
        Pin.setForeground(Color.WHITE);
        Pin.setBounds(155, 425, 110, 28);
        background.add(Pin);

        Enquiry = new JButton("BALANCE ENQUIRY");
        Enquiry.setBackground(Color.BLACK);
        Enquiry.setForeground(Color.WHITE);
        Enquiry.setBounds(270, 425, 160, 28);
        background.add(Enquiry);

        Exit = new JButton("EXIT");
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.setBounds(270, 455, 160, 28);
        background.add(Exit);

        Deposit.addActionListener(this);
        Fast.addActionListener(this);
        Pin.addActionListener(this);
        Enquiry.addActionListener(this);
        Exit.addActionListener(this);
        Withdrawl.addActionListener(this);
        Mini.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == Deposit) {
                new Deposit(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Fast) {
                new FastCash(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Pin) {
                new PinChange(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Withdrawl) {
                new Withdrawl(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Mini) {
                new MiniStatement(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Enquiry) {
                new BalanceEnquiry(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Exit) {
                System.exit(0);
            }

        } catch (Exception exception) {
           
        }
    }
    public static void main(String []args)
    {
    	new ATMFunction("").setVisible(true);
    	
    }
}

