package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds( 280,40 ,400 ,40 );
        add(l1);
        
        JLabel type=new JLabel("Account Type:-");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds( 100,140 ,200 ,30 );
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setBounds(100, 190, 200,30);
        r1.setFont(new Font("RALEWAY",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(310, 190, 250,30);
        r2.setFont(new Font("RALEWAY",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setBounds(100, 230, 200,30);
        r3.setFont(new Font("RALEWAY",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);
        
        r4=new JRadioButton("Recrutting Deposit Account");
        r4.setBounds(310, 230, 250,30);
        r4.setFont(new Font("RALEWAY",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup acctype =new ButtonGroup();
        acctype.add(r1);
        acctype.add(r2);
        acctype.add(r3);
        acctype.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds( 100,300 ,200 ,30 );
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds( 330,300 ,300 ,30 );
        add(number);
        
        JLabel pin=new JLabel("Card Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds( 100,360 ,200 ,30 );
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds( 330,360 ,300 ,30 );
        add(pnumber);
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds( 100,430 ,300 ,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("RALEWAT",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("RALEWAT",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("RALEWAT",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("RALEWAT",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("RALEWAT",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("RALEWAT",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
       
        c7=new JCheckBox("Above all details are totally correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("RALEWAT",Font.BOLD,16));
        c7.setBounds(100,660,600,30);
        add(c7);
        
        submit =new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("RALEWAT",Font.BOLD,14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel =new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("RALEWAT",Font.BOLD,14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType=null;
            if(r1.isSelected())
            {
                accountType="Saving Account";
            }
            else if(r2.isSelected())
            {
                accountType="Fixed Depoist Account";
            }
            else if(r3.isSelected())
            {
                accountType="Current Account";
            }
            else if(r4.isSelected())
            {
                accountType="Recurring Deposit Account";
            } 
            
            Random random =new Random();
            String cardnumber = "" +Math.abs((random.nextLong() % 90000000L) + 603039000000000L);
            String pinnumber = "" +Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+"ATM Card";
            }
            else if(c2.isSelected())
            {
                facility=facility+  " Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility=facility+ " Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility=facility+ " EMAIL and SMS Alerts";
            }
            else if(c5.isSelected())
            {
                facility=facility+ " Cheque Book";
            }
            else if(c6.isSelected())
            {
                facility=facility+ " E-Statement";
            }
            
            try
            {
                if(accountType=="")
                {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }
                else
                {
                    conn conn = new conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    conn.s.execute(query1);
                    
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.execute(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\nPin:"+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e )
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
          
    public static void main(String args[]) {
        new SignupThree("");

    }

}
