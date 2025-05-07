package Travel_Managment_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup  extends JFrame implements ActionListener{
    RButton create , back;
    RTextField tfusername , tfname , tfpassword , tfAnswer;
    Choice c1;
    Signup(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width ;
        int screenHeight = screenSize.height ;

        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        RPanel p1 = new RPanel(30, new Color(133,193,233));
        p1.setBounds(555,150,400,500);
        p1.setLayout(null);
        add(p1);

        
        
        JLabel lblRagister = new JLabel("User Registration");
        lblRagister.setBounds(100,20,250,30);
        lblRagister.setFont(new Font("Roman",Font.BOLD , 25));
        p1.add(lblRagister);


        JLabel lblUsername = new JLabel("User Name : ");
        lblUsername.setBounds(25,100,130,30);
        lblUsername.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblUsername);
        tfusername = new RTextField(10);
        tfusername.setBounds(170,100,200,30);
        tfusername.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(25,150,130,30);
        lblname.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblname);
        tfname = new RTextField(10);
        tfname.setBounds(170,150,200,30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfname);

        
        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(25,200,130,30);
        lblPassword.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblPassword);
        tfpassword = new RTextField(10);
        tfpassword.setBounds(170,200,200,30);
        tfpassword.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfpassword);

        JLabel lblSecurity = new JLabel("<html>Security<br>Question:</html>");
        lblSecurity.setBounds(25,250,130,70);
        lblSecurity.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblSecurity);
        c1 = new Choice();
        c1.add("Enter Your Name....");
        c1.add("Enter Your age....");
        c1.setBounds(170,270,200,30);
        c1.setFont(new Font("Roman",Font.PLAIN , 15));
        p1.add(c1);

        JLabel lblAnswer = new JLabel("Answer : ");
        lblAnswer.setBounds(25,330,130,30);
        lblAnswer.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblAnswer);
        tfAnswer = new RTextField(10);
        tfAnswer.setBounds(170,330,200,30);
        tfAnswer.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfAnswer);

        create = new RButton("Create",30);
        create.setBounds(50,420,125,30);
        create.setFont(new Font("Roman",Font.BOLD , 15));
        create.addActionListener(this);
        p1.add(create);

        back = new RButton("Back",30);
        back.setBounds(230,420,125,30);
        back.setFont(new Font("Roman",Font.BOLD , 15));
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create) {
            String Username = tfusername.getText();
            String Name = tfname.getText();
            String Password = tfpassword.getText();
            String Question = c1.getSelectedItem();
            String Answer = tfAnswer.getText();
        
            try {
                Conn c = new Conn();
                if (c.s == null) {
                    JOptionPane.showMessageDialog(null, "Connection Failed! Statement is null.");
                    return;
                }
                String query = "INSERT INTO account VALUES('" + Username + "', '" + Name + "', '" + Password + "', '" + Question + "', '" + Answer + "')";
                c.s.executeUpdate(query);
        
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
        
        else  if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] argus){
        new Signup();

    }
}
