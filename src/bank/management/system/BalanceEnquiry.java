
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener  {
    JButton back;
    String pin;
    BalanceEnquiry(String pin){
        setLayout(null);
        this.pin=pin;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text= new JLabel("Balance Enquiry ");
        text.setBounds(250,300,200,20);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setForeground(Color.white);
        image.add(text);
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
        balanceText.setBounds(180,370,350,20);
        balanceText.setForeground(Color.white);
        balanceText.setFont(new Font("System",Font.BOLD,15));
        image.add(balanceText);
        
        back = new JButton("Back");
        back.setBounds(355, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
