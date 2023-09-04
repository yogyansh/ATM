package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;

public class SignUp2 extends JFrame implements ActionListener, KeyListener {

    JLabel Religion, Category, Income, Education, Occupation, Pan, Aadhar, SeniorCitizen, ExistingAccount, Page2, FormNo, Nominee, NomineeAadhar, FormNo_, logo, rlabel, plabel, aalabel, nalabel, nlabel;
    JComboBox Category_, Income_, Education_, Occupation_;
    JTextField Religion_, Pan_, Aadhar_, Nominee_, NomineeAadhar_;
    JRadioButton YesC, NoC, YesE, NoE;
    JButton Next;
    String Value = null;
    int flag = 0;

    public SignUp2(String value) {
        Value = value;
        setVisible(true);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        setSize(750, 750);
        setLocation(400, 50);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon first = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image second = first.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon third = new ImageIcon(second);
        logo = new JLabel(third);
        logo.setBounds(95, 8, 100, 80);
        add(logo);

        Page2 = new JLabel("Page 2: Additional Details");
        Page2.setBounds(215, 45, 400, 30);
        Page2.setFont(new Font("Courier", Font.BOLD, 20));
        add(Page2);

        FormNo = new JLabel("Form No.");
        FormNo.setBounds(600, 10, 70, 20);
        add(FormNo);

        FormNo_ = new JLabel(" " + Value);
        FormNo_.setBounds(650, 10, 150, 20);
        add(FormNo_);

        Religion = new JLabel("Religion:");
        Religion.setBounds(50, 100, 100, 20);
        Religion.setFont(new Font("Courier", Font.BOLD, 15));
        add(Religion);

        Category = new JLabel("Category:");
        Category.setBounds(50, 140, 100, 20);
        Category.setFont(new Font("Courier", Font.BOLD, 15));
        add(Category);

        Income = new JLabel("Income:");
        Income.setBounds(50, 180, 100, 20);
        Income.setFont(new Font("Courier", Font.BOLD, 15));
        add(Income);

        Education = new JLabel("Qualification:");
        Education.setBounds(50, 220, 150, 20);
        Education.setFont(new Font("Courier", Font.BOLD, 15));
        add(Education);

        Occupation = new JLabel("Occupation:");
        Occupation.setBounds(50, 260, 100, 20);
        Occupation.setFont(new Font("Courier", Font.BOLD, 15));
        add(Occupation);

        Pan = new JLabel("PAN Number:");
        Pan.setBounds(50, 300, 100, 20);
        Pan.setFont(new Font("Courier", Font.BOLD, 15));
        add(Pan);

        Aadhar = new JLabel("Aadhar Number:");
        Aadhar.setBounds(50, 340, 150, 20);
        Aadhar.setFont(new Font("Courier", Font.BOLD, 15));
        add(Aadhar);

        Nominee = new JLabel("Nominee's Name:");
        Nominee.setBounds(50, 460, 150, 20);
        Nominee.setFont(new Font("Courier", Font.BOLD, 15));
        add(Nominee);

        NomineeAadhar = new JLabel("Nominee's Aadhar Number:");
        NomineeAadhar.setBounds(50, 500, 230, 20);
        NomineeAadhar.setFont(new Font("Courier", Font.BOLD, 15));
        add(NomineeAadhar);

        SeniorCitizen = new JLabel("Senior Citizen:");
        SeniorCitizen.setBounds(50, 380, 150, 20);
        SeniorCitizen.setFont(new Font("Courier", Font.BOLD, 15));
        add(SeniorCitizen);

        ExistingAccount = new JLabel("Existing Account:");
        ExistingAccount.setBounds(50, 420, 150, 20);
        ExistingAccount.setFont(new Font("Courier", Font.BOLD, 15));
        add(ExistingAccount);

        Religion_ = new JTextField(30);
        Religion_.setBounds(260, 100, 350, 20);
        Religion_.addKeyListener(this);
        Religion_.setFont(new Font("Courier", Font.BOLD, 15));
        add(Religion_);

        String category[] = {"General", "SC", "BC", "OBC", "Other"};
        Category_ = new JComboBox(category);
        add(Category_);
        Category_.setBounds(260, 140, 350, 20);
        Category_.setBackground(Color.WHITE);

        String salary[] = {"Null", "<100000", "100000-400000", "400000-600000", ">600000"};
        Income_ = new JComboBox(salary);
        add(Income_);
        Income_.setBounds(260, 180, 350, 20);
        Income_.setBackground(Color.WHITE);

        String edu[] = {"10th", "12th", "Graduate", "Post Graduate", "PHD"};
        Education_ = new JComboBox(edu);
        add(Education_);
        Education_.setBounds(260, 220, 350, 20);
        Education_.setBackground(Color.WHITE);

        String occ[] = {"Doctor", "Teacher", "Engineer", "Banker", "Farmer", "Business", "Student", "Other"};
        Occupation_ = new JComboBox(occ);
        add(Occupation_);
        Occupation_.setBounds(260, 260, 350, 20);
        Occupation_.setBackground(Color.WHITE);

        Pan_ = new JTextField(30);
        Pan_.addKeyListener(this);
        Pan_.setBounds(260, 300, 350, 20);
        Pan_.setFont(new Font("Courier", Font.BOLD, 15));
        add(Pan_);

        Aadhar_ = new JTextField(30);
        Aadhar_.addKeyListener(this);
        Aadhar_.setBounds(260, 340, 350, 20);
        Aadhar_.setFont(new Font("Courier", Font.BOLD, 15));
        add(Aadhar_);

        Nominee_ = new JTextField(50);
        Nominee_.addKeyListener(this);
        Nominee_.setBounds(260, 460, 350, 20);
        Nominee_.setFont(new Font("Courier", Font.BOLD, 15));
        add(Nominee_);

        NomineeAadhar_ = new JTextField(50);
        NomineeAadhar_.addKeyListener(this);
        NomineeAadhar_.setBounds(260, 500, 350, 20);
        NomineeAadhar_.setFont(new Font("Courier", Font.BOLD, 15));
        add(NomineeAadhar_);

        YesC = new JRadioButton("Yes");
        add(YesC);
        YesC.setBounds(260, 380, 50, 20);
        YesC.setBackground(Color.WHITE);

        NoC = new JRadioButton("No");
        add(NoC);
        NoC.setBounds(350, 380, 50, 20);
        NoC.setBackground(Color.WHITE);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NoC);
        bg.add(YesC);

        YesE = new JRadioButton("Yes");
        add(YesE);
        YesE.setBounds(260, 420, 50, 20);
        YesE.setBackground(Color.WHITE);

        NoE = new JRadioButton("No");
        add(NoE);
        NoE.setBounds(350, 420, 50, 20);
        NoE.setBackground(Color.WHITE);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(NoE);
        bg2.add(YesE);

        Next = new JButton("Next");
        add(Next);
        Next.setBounds(510, 550, 100, 20);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);

        rlabel = new JLabel();
        rlabel.setBounds(610, 100, 200, 20);
        rlabel.setForeground(Color.RED);
        add(rlabel);

        plabel = new JLabel();
        plabel.setBounds(610, 300, 200, 20);
        plabel.setForeground(Color.RED);
        add(plabel);

        nlabel = new JLabel("");
        nlabel.setBounds(610, 460, 200, 20);
        nlabel.setForeground(Color.RED);
        add(nlabel);

        nalabel = new JLabel();
        nalabel.setBounds(610, 500, 200, 20);
        nalabel.setForeground(Color.RED);
        add(nalabel);

        aalabel = new JLabel();
        aalabel.setBounds(610, 340, 200, 20);
        aalabel.setForeground(Color.RED);
        add(aalabel);

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        try {
            Pattern pattern;

            pattern = Pattern.compile("^[a-zA-Z ]{1,15}$");
            if (e.getSource() == Religion_) {

                if (!pattern.matcher(Religion_.getText()).matches()) {

                    rlabel.setText("*Incorrect");
                    flag = 1;
                } else {
                    rlabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == Nominee_) {
                if (!pattern.matcher(Nominee_.getText()).matches()) {

                    nlabel.setText("*Incorrect");
                    flag = 1;
                } else {
                    nlabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == Aadhar_) {
                pattern = Pattern.compile("^[0-9]{12}$");
                if (!pattern.matcher(Aadhar_.getText()).matches()) {
                    aalabel.setText("*Incorrect");
                    flag = 1;
                } else {
                    aalabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == NomineeAadhar_) {
                pattern = Pattern.compile("^[0-9]{12}$");
                if (!pattern.matcher(NomineeAadhar_.getText()).matches()) {
                    nalabel.setText("*Incorrect");
                    flag = 1;
                } else {
                    nalabel.setText("");
                    flag = 0;
                }
            } else if (e.getSource() == Pan_) {
                pattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
                if (!pattern.matcher(Pan_.getText()).matches()) {
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
        String religion = Religion_.getText();
        String pan = Pan_.getText();
        String adhar = Aadhar_.getText();
        String seniorCitizen = null;
        String category = (String) Category_.getSelectedItem();
        String income = (String) Income_.getSelectedItem();
        String qualification = (String) Education_.getSelectedItem();
        String occupation = (String) Occupation_.getSelectedItem();
        String nominee = Nominee_.getText();
        String nomineeAadhar = NomineeAadhar_.getText();

        if (YesC.isSelected()) {
            seniorCitizen = "Yes";
        } else {
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if (YesE.isSelected()) {
            existingAccount = "Yes";
        } else {
            existingAccount = "No";
        }
        if (flag == 0) {
            try {
                ConnectDb connect = new ConnectDb();
                if (religion.equals("") || pan.equals("") || adhar.equals("") || seniorCitizen == null || existingAccount == null || nominee.equals("") || nomineeAadhar.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill required fields");
                } else {
                    connect.statement.executeUpdate("Insert into Signup2 values('" + religion + "','" + category + "','" + income + "','" + qualification + "','" + occupation + "','" + pan + "','" + adhar + "','" + seniorCitizen + "','" + existingAccount + "','" + Value + "','" + nominee + "','" + nomineeAadhar + "')");
                    new SignUp3(Value).setVisible(true);
                    setVisible(false);
                }
            } catch (Exception exception) {
              
            }
        }
    }
    public static void main(String []args)
    {
    new SignUp2("").setVisible(true);	
    }
}

