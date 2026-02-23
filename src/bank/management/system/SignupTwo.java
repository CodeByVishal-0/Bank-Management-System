package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton seniorNo, seniorYes, existingYes, existingNo;
    JComboBox religionDrop,categoryDrop,incomeDrop,educationDrop,occupationDrop;
    String formno;
    

    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 2");
        JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionaldetails.setBounds(280, 80, 500, 50);
        add(additionaldetails);

        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 150, 100, 50);
        add(religion);
        String[] valReligion={"Hindu","Muslim","Sikh","Christian","Other"};
         religionDrop =new JComboBox(valReligion);
        religionDrop.setBounds(300,160,300,30);
        religionDrop.setBackground(Color.white);
        add(religionDrop);

        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 200, 170, 50);
        add(category);
        
        String[] valCategory = {"General","OBC","SC","ST"};
        categoryDrop= new JComboBox(valCategory);
        categoryDrop.setBounds(300,210,300,30);
        categoryDrop.setBackground(Color.white);
        add(categoryDrop);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 250, 170, 50);
        add(income);
        
        String[] valIncome = {"Null","<100,000","<250,000","<500,000","upto 1,000,000"};
         incomeDrop = new JComboBox(valIncome);
        incomeDrop.setBounds(300,260,300,30);
        incomeDrop.setBackground(Color.white);
        add(incomeDrop);

        JLabel educationalQualification = new JLabel("Education : ");
        educationalQualification.setFont(new Font("Raleway", Font.BOLD, 20));
        educationalQualification.setBounds(100, 300, 170, 50);
        add(educationalQualification);
        
        String[] valEducation = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
         educationDrop =new JComboBox(valEducation);
        educationDrop.setBounds(300,310,300,30);
        educationDrop.setBackground(Color.white);
        add(educationDrop);
        
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 350, 170, 50);
        add(occupation);
        
        String[] valOccupation = {"Self_Employed","Salaried","Bussiness","Student","Retired","Other"};
        occupationDrop = new JComboBox(valOccupation);
        occupationDrop.setBackground(Color.white);
        occupationDrop.setBounds(300,360,300,30);
        add(occupationDrop);
        
        JLabel pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 400, 170, 50);
        add(pan);
        
         panTextField = new JTextField();
        panTextField.setBounds(300,410,300,30);
        panTextField.setBackground(Color.white);
        panTextField.setFont(new Font("Raleway",Font.BOLD,15));
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 450, 170, 50);
        add(aadhar);
        
         aadharTextField = new JTextField();
        aadharTextField.setBounds(300,460,300,30);
        aadharTextField.setBackground(Color.white);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,15));
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 500, 170, 50);
        add(seniorCitizen);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 510, 100, 50);
        seniorYes.setBackground(Color.white);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(400, 510, 100, 50);
        seniorNo.setBackground(Color.white);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        JLabel existing = new JLabel("Existing Account : ");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 550, 180, 50);
        add(existing);
        
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300, 560, 100, 50);
        existingYes.setBackground(Color.white);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBounds(400, 560, 100, 50);
        existingNo.setBackground(Color.white);
        add(existingNo);

        ButtonGroup exisitingGroup = new ButtonGroup();
        exisitingGroup.add(existingYes);
        exisitingGroup.add(existingNo);

        next = new JButton("Next");
        next.setBounds(540, 600, 60, 25);
        next.setFont(new Font("Raleway", Font.BOLD, 10));
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pan =panTextField.getText();
        String aadhar = aadharTextField.getText();
        String senior="";
        if(seniorYes.isSelected()){
            senior="Yes";
        } else if(seniorNo.isSelected()){
            senior="No";
        }
        String existing="";
        if(existingYes.isSelected()){
            existing="Yes";
        }
        else if(existingNo.isSelected()){
            existing="No";
        }
        String religion =""+ religionDrop.getSelectedItem();
        String category=""+categoryDrop.getSelectedItem();
        String income= ""+incomeDrop.getSelectedItem();
        String occupation=""+occupationDrop.getSelectedItem();
        String education = ""+educationDrop.getSelectedItem();
        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            }
            else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            }else if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            }else if(senior.equals("")){
                JOptionPane.showMessageDialog(null, "Senior Citizen is Required");
            }else if(existing.equals("")){
                JOptionPane.showMessageDialog(null, "Existing Account is Required");
            }else{
                Conn c = new Conn();
                    String query = "insert into signuptwo values ('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + senior + "','" + existing + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");

    }

}
