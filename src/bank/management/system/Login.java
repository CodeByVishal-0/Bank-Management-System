package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, sign, clear;
    JTextField cardNumber;
    JPasswordField pass;

    Login() {
        setTitle("BANK MANAGEMENT SYSTEM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card no.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(120, 5, 100, 400);
        add(cardno);
//        textfiled
        cardNumber = new JTextField();
        cardNumber.setBounds(250, 200, 150, 20);
        cardNumber.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardNumber);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(120, 5, 200, 500);
        add(pin);

        pass = new JPasswordField();
        pass.setBounds(250, 250, 150, 20);
        pass.setFont(new Font("Arial", Font.BOLD, 14));
        add(pass);

        login = new JButton("LOGIN");
        login.setBounds(200, 300, 100, 20);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        sign = new JButton("SIGN UP");
        sign.setBackground(Color.black);
        sign.setForeground(Color.white);
        sign.setBounds(300, 300, 100, 20);
        sign.addActionListener(this);
        add(sign);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.setBounds(260, 325, 100, 20);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.white);

        setSize(600, 400);
        setVisible(true);
        setLocation(400, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String cardno = cardNumber.getText();
            String pin = pass.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from login where cardNumber='" + cardno + "' and pinNumber = '" + pin + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (ae.getSource() == sign) {
            setVisible(false);
            new SignupOne().setVisible(true);
        } else if (ae.getSource() == clear) {
            cardNumber.setText("");
            pass.setText("");
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
