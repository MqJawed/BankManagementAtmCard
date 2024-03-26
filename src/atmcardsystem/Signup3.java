package atmcardsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton t1, t2, t3, t4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit,cancel;
    long random;
    int pinrandom; 
    String fno3;
    Signup3(String formnumber){
  
        this.fno3 = formnumber;
        random = ThreadLocalRandom.current().nextLong(1000000000L,10000000000L);
        pinrandom = ThreadLocalRandom.current().nextInt(1000,10000);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("resources/signupbg.jpg"));
        Image image = img.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon newimg = new ImageIcon(image);
        JLabel limg = new JLabel(newimg);
        limg.setBounds(0,0,600,700);
        add(limg);
        
        JLabel pag = new JLabel("Page 3: Account Details");
        pag.setFont(new Font("Raleway", Font.BOLD, 24));
        pag.setBounds(130,30,350,30);
        limg.add(pag);
        
        JLabel acc = new JLabel("Account Type");
        acc.setFont(new Font("Raleway", Font.BOLD, 20));
        acc.setBounds(70,115,200,25);
        limg.add(acc);
        
        t1 = new JRadioButton("Savings");
        t1.setFont(new Font("Calibri",Font.BOLD,16));
        t1.setBackground(Color.WHITE);
        t1.setBounds(70,150,100,25);
        limg.add(t1);
        
        t2 = new JRadioButton("Current");
        t2.setFont(new Font("Caibri", Font.BOLD, 16));
        t2.setBackground(Color.WHITE);
        t2.setBounds(70,190,100,25);
        limg.add(t2);
        
        t3 = new JRadioButton("Fixed Deposit");
        t3.setFont(new Font("Caibri", Font.BOLD, 16));
        t3.setBackground(Color.WHITE);
        t3.setBounds(210,150,190,25);
        limg.add(t3);
        
        t4 = new JRadioButton("Recurring Deposit");
        t4.setFont(new Font("Caibri", Font.BOLD, 16));
        t4.setBackground(Color.WHITE);
        t4.setBounds(210,190,190,25);
        limg.add(t4);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(t1);
        bg.add(t2);
        bg.add(t3);
        bg.add(t4);
        
        JLabel cno = new JLabel("Card No");
        cno.setFont(new Font("Raleway", Font.BOLD, 20));
        cno.setBounds(70,265,150,25);
        limg.add(cno);
        
        JLabel det = new JLabel("16 Digit No");
        det.setFont(new Font("Raleway", Font.BOLD, 16));
        det.setBounds(70,290,250,25);
        limg.add(det);
        
        JLabel card = new JLabel("XXXX-XXXX-XXXX-0786");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(210,278,350,25);
        limg.add(card);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(70,340,50,25);
        limg.add(pin);
        
        JLabel pdet = new JLabel("4 Digit Pin");
        pdet.setFont(new Font("Raleway", Font.BOLD, 16));
        pdet.setBounds(70,365,200,25);
        limg.add(pdet);
        
        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        pinno.setBounds(210,350,100,25);
        limg.add(pinno);
        
        JLabel ser = new JLabel("Service Requied");
        ser.setFont(new Font("Raleway", Font.BOLD, 20));
        ser.setBounds(70,420,200,25);
        limg.add(ser);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Calibri",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(70,460,120,25);
        limg.add(c1);
        
        c2 = new JCheckBox("InterNet Banking");
        c2.setFont(new Font("Calibri",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(210,460,180,25);
        limg.add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Calibri",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(410,460,180,25);
        limg.add(c3);
        
        c4 = new JCheckBox("Alert SMS");
        c4.setFont(new Font("Calibri",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(70,500,120,25);
        limg.add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Calibri",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(210,500,180,25);
        limg.add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Calibri",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(410,500,180,25);
        limg.add(c6);
        
        c7 = new JCheckBox();
        c7.setBackground(Color.WHITE);
        c7.setBounds(70,570,20,20);
        c7.addActionListener(this);
        limg.add(c7);
        
        JLabel dec = new JLabel("I do hereby declare that all the information are correct");
        dec.setFont(new Font("Seriff", Font.BOLD, 16));
        dec.setBounds(95,570,500,20);
        limg.add(dec);
        
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.CYAN);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Calibri", Font.BOLD, 20));
        cancel.setBounds(165, 600, 125, 30);
        cancel.addActionListener(this);
        limg.add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Calibri", Font.BOLD, 20));
        submit.setBounds(360, 600, 125, 30);
        submit.addActionListener(this);
        //submit.setEnabled(false);
        limg.add(submit);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,700);
        setTitle("SIGNUP");
        setLocation(450,20);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == cancel){
            int result = JOptionPane.showConfirmDialog(this, "Are You Sure You want to cancel?");
            if(result == JOptionPane.YES_OPTION){
                setVisible(false);
                new Login();
            }
        }else if(ae.getSource() == submit){
            String type = null;
            if(t1.isSelected())
                type = "Savings";
            else if(t2.isSelected())
                type = "Current";
            else if(t3.isSelected())
                type = "Fixed Deposit";
            else if(t4.isSelected())
                type = "Recurring Deposit";
            
            long cardno = 7873960000000000L+random;
            String scardno = "" + cardno;
            //System.out.println(cardno);
            
            String spin = "" +pinrandom;
            
           String fac = "";
           if(c1.isSelected())
               fac += " ATM Card";
           if(c2.isSelected())
               fac += " InterNet Banking";
           if(c3.isSelected())
               fac += " Mobile Banking";
           if(c4.isSelected())
               fac += " Alert SMS";
           if(c5.isSelected())
               fac += " Cheque Book";
           if(c6.isSelected())
               fac += " E-Statement";
           //System.out.print(fac);
           
           try{
               Conn con = new Conn();
               String query = "insert into bankdb3 values('"+type+"' ,'"+fno3+"', '"+scardno+"', '"+spin+"', '"+fac+"');";
               String query2 = "insert into logindb values('"+fno3+"', '"+scardno+"', '"+spin+"');";
               String query3 = "insert into balancedb values('"+scardno+"', '"+spin+"', 0);";
               
               con.s.executeUpdate(query);
               con.s.executeUpdate(query2);
               con.s.executeUpdate(query3);
               
               JOptionPane.showMessageDialog(this, "Card Number: "+scardno+"\nPin: "+spin);
               setVisible(false);
               new Login().setVisible(true);
           }
           catch(Exception e){
               System.out.println(e);
           }
            
        }
        
    }
    
    public static void main(String args[])
    {
        new Signup3("");
    }
}
