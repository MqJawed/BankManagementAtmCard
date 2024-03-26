package atmcardsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        this.pinnumber = pinnumber;
        String card = null;
        String bal = null;
        String state = null;

        try {
            Conn con = new Conn();
            String query = "select * from logindb where Pin = '" + pinnumber + "';";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                card = rs.getString("Cardno");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn con = new Conn();
            String query = "select * from balancedb where Pin = '" + pinnumber + "';";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                bal = rs.getString("Balance");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn con = new Conn();
            String query = "select * from transaction where Pin = '" + pinnumber + "' order by Date desc limit 5;";
            ResultSet rs = con.s.executeQuery(query);
            while (rs.next()) {
                if (state == null) {
                    state = "<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;RS " + rs.getString("Amount") + "<br><br><html>";
                } else {
                    state += "<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;RS " + rs.getString("Amount") + "<br><br><html>";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel mslabel = new JLabel("Cardno: xxxx xxxx xxxx " + card.substring(12));
        mslabel.setFont(new Font("TimesRoman", Font.BOLD, 16));
        mslabel.setBounds(10, 20, 290, 50);
        add(mslabel);
        
        JLabel statelabel = new JLabel(state);
        statelabel.setFont(new Font("TimesRoman", Font.BOLD, 12));
        statelabel.setBounds(10, 90, 400, 300);
        statelabel.setBackground(Color.WHITE);
        add(statelabel);
        
        JLabel ballabel = new JLabel("Your Account Balance is: "+bal);
        ballabel.setFont(new Font("TimesRoman", Font.BOLD, 16));
        ballabel.setBounds(10, 350, 350, 50);
        add(ballabel);

        setVisible(true);
        setSize(400, 500);
        setResizable(false);
        setLocation(150, 150);
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }

}
