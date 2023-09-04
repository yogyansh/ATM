package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.regex.Pattern;

public class SignUp extends JFrame implements ActionListener, KeyListener {

    JLabel Name, Fname, Dob, Sex, Email, MaritalStatus, Address, City, Pincode, State, Appform, Page1, Landmark, PermanentAddress, District, logo, elabel, nlabel, flabel, clabel, slabel, dlabel, plabel;
    JTextField Name_, Fname_, Email_, Address_, City_, Pincode_, State_, Landmark_, PermanentAddress_, District_;
    JRadioButton Male, Female, Other, Married, Unmarried;
    JDateChooser datechooser;
    JButton Next;
    String Value;
    int value, flag = 0;

    public SignUp() {
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 750);
        setLocation(400, 50);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        Date date = new Date();

        Value = date.getDate() + "" + date.getHours() + "" + date.getMinutes() + "" + date.getSeconds();

        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon first = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image second = first.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon third = new ImageIcon(second);
        logo = new JLabel(third);
        logo.setBounds(80, 10, 100, 80);
        add(logo);

        Name = new JLabel("Name:");
        Fname = new JLabel("Father's Name:");
        Dob = new JLabel("Date of Birth:");
        Sex = new JLabel("Gender:");
        Email = new JLabel("Email Address:");
        MaritalStatus = new JLabel("Marital Status:");
        Address = new JLabel("Temporary Address:");
        City = new JLabel("City:");
        Pincode = new JLabel("Pincode:");
        State = new JLabel("State:");
        Appform = new JLabel("");
        Page1 = new JLabel("Page 1:Personal Details");
        Appform = new JLabel("APPLICATION FORM NO." + Value);
        Landmark = new JLabel("Landmark:");
        PermanentAddress = new JLabel("Permanent Address:");
        District = new JLabel("District:");

        Name_ = new JTextField(50);
        Fname_ = new JTextField(50);
        Email_ = new JTextField(50);
        Address_ = new JTextField(50);
        City_ = new JTextField(50);
        Pincode_ = new JTextField(50);
        State_ = new JTextField(50);
        Landmark_ = new JTextField(50);
        PermanentAddress_ = new JTextField(50);
        District_ = new JTextField(50);

        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        Other = new JRadioButton("Other");
        Married = new JRadioButton("Married");
        Unmarried = new JRadioButton("Unmarried");

        datechooser = new JDateChooser();
        datechooser.setBounds(250, 210, 400, 20);
        add(datechooser);

        Next = new JButton("Next");

        add(Appform);
        Appform.setBounds(200, -25, 450, 200);
        Appform.setFont(new Font("Courier", Font.BOLD, 25));

        add(Page1);
        Page1.setBounds(250, 12, 300, 200);
        Page1.setFont(new Font("Courier", Font.BOLD, 18));

        add(Name);
        Name.setBounds(50, 40, 200, 200);
        Name.setFont(new Font("Courier", Font.BOLD, 18));

        add(Fname);
        Fname.setBounds(50, 80, 200, 200);
        Fname.setFont(new Font("Courier", Font.BOLD, 18));

        add(Dob);
        Dob.setBounds(50, 120, 200, 200);
        Dob.setFont(new Font("Courier", Font.BOLD, 18));

        add(Sex);
        Sex.setBounds(50, 160, 200, 200);
        Sex.setFont(new Font("Courier", Font.BOLD, 18));

        add(Email);
        Email.setBounds(50, 200, 200, 200);
        Email.setFont(new Font("Courier", Font.BOLD, 18));

        add(MaritalStatus);
        MaritalStatus.setBounds(50, 240, 200, 200);
        MaritalStatus.setFont(new Font("Courier", Font.BOLD, 18));

        add(Address);
        Address.setBounds(50, 280, 250, 200);
        Address.setFont(new Font("Courier", Font.BOLD, 18));

        add(City);
        City.setBounds(50, 400, 200, 200);
        City.setFont(new Font("Courier", Font.BOLD, 18));

        add(Pincode);
        Pincode.setBounds(50, 480, 200, 200);
        Pincode.setFont(new Font("Courier", Font.BOLD, 18));

        add(State);
        State.setBounds(50, 520, 200, 200);
        State.setFont(new Font("Courier", Font.BOLD, 18));

        add(Name_);
        Name_.addKeyListener(this);
        Name_.setBounds(250, 130, 400, 20);
        Name_.setFont(new Font("Courier", Font.BOLD, 18));

        add(Fname_);
        Fname_.addKeyListener(this);
        Fname_.setBounds(250, 170, 400, 20);
        Fname_.setFont(new Font("Courier", Font.BOLD, 18));

        add(Email_);
        Email_.addKeyListener(this);
        Email_.setBounds(250, 290, 400, 20);
        Email_.setFont(new Font("Courier", Font.BOLD, 18));

        add(Address_);
        Address_.setBounds(250, 370, 400, 20);
        Address_.setFont(new Font("Courier", Font.BOLD, 18));

        add(PermanentAddress_);
        PermanentAddress_.setBounds(250, 410, 400, 20);
        PermanentAddress_.setFont(new Font("Courier", Font.BOLD, 18));

        add(District);
        District.setBounds(50, 440, 200, 200);
        District.setFont(new Font("Courier", Font.BOLD, 18));

        add(Landmark);
        Landmark.setBounds(50, 360, 200, 200);
        Landmark.setFont(new Font("Courier", Font.BOLD, 18));

        add(PermanentAddress);
        PermanentAddress.setBounds(50, 320, 250, 200);
        PermanentAddress.setFont(new Font("Courier", Font.BOLD, 18));

        add(District_);
        District_.addKeyListener(this);
        District_.setBounds(250, 530, 400, 20);
        District_.setFont(new Font("Courier", Font.BOLD, 18));

        add(Landmark_);
        Landmark_.setBounds(250, 450, 400, 20);
        Landmark_.setFont(new Font("Courier", Font.BOLD, 18));

        add(City_);
        City_.addKeyListener(this);
        City_.setBounds(250, 490, 400, 20);
        City_.setFont(new Font("Courier", Font.BOLD, 18));

        add(Pincode_);
        Pincode_.addKeyListener(this);
        Pincode_.setBounds(250, 570, 400, 20);
        Pincode_.setFont(new Font("Courier", Font.BOLD, 18));

        add(State_);
        State_.addKeyListener(this);
        State_.setBounds(250, 610, 400, 20);
        State_.setFont(new Font("Courier", Font.BOLD, 18));

        ButtonGroup bg = new ButtonGroup();
        bg.add(Male);
        bg.add(Female);
        bg.add(Other);

        add(Male);
        Male.setBounds(250, 250, 90, 20);
        Male.setBackground(Color.WHITE);

        add(Female);
        Female.setBounds(350, 250, 90, 20);
        Female.setBackground(Color.WHITE);

        add(Other);
        Other.setBounds(450, 250, 90, 20);
        Other.setBackground(Color.WHITE);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(Married);
        bg2.add(Unmarried);

        add(Married);
        Married.setBounds(250, 330, 90, 20);
        Married.setBackground(Color.WHITE);

        add(Unmarried);
        Unmarried.setBounds(350, 330, 90, 20);
        Unmarried.setBackground(Color.WHITE);

        add(Next);
        Next.setBounds(580, 650, 70, 25);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);

        elabel = new JLabel();
        elabel.setBounds(650, 290, 200, 20);
        elabel.setForeground(Color.RED);
        add(elabel);

        flabel = new JLabel();
        flabel.setBounds(650, 170, 200, 20);
        flabel.setForeground(Color.RED);
        add(flabel);

        nlabel = new JLabel("");
        nlabel.setBounds(650, 130, 200, 20);
        nlabel.setForeground(Color.RED);
        add(nlabel);

        slabel = new JLabel();
        slabel.setBounds(650, 610, 200, 20);
        slabel.setForeground(Color.RED);
        add(slabel);

        dlabel = new JLabel();
        dlabel.setBounds(650, 530, 200, 20);
        dlabel.setForeground(Color.RED);
        add(dlabel);

        clabel = new JLabel();
        clabel.setBounds(650, 490, 200, 20);
        clabel.setForeground(Color.RED);
        add(clabel);

        plabel = new JLabel();
        plabel.setBounds(650, 570, 200, 20);
        plabel.setForeground(Color.RED);
        add(plabel);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        try {
            Pattern pattern;
            if (e.getSource() == Email_) {
                pattern = Pattern.compile("^[a-zA-z_](.+){0,30}[@][a-zA-z]{4,10}[.][a-zA-z]{2,6}[.]{0,1}[a-zA-z]{0,5}$");
                if (!pattern.matcher(Email_.getText()).matches()) {
                    elabel.setText("*Incorrect Email");
                    flag = 1;
                } else {
                    elabel.setText("");
                    flag = 0;
                }
            }
            pattern = Pattern.compile("^[a-zA-Z ]{1,15}$");
            if (e.getSource() == Name_) {

                if (!pattern.matcher(Name_.getText()).matches()) {

                    nlabel.setText("*Incorrect Naming");
                    flag = 1;
                } else {
                    nlabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == Fname_) {
                if (!pattern.matcher(Fname_.getText()).matches()) {

                    flabel.setText("*Incorrect Naming");
                    flag = 1;
                } else {
                    flabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == State_) {
                if (!pattern.matcher(State_.getText()).matches()) {

                    slabel.setText("*only Alphabets allowed");
                    flag = 1;
                } else {
                    slabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == City_) {
                if (!pattern.matcher(City_.getText()).matches()) {

                    clabel.setText("*only Alphabets allowed");
                    flag = 1;
                } else {
                    clabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == District_) {
                if (!pattern.matcher(District_.getText()).matches()) {

                    dlabel.setText("*only Alphabets allowed");
                    flag = 1;
                } else {
                    dlabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == Pincode_) {
                pattern = Pattern.compile("^[0-9]{6}$");
                if (!pattern.matcher(Pincode_.getText()).matches()) {
                    plabel.setText("*Incorrect");
                    flag = 1;
                } else {
                    plabel.setText("");
                    flag = 0;
                }
            }
        } catch (Exception exception) {
          
        }
    }

    public void actionPerformed(ActionEvent e) {

        String name = Name_.getText();
        String fname = Fname_.getText();
        String email = Email_.getText();
        String address = Address_.getText();
        String city = City_.getText();
        String pincode = Pincode_.getText();
        String state = State_.getText();
        String sex = null;
        String martialStatus = null;
        String district = District_.getText();
        String permanent = PermanentAddress_.getText();
        String landmark = Landmark_.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        if (Male.isSelected()) {
            sex = "Male";
        } else if (Female.isSelected()) {
            sex = "Female";
        } else if (Other.isSelected()) {
            sex = "Other";
        }

        if (Married.isSelected()) {
            martialStatus = "Married";
        } else if (Unmarried.isSelected()) {
            martialStatus = "Unmarried";
        }
        try {
            if (name.equals("") || fname.equals("") || email.equals("") || address.equals("") || city.equals("") || pincode.equals("") || state.equals("") || permanent.equals("") || dob.equals("") || martialStatus == null || sex == null) {
                JOptionPane.showMessageDialog(null, "Fill all the required values");
            } else if (flag == 1) {
                return;
            } else if (flag == 0) {
                ConnectDb connect = new ConnectDb();
                connect.statement.executeUpdate("insert into Signup values('" + name + "','" + fname + "','" + sex + "','" + email + "','" + martialStatus + "','" + address + "','" + city + "','" + pincode + "','" + state + "','" + dob + "','" + Value + "','" + permanent + "','" + landmark + "','" + district + "')");
                new SignUp2(Value).setVisible(true);
                setVisible(false);
            }
        } catch (Exception exception) {
            
        }
    }
    public static void main(String []args)
    {
    new SignUp().setVisible(true);	
    }
}
