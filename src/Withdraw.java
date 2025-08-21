import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends Frame implements ActionListener {

    Label l1,l2;
    TextField t1;
    private Image img;
    Button b1,b2;
    String PinNum;
    public Withdraw(String PinNum){
//        setVisible(true);
        setLayout(null);
        setSize(900,900);
        setLocation(500,70);
        this.PinNum=PinNum;

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

        l1=new Label("Enter the Amount you want to Withdraw");
        l1.setBounds(170,300,400,20);
        l1.setForeground(Color.white);
        l1.setBackground(Color.black);
        l1.setFont(new Font("System",Font.BOLD,16));
        add(l1);

        t1=new TextField();
        t1.setFont(new Font("System",Font.BOLD,16));
        t1.setBounds(170,350,320,25);
        add(t1);

        b1=new Button("Withdrawe");
        b1.setBounds(355,485,150,30);
        add(b1);

        b2=new Button("Exit");
        b2.setBounds(355,520,150,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public static void main(String[] args) {
        new Withdraw("1234");
    }


    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            g.drawImage(img, 0, 0, 900, 900, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String am=t1.getText().toString();
            Date date=new Date();
            date.toString();
            if(am.equals("")){
                Dialog d = new Dialog(this, "Error", true);
                d.setSize(200, 150);
                d.setLocation(700, 500);
                d.setLayout(new FlowLayout());

                d.add(new Label("Enter valid Amount"));

                d.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        d.dispose();
                    }
                });

                d.setVisible(true);
            }
            else{
                try {
                    Con con=new Con();
                    String query="insert into bank values('"+PinNum+"','"+date.toString()+"','Withdraw','"+am+"')";
                    con.s.executeUpdate(query);
                    Dialog d = new Dialog(this, "Success", true);
                    d.setSize(200, 150);
                    d.setLocation(700, 500);
                    d.setLayout(new FlowLayout());

                    d.add(new Label("Ammount:"+am+" Withdraw succesfully"));

                    d.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            d.dispose();
                        }
                    });

                    d.setVisible(true);
                    setVisible(false);
                    new Transaction(PinNum).setVisible(true);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        } else if (e.getSource()==b2) {
            this.dispose();
            new Transaction(PinNum).setVisible(true);


        }
    }
}
