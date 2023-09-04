package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField t1, t2, t3;
    JLabel Current, New, ReEnter, j1, background;
    JButton Save, Back;
    String Value = null;

    public PinChange(String value) {
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

        this.Value = value;
        j1 = new JLabel("CHANGE YOUR PIN");
        j1.setBounds(180, 320, 550, 30);
        j1.setFont(new Font("Courier", Font.BOLD, 20));
        j1.setForeground(Color.WHITE);
        background.add(j1);

        t1 = new JPasswordField(80);
        t1.setBounds(265, 355, 165, 25);
        background.add(t1);

        t2 = new JPasswordField(80);
        t2.setBounds(265, 390, 165, 25);
        background.add(t2);

        t3 = new JPasswordField(80);
        t3.setBounds(265, 425, 165, 25);
        background.add(t3);

        Current = new JLabel("Current PIN:");
        Current.setBounds(155, 355, 110, 28);
        Current.setFont(new Font("Courier", Font.BOLD, 15));
        Current.setForeground(Color.WHITE);
        background.add(Current);

        New = new JLabel("New PIN:");
        New.setBounds(155, 390, 110, 28);
        New.setFont(new Font("Courier", Font.BOLD, 15));
        New.setForeground(Color.WHITE);
        background.add(New);

        ReEnter = new JLabel("Re-Enter:");
        ReEnter.setBounds(155, 425, 150, 28);
        ReEnter.setFont(new Font("Courier", Font.BOLD, 15));
        ReEnter.setForeground(Color.WHITE);
        background.add(ReEnter);

        Back = new JButton("BACK");
        background.add(Back);
        Back.setBounds(300, 455, 135, 25);
        Back.setBackground(Color.WHITE);
        Back.setForeground(Color.BLACK);

        Save = new JButton("SAVE");
        background.add(Save);
        Save.setBounds(155, 455, 135, 25);
        Save.setBackground(Color.WHITE);
        Save.setForeground(Color.BLACK);

        Save.addActionListener(this);
        Back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String data = t1.getText();
            String newpin = t2.getText();
            String re = t3.getText();
            if (e.getSource() == Save) {
                {
                    if (data.equals("") || newpin.equals("") || re.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    } else if (!newpin.equals(re)) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        JOptionPane.showMessageDialog(null, "Entered and re-Entered pin does not Matches");
                    }
                    if (newpin.equals(re) && !data.equals("") && !newpin.equals("") && !re.equals("")) {
                        int current = Integer.parseInt(data);
                        ConnectDb connect = new ConnectDb();
                        ResultSet rs = connect.statement.executeQuery("Select * from login where Pin='" + current + "'");
                        if (rs.next()) {
                            int reset = Integer.parseInt(re);
                            connect.statement.executeUpdate("Update login set pin='" + reset + "' Where Value='" + Value + "'");
                            connect.statement.executeUpdate("Update Signup3 set pin='" + reset + "' Where Value='" + Value + "'");
                            JOptionPane.showMessageDialog(null, "Pin Succesfully Updated");

                            new ATMFunction(Value).setVisible(true);
                            setVisible(false);
                        } else {
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            JOptionPane.showMessageDialog(null, "Incorrect PIN");
                        }
                    }
                }

            } else if (e.getSource() == Back) {
                new ATMFunction(Value).setVisible(true);
                setVisible(false);
            }
        } catch (Exception exception) {
            
        }
    }
    public static void main(String []args)
    {
    new PinChange("").setVisible(true);	
    }
}
