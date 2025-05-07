package login_functionality;


import java.awt.*;

public class ScreenSize {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Width: " + screenSize.width);
        System.out.println("Height: " + screenSize.height);
    }
}