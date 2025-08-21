
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class SignUpThree extends Frame implements ActionListener {

    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    Checkbox r1, r2, r3, r4;
    Button b1, b2;
    Checkbox c1, c2, c3, c4, c5, c6, c7;
    CheckboxGroup accountTypeGroup;
    int ranNo;

    SignUpThree(int ranNo) {
        this.ranNo = ranNo;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);
        setBackground(Color.WHITE);


        l1 = new Label("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2 = new Label("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        add(l2);

        accountTypeGroup = new CheckboxGroup();
        r1 = new Checkbox("Saving Account", accountTypeGroup, false);
        r2 = new Checkbox("Fixed Deposit Account", accountTypeGroup, false);
        r3 = new Checkbox("Current Account", accountTypeGroup, false);
        r4 = new Checkbox("Recurring Deposit Account", accountTypeGroup, false);

        r1.setBounds(100, 180, 200, 30);
        r2.setBounds(350, 180, 250, 30);
        r3.setBounds(100, 220, 250, 30);
        r4.setBounds(350, 220, 250, 30);

        add(r1);
        add(r2);
        add(r3);
        add(r4);

        l3 = new Label("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 300, 200, 30);
        add(l3);

        l4 = new Label("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330, 300, 250, 30);
        add(l4);

        l5 = new Label("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.PLAIN, 12));
        l5.setBounds(100, 330, 200, 20);
        add(l5);

        l6 = new Label("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.PLAIN, 12));
        l6.setBounds(330, 330, 500, 20);
        add(l6);

        l7 = new Label("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 370, 200, 30);
        add(l7);

        l8 = new Label("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330, 370, 200, 30);
        add(l8);

        l9 = new Label("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.PLAIN, 12));
        l9.setBounds(100, 400, 200, 20);
        add(l9);

        l10 = new Label("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 450, 200, 30);
        c1 = new Checkbox("ATM CARD");
        c2 = new Checkbox("Internet Banking");
        c3 = new Checkbox("Mobile Banking");
        c4 = new Checkbox("EMAIL Alerts");
        c5 = new Checkbox("Cheque Book");
        c6 = new Checkbox("E-Statement");
        c7 = new Checkbox("I hereby declare that the above entered details are correct", true);

        c1.setBounds(100, 500, 200, 30);
        c2.setBounds(350, 500, 200, 30);
        c3.setBounds(100, 550, 200, 30);
        c4.setBounds(350, 550, 200, 30);
        c5.setBounds(100, 600, 200, 30);
        c6.setBounds(350, 600, 200, 30);
        c7.setBounds(100, 680, 600, 30);

        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c6);
        add(c7);

        add(l10);

        l11 = new Label("Form No:");
        l11.setFont(new Font("Raleway", Font.PLAIN, 14));
        l11.setBounds(700, 10, 70, 30);
        add(l11);

        l12 = new Label(ranNo+"");
        l12.setFont(new Font("Raleway", Font.PLAIN, 14));
        l12.setBounds(770, 10, 100, 30);
        add(l12);


        b1 = new Button("Submit");
        b2 = new Button("Cancel");

        b1.setBounds(250, 720, 100, 30);
        b2.setBounds(420, 720, 100, 30);

        add(b1); add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);


        setSize(850, 850);
        setLocation(500, 120);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String atype = "";
        Checkbox selected = accountTypeGroup.getSelectedCheckbox();
        if (selected != null) {
            atype = selected.getLabel();
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (c1.getState()){
            facility += " ATM Card";
        }
        if (c2.getState()){
            facility += " Internet Banking";
        }
        if (c3.getState()){
            facility += " Mobile Banking";
        }
        if (c4.getState()){
            facility += " EMAIL Alerts";
        }
        if (c5.getState()){
            facility += " Cheque Book";
        }
        if (c6.getState()){
            facility += " E-Statement";
        }

        try {
            if (ae.getSource() == b1) {
                if (atype.equals("")) {
                    Dialog d = new Dialog(this, "Error", true);
                    d.setSize(200, 150);
                    d.setLocation(500, 500);
                    d.setLayout(new FlowLayout());

                    d.add(new Label("Enter valid data"));

                    d.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            d.dispose();
                        }
                    });

                    d.setVisible(true);
                } else {
                    Con c1 = new Con();
                    String q1 = "insert into signupthree values('" + ranNo + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
                    String q2 = "insert into login values('" + ranNo + "','" + cardno + "','" + pin + "')";
                    String q3 = "INSERT INTO user VALUES('" + cardno + "','" + pin + "','" + ranNo + "'," + 0 + ")";

                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    Dialog d = new Dialog(this, "Error", true);
                    d.setSize(200, 150);
                    d.setLocation(500, 500);
                    d.setLayout(new FlowLayout());

                    d.add(new Label("Your card number is:+ "+cardno));
                    d.add(new Label("your pin:"+pin));

                    d.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            d.dispose();
                            setVisible(false);
                            new Login().setVisible(true);
                        }
                    });

                    d.setVisible(true);



                }
            } else if (ae.getSource() == b2) {
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpThree(1234);
    }
}
