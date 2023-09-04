package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;

public class LoginFirst extends JFrame implements ActionListener, KeyListener {

    JLabel title, Card, Password, background, logo, rlabel;
    JTextField Card_no;
    JPasswordField Pin_no;
    JButton Signup, Signin, Clear;
    int flag = 0;

    public LoginFirst() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLayout(null);
        setResizable(false);
        setLocation(400, 50);
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        background = new JLabel(i3);
        background.setBounds(0, 0, 750, 750);
        add(background);

        ImageIcon First = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image second = First.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon Third = new ImageIcon(second);
        logo = new JLabel(Third);
        logo.setBounds(100, 77, 100, 80);
        background.add(logo);

        title = new JLabel("WELCOME TO ATM");
        title.setFont(new Font("Courier", Font.BOLD, 25));

        Card = new JLabel("Card No:");
        Card.setFont(new Font("Courier", Font.BOLD, 18));

        Password = new JLabel("PIN:");
        Password.setFont(new Font("Courier", Font.BOLD, 18));

        Card_no = new JTextField(15);
        Card_no.setFont(new Font("Courier", Font.BOLD, 15));
        Card_no.addKeyListener(this);

        Pin_no = new JPasswordField(15);
        Pin_no.setFont(new Font("Courier", Font.BOLD, 15));

        Signup = new JButton("SIGN UP");
        Signup.setFont(new Font("Courier", Font.BOLD, 15));
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);

        Signin = new JButton("SIGN IN");
        Signin.setFont(new Font("Courier", Font.BOLD, 15));
        Signin.setBackground(Color.BLACK);
        Signin.setForeground(Color.WHITE);

        Clear = new JButton("Reset");
        Clear.setFont(new Font("Courier", Font.BOLD, 15));
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.white);

        background.add(title);
        background.add(Card);
        background.add(Password);
        background.add(Card_no);
        background.add(Pin_no);
        background.add(Signup);
        background.add(Signin);
        background.add(Clear);

        title.setBounds(220, -55, 250, 400);
        Card.setBounds(100, 100, 200, 200);
        Password.setBounds(100, 140, 200, 200);
        Card_no.setBounds(220, 190, 230, 20);
        Pin_no.setBounds(220, 230, 230, 20);
        Signin.setBounds(220, 280, 100, 30);
        Clear.setBounds(350, 280, 100, 30);
        Signup.setBounds(285, 320, 100, 30);

        rlabel = new JLabel();
        rlabel.setBounds(450, 190, 230, 20);
        rlabel.setForeground(Color.RED);
        background.add(rlabel);

        getContentPane().setBackground(Color.WHITE);

        Signin.addActionListener(this);
        Signup.addActionListener(this);
        Clear.addActionListener(this);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        try {
            Pattern pattern;
            if (e.getSource() == Card_no) {
                pattern = Pattern.compile("^[0-9]{16}$");
                if (!pattern.matcher(Card_no.getText()).matches()) {
                    rlabel.setText("*Incorrect Email");
                    flag = 1;
                } else {
                    rlabel.setText("");
                    flag = 0;
                }
            }
        } catch (Exception exception) {

        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String s1 = Card_no.getText();
            String s2 = Pin_no.getText();
            String s3 = null;
            if (e.getSource() == Signin) {
                if (s1.equals("") || s2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Card Number and PIN");
                    return;
                }
                ConnectDb connect = new ConnectDb();
                int pin = Integer.parseInt(s2);
                ResultSet rs = connect.statement.executeQuery("select Value from login where CardNo = '" + s1 + "' and Pin = '" + pin + "'");
                if (rs.next()) {
                    s3 = rs.getString("Value");
                    new ATMFunction(s3).setVisible(true);
                    setVisible(false);
                } else {
                    Card_no.setText("");
                    Pin_no.setText("");
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                }
            } else if (e.getSource() == Signup) {
                new SignUp().setVisible(true);
                setVisible(false);
            } else if (e.getSource() == Clear) {
                Card_no.setText("");
                Pin_no.setText("");
            }
        } catch (Exception exception) {
         
        }
    }
    public static void main(String []args)
    {
    new LoginFirst().setVisible(true);	
    }
}
