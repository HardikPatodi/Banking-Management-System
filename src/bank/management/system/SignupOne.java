package bank.management.system;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
        

public class SignupOne extends JFrame implements ActionListener{
    long num;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male ,female ,unmarried ,married,others;
    JDateChooser datechooser;
    SignupOne()
    {
        setLayout(null);
        setSize(800,750);
        setLocation(350,30);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        Random ran= new Random();
        num =Math.abs((ran.nextLong()%9000)+1000L);
        
        JLabel formno = new JLabel("APPLICATION NO."+num);
        formno.setBounds(200, 30, 400, 30);
        formno.setFont(new Font("RALEWAY",Font.BOLD,34));
        add(formno);
        
        JLabel personalInfo = new JLabel("Personal Information");
        personalInfo.setBounds(270, 80, 400, 30);
        personalInfo.setFont(new Font("RALEWAY",Font.BOLD,24));
        add(personalInfo);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(100,140 , 200, 30);
        name.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("raleway",Font.BOLD,16));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,190 , 200, 30);
        fname.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("raleway",Font.BOLD,16));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(100,240 , 200, 30);
        dob.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 200, 30);
        datechooser.setForeground(Color.black);
        add(datechooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,290 , 200, 30);
        gender.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(gender);
        
        male =new JRadioButton("Male");
        male.setBounds(300, 290,100,30);
        male.setBackground(Color.white);
        add(male);
        
        female =new JRadioButton("Female");
        female.setBounds(420, 290,100,30);
        female.setBackground(Color.white);
        add(female);
        
        others =new JRadioButton("Others");
        others.setBounds(540, 290,100,30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        gendergrp.add(others);
                
        
        JLabel email = new JLabel("Email:");
        email.setBounds(100,340 , 200, 30);
        email.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("raleway",Font.BOLD,16));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marrital Status:");
        marital.setBounds(100,390 , 200, 30);
        marital.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(marital);
        
        married =new JRadioButton("Married");
        married.setBounds(300, 390,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried =new JRadioButton("Unmarried");
        unmarried.setBounds(420, 390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        ButtonGroup marriedgrp = new ButtonGroup();
        marriedgrp.add(married);
        marriedgrp.add(unmarried);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(100,440 , 200, 30);
        address.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("raleway",Font.BOLD,16));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setBounds(100,490 , 200, 30);
        city.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("raleway",Font.BOLD,16));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setBounds(100,540 , 200, 30);
        state.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("raleway",Font.BOLD,16));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setBounds(100,590 , 200, 30);
        pincode.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("raleway",Font.BOLD,16));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(600, 650, 100, 30);
        next.addActionListener(this);
        add(next);
                
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno = ""+num;
        String name = nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        
        String gender=null;
        if(male.isSelected())
            gender="Male";
        else if(female.isSelected())
            gender="Female";
        
        String email = emailTextField.getText();
        
        String marital=null;
        if(married.isSelected())
            marital="Married";
        else if(unmarried.isSelected())
            marital = "Unmarried";
        
        String address =addressTextField.getText();
        String city =cityTextField.getText();
        String state =stateTextField.getText();
        String pin =pincodeTextField.getText();
        
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                conn c=new conn();
                String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) {
        new SignupOne();
    }
}
