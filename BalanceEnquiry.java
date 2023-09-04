package asimulatorsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String Value = null;
    JLabel background, label, amount;
    JButton back;

    BalanceEnquiry(String Value) {
        this.Value = Value;
        setVisible(true);
        setSize(750, 750);
        setLocation(400, 50);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/cmachine.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        amount = new JLabel("");
        amount.setBounds(155, 355, 350, 20);
        amount.setFont(new Font("Courier", Font.BOLD, 15));
        amount.setForeground(Color.WHITE);
        background.add(amount);

        back = new JButton("BACK");
        back.setBounds(330, 455, 100, 20);
        back.setFont(new Font("Courier", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        add(back);

        try {
            ConnectDb connect = new ConnectDb();
            ResultSet rs = connect.statement.executeQuery("Select Balance from bank where value='" + Value + "'");
            double balance = 0;
            while (rs.next()) {
                balance = rs.getDouble("Balance");
            }
            amount.setText("Your Account Balance is " + balance);
        } catch (Exception exception) {
           
        }
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        new ATMFunction(Value).setVisible(true);
        setVisible(false);  
    }


	public static void main(String[] args) {
		new BalanceEnquiry("").setVisible(true);

	}

}
