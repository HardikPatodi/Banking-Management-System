package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl ,fastcash, ministatement,pinchng,balenquiry,exit;
    String pinnumber;
    public Transactions(String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0, 0, 900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transcations");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.white);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355, 415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchng = new JButton("Pin Change");
        pinchng.setBounds(170, 485,150,30);
        pinchng.addActionListener(this);
        image.add(pinchng);
        
        balenquiry = new JButton("Balance Enquiry");
        balenquiry.setBounds(355, 485,150,30);
        balenquiry.addActionListener(this);
        image.add(balenquiry);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(355, 520,150,30);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchng)
        {
            setVisible(false);
            new PinChanging(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
