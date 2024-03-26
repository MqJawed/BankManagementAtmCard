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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    
    JTextField cardnofield;
    JPasswordField passfield;
    JButton signin, signup, clear, exit;

    Login(){
        
        setLayout(null);
        
        ImageIcon tempimg = new ImageIcon(ClassLoader.getSystemResource("resources/Loginpage.jpg"));
        Image image = tempimg.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(image);
        JLabel limg = new JLabel(img);
        limg.setBounds(0,0,800,500);
        add(limg); 
       
        JLabel head = new JLabel("WELCOME TO QJ BANK");
        head.setFont(new Font("Serif", Font.BOLD, 38));
        head.setBounds(160,40,600,50);
        limg.add(head);
        
        ImageIcon tempimg2 = new ImageIcon(ClassLoader.getSystemResource("resources/banklogo.jpg"));
        Image image2 = tempimg2.getImage().getScaledInstance(150,100, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(image2);
        JLabel bimg = new JLabel(img2);
        bimg.setBounds(100,40,50,50);
        limg.add(bimg); 
        
        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Serif", Font.BOLD, 30));
        cardno.setBounds(100, 200, 200, 50);
        limg.add(cardno);
        
        cardnofield = new JTextField();
        cardnofield.setFont(new Font("Serif",Font.PLAIN, 20));
        cardnofield.setBounds(350, 210, 270, 30);
        limg.add(cardnofield);
        
        JLabel pass = new JLabel("PassWord");
        pass.setFont(new Font("Serif", Font.BOLD, 30));
        pass.setBounds(100, 270, 200, 50);
        limg.add(pass);
        
        passfield = new JPasswordField();
        passfield.setFont(new Font("Calibri",Font.PLAIN, 20));
        passfield.setBounds(350, 280, 270, 30);
        limg.add(passfield);
        
        signin = new JButton("Sign In");
        signin.setBackground(Color.GRAY);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Calibri", Font.BOLD, 20));
        signin.setBounds(350, 335, 150, 30);
        signin.addActionListener(this);
        limg.add(signin);
        
        clear = new JButton("Clear");
        clear.setBackground(Color.GRAY);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Calibri", Font.BOLD, 20));
        clear.setBounds(520, 335, 100, 30);
        clear.addActionListener(this);
        limg.add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBackground(Color.GRAY);
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Calibri", Font.BOLD, 20));
        signup.setBounds(350, 385, 150, 30);
        signup.addActionListener(this);
        limg.add(signup);
        
        exit = new JButton("Exit");
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Calibri", Font.BOLD, 20));
        exit.setBounds(520, 385, 100, 30);
        exit.addActionListener(this);
        limg.add(exit);
        
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setTitle("ATM");
        setLocation(350,150);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardnofield.setText("");
            passfield.setText("");
        }else if(ae.getSource() == signin)
        {
            String cardno = cardnofield.getText();
            String pinno = passfield.getText();
            Conn con = new Conn();
            try{
                String query = "select * from logindb where Cardno = '"+cardno+"' and Pin = '"+pinno+"'";
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Trans(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(this, "INVALID CREDENTIALS");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup1().setVisible(true);
        }else if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args) {
        
        new Login();
    }
    
}
