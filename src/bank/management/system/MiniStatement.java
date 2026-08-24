package bank.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pin;
    JButton back;

    MiniStatement(String pin) {
        this.pin = pin;
        setLayout(null);

        JLabel name = new JLabel("SBI Bank");
        name.setBounds(150, 20, 100, 35);
        name.setForeground(Color.black);
        name.setFont(new Font("System", Font.BOLD, 15));
        add(name);

        JLabel mini = new JLabel();
        mini.setBounds(20, 100, 300, 100);
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
//        JLabel balance = new JLabel();
//        balance.setBounds(20, 80, 300, 20);
//        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNumber='"+pin+"'");
            while (rs.next()) {
                card.setText("Card Number : "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='1234' limit 5");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        int balance=0;
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+pin+"'");
//            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
        
        JLabel balanceText= new JLabel("Your Current Account Balance is: "+balance);
        balanceText.setBounds(50,300,350,20);
        balanceText.setForeground(Color.black);
        balanceText.setFont(new Font("System",Font.BOLD,15));
        add(balanceText);
        
        setVisible(true);
        setLocation(20, 20);
        setSize(400, 600);
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
