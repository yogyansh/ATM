package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JLabel j1, j2, j3, background;
    JTextField t1;
    JButton Deposit, Back, Exit;
    String Value = null;

    public Deposit(String Value) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLocation(400, 50);
        setResizable(false);
        setLayout(null);

        this.Value = Value;

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/cmachine.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        j1 = new JLabel("ENTER AMOUNT YOU WANT");
        j1.setBounds(158, 335, 550, 28);
        j1.setFont(new Font("Courier", Font.BOLD, 20));
        j1.setForeground(Color.WHITE);
        background.add(j1);

        j2 = new JLabel("TO DEPOSIT");
        j2.setBounds(230, 360, 200, 28);
        j2.setFont(new Font("Courier", Font.BOLD, 20));
        j2.setForeground(Color.WHITE);
        background.add(j2);

        t1 = new JTextField(30);
        t1.setBounds(155, 390, 278, 22);
        background.add(t1);

        Deposit = new JButton("DEPOSIT");
        background.add(Deposit);
        Deposit.setBounds(155, 420, 130, 28);
        Deposit.setForeground(Color.BLACK);
        Deposit.setBackground(Color.WHITE);

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

        Deposit.addActionListener(this);
        Back.addActionListener(this);
        Exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            new ATMFunction(Value).setVisible(true);
            setVisible(false);
        } else if (e.getSource() == Exit) {
            System.exit(0);
        } else if (e.getSource() == Deposit) {
            try {
                String text = t1.getText();
                if (text.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter some  amount");
                } else {
                    ConnectDb connect = new ConnectDb();
                    Double balance = 0.0;
                    Double depositData;
                    ResultSet rs = connect.statement.executeQuery("Select balance from bank where value='" + Value + "'");
                    while (rs.next()) {
                        balance = rs.getDouble("Balance");
                    }
                    depositData = Double.parseDouble(text);
                    balance = balance + depositData;
                    Date date = new Date();
                    connect.statement.executeUpdate("Insert into bank values ('" + Value + "','" + depositData + "','" + balance + "','" + 0 + "','" + date + "')");

                    JOptionPane.showMessageDialog(null, "Rs" + text + " is deposited Sucessfully");
                    new ATMFunction(Value).setVisible(true);
                    setVisible(false);
                }
            } catch (Exception exception) {
               
            }
        }
    }
    public static void main(String []args)
    {
    new Deposit("").setVisible(true);	
    }
}
  