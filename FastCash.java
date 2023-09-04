package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton Rs100, Rs200, Rs500, Rs2000, Rs5000, Rs10000, Exit, Back;
    JLabel j, background;
    String Value = null;

    public FastCash(String Value) {

        setVisible(true);
        setSize(750, 750);
        setLocation(400, 50);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.Value = Value;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/cmachine.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        j = new JLabel("SELECT WITHDRAWAL AMOUNT");
        j.setBounds(158, 320, 550, 20);
        j.setFont(new Font("Courier", Font.BOLD, 17));
        j.setForeground(Color.WHITE);
        background.add(j);

        Rs100 = new JButton("Rs 100");
        Rs100.setBackground(Color.BLACK);
        Rs100.setForeground(Color.WHITE);
        Rs100.setBounds(155, 355, 135, 28);
        background.add(Rs100);

        Rs200 = new JButton("Rs 200");
        Rs200.setBackground(Color.BLACK);
        Rs200.setForeground(Color.WHITE);
        Rs200.setBounds(300, 355, 135, 28);
        background.add(Rs200);

        Rs500 = new JButton("Rs 500");
        Rs500.setBackground(Color.BLACK);
        Rs500.setForeground(Color.WHITE);
        Rs500.setBounds(155, 390, 135, 28);
        background.add(Rs500);

        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBackground(Color.BLACK);
        Rs2000.setForeground(Color.WHITE);
        Rs2000.setBounds(300, 390, 135, 28);
        background.add(Rs2000);

        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBackground(Color.BLACK);
        Rs5000.setForeground(Color.WHITE);
        Rs5000.setBounds(155, 425, 135, 28);
        background.add(Rs5000);

        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBackground(Color.BLACK);
        Rs10000.setForeground(Color.WHITE);
        Rs10000.setBounds(300, 425, 135, 28);
        background.add(Rs10000);

        Exit = new JButton("EXIT");
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
        Exit.setBounds(300, 455, 135, 28);
        background.add(Exit);

        Back = new JButton("BACK");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(155, 455, 135, 28);
        background.add(Back);

        Rs100.addActionListener(this);
        Rs500.addActionListener(this);
        Rs5000.addActionListener(this);
        Rs200.addActionListener(this);
        Rs2000.addActionListener(this);
        Rs10000.addActionListener(this);
        Exit.addActionListener(this);
        Back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == Exit) {
                System.exit(0);
            } else if (e.getSource() == Back) {
                new ATMFunction(Value).setVisible(true);
                setVisible(false);
            } else {
                double balance = 0, data = 0;
                ConnectDb connect = new ConnectDb();
                Date date = new Date();
                ResultSet rs = connect.statement.executeQuery("Select Balance from bank where value ='" + Value + "'");
                while (rs.next()) {
                    balance = rs.getDouble("Balance");
                }
                if (e.getSource() == Rs100) {
                    if (balance >= 100) {
                        balance -= 100;
                        data = 100;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");

                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
                if (e.getSource() == Rs500) {
                    if (balance >= 500) {
                        balance -= 500;
                        data = 500;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
                if (e.getSource() == Rs5000) {
                    if (balance >= 5000) {
                        balance -= 5000;
                        data = 5000;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
                if (e.getSource() == Rs200) {
                    if (balance >= 200) {
                        balance -= 200;
                        data = 200;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
                if (e.getSource() == Rs2000) {
                    if (balance >= 2000) {
                        balance -= 2000;
                        data = 2000;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
                if (e.getSource() == Rs10000) {
                    if (balance >= 10000) {
                        balance -= 10000;
                        data = 10000;
                        connect.statement.executeUpdate("Insert into bank values('" + Value + "','" + 0 + "','" + balance + "','" + data + "','" + date + "')");
                        JOptionPane.showMessageDialog(null, "Successfully withdrawal amount:" + data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Not sufficient balance");
                    }
                }
            }
        } catch (Exception exception) {
         
        }
    }
    public static void main(String []args)
    {
    new FastCash("").setVisible(true);	
    }
}
