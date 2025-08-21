import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.*;


class GenrateRandom {
    private GenrateRandom() {
    }



    public static int getRandom(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }
}

public class SignUpOne extends Frame implements ActionListener {

    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    TextField t1, t2, t3, t4, t5, t6, t7, tDob;
    Checkbox male, female, married, unmarried, Other;
    Button b;
    int ranNo;

   
    public SignUpOne() {
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setLayout(null);
        setBackground(Color.white);
        setSize(850, 750);
        setLocation(300, 100);
//        setVisible(true);

        ranNo=GenrateRandom.getRandom(8999)+1000;
        
        l1 = new Label("APPLICATION FORM NO. " + ranNo);
        l1.setFont(new Font("Raleway", Font.BOLD, 28));
        
        l1.setBounds(140, 50, 600, 40);
        add(l1);

        l2 = new Label("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l2.setBounds(200, 100, 600, 30);
        add(l2);

       
        l3 = new Label("Name:");
        l3.setBounds(100, 150, 200, 30);
        add(l3);

        t1 = new TextField();
        t1.setBounds(300, 150, 400, 30);
        add(t1);

        l4 = new Label("Father's Name:");
        l4.setBounds(100, 200, 200, 30);
        add(l4);

        t2 = new TextField();
        t2.setBounds(300, 200, 400, 30);
        add(t2);

        l5 = new Label("Date of Birth (dd/mm/yyyy):");
        l5.setBounds(100, 250, 200, 30);
        add(l5);

        tDob = new TextField();
        tDob.setBounds(300, 250, 400, 30);
        add(tDob);

        l6 = new Label("Gender:");
        l6.setBounds(100, 300, 200, 30);
        add(l6);

        CheckboxGroup genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, false);
        male.setBounds(300, 300, 80, 30);
        add(male);

        female = new Checkbox("Female", genderGroup, false);
        female.setBounds(400, 300, 100, 30);
        add(female);

        l7 = new Label("Email Address:");
        l7.setBounds(100, 350, 200, 30);
        add(l7);

        t3 = new TextField();
        t3.setBounds(300, 350, 400, 30);
        add(t3);

        l8 = new Label("Marital Status:");
        l8.setBounds(100, 400, 200, 30);
        add(l8);

        CheckboxGroup maritalGroup = new CheckboxGroup();
        married = new Checkbox("Married", maritalGroup, false);
        married.setBounds(300, 400, 100, 30);
        add(married);

        unmarried = new Checkbox("Unmarried", maritalGroup, false);
        unmarried.setBounds(420, 400, 100, 30);
        add(unmarried);

        Other = new Checkbox("Other", maritalGroup, false);
        Other.setBounds(540, 400, 100, 30);
        add(Other);

        l9 = new Label("Address:");
        l9.setBounds(100, 450, 200, 30);
        add(l9);

        t4 = new TextField();
        t4.setBounds(300, 450, 400, 30);
        add(t4);

        l10 = new Label("City:");
        l10.setBounds(100, 500, 200, 30);
        add(l10);

        t5 = new TextField();
        t5.setBounds(300, 500, 400, 30);
        add(t5);

        l11 = new Label("Pin Code:");
        l11.setBounds(100, 550, 200, 30);
        add(l11);

        t6 = new TextField();
        t6.setBounds(300, 550, 400, 30);
        add(t6);

        l12 = new Label("State:");
        l12.setBounds(100, 600, 200, 30);
        add(l12);

        t7 = new TextField();
        t7.setBounds(300, 600, 400, 30);
        add(t7);

       
        b = new Button("Next");
        b.setBounds(620, 660, 80, 30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        add(b);

        b.addActionListener(this);

        
        

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String fname = t2.getText();
        String dob = tDob.getText();
        
        String gender = "Male";
        if(male.getState()){
           gender="Male";
        }
        else if(female.getState()){
            gender="Female";
        }
        String email = t3.getText();
        String marital =null;
        if(married.getState()){
            marital="Married";
        }else if(unmarried.getState()){
            marital="Unmarried";
        }else if(Other.getState()){
            marital= "Other" ;
        }

        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();

       
//        System.out.println("Form No: " + ranNo);
//        System.out.println("Name: " + name);
//        System.out.println("Father: " + fname);
//        System.out.println("DOB: " + dob);
//        System.out.println("Gender: " + gender);
//        System.out.println("Email: " + email);
//        System.out.println("Marital: " + marital);
//        System.out.println("Address: " + address);
//        System.out.println("City: " + city);
//        System.out.println("Pincode: " + pincode);
//        System.out.println("State: " + state);

        if(name.equals("")){
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
        }
        else{

            Con cn=new Con();
            String q="insert into signup values('"+ranNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            try {
                cn.s.executeUpdate(q);
                setVisible(false);
                new SignUpTwo(ranNo).setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
