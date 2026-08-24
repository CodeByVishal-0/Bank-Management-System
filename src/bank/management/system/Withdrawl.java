package bank.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    JButton withdrawl, back;
    JTextField amount;

    Withdrawl(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter Amount you want to Withdraw");
        text.setBounds(220, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(220, 350, 100, 20);
        amount.setFont(new Font("System", Font.BOLD, 20));
        image.add(amount);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355, 485, 150, 30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String num = amount.getText();
            if (num.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount.");
            }
           else {
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pin + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(num)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
//                    return;
                }
                else{
                    Date date = new Date();
                String query= "insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+num+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Balance Withdrawl Successfully.");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
