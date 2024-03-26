package atmcardsystem;

import java.sql.*;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FastCash extends JFrame implements ActionListener{
    
        JButton dep,fast,pch,cwith,mst,benq,ex, emer;
        JLabel depl,fastl,pchl,cwithl,mstl,benql,emerl;
        String pinnumber;
        FastCash(String pinnumber){
            
            this.pinnumber = pinnumber;
            setLayout(null);

            ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
            Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(img);
            JLabel labimg = new JLabel(bg);
            labimg.setBounds(0,0,700,700);
            add(labimg);
            
            JLabel sel = new JLabel("Select Amount");
            sel.setFont(new Font("TimesRoman",Font.BOLD,24));
            sel.setForeground(Color.WHITE);
            sel.setBounds(120,50,250,200);
            labimg.add(sel);
            
            depl = new JLabel("RS 100");
            depl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            depl.setForeground(Color.WHITE);
            depl.setBounds(80,240,125,25);
            labimg.add(depl);
            
            dep = new JButton();
            dep.setBounds(18,235,50,35);
            dep.addActionListener(this);
            labimg.add(dep);
            
            fastl = new JLabel("RS 200");
            fastl.setBounds(80,278,125,25);
            fastl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            fastl.setForeground(Color.WHITE);
            labimg.add(fastl);
            
            fast = new JButton();
            fast.setBounds(18,273,50,35);
            fast.addActionListener(this);
            labimg.add(fast);
            
            pchl = new JLabel("RS 500");
            pchl.setBounds(80,315,125,25);
            pchl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            pchl.setForeground(Color.WHITE);
            labimg.add(pchl);
            
            pch = new JButton();
            pch.setBounds(18,311,50,35);
            pch.addActionListener(this);
            labimg.add(pch);
            
            emerl = new JLabel("RS 1000");
            emerl.setBounds(80,352,125,25);
            emerl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            emerl.setForeground(Color.WHITE);
            labimg.add(emerl);
            
            emer = new JButton();
            emer.setBounds(18,350,50,35);
            emer.addActionListener(this);
            labimg.add(emer);
            
            cwithl = new JLabel("RS 2000",SwingConstants.RIGHT);
            cwithl.setBounds(260,240,125,25);
            cwithl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            cwithl.setForeground(Color.WHITE);
            labimg.add(cwithl);
            
            cwith = new JButton();
            cwith.setBounds(402,235,50,35);
            cwith.addActionListener(this);
            labimg.add(cwith);
            
            mstl = new JLabel("RS 5000",SwingConstants.RIGHT);
            mstl.setBounds(260,278,125,25);
            mstl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            mstl.setForeground(Color.WHITE);
            labimg.add(mstl);
            
            mst = new JButton();
            mst.setBounds(402,273,50,35);
            mst.addActionListener(this);
            labimg.add(mst);
          
            
            benql = new JLabel("RS 10000",SwingConstants.RIGHT);
            benql.setBounds(260,315,125,25);
            benql.setFont(new Font("TimesRoman", Font.BOLD, 18));
            benql.setForeground(Color.WHITE);
            labimg.add(benql);
            
            benq = new JButton();
            benq.setBounds(402,311,50,35);
            benq.addActionListener(this);
            labimg.add(benq);
            
            JLabel exl = new JLabel("BACK",SwingConstants.RIGHT);
            exl.setBounds(260,352,125,25);
            exl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            exl.setForeground(Color.WHITE);
            labimg.add(exl);
            
            ex = new JButton();
            ex.setBounds(402,350,50,35);
            ex.addActionListener(this);
            labimg.add(ex);

            setUndecorated(true);
            setVisible(true);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(700,700);
            setLocation(400,50);
    
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == ex){
                setVisible(false);
                new Trans(pinnumber).setVisible(true);
            }else{
                String amount = null;
                if(ae.getSource() == dep){
                    amount = depl.getText().substring(3);
                }else if(ae.getSource() == fast){
                    amount = fastl.getText().substring(3);
                }else if(ae.getSource() == pch){
                    amount = pchl.getText().substring(3);
                }else if(ae.getSource() == cwith){
                    amount = cwithl.getText().substring(3);
                }else if(ae.getSource() == emer){
                    amount = emerl.getText().substring(3);
                }else if(ae.getSource() == mst){
                    amount = mstl.getText().substring(3);
                }else if(ae.getSource() == benq){
                    amount = benql.getText().substring(3);
                }
                
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
                    if(balance >= Double.parseDouble(amount)){
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
            }
        }
        public static void main(String args[]){
            
            new FastCash("");
        }
}
