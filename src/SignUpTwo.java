import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpTwo extends Frame implements ActionListener {

    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    Button b;
    TextField t1, t2;
    Choice c1, c2, c3, c4, c5;
    Checkbox r1, r2, r3, r4;
    CheckboxGroup g1, g2;
    int ranNo;

    SignUpTwo(int ranNo) {
        this.ranNo = ranNo;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        setBackground(Color.WHITE);
        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);


        l1 = new Label("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 30, 600, 40);
        add(l1);
        l2 = new Label("Religion:");
        l2.setBounds(100, 120, 100, 30);
        add(l2);
        c1 = new Choice();
        String rel[]=new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        for (String val : rel) {
            c1.add(val);
        }

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        l3 = new Label("Category:");
        l3.setBounds(100, 170, 100, 30);
        add(l3);


        c2 = new Choice();
        String cat[]= new String[]{"General", "OBC", "SC", "ST", "Other"};
        for (String val :cat) {
            c2.add(val);
        }
        c2.setBounds(350, 170, 320, 30);
        add(c2);





        l4 = new Label("Income:");
        l4.setBounds(100, 220, 100, 30);
        add(l4);

        c3 = new Choice();
        String inc[]= new String[]{"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        for (String val :inc) {
            c3.add(val);
        }
        c3.setBounds(350, 220, 320, 30);
        add(c3);


        l5 = new Label("Educational");
        l5.setBounds(100, 270, 150, 30);
        add(l5);
        l11 = new Label("Qualification:");
        l11.setBounds(100, 290, 150, 30);
        add(l11);

        c4 = new Choice();
        String edu[]=new String[]{"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        for (String val : edu) {
            c4.add(val);
        };
        c4.setBounds(350, 270, 320, 30);
        add(c4);

        l6 = new Label("Occupation:");
        l6.setBounds(100, 340, 150, 30);
        add(l6);

        String oc[]= new String[]{"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        c5 = new Choice();
        for (String val :oc) c5.add(val);
        c5.setBounds(350, 340, 320, 30);
        add(c5);

        l7 = new Label("PAN Number:");
        l7.setBounds(100, 390, 150, 30);
        add(l7);
        t1 = new TextField();
        t1.setBounds(350, 390, 320, 30);
        add(t1);

        l8 = new Label("Aadhar Number:");
        l8.setBounds(100, 440, 180, 30);
        add(l8);

        t2 = new TextField();
        t2.setBounds(350, 440, 320, 30);
        add(t2);

        l9 = new Label("Senior Citizen:");
        l9.setBounds(100, 490, 150, 30);
        add(l9);
        g1 = new CheckboxGroup();
        r1 = new Checkbox("Yes", g1, false);
        r2 = new Checkbox("No", g1, false);
        r1.setBounds(350, 490, 100, 30);
        r2.setBounds(460, 490, 100, 30);
        add(r1);
        add(r2);

        l10 = new Label("Existing Account:");
        l10.setBounds(100, 540, 180, 30);
        add(l10);

        g2 = new CheckboxGroup();
        r3 = new Checkbox("Yes", g2, false);
        r4 = new Checkbox("No", g2, false);
        r3.setBounds(350, 540, 100, 30);
        r4.setBounds(460, 540, 100, 30);
        add(r3);
        add(r4);


        l12 = new Label("Form No:");
        l12.setBounds(700, 10, 60, 30);
        add(l12);

        l13 = new Label(ranNo+"");
        l13.setBounds(760, 10, 60, 30);
        add(l13);


        b = new Button("Next");
        b.setBounds(570, 640, 100, 30);
        b.addActionListener(this);
        add(b);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = c1.getSelectedItem();
        String category = c2.getSelectedItem();
        String income = c3.getSelectedItem();
        String education = c4.getSelectedItem();
        String occupation = c5.getSelectedItem();
        String pan = t1.getText();
        String aadhar = t2.getText();
        String scitizen = (g1.getSelectedCheckbox() != null) ? g1.getSelectedCheckbox().getLabel() : "";
        String eaccount = (g2.getSelectedCheckbox() != null) ? g2.getSelectedCheckbox().getLabel() : "";

        try {
            if (aadhar.equals("")) {
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
                Con cn = new Con();
                String q1 = "insert into signuptwo values('" + ranNo + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "')";
                cn.s.executeUpdate(q1);
                setVisible(false);
                new SignUpThree(ranNo).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new SignUpTwo("1234");
    }
}
