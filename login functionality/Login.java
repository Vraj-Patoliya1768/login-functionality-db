package Travel_Managment_System;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener
{
    RTextField tfusername , tfpass;
    RButton login , signup , forgotpass;
    Login(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width ;
        int screenHeight = screenSize.height ;

        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        RPanel p1 = new RPanel(30, new Color(133,193,233));
        p1.setBounds(555,150,400,450);
        p1.setLayout(null);
        add(p1);
        
        
        JLabel lblhead = new JLabel("User Login");
        lblhead.setBounds(135,20,500,30);
        lblhead.setFont(new Font("Roman",Font.BOLD , 25));
        p1.add(lblhead);

        JLabel lblUsername = new JLabel("User Name : ");
        lblUsername.setBounds(50,100,500,30);
        lblUsername.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblUsername);
        tfusername = new RTextField(10);
        tfusername.setBounds(50,136,300,30);
        tfusername.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfusername);

        JLabel lblpass = new JLabel("Password : ");
        lblpass.setBounds(50,185,500,30);
        lblpass.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblpass);
        tfpass = new RTextField(10);
        tfpass.setBounds(50,220,300,30);
        tfpass.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfpass);

        login = new RButton("Login",30);
        login.setBounds(50,300,125,30);
        login.setFont(new Font("Roman",Font.BOLD , 15));
        login.addActionListener(this);
        login.setBorder(BorderFactory.createEmptyBorder());

        p1.add(login);

        signup = new RButton("Sign Up",30);
        signup.setBounds(225,300,125,30);
        signup.setFont(new Font("Roman",Font.BOLD , 15));
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p1.add(signup);

        forgotpass = new RButton("Forgot Password",30);
        forgotpass.setBounds(50,360,300,30);
        forgotpass.setFont(new Font("Roman",Font.BOLD , 15));
        forgotpass.setBorder(BorderFactory.createEmptyBorder());
        forgotpass.addActionListener(this);
        p1.add(forgotpass);

        JLabel text = new JLabel("Trouble In Login....");
        text.setBounds(225,410,1000,30);
        text.setFont(new Font("Roman",Font.BOLD , 18));
        text.setForeground(Color.red);
        p1.add(text);

      
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login) {
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM account WHERE username = '" + tfusername.getText() + "' AND password = '" + tfpass.getText() + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            try{
                setVisible(false);
                new Signup();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == forgotpass){
            try{
                setVisible(false);
                new Forgetpassword();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] argus){
        new Login();
    }
}
