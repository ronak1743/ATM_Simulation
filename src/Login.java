import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.*;

public class Login extends Frame implements ActionListener{

    Label l1, l2, l3;
    TextField tf1, tf2;
    Button b1, b2, b3;
    private Image logo;

    public Login(){
        super("AUTOMATED TELLER MACHINE");
        setLayout(null);
        setBackground(Color.WHITE);
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);

        try {
            logo = Toolkit.getDefaultToolkit().getImage(
                    getClass().getResource("/icons/img.png")
            );
        } catch (Exception ignored) {}

        l1 = new Label("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 36));
        l1.setBounds(220,60,450,40);
        add(l1);

        l2 = new Label("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 24));
        l2.setBounds(125,150,150,30);
        add(l2);

        tf1 = new TextField(15);
        tf1.setFont(new Font("Arial", Font.BOLD, 16));
        tf1.setBounds(300,150,230,30);
        add(tf1);

        l3 = new Label("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 24));
        l3.setBounds(125,220,150,30);
        add(l3);

        tf2 = new TextField(15);
        tf2.setEchoChar('*');
        tf2.setFont(new Font("Arial", Font.BOLD, 16));
        tf2.setBounds(300,220,230,30);
        add(tf2);

        b1 = new Button("SIGN IN");
        b1.setBounds(300,300,100,30);
        add(b1);

        b2 = new Button("CLEAR");
        b2.setBounds(430,300,100,30);
        add(b2);

        b3 = new Button("SIGN UP");
        b3.setBounds(300,350,230,30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose(); System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (logo != null) {
            g.drawImage(logo, 130, 40, 80, 80, this);
        }
    }

    public void actionPerformed(ActionEvent ae){
        Object src = ae.getSource();
        try{
            if(src==b1){

            }else if(src==b2){
                tf1.setText("");
                tf2.setText("");
            }else if(src==b3){
                setVisible(false);
                SignUpOne s=new SignUpOne();
                s.setVisible(true);
                if(!s.isDisplayable()){
                    setVisible(true);
                }

            }
        }catch(Exception e){

        }
    }

    public static void main(String[] args){
        new Login();
    }


}
