package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100, rs200, rs500, rs1000, rs2000, rs10000, back;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select Withdrawl Amount");
        text.setBounds(230, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setForeground(Color.white);
        image.add(text);

        rs100 = new JButton("Rs. 100");
        rs100.setBounds(170, 415, 150, 30);
        rs100.addActionListener(this);
        image.add(rs100);

        rs200 = new JButton("Rs. 200");
        rs200.setBounds(355, 415, 150, 30);
        rs200.addActionListener(this);
        image.add(rs200);
//        
        rs500 = new JButton("Rs. 500");
        rs500.setBounds(170, 450, 150, 30);
        rs500.addActionListener(this);
        image.add(rs500);
//        
        rs1000 = new JButton("Rs. 1000");
        rs1000.setBounds(355, 450, 150, 30);
        rs1000.addActionListener(this);
        image.add(rs1000);
//        
        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(170, 485, 150, 30);
        rs2000.addActionListener(this);
        image.add(rs2000);
//        
        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(355, 485, 150, 30);
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(4).trim();
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
                if(balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
//                    return;
                }
                else{
                    Date date = new Date();
                String query= "insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Balance Withdrawl Successfully.");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        new FastCash("");

    }
}
