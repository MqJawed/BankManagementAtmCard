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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PinChange extends JFrame implements ActionListener{
    
        String pinnumber;
        JTextField pinchangefield,repinchangefield;
        JButton change, back;
        String newpinnumber;
        
        PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
            
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/atmscreen.jpg"));
        Image img = ic.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(img);
        JLabel labimg = new JLabel(bg);
        labimg.setBounds(0,0,700,700);
        add(labimg);
        
        JLabel pinchl = new JLabel("Enter New pin");
        pinchl.setFont(new Font("TimesRoman",Font.BOLD,18));
        pinchl.setForeground(Color.WHITE);
        pinchl.setBounds(80,150,200,30);
        labimg.add(pinchl);
        
        pinchangefield = new JTextField();
        pinchangefield.setFont(new Font("TimesRoman",Font.BOLD,20));
        pinchangefield.setForeground(Color.WHITE);
        pinchangefield.setBounds(300,150,100,30);
        pinchangefield.setOpaque(false);
        pinchangefield.setBorder(null);
        labimg.add(pinchangefield);
        
        JLabel newpchl = new JLabel("ReEnter New pin");
        newpchl.setFont(new Font("TimesRoman",Font.BOLD,18));
        newpchl.setForeground(Color.WHITE);
        newpchl.setBounds(80,200,200,30);
        labimg.add(newpchl);
        
        repinchangefield = new JTextField();
        repinchangefield.setFont(new Font("TimesRoman",Font.BOLD,20));
        repinchangefield.setForeground(Color.WHITE);
        repinchangefield.setBounds(300,200,100,30);
        repinchangefield.setOpaque(false);
        repinchangefield.setBorder(null);
        labimg.add(repinchangefield);
        
        JLabel withl = new JLabel("Change",SwingConstants.RIGHT);
        withl.setBounds(260,315,125,25);
        withl.setFont(new Font("TimesRoman", Font.BOLD, 18));
        withl.setForeground(Color.WHITE);
        labimg.add(withl);

        change = new JButton();
        change.setBounds(402,311,50,35);
        change.addActionListener(this);
        labimg.add(change);

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
        if(ae.getSource() == back){
            setVisible(false);
            new Trans(pinnumber).setVisible(true);
        }else{
            if(pinchangefield.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(this, "Enter New Pin");
                
            }else if(repinchangefield.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(this, "ReEnter New Pin");
                
            }else if(!(pinchangefield.getText().equals(repinchangefield.getText()))){
                                
                JOptionPane.showMessageDialog(this, "ReEnter Correct Pin");

            }else{
                newpinnumber = repinchangefield.getText();
                Conn con = new Conn();
                String query1 = "update logindb set Pin = '"+newpinnumber+"' where Pin = '"+pinnumber+"';";
                String query2 = "update bankdb3 set Pin = '"+newpinnumber+"' where Pin = '"+pinnumber+"';";
                String query3 = "update transaction set Pin = '"+newpinnumber+"' where Pin = '"+pinnumber+"';";
                String query4 = "update balancedb set Pin = '"+newpinnumber+"' where Pin = '"+pinnumber+"';";

                try{
                    con.s.executeUpdate(query1);
                    con.s.executeUpdate(query2);
                    con.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(this,"Pin Changed Successfully");
                    setVisible(false);
                    new Trans(newpinnumber).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
                }
            }    
        }
    }
    public static void main(String args[]){
        
        new PinChange("");
    }
    
}
