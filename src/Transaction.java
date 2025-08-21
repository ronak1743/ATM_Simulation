import java.awt.*;
import java.awt.event.*;

public class Transaction extends Frame implements ActionListener{
    private Image img;
    Label l1;

    Button b1,b2,b3,b4,b5,b6,b7;
    String PinNum;


    public Transaction(String PinNum){
        setVisible(true);
        setSize(900,900);
        setLocation(500,70);
        setLayout(null);
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

        l1=new Label("Please selcet your Transaction");
        l1.setBounds(220,300,250,40);
        l1.setBackground(Color.black);
        l1.setForeground(Color.white);
        l1.setFont(new Font("System",Font.BOLD,16));
        add(l1);

        b1=new Button("Deposit");
        b1.setBounds(170,415,150,30);
        add(b1);

        b2=new Button("Cash Withdrawal");
        b2.setBounds(355,415,150,30);
        add(b2);

        b3=new Button("Fast Cash");
        b3.setBounds(170,450,150,30);
        add(b3);

        b4=new Button("Mini Statment");
        b4.setBounds(355,450,150,30);
        add(b4);

        b5=new Button("change pin");
        b5.setBounds(170,485,150,30);
        add(b5);

        b6=new Button("Balance Enquiry");
        b6.setBounds(355,485,150,30);
        add(b6);

        b7=new Button("Exit");
        b7.setBounds(355,520,150,30);
        add(b7);

        b7.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);


        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Ok");
            }
        });



    }

    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            g.drawImage(img, 0, 0, 900, 900, this);
        }
    }
    public static void main(String[] args) {
        new Transaction("1234");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(e.getSource()==b1){
            setVisible(false);
            new Deposit(PinNum).setVisible(true);
        }
        else if(e.getSource()==b2){
            setVisible(false);
            new Withdraw(PinNum).setVisible(true);
        }
        else if(e.getSource()==b3){
            setVisible(false);
            new FastCash(PinNum).setVisible(true);
        }
    }
}
