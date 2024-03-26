package atmcardsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Withdrawl extends JFrame implements ActionListener{
    
    String pinnumber;
    JTextField amountfield;
    JButton withdrawl, back;
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
        Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(img);
        JLabel labimg = new JLabel(bg);
        labimg.setBounds(0,0,700,700);
        add(labimg);

        JLabel amt = new JLabel("Enter Amount to Withdraw");
        amt.setFont(new Font("TimesRoman",Font.BOLD,20));
        amt.setForeground(Color.WHITE);
        amt.setBounds(90,150,300,50);
        labimg.add(amt);
        
        amountfield = new JTextField();
        amountfield.setFont(new Font("TimesRoman",Font.BOLD,20));
        amountfield.setForeground(Color.WHITE);
        amountfield.setBounds(150,200,130,30);
        amountfield.setOpaque(false);
        amountfield.setBorder(null);
        labimg.add(amountfield);
        
        JLabel withl = new JLabel("Withdraw",SwingConstants.RIGHT);
        withl.setBounds(260,315,125,25);
        withl.setFont(new Font("TimesRoman", Font.BOLD, 18));
        withl.setForeground(Color.WHITE);
        labimg.add(withl);

        withdrawl = new JButton();
        withdrawl.setBounds(402,311,50,35);
        withdrawl.addActionListener(this);
        labimg.add(withdrawl);

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
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == withdrawl){
                String amount = amountfield.getText();
                try{
                    Double amountd = Double.parseDouble(amount);
                    amountd = amountd/amountd;
                    Conn con = new Conn();
                    double balance = 0;
                    String bs = null;
                    String query = "select * from balancedb where Pin = '"+pinnumber+"';";
                    try{
                        ResultSet rs = con.s.executeQuery(query);
                        while (rs.next()){
                            bs = rs.getString("Balance");
                        }
                        balance = Double.parseDouble(bs);
                        if(balance >= amountd){
                            Date date = new Date();
                            String query2 = "insert into transaction values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"');";
                            con.s.executeUpdate(query2);
                            String query3 = "update balancedb set Balance = Balance-"+amount+" where Pin = '"+pinnumber+"';";
                            con.s.executeUpdate(query3);
                            JOptionPane.showMessageDialog(this, "RS "+amount+" Debited Successfully");
                            setVisible(false);
                            new Trans(pinnumber).setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(this, "Insufficient Balance");
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Enter Valid Amount");
                }
                
            }else if(ae.getSource() == back){
                setVisible(false);
                new Trans(pinnumber).setVisible(true);
            }
        }
    
    public static void main(String args[]){
        
        new Withdrawl("");
    }
}
