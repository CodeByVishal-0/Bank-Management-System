package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener {
    String formno;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JRadioButton savings, current, fixedDeposit, recurringDeposit;
    JButton submit, cancel;

    SignupThree(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 3");
        JLabel additionaldetails = new JLabel("Page 3 : Account Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionaldetails.setBounds(280, 80, 500, 50);
        add(additionaldetails);

        JLabel accountType = new JLabel("Account Type : ");
        accountType.setFont(new Font("Raleway", Font.BOLD, 20));
        accountType.setBounds(100, 180, 150, 50);
        add(accountType);

        savings = new JRadioButton("Saving Account");
        savings.setBounds(100, 230, 150, 20);
        savings.setFont(new Font("Raleway", Font.BOLD, 15));
        savings.setBackground(Color.white);
        add(savings);

        current = new JRadioButton("Current Account");
        current.setBounds(400, 230, 150, 20);
        current.setFont(new Font("Raleway", Font.BOLD, 15));
        current.setBackground(Color.white);
        add(current);

        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setBounds(400, 260, 200, 20);
        fixedDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
        fixedDeposit.setBackground(Color.white);
        add(fixedDeposit);

        recurringDeposit = new JRadioButton("Recurring Deposit Account");
        recurringDeposit.setBounds(100, 260, 250, 20);
        recurringDeposit.setFont(new Font("Raleway", Font.BOLD, 15));
        recurringDeposit.setBackground(Color.white);
        add(recurringDeposit);

        ButtonGroup group = new ButtonGroup();
        group.add(savings);
        group.add(current);
        group.add(fixedDeposit);
        group.add(recurringDeposit);

        JLabel card = new JLabel("Card Number");
        card.setBounds(100, 350, 150, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-2190");
        number.setBounds(350, 350, 250, 20);
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        add(number);

        JLabel yourcard = new JLabel("Your 16 Digit Card Number");
        yourcard.setBounds(100, 370, 150, 20);
        yourcard.setFont(new Font("Raleway", Font.BOLD, 10));
        add(yourcard);

        JLabel pin = new JLabel("PIN :");
        pin.setBounds(100, 400, 150, 20);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setBounds(350, 400, 250, 20);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pnumber);

        JLabel yourpin = new JLabel("Your 4 Digit PIN");
        yourpin.setBounds(100, 420, 150, 20);
        yourpin.setFont(new Font("Raleway", Font.BOLD, 10));
        add(yourpin);

        JLabel services = new JLabel("Services Required :");
        services.setBounds(100, 470, 200, 20);
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setBounds(100, 500, 200, 20);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350, 500, 200, 20);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100, 520, 200, 20);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c3);
        c4 = new JCheckBox("E-Mail & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setBounds(350, 520, 200, 20);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100, 540, 200, 20);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(350, 540, 200, 20);
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c6);
        c7 = new JCheckBox("I hereby declares that the above entered details are best to my knowledge.");
        c7.setBackground(Color.white);
        c7.setBounds(100, 600, 700, 20);
        c7.setFont(new Font("Raleway", Font.BOLD, 15));
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 650, 70, 25);
        cancel.setFont(new Font("Raleway", Font.BOLD, 10));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(370, 650, 70, 25);
        submit.setFont(new Font("Raleway", Font.BOLD, 10));
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.white);
        setSize(800, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = "";
            if (savings.isSelected()) {
                accountType = "Saving Account";
            } else if (current.isSelected()) {
                accountType = "Cuurent Account";
            } else if (fixedDeposit.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurringDeposit.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardNumber ="" +Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber=""+Math.abs((random.nextInt()%9000L)+1000L);
            String facility="";
            if(c1.isSelected()){
                facility+="ATM Card";
            }
            if(c2.isSelected()){
                facility+="Internet Banking";
            }
            if(c3.isSelected()){
                facility+="Mobile Banking";
            }
            if(c4.isSelected()){
                facility+="E-Mail & SMS Alerts";
            }
            if(c5.isSelected()){
                facility+="Cheque Book";
            }
            if(c6.isSelected()){
                facility+="E-Statement";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required.");
                }
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please check declaration box.");
                }
                else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values ('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    String query2 = "insert into login values ('" + formno + "',  '" + cardNumber + "', '" + pinNumber + "')";
                    conn.s.execute(query1);
                    conn.s.execute(query2);
                    
                    JOptionPane.showMessageDialog(null,"CardNumber :"+cardNumber+"\n Pin :"+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                    
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        } else{
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");

    }

}
