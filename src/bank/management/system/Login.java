package bank.management.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,600);
        setVisible(true);
        setLocation(350,150);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/finall.png")); 
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(350, 30, 100,100);
        add(label);
        
        JLabel text =new JLabel("WELCOME TO THE ATM");
        text.setBounds(250, 140, 300, 50);
        text.setFont(new Font("tahomo",Font.BOLD,24));
        add(text);
        
        JLabel cardno =new JLabel("CARD NO :");
        cardno.setBounds(230, 220, 150, 30);
        cardno.setFont(new Font("tahomo",Font.BOLD,16));
        add(cardno);
        
        cardTextField =new JTextField();
        cardTextField.setBounds(330, 220, 200, 30);
        cardTextField.setFont(new Font("ARIAL",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin =new JLabel("PIN :");
        pin.setBounds(230, 280, 150, 30);
        pin.setFont(new Font("tahomo",Font.BOLD,16));
        add(pin);
        
        pinTextField =new JPasswordField();
        pinTextField.setBounds(330, 280, 200, 30);
        pinTextField.setFont(new Font("ARIAL",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("LOGIN");
        login.setBounds(230, 350, 120, 40);
        add(login);
        login.addActionListener(this);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        
        clear = new JButton("CLEAR");
        clear.setBounds(410, 350, 120, 40);
        add(clear);
        clear.addActionListener(this);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(230, 410,300, 40);
        add(signup);
        signup.addActionListener(this);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            conn conn =new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query="Select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try
            {
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Incorrect card nmber or pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Login();
    }
}
