package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener {

    JLabel Page3, FormNo, Acc, CardNo, Pin, Service, Cn, Pn, j1, j2, j3, FormNo_, logo;
    JButton Submit, Cancel;
    JRadioButton Saving, Current, Fixed, Recurring;
    JCheckBox Atm, Internet, Mobile, Email, Cheque, E, Terms;
    int Password;
    String form = null, card;
    Long Card;

    public SignUp3(String Value) {
        form = Value;
        setVisible(true);
        setSize(750, 750);
        setLocation(400, 50);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 3");

        ImageIcon First = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image second = First.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon Third = new ImageIcon(second);
        logo = new JLabel(Third);
        logo.setBounds(85, 10, 100, 80);
        add(logo);

        Page3 = new JLabel("Page 3: Account Details");
        Page3.setBounds(215, 60, 300, 30);
        Page3.setFont(new Font("Courier", Font.BOLD, 20));
        add(Page3);

        FormNo = new JLabel("Form No.");
        FormNo.setBounds(600, 10, 70, 20);
        add(FormNo);

        FormNo_ = new JLabel(" " + Value);
        FormNo_.setBounds(650, 10, 150, 20);
        add(FormNo_);

        Acc = new JLabel("Account Type:");
        Acc.setBounds(70, 120, 200, 20);
        Acc.setFont(new Font("Courier", Font.BOLD, 15));
        add(Acc);

        Saving = new JRadioButton("Saving Account");
        add(Saving);
        Saving.setBounds(70, 160, 150, 20);
        Saving.setBackground(Color.WHITE);

        Current = new JRadioButton("Current Account");
        add(Current);
        Current.setBounds(70, 200, 150, 20);
        Current.setBackground(Color.WHITE);

        Fixed = new JRadioButton("Fixed Deposit Account");
        add(Fixed);
        Fixed.setBounds(250, 160, 300, 20);
        Fixed.setBackground(Color.WHITE);

        Recurring = new JRadioButton("Recurring Deposit Account");
        add(Recurring);
        Recurring.setBounds(250, 200, 300, 20);
        Recurring.setBackground(Color.WHITE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Current);
        bg.add(Fixed);
        bg.add(Saving);
        bg.add(Recurring);

        CardNo = new JLabel("Card Number:");
        CardNo.setBounds(70, 260, 200, 20);
        CardNo.setFont(new Font("Courier", Font.BOLD, 15));
        add(CardNo);

        Cn = new JLabel("(Your 16-digit Card No:)");
        Cn.setBounds(70, 280, 200, 14);
        add(Cn);

        j1 = new JLabel("It would appear on Atm Card,Cheque book and Statements");
        j1.setBounds(250, 280, 350, 14);
        add(j1);

        Pin = new JLabel("PIN:");
        Pin.setBounds(70, 310, 200, 20);
        Pin.setFont(new Font("Courier", Font.BOLD, 15));
        add(Pin);

        Pn = new JLabel("(4-Digit Password)");
        Pn.setBounds(70, 330, 200, 14);
        add(Pn);

        Random random = new Random();
        Long Second = (random.nextLong() % 9000L) + 1000L;
        Password = (int) Math.abs(Second);

        j2 = new JLabel("XXXX");
        j2.setBounds(250, 310, 200, 20);
        j2.setFont(new Font("Courier", Font.BOLD, 15));
        add(j2);
          
        try {
        Long formno = Long.parseLong(form);
        Card = 2037654700000000L + formno;
        card = "" + Card;
       
        j3 = new JLabel("XXXXXXXXXXXX" + card.substring(12));
        j3.setBounds(250, 260, 200, 20);
        j3.setFont(new Font("Courier", Font.BOLD, 15));
        add(j3);
        }
        catch(Exception exception)
        {
        }

        Service = new JLabel("Services Required:");
        Service.setBounds(70, 360, 200, 20);
        Service.setFont(new Font("Courier", Font.BOLD, 15));
        add(Service);

        Atm = new JCheckBox("ATM CARD");
        Atm.setBounds(70, 400, 170, 20);
        Atm.setBackground(Color.WHITE);
        add(Atm);

        Mobile = new JCheckBox("Mobile Banking");
        Mobile.setBounds(250, 400, 200, 20);
        Mobile.setBackground(Color.WHITE);
        add(Mobile);

        Cheque = new JCheckBox("Cheque Book");
        Cheque.setBounds(70, 440, 170, 20);
        Cheque.setBackground(Color.WHITE);
        add(Cheque);

        Internet = new JCheckBox("Internet Banking");
        Internet.setBounds(250, 440, 200, 20);
        Internet.setBackground(Color.WHITE);
        add(Internet);

        Email = new JCheckBox("Email Alerts");
        Email.setBounds(70, 480, 170, 20);
        Email.setBackground(Color.WHITE);
        add(Email);

        E = new JCheckBox("E Statement");
        E.setBounds(250, 480, 200, 20);
        E.setBackground(Color.WHITE);
        add(E);

        Terms = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge");
        Terms.setBounds(70, 550, 550, 14);
        Terms.setBackground(Color.WHITE);
        add(Terms);

        Submit = new JButton("Submit");
        Submit.setBounds(200, 580, 80, 20);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(300, 580, 80, 20);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        add(Cancel);

        Submit.addActionListener(this);
        Cancel.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            String accountType = null;
            if (Saving.isSelected()) {
                accountType = "Saving Account";
            } else if (Fixed.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (Current.isSelected()) {
                accountType = "Current Account";
            } else if (Recurring.isSelected()) {
                accountType = "Recurring Account";
            }

            String service = "";
            if (Atm.isSelected()) {
                service = service + " ATM Card";
            }
            if (Cheque.isSelected()) {
                service = service + " Cheque Book";
            }
            if (Email.isSelected()) {
                service = service + " Email Alerts";
            }
            if (Mobile.isSelected()) {
                service = service + " Mobile Banking";
            }
            if (Internet.isSelected()) {
                service = service + " Internet Banking";
            }
            if (E.isSelected()) {
                service = service + " E-Statement";
            }

            if (e.getSource() == Cancel) {
                System.exit(0);
            }
            if (accountType == (null) || service.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select manditory fields");
            } else {
                if (!Terms.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You must be agree for registration");
                } else if (e.getSource() == Submit && Terms.isSelected()) {
                    ConnectDb connect = new ConnectDb();
                    connect.statement.executeUpdate("Insert into signup3 values('" + accountType + "','" + service + "','" + form + "','" + card + "','" + Password + "')");
                    connect.statement.executeUpdate("Insert into login values('" + form + "','" + card + "','" + Password + "')");
                    JOptionPane.showMessageDialog(null, "Card Number:" + card + "\n Pin:" + Password);
                    Date date = new Date();
                    connect.statement.executeUpdate("Insert into bank values ('" + form + "','" + 0 + "','" + 0 + "','" + 0 + "','" + date + "')");
                    new Deposit(form).setVisible(true);
                    setVisible(false);
                }
            }
        } catch (Exception exception) {
         
        }
    }
    public static void main(String []args)
    {
    new SignUp3("").setVisible(true);	
    }
}
