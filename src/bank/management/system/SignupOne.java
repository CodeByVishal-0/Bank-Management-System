package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    int random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pincodeTextField, stateTextField;
    JButton next,back;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried;

    SignupOne() {
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 1");
        random = (int) (Math.random() * 10000);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(150, 20, 1000, 50);
        add(formno);

        JLabel personaldetails = new JLabel("Page 1 : Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personaldetails.setBounds(280, 80, 500, 50);
        add(personaldetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 150, 100, 50);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        nameTextField.setBounds(300, 165, 200, 25);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 200, 170, 50);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameTextField.setBounds(300, 215, 200, 25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 250, 170, 50);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 265, 200, 25);
        add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 300, 170, 50);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 300, 100, 50);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 300, 100, 50);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 350, 170, 50);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailTextField.setBounds(300, 360, 200, 25);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 400, 170, 50);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 400, 100, 50);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 400, 100, 50);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 450, 170, 50);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        addressTextField.setBounds(300, 465, 200, 25);
        add(addressTextField);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 500, 170, 50);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        cityTextField.setBounds(300, 515, 200, 25);
        add(cityTextField);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 550, 170, 50);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        stateTextField.setBounds(300, 565, 200, 25);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 600, 170, 50);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 10));
        pincodeTextField.setBounds(300, 615, 200, 25);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBounds(440, 670, 60, 25);
        next.setFont(new Font("Raleway", Font.BOLD, 10));
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBounds(300, 670, 60, 25);
        back.setFont(new Font("Raleway", Font.BOLD, 10));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);
        setSize(800, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }
        String marritalStatus = "";
        if (married.isSelected()) {
            marritalStatus = "married";
        } else if (unmarried.isSelected()) {
            marritalStatus = "unmarried";
        }
        String fname = "" + fnameTextField.getText();
        String email = "" + emailTextField.getText();
        String address = "" + addressTextField.getText();
        String city = "" + cityTextField.getText();
        String pincode = "" + pincodeTextField.getText();
        String state = "" + stateTextField.getText();
        if (ae.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        } else {
            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                } else if (fname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Father's Name is Required");
                } else if (dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is Required");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email is Required");
                } else if (gender.equals("")) {
                    JOptionPane.showMessageDialog(null, "Gender is Required");
                } else if (marritalStatus.equals("")) {
                    JOptionPane.showMessageDialog(null, "Marrital Status is Required");
                } else if (address.equals("")) {
                    JOptionPane.showMessageDialog(null, " Address is Required");
                } else if (city.equals("")) {
                    JOptionPane.showMessageDialog(null, "City is Required");
                } else if (pincode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pincode is Required");
                } else if (state.equals("")) {
                    JOptionPane.showMessageDialog(null, "State is Required");
                } else {
                    Conn c = new Conn();
                    String query = "insert into signup values ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + email + "','" + gender + "','" + marritalStatus + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new SignupOne();

    }

}
