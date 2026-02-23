
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String pin;
    JPasswordField newPin,renewPin;
    JButton submit,cancel;
    PinChange(String pin){
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text= new JLabel("Change your PIN: ");
        text.setBounds(250,300,200,20);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setForeground(Color.white);
        image.add(text);
        
        JLabel newPinText= new JLabel("New PIN: ");
        newPinText.setBounds(220,370,100,20);
        newPinText.setFont(new Font("System",Font.BOLD,18));
        newPinText.setForeground(Color.white);
        image.add(newPinText);
        
        
        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway",Font.BOLD,15));
        newPin.setBounds(320, 370, 100, 20);
        image.add(newPin);
        newPin.addActionListener(this);
        
        JLabel renewPinText= new JLabel("Re-Enter PIN: ");
        renewPinText.setBounds(200,400,150,20);
        renewPinText.setFont(new Font("System",Font.BOLD,18));
        renewPinText.setForeground(Color.white);
        image.add(renewPinText);
        
        renewPin = new JPasswordField();
        renewPin.setFont(new Font("Raleway",Font.BOLD,15));
        renewPin.setBounds(320, 400, 100, 20);
        image.add(renewPin);
        renewPin.addActionListener(this);
        
        submit = new JButton("Change");
        submit.setBounds(355, 520, 150, 30);
        submit.addActionListener(this);
        image.add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(355, 485, 150, 30);
        cancel.addActionListener(this);
        image.add(cancel);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String newpin = newPin.getText();
        String renewpin = renewPin.getText();
        if(ae.getSource()==submit){
            if(newpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New Pin ");
            }else if(!(newpin.equals(renewpin))){
                JOptionPane.showMessageDialog(null,"New PIN not matched with Re-Enter  PIN");
            }else{
                try{
                    Conn conn= new Conn();
                    String query1 ="update bank set pin= '"+newpin+"' where pin='"+pin+"'";
                    String query2 ="update login set pinNumber= '"+newpin+"' where pinNumber='"+pin+"'";
                    String query3 ="update signupthree  set pinNumber ='"+newpin+"' where pinNumber='"+pin+"'";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Pin Changed Successfully.");
                    setVisible(false);
                    new Transactions(newpin).setVisible(true);
                    
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        
    }
    public static void main(String[] args){
        
    new PinChange("");
    }
    
}
