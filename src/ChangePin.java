import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ChangePin extends Frame implements ActionListener {
    String cardnum,Pinnum;
    private Image img;
    Label l1,l2,l3;
    TextField tf1,tf2;

    Button b1,b2;
    public ChangePin(String cardnum,String Pinnum){

        this.cardnum=cardnum;
        this.Pinnum=Pinnum;
        setVisible(true);
        setSize(900,900);
        setLocation(500,70);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
                System.exit(0);
            }
        });
        try {
            img= Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/atm.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        l1=new Label("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 17));
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);
        l1.setBounds(260,290,170,35);
        add(l1);

        l2=new Label("Enter New Pin:");
        l2.setFont(new Font("system",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.BLACK);
        l2.setBounds(160,340,120,35);
        add(l2);

        l3=new Label("Re-Enter new Pin:");
        l3.setFont(new Font("system",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        l3.setBackground(Color.BLACK);
        l3.setBounds(160,380,150,35);
        add(l3);

        tf1=new TextField();
        tf1.setEchoChar('*');
        tf1.setFont(new Font("system",Font.BOLD,24));
        tf1.setBounds(320,345,190,26);
        add(tf1);
        tf2=new TextField();
        tf2.setEchoChar('*');
        tf2.setFont(new Font("system",Font.BOLD,24));
        tf2.setBounds(320,385,190,26);
        add(tf2);

        b1=new Button("Change");
        b2=new Button("Cancle");

        b1.setBounds(355,485,160,30);
        add(b1);

        b2.setBounds(355,520,160,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);


    }

    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            g.drawImage(img, 0, 0, 900, 900, this);
        }
    }

    public static void main(String[] args) {
        new ChangePin("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            Dialog d=new Dialog(this,"Notification",false);
            d.setLayout(new FlowLayout());
            d.setSize(400,100);
            d.setLocation(800,500);
            String s1=tf1.getText().toString();
            String s2=tf2.getText().toString();
            if(!s1.equals("") && s1.equals(s2) && s1.length()==4){
                Con con=new Con();
                String query="update user set pin='"+s2+"'"+"where cardnum='"+cardnum+"'";
                try {
                    con.s.executeUpdate(query);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                tf1.setText("");
                tf2.setText("");
                d.add(new Label("Your pin is changed"));

                d.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        d.dispose();
                        dispose();
                        new Transaction(cardnum,s2).setVisible(true);
                    }
                });
            }
            else{
                d.add(new Label("Enter Valid 4 digit pin"));
                d.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        d.dispose();
                    }
                });
            }
            d.setVisible(true);
        }
        else{
            dispose();
            new Transaction(cardnum,Pinnum).setVisible(true);
        }
    }
}
