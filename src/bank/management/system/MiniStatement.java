
package bank.management.system;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener{
    
    String pinnumber;
    
    public MiniStatement(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel text=new JLabel("Local Bank");
        text.setBounds(150,20,100,20);
        add(text);
        
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try
        {
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number:" +rs.getString("cardnumber  ").substring(0,4)+"XXXXXXXX" +rs.getString("cardnumber  ").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<HTML>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><HTML>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        
        setTitle("Mini-Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            
        }
        catch(Exception e)
        {
            
        }
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new MiniStatement("");
    }
}
