import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends Frame implements ActionListener{
    private Image img;
    Label l1;

    Button b1,b2,b3,b4,b5,b6,b7;
    String PinNum;


    public FastCash(String PinNum){
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

        l1=new Label("Select Withdraw Ammount:");
        l1.setBounds(220,300,250,40);
        l1.setBackground(Color.black);
        l1.setForeground(Color.white);
        l1.setFont(new Font("System",Font.BOLD,16));
        add(l1);

        b1=new Button("Rs 100");
        b1.setBounds(170,415,150,30);
        add(b1);

        b2=new Button("Rs 500");
        b2.setBounds(355,415,150,30);
        add(b2);

        b3=new Button("Rs 1000");
        b3.setBounds(170,450,150,30);
        add(b3);

        b4=new Button("Rs 2000");
        b4.setBounds(355,450,150,30);
        add(b4);

        b5=new Button("Rs 5000");
        b5.setBounds(170,485,150,30);
        add(b5);

        b6=new Button("Rs 10000");
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
        new FastCash("1234");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){
            setVisible(false);
            new Transaction(PinNum).setVisible(true);
        }
        else{
            Button b=(Button) e.getSource();
            String am=b.getLabel().toString().substring(3);
            try {
                Con con=new Con();
                ResultSet rs=con.s.executeQuery("select * from bank where pin ='"+PinNum+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(am)){
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

                    String query="insert into bank values('"+PinNum+"','"+new Date().toString()+"','Withdraw','"+am+"')";
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
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
