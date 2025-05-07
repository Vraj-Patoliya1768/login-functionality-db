package Travel_Managment_System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;

    Splash() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width ;
        int screenHeight = screenSize.height ;

        setSize(screenWidth, screenHeight);
        setLocation(0, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            
            Thread.sleep(3000);
            new Login(); 
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        new Splash();
    }
}
