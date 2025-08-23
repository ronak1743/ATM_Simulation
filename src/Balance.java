import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends Frame implements ActionListener {
    private Image img;
    String PinNum,cardnum;
    Label l;
    Button b1;
    public  Balance(String cardnum,String PinNum){
        setVisible(true);
        setLayout(null);
        setSize(900,900);
        setLocation(500,70);
        this.PinNum=PinNum;

        setLayout(null);
        this.cardnum=cardnum;
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
        Con c=new Con();
        String q="select ammount from user where cardnum="+cardnum;
        int x=0;
        try {
            ResultSet rs=c.s.executeQuery(q);
            if(rs.next()){
                x=rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        l=new Label("Your Balance:"+x);
        l.setBounds(160,300,200,40);
        l.setFont(new Font("System",Font.BOLD,16));
        l.setBackground(Color.BLACK);
        l.setForeground(Color.WHITE);
        add(l);


        b1=new Button("Exit");
        b1.setBounds(355,520,150,30);
        add(b1);
        b1.addActionListener(this);

    }


    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            g.drawImage(img, 0, 0, 900, 900, this);
        }
    }

    public static void main(String[] args) {
        new Balance("5040936023664490","7490");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            setVisible(false);
            dispose();
            new Transaction(cardnum,PinNum).setVisible(true);
        }
    }
}
