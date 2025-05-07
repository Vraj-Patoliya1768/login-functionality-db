package Travel_Managment_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Forgetpassword extends JFrame implements ActionListener{
    RTextField tfusername , tfname , c1 , tfAnswer,tfpassword;
    RButton search , retrive , back;
    

    Forgetpassword(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width ;
        int screenHeight = screenSize.height ;

        setSize(screenWidth, screenHeight);
        setLocation(0, 0);
        setLayout(null);
        //setBounds();
        getContentPane().setBackground(Color.WHITE);
        RPanel p1 = new RPanel(30, new Color(133,193,233));
        p1.setBounds(555,150,400,500);
        p1.setLayout(null);
        add(p1);

        JLabel lblRagister = new JLabel("Forget Password");
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

        search = new RButton("Search", 30); 
        search.setBounds(280,140,90,20);
        search.setFont(new Font("Roman",Font.BOLD , 14));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name : ");
        lblname.setBounds(25,180,130,30);
        lblname.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblname);
        tfname = new RTextField(10);
        tfname.setBounds(170,180,200,30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfname);

        JLabel lblSecurity = new JLabel("<html>Security<br>Question:</html>");
        lblSecurity.setBounds(25,220,130,70);
        lblSecurity.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblSecurity);
        c1= new RTextField(10);
        c1.setBounds(170,240,200,30);
        c1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(c1);

        
        JLabel lblanswer = new JLabel("Answer : ");
        lblanswer.setBounds(25,280,130,70);
        lblanswer.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblanswer);
        tfAnswer= new RTextField(10);
        tfAnswer.setBounds(170,300,200,30);
        tfAnswer.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfAnswer);

        retrive = new RButton("Retrive", 30); 
        retrive.setBounds(280,340,90,20);
        retrive.setFont(new Font("Roman",Font.BOLD , 14));
        retrive.setBorder(BorderFactory.createEmptyBorder());
        retrive.addActionListener(this);
        p1.add(retrive);

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(25,370,130,30);
        lblPassword.setFont(new Font("Roman",Font.BOLD , 20));
        p1.add(lblPassword);
        tfpassword = new RTextField(10);
        tfpassword.setBounds(170,370,200,30);
        tfpassword.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfpassword);

        back = new RButton("Back",30);
        back.setBounds(140,440,125,30);
        back.setFont(new Font("Roman",Font.BOLD , 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        Conn c = new Conn();
        if (ae.getSource() == search) {
            try {
                
                if (c.s == null) {
                    JOptionPane.showMessageDialog(null, "Statement is null. Database connection failed.");
                    return;
                }
        
                String query = "select * from account where username = '" + tfusername.getText() + "'";
                ResultSet st = c.s.executeQuery(query);
                boolean found = false;
                while (st.next()) {
                    tfname.setText(st.getString("name"));
                    c1.setText(st.getString("security"));
                    found = true;
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No user found with that username.");
                }
        
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while fetching user data.");
            }
        }
        else if(ae.getSource() == retrive){
            try{
                String querry = "select * from account where answer = '"+tfAnswer.getText()+"' and username = '"+tfusername.getText()+"'";
                ResultSet st = c.s.executeQuery(querry);
                boolean found = false;
                while (st.next()) {
                    tfpassword.setText(st.getString("password"));
                    found = true;
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "No user found with that username.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] arg)
    {
        new Forgetpassword();
    }
}
