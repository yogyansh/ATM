package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String Value = null;
    JButton Back;
    JLabel Card, CardNo, label, amount, BankName, details,logo;

    MiniStatement(String Value) {
        setVisible(true);
        setSize(550, 600);
        setLocation(400, 150);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        this.Value = Value;
        Back = new JButton("BACK");
        add(Back);
        Back.setBounds(300, 420, 130, 28);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);

        ImageIcon first = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image second = first.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon third = new ImageIcon(second);
        logo = new JLabel(third);
        logo.setBounds(40, 5, 100, 80);
        add(logo);

        Card = new JLabel("Card Number:");
        Card.setBounds(100, 100, 110, 28);
        Card.setFont(new Font("Courier", Font.BOLD, 15));
        add(Card);

        CardNo = new JLabel("");
        CardNo.setBounds(215, 100, 200, 28);
        CardNo.setFont(new Font("Courier", Font.BOLD, 15));
        add(CardNo);

        BankName = new JLabel("HARYANA NATIONAL BANK");
        BankName.setBounds(145, 60, 300, 30);
        BankName.setFont(new Font("Courier", Font.BOLD, 18));
        add(BankName);

        details = new JLabel("");
        details.setBounds(100, 100, 450, 280);
        add(details);

        amount = new JLabel("");
        amount.setBounds(100, 355, 450, 20);
        amount.setFont(new Font("Courier", Font.BOLD, 15));
        add(amount);

        Back.addActionListener(this);

        try {
            ConnectDb connect = new ConnectDb();
            ResultSet rs = connect.statement.executeQuery("Select * from login where Value='" + Value + "'");
            if (rs.next()) {
                String card = rs.getString("CardNo");
                CardNo.setText(card.substring(0, 4) + "XXXXXXXX" + card.substring(12));
            }
            rs = connect.statement.executeQuery("select * from bank where value='" + Value + "'");
            int i = 0;
            while (rs.next()) {
                i++;
            }
            i = i - 6;
            rs = connect.statement.executeQuery("select * from bank where value='" + Value + "'");
            for (int k = 0; k < i; k++) {
                rs.next();
            }
            while (rs.next()) {
                double deposit = rs.getDouble("DepositAmount");
                double withdraw = rs.getDouble("withdrawl");
                double date;
                String mode = withdraw == 0 ? "Deposit " : "Withdraw";
                double money = deposit == 0 ? withdraw : deposit;
                details.setText(details.getText() + "<HTML>" + rs.getString(5) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + mode + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + money + "<br><br><html>");
            }
            ResultSet result = connect.statement.executeQuery("Select Balance from bank where value='" + Value + "'");
            double balance = 0;
            while (result.next()) {
                balance = result.getDouble("Balance");

            }
            amount.setText("Your account balance is Rs " + balance);
        } catch (Exception exception) {
           
        }
    }

    public void actionPerformed(ActionEvent e) {
        new ATMFunction(Value).setVisible(true);
        setVisible(false);
    }
    public static void main(String []args)
    {
    new MiniStatement("").setVisible(true);	
    }
}
