package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel j1, j2, j3, background;
    JTextField t1;
    JButton Withdraw, Back, Exit;
    String Value;

    public Withdrawl(String Value) {
        this.Value = Value;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLocation(400, 50);
        setResizable(false);
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/cmachine.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        j1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        j1.setBounds(158, 320, 550, 28);
        j1.setFont(new Font("Courier", Font.BOLD, 18));
        j1.setForeground(Color.WHITE);
        background.add(j1);

        j2 = new JLabel("IS RS.10,000");
        j2.setBounds(230, 345, 200, 28);
        j2.setFont(new Font("Courier", Font.BOLD, 20));
        j2.setForeground(Color.WHITE);
        background.add(j2);

        t1 = new JTextField(30);
        t1.setBounds(155, 390, 277, 24);
        background.add(t1);

        Withdraw = new JButton("WITHDRAW");
        background.add(Withdraw);
        Withdraw.setBounds(155, 420, 130, 28);
        Withdraw.setForeground(Color.BLACK);
        Withdraw.setBackground(Color.WHITE);

        Back = new JButton("BACK");
        background.add(Back);
        Back.setBounds(300, 420, 130, 28);
        Back.setForeground(Color.BLACK);
        Back.setBackground(Color.WHITE);

        Exit = new JButton("EXIT");
        background.add(Exit);
        Exit.setBounds(300, 450, 130, 28);
        Exit.setForeground(Color.BLACK);
        Exit.setBackground(Color.WHITE);

        Withdraw.addActionListener(this);
        Back.addActionListener(this);
        Exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == Withdraw) {
                String text = t1.getText();

                if (text.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter some amount");
                } else {
                    double data = 0;
                    data = Double.parseDouble(text);
                    double balance = 0;
                    if (data > 10000) {
                        t1.setText("");
                        JOptionPane.showMessageDialog(null, "You can only Withdraw maximum amount of 10,000");
                    } else if (data <= 10000) {
                        ConnectDb connect = new ConnectDb();
                        ResultSet rs = connect.statement.executeQuery("Select Balance from bank where value ='" + Value + "'");
                        while (rs.next()) {
                            balance = rs.getDouble("Balance");
                        }
                        if (data > balance) {
                            t1.setText("");
                            JOptionPane.showMessageDialog(null, "You don't have sufficient balance");
                        } else if (data <= balance) {
                            balance = balance - data;
                            Date date = new Date();
                            connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                            JOptionPane.showMessageDialog(null, "RS" + data + " debited succesfully");
                            new ATMFunction(Value).setVisible(true);
                            setVisible(false);
                        }

                    }
                }
            } else if (e.getSource() == Back) {
                new ATMFunction(Value).setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Exit) {
                System.exit(0);
            }
        } catch (Exception exception) {
           
        }
    }
    public static void main(String []args)
    {
    new Withdrawl("").setVisible(true);	
    }
}

