
package atmcardsystem;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
public class Signup2 extends JFrame implements ActionListener{
    
    JComboBox relfield,incfield,edfield, occfield, catfield;
    JTextField panfield, adfield;
    JRadioButton sc,sc2, ex, ex2;
    JButton next;
    String fno2;
    
    Signup2(){} // for accessing direct from this file
    Signup2(String formnumber){ // for accessing from signup1 file
        
        this.fno2 = formnumber;
        setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("resources/signupbg.jpg"));
        Image image = img.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon newimg = new ImageIcon(image);
        JLabel limg = new JLabel(newimg);
        limg.setBounds(0,0,600,700);
        add(limg);
        
        JLabel pag = new JLabel("Page 2: Additional Details");
        pag.setFont(new Font("Raleway", Font.BOLD, 20));
        pag.setBounds(170,70,300,22);
        limg.add(pag);
        
        JLabel rel = new JLabel("Religion");
        rel.setFont(new Font("Serif", Font.BOLD, 18));
        rel.setBounds(70,150,100,20);
        limg.add(rel);
        
        String religion[] = {"Islam","Hinduism","Jainism","Christian","Other"};
        relfield = new JComboBox(religion);
        relfield.setBackground(Color.WHITE);
        relfield.setFont(new Font("Serif", Font.PLAIN, 14));
        relfield.setBounds(270,145,270,25);
        limg.add(relfield);
        
        JLabel cat = new JLabel("Category");
        cat.setFont(new Font("Serif", Font.BOLD, 18));
        cat.setBounds(70,190,200,20);
        limg.add(cat);
        
        String category[] = {"General","SC","ST","OBC","Other"};     
        catfield = new JComboBox(category);
        catfield.setBackground(Color.WHITE);
        catfield.setFont(new Font("Serif", Font.PLAIN, 14));
        catfield.setBounds(270,185,270,25);
        limg.add(catfield);
        
        JLabel inc = new JLabel("Income(INR)");
        inc.setFont(new Font("Serif", Font.BOLD, 18));
        inc.setBounds(70,230,200,20);
        limg.add(inc);
       
        String income[] = {"> 1,20,000" ,"> 2,40,000",">5,00,000"};
        incfield = new JComboBox(income);
        catfield.setBackground(Color.WHITE);
        incfield.setFont(new Font("Serif", Font.PLAIN, 16));
        incfield.setBounds(270,225,270,25);
        incfield.setForeground(new Color(105,105,105));
        limg.add(incfield);
        
        JLabel edu = new JLabel("Qualification");
        edu.setFont(new Font("Serif", Font.BOLD, 18));
        edu.setBounds(70,270,150,20);
        limg.add(edu);
        
        String education[] = {"Graduated","Non-Graduated"};
        edfield = new JComboBox(education);
        edfield.setBackground(Color.WHITE);
        edfield.setFont(new Font("Serif", Font.PLAIN, 14));
        edfield.setBounds(270,265,270,25);
        limg.add(edfield);
        
        JLabel occ = new JLabel("Occupation");
        occ.setFont(new Font("Serif", Font.BOLD, 18));
        occ.setBounds(70,310,150,20);
        limg.add(occ);
        
        String occupation[] = {"Business","Self-Employed","Student","Non-Salaried","Other"};
        occfield = new JComboBox(occupation);
        occfield.setBackground(Color.WHITE);
        occfield.setFont(new Font("Serif", Font.PLAIN, 14));
        occfield.setBounds(270,305,270,25);
        limg.add(occfield);
        
        JLabel pan = new JLabel("PAN");
        pan.setFont(new Font("Serif", Font.BOLD, 18));
        pan.setBounds(70,350,100,20);
        limg.add(pan);
        
        panfield = new JTextField("");
        panfield.setFont(new Font("Serif", Font.PLAIN, 18));
        panfield.setBounds(270,345,270,25);
        limg.add(panfield);
        
        JLabel ad = new JLabel("Aadhar");
        ad.setFont(new Font("Serif", Font.BOLD, 18));
        ad.setBounds(70,390,100,20);
        limg.add(ad);
        
        adfield = new JTextField("");
        adfield.setFont(new Font("Serif", Font.PLAIN, 18));
        adfield.setBounds(270,385,270,25);
        limg.add(adfield);
        
        JLabel sct = new JLabel("Senior Citizen");
        sct.setFont(new Font("Serif", Font.BOLD, 18));
        sct.setBounds(70,430,200,20);
        limg.add(sct);
        
        sc = new JRadioButton("Yes");
        sc.setFont(new Font("Serif", Font.BOLD, 16));
        sc.setBackground(Color.WHITE);
        sc.setBounds(270,425,70,25);
        limg.add(sc);
        
        sc2 = new JRadioButton("No");
        sc2.setFont(new Font("Serif", Font.BOLD, 16));
        sc2.setBackground(Color.WHITE);
        sc2.setBounds(370,425,70,25);
        limg.add(sc2);
        
        ButtonGroup jg = new ButtonGroup();
        jg.add(sc);
        jg.add(sc2);

        JLabel exa = new JLabel("Existing Account");
        exa.setFont(new Font("Serif", Font.BOLD, 18));
        exa.setBounds(70,470,200,20);
        limg.add(exa);
        
        ex = new JRadioButton("Yes");
        ex.setFont(new Font("Serif", Font.BOLD, 16));
        ex.setBackground(Color.WHITE);
        ex.setBounds(270,465,70,25);
        limg.add(ex);
        
        ex2 = new JRadioButton("No");
        ex2.setFont(new Font("Serif", Font.BOLD, 16));
        ex2.setBackground(Color.WHITE);
        ex2.setBounds(370,465,70,25);
        limg.add(ex2);
        
        ButtonGroup jg2 = new ButtonGroup();
        jg2.add(ex);
        jg2.add(ex2);     
        
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
        String rel = (String) relfield.getSelectedItem();
        String cat = (String) catfield.getSelectedItem();
        String inc = (String) incfield.getSelectedItem();
        String ed = (String) edfield.getSelectedItem();
        String occ = (String) occfield.getSelectedItem();
        String pan = panfield.getText();
        String ad = adfield.getText();
 
        String ext = null;
        if(ex.isSelected())
            ext = "Yes";
        else
            ext = "No";
        
        String sct = null;
        if(sc.isSelected())
            sct = "Yes";
        else
            sct = "No";
//        JOptionPane.showConfirmDialog(this, "Are you sure data provided is correct in all respect");
       try {
            Conn ncon = new Conn();
            String query = "insert into bankdb2 values('"+fno2+"', '"+rel+"', '"+cat+"', '"+inc+"', '"+ed+"', '"+occ+"', '"+pan+"', '"+ad+"', '"+sct+"', '"+ext+"');";
            ncon.s.executeUpdate(query);
            //JOptionPane.showMessageDialog(this,"Sucessfully Registered\nLogin to continue");
            setVisible(false);
            new Signup3(fno2).setVisible(true);
        } catch (SQLException e) {
           System.out.println(e);
        }
    }    
    
    public static void main(String args[])
    {
//        int random = ThreadLocalRandom.current().nextInt(1000,10000);
//        System.out.println(random);
        new Signup2("");
    }
}
