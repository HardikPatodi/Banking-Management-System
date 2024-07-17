package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
        

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes ,sno,eyes,eno;
    JComboBox religion,category,income,Education,Occupation;
    String formno;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setSize(800,750);
        setLocation(350,30);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        
        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setBounds(270, 80, 400, 30);
        AdditionalDetails.setFont(new Font("RALEWAY",Font.BOLD,24));
        add(AdditionalDetails);
        
        JLabel Religion = new JLabel("Religion:");
        Religion.setBounds(100,140 , 200, 30);
        Religion.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(Religion);
        
        String valreg[] = {"Hindu","Muslim","Sikh","Christan","Others"};
        religion=new JComboBox(valreg);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel Category = new JLabel("Category:");
        Category.setBounds(100,190 , 200, 30);
        Category.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(Category);
        
        String valCat[]={"General","ST","SC","OBC"};
        category=new JComboBox(valCat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel Income = new JLabel("Income:");
        Income.setBounds(100,240 , 200, 30);
        Income.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(Income);
        
        String valIncome[] ={"NULL","<1,50,000",">5,00,000",">50,00,000"}; 
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setBounds(100,290 , 200, 30);
        gender.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setBounds(100,315 , 200, 30);
        email.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(email);
        
        String valEducation[] ={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"}; 
        Education = new JComboBox(valEducation);
        Education.setBounds(300, 290, 400, 50);
        Education.setBackground(Color.white);
        add(Education);
        
        JLabel marital = new JLabel("Occupation:");
        marital.setBounds(100,390 , 200, 30);
        marital.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(marital);
        
        String valOccupation[] ={"Salaried","Self-Employed","Bussiness","Retired"}; 
        Occupation = new JComboBox(valOccupation);
        Occupation.setBounds(300, 390, 400, 30);
        Occupation.setBackground(Color.white);
        add(Occupation);
        
        JLabel address = new JLabel("PAN Number.:");
        address.setBounds(100,440 , 200, 30);
        address.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("raleway",Font.BOLD,16));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setBounds(100,490 , 200, 30);
        city.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("raleway",Font.BOLD,16));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setBounds(100,540 , 200, 30);
        state.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(420, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setBounds(100,590 , 200, 30);
        pincode.setFont(new Font("RALEWAY",Font.BOLD,20));
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(420, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup exist = new ButtonGroup();
        exist.add(eyes);
        exist.add(eno);
        
        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(600, 650, 100, 30);
        next.addActionListener(this);
        add(next);
                
    }
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion = (String)religion.getSelectedItem();
        String scategory= (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)Education.getSelectedItem();
        String soccupation = (String)Occupation.getSelectedItem();
        
        String seniorcitizen=null;
        if(syes.isSelected())
            seniorcitizen="Yes";
        else if(sno.isSelected())
            seniorcitizen="No";
        
        String existingacc=null;
        if(eyes.isSelected())
            existingacc="Yes";
        else if(eno.isSelected())
            existingacc = "No";
        
        String span =pan.getText();
        String saadhar =aadhar.getText();
        
        try{
                conn c=new conn();
                String query = "Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingacc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    public static void main(String args[]) {
        new SignupTwo("");
    }
}

