package bank.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JButton deposit, back;
    JTextField amount;

    Deposit(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter Amount you want to Deposit");
        text.setBounds(220, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(220, 350, 100, 20);
        amount.setFont(new Font("System", Font.BOLD, 20));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        image.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String num = amount.getText();
            if (num.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount.");
            }
            else {
                try {
                    Date date = new Date();
                    Conn conn = new Conn();
                    String query = "insert into bank values ('" + pin + "','" + date + "','Deposit','" + num + "')";
                    conn.s.execute(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+num+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
