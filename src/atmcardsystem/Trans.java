package atmcardsystem;

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

public class Trans extends JFrame implements ActionListener{
    
        JButton dep,fast,pch,cwith,mst,benq,ex, emer;
        String pinnumber;
        Trans(String pinnumber){
            
            this.pinnumber = pinnumber;
            setLayout(null);

            ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
            Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
            ImageIcon bg = new ImageIcon(img);
            JLabel labimg = new JLabel(bg);
            labimg.setBounds(0,0,700,700);
            add(labimg);
            
            JLabel sel = new JLabel("Select Transction");
            sel.setFont(new Font("TimesRoman",Font.BOLD,24));
            sel.setForeground(Color.WHITE);
            sel.setBounds(120,50,250,200);
            labimg.add(sel);
            
            JLabel depl = new JLabel("Deposit");
            depl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            depl.setForeground(Color.WHITE);
            depl.setBounds(80,240,125,25);
            labimg.add(depl);
            
            dep = new JButton();
            dep.setBounds(18,235,50,35);
            dep.addActionListener(this);
            labimg.add(dep);
            
            JLabel fastl = new JLabel("Fast Cash");
            fastl.setBounds(80,278,125,25);
            fastl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            fastl.setForeground(Color.WHITE);
            labimg.add(fastl);
            
            fast = new JButton();
            fast.setBounds(18,273,50,35);
            fast.addActionListener(this);
            labimg.add(fast);
            
            JLabel pchl = new JLabel("Change Pin");
            pchl.setBounds(80,315,125,25);
            pchl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            pchl.setForeground(Color.WHITE);
            labimg.add(pchl);
            
            pch = new JButton();
            pch.setBounds(18,311,50,35);
            pch.addActionListener(this);
            labimg.add(pch);
            
            JLabel emerl = new JLabel("Emergency");
            emerl.setBounds(80,352,125,25);
            emerl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            emerl.setForeground(Color.WHITE);
            labimg.add(emerl);
            
            emer = new JButton();
            emer.setBounds(18,350,50,35);
            emer.addActionListener(this);
            labimg.add(emer);
            
            JLabel cwithl = new JLabel("Withdrawl",SwingConstants.RIGHT);
            cwithl.setBounds(260,240,125,25);
            cwithl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            cwithl.setForeground(Color.WHITE);
            labimg.add(cwithl);
            
            cwith = new JButton();
            cwith.setBounds(402,235,50,35);
            cwith.addActionListener(this);
            labimg.add(cwith);
            
            JLabel mstl = new JLabel("Statement",SwingConstants.RIGHT);
            mstl.setBounds(260,278,125,25);
            mstl.setFont(new Font("TimesRoman", Font.BOLD, 18));
            mstl.setForeground(Color.WHITE);
            labimg.add(mstl);
            
            mst = new JButton();
            mst.setBounds(402,273,50,35);
            mst.addActionListener(this);
            labimg.add(mst);
          
            
            JLabel benql = new JLabel("Balance",SwingConstants.RIGHT);
            benql.setBounds(260,315,125,25);
            benql.setFont(new Font("TimesRoman", Font.BOLD, 18));
            benql.setForeground(Color.WHITE);
            labimg.add(benql);
            
            benq = new JButton();
            benq.setBounds(402,311,50,35);
            benq.addActionListener(this);
            labimg.add(benq);
            
            JLabel exl = new JLabel("EXIT",SwingConstants.RIGHT);
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
            setTitle("TransactionPage");
            setLocation(400,50);
    
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == ex){
                System.exit(0);
            }else if(ae.getSource() == emer){
                setVisible(false);
                JOptionPane.showMessageDialog(this, "Emergency!");
            }else if(ae.getSource() == dep){
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }else if(ae.getSource() == cwith){
                setVisible(false);
                new Withdrawl(pinnumber).setVisible(true);
            }else if(ae.getSource() == fast){
                setVisible(false);
                new FastCash(pinnumber).setVisible(true);
            }else if(ae.getSource() == pch){
                setVisible(false);
                new PinChange(pinnumber).setVisible(true);
            }else if(ae.getSource() == benq){
                setVisible(false);
                new BalanceEnquiry(pinnumber).setVisible(true);
            }else if(ae.getSource() == mst){
                //setVisible(false);
                new MiniStatement(pinnumber).setVisible(true);
            }
        }
        public static void main(String args[]){
            
            new Trans("");
        }
}
