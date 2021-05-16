import java.awt.*;
import javax.swing.*;

public class Pong extends JPanel {

        int width;
        int height;

        float radius = 40;
        float diameter = radius * 2;

        float x = radius+50;
        float y = radius +20;

        float dx = 3;
        float dy = 3;


    public Pong(){

        Thread thread = new Thread(){
            public void run() {

                while (true) {



                }
            }
        };

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval((int)(x-radius), (int)(y-radius), (int)diameter, (int) diameter);
    }

    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setContentPane(new Pong());
        frame.setVisible(true);

    }

}
