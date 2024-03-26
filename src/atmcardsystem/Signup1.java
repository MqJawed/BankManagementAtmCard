
package atmcardsystem;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
public class Signup1 extends JFrame implements ActionListener{
    
    JTextField namefield, fnamefield, adfield, cfield, sfield, pfield, phfield, efield;
    JDateChooser jd;
    JRadioButton jb,jb2;
    JButton next;
    int random;
    
    Signup1(){
        
        setLayout(null);
        random = ThreadLocalRandom.current().nextInt(1000,10000);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("resources/signupbg.jpg"));
        Image image = img.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon newimg = new ImageIcon(image);
        JLabel limg = new JLabel(newimg);
        limg.setBounds(0,0,600,700);
        add(limg);

        JLabel per = new JLabel("Application no." + random);
        per.setFont(new Font("Raleway", Font.BOLD, 25));
        per.setBounds(150,0,300,50);
        limg.add(per);
        
        JLabel pag = new JLabel("Page 1: Personal Details");
        pag.setFont(new Font("Raleway", Font.BOLD, 18));
        pag.setBounds(170,70,250,20);
        limg.add(pag);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Serif", Font.BOLD, 18));
        name.setBounds(70,150,100,20);
        limg.add(name);
        
        namefield = new JTextField("");
        namefield.setFont(new Font("Serif", Font.PLAIN, 18));
        namefield.setBounds(270,145,270,25);
        limg.add(namefield);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Serif", Font.BOLD, 18));
        fname.setBounds(70,190,200,20);
        limg.add(fname);
        
        fnamefield = new JTextField("");
        fnamefield.setFont(new Font("Serif", Font.PLAIN, 18));
        fnamefield.setBounds(270,185,270,25);
        limg.add(fnamefield);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Serif", Font.BOLD, 18));
        dob.setBounds(70,230,200,20);
        limg.add(dob);
       
        jd = new JDateChooser();
        jd.setBounds(270,225,270,25);
        jd.setForeground(new Color(105,105,105));
        limg.add(jd);
        
        JLabel gen = new JLabel("Gender");
        gen.setFont(new Font("Serif", Font.BOLD, 18));
        gen.setBounds(70,270,100,20);
        limg.add(gen);
        
        jb = new JRadioButton("Male");
        jb.setFont(new Font("Raleway", Font.BOLD, 16));
        jb.setBounds(270,265,100,25);
        limg.add(jb);
        
        jb2 = new JRadioButton("Female");
        jb2.setFont(new Font("Raleway", Font.BOLD, 16));
        jb2.setBounds(440,265,100,25);
        limg.add(jb2);
        
        ButtonGroup jg = new ButtonGroup();
        jg.add(jb);
        jg.add(jb2);
        
        JLabel ad = new JLabel("Address");
        ad.setFont(new Font("Serif", Font.BOLD, 18));
        ad.setBounds(70,310,100,20);
        limg.add(ad);
        
        adfield = new JTextField("");
        adfield.setFont(new Font("Serif", Font.PLAIN, 18));
        adfield.setBounds(270,305,270,25);
        limg.add(adfield);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("Serif", Font.BOLD, 18));
        city.setBounds(70,350,100,20);
        limg.add(city);
        
        cfield = new JTextField("");
        cfield.setFont(new Font("Serif", Font.PLAIN, 18));
        cfield.setBounds(270,345,270,25);
        limg.add(cfield);
        
        JLabel st = new JLabel("State");
        st.setFont(new Font("Serif", Font.BOLD, 18));
        st.setBounds(70,390,100,20);
        limg.add(st);
        
        sfield = new JTextField("");
        sfield.setFont(new Font("Serif", Font.PLAIN, 18));
        sfield.setBounds(270,385,270,25);
        limg.add(sfield);
        
        JLabel pc = new JLabel("PinCode");
        pc.setFont(new Font("Serif", Font.BOLD, 18));
        pc.setBounds(70,430,100,20);
        limg.add(pc);
        
        pfield = new JTextField("");
        pfield.setFont(new Font("Serif", Font.PLAIN, 18));
        pfield.setBounds(270,425,270,25);
        limg.add(pfield);
        
        JLabel ph = new JLabel("Phone.");
        ph.setFont(new Font("Serif", Font.BOLD, 18));
        ph.setBounds(70,470,100,20);
        limg.add(ph);
        
        phfield = new JTextField("");
        phfield.setFont(new Font("Serif", Font.PLAIN, 18));
        phfield.setBounds(270,465,270,25);
        limg.add(phfield);
        
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Serif", Font.BOLD, 18));
        email.setBounds(70,510,100,20);
        limg.add(email);
        
        efield = new JTextField("");
        efield.setFont(new Font("Serif", Font.PLAIN, 18));
        efield.setBounds(270,505,270,25);
        limg.add(efield);
        
        next = new JButton("Next");
        next.setBackground(Color.CYAN);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Calibri", Font.BOLD, 20));
        next.setBounds(450, 560, 90, 30);
        next.addActionListener(this);
        limg.add(next);
        
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,700);
        setTitle("SIGNUP");
        setLocation(450,50);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String fno = Integer.toString(random);
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String db = ((JTextField) jd.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(jb.isSelected())
            gender = "Male";
        else
            gender = "Female";
        String address = adfield.getText();
        String city = cfield.getText();
        String state = sfield.getText();
        String pin = pfield.getText();
        String ph = phfield.getText();
        String email = efield.getText();
//        JOptionPane.showConfirmDialog(this, "Are you sure data provided is correct in all respect");
       try {
            Conn ncon = new Conn();
            String query = "insert into bankdb values('"+fno+"', '"+name+"', '"+fname+"', '"+db+"', '"+gender+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"', '"+ph+"', '"+email+"');";
            ncon.s.executeUpdate(query);
//            JOptionPane.showMessageDialog(this,"Sucessfully Registered\nLogin to continue");
              setVisible(false);
            new Signup2(fno).setVisible(true);
        } catch (Exception e) {
           System.out.println("hello");
        }
    }    
    
    public static void main(String args[])
    {
//        int random = ThreadLocalRandom.current().nextInt(1000,10000);
//        System.out.println(random);
        new Signup1();
    }
}
