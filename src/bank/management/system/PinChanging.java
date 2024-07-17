
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChanging extends JFrame implements ActionListener{
    
    JButton change,back;
    JPasswordField repin,pin;
    String pinnumber;
   PinChanging(String pinnumber)
   {
       this.pinnumber=pinnumber;
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       
       JLabel image =new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("CHANGE YOUR PIN");
       text.setBounds(250,280,500,35);
       text.setForeground(Color.white);
       text.setFont(new Font("system",Font.BOLD,16));
       image.add(text);
       
       JLabel pintext=new JLabel("NEW PIN");
       pintext.setBounds(165,320,180,25);
       pintext.setForeground(Color.white);
       pintext.setFont(new Font("system",Font.BOLD,16));
       image.add(pintext);
       
       pin=new JPasswordField();
       pin.setBackground(Color.white);
       pin.setFont(new Font("system",Font.BOLD,25));
       pin.setBounds(330,320,180,25);
       image.add(pin);
       
       JLabel repintext=new JLabel("Re-Enter NEW PIN");
       repintext.setBounds(165,360,180,25);
       repintext.setForeground(Color.white);
       repintext.setFont(new Font("system",Font.BOLD,16));
       image.add(repintext);
       
       repin=new JPasswordField();
       repin.setFont(new Font("system",Font.BOLD,25));
       repin.setBounds(330,360,180,25);
       image.add(repin);
       
       change=new JButton("Change");
       change.setBounds(355,485,150,30);
       change.addActionListener(this);
       image.add(change);
       
       back=new JButton("Back");
       back.setBounds(355,520,150,30);
       back.addActionListener(this);
       image.add(back);
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==change)
       {
           try
           {
               String npin=pin.getText();
               String rpin=repin.getText();
               
               if(!npin.equals(rpin))
               {
                   JOptionPane.showMessageDialog(null,"Entered pin doesnot match");
                   return;
               }
               if(npin.equals("") || rpin.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Entered pin doesnot match");
                   return;
               }
               conn conn =new conn();
               String q1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
               String q2="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
               String q3="update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";
               
               conn.s.executeUpdate(q1);
               conn.s.executeUpdate(q2);
               conn.s.executeUpdate(q3);
               
               JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
               setVisible(false);
               new Transactions(rpin).setVisible(true);
           }
           catch(Exception e)
           {
               
           }
       }
       else
       {
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
   }
    public static void main(String args[]) {
        new PinChanging("").setVisible(true);
    }
}
