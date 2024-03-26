package atmcardsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
            
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
        Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(img);
        JLabel labimg = new JLabel(bg);
        labimg.setBounds(0,0,700,700);
        add(labimg);
        
        JLabel accinfo = new JLabel("ACCOUNT BALANCE");
        accinfo.setFont(new Font("TimesRoman",Font.BOLD,20));
        accinfo.setForeground(Color.WHITE);
        accinfo.setBounds(100,150,300,50);
        labimg.add(accinfo);

        
        Conn con = new Conn();
        String bs = null;
        String query = "select * from balancedb where Pin = '"+pinnumber+"';";
        try{
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()){
                bs = rs.getString("Balance");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel bal = new JLabel();
        bal.setFont(new Font("TimesRoman",Font.BOLD,20));
        bal.setForeground(Color.WHITE);
        bal.setBounds(150,200,130,30);
        bal.setOpaque(false);
        bal.setBorder(null);
        labimg.add(bal);
        bal.setText(bs);
        
        JLabel backl = new JLabel("BACK",SwingConstants.RIGHT);
        backl.setBounds(260,352,125,25);
        backl.setFont(new Font("TimesRoman", Font.BOLD, 18));
        backl.setForeground(Color.WHITE);
        labimg.add(backl);

        back = new JButton();
        back.setBounds(402,350,50,35);
        back.addActionListener(this);
        labimg.add(back);
        
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,700);
        setLocation(400,50);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Trans(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
