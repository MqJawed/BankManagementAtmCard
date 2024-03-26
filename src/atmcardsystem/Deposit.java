package atmcardsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Deposit extends JFrame implements ActionListener{
    
    String pinnumber;
    JTextField amountfield;
    JButton deposit, back;
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
        Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(img);
        JLabel labimg = new JLabel(bg);
        labimg.setBounds(0,0,700,700);
        add(labimg);

        JLabel amt = new JLabel("Enter Amount to Deposit");
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
        
        JLabel depol = new JLabel("Deposit",SwingConstants.RIGHT);
        depol.setBounds(260,315,125,25);
        depol.setFont(new Font("TimesRoman", Font.BOLD, 18));
        depol.setForeground(Color.WHITE);
        labimg.add(depol);

        deposit = new JButton();
        deposit.setBounds(402,311,50,35);
        deposit.addActionListener(this);
        labimg.add(deposit);

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
        setTitle("Deposit");
        setLocation(400,50);
        
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == deposit){
                String amount = amountfield.getText();
                try{
                    double amountd = Double.parseDouble(amount);
                    amountd = amountd/amountd;
                    
                    Date date = new Date();
                    Conn con = new Conn();
                    String query = "insert into transaction values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amount+"');";
                    String query2 = "update balancedb set Balance = Balance+"+amount+" where Pin = '"+pinnumber+"';";
                    try{
                        con.s.executeUpdate(query);
                        con.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(this, "Rs "+amount+" Deposited Successfully");
                        setVisible(false);
                        new Trans(pinnumber).setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Enter Valid Amount");
                }
                
            }else if(ae.getSource() == back){
                setVisible(false);
                new Trans(pinnumber).setVisible(true);
            }
        }
    
    public static void main(String args[]){
        
        new Deposit("");
    }
}
