import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaSwing {

    public static void main(String[] args){

        //simpleWindow();
        //jButtonExample();
        //imageButton();
        //labelExample();
        new LabelExample2();

    }

    public static void simpleWindow(){
        JFrame f = new JFrame();

        JButton b = new JButton("click");
        b.setBounds(130,100,100,40);

        f.add(b);

        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);

    }


    public static void jButtonExample(){

        JFrame f = new JFrame("Button example!");

        final JTextField tf = new JTextField();
        tf.setBounds(50,50,150,20);

        JButton b = new JButton("Click Here");
        b.setBounds(50,100,95,30);

        b.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e) {
                tf.setText("Welcome to whatever");

        }
    });

        f.add(b);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void imageButton(){

        JFrame f = new JFrame("Image Button");
        JButton b = new JButton(new ImageIcon("src\\red.png"));
        b.setBounds(100,100,100,40);
        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void labelExample(){

        JFrame f = new JFrame("Label example");
        JLabel l1 = new JLabel("First label");
        JLabel l2 = new JLabel("Second label");
        l1.setBounds(50,50,100,30);
        l2.setBounds(50,100,100,30);
        f.add(l1); f.add(l2);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class LabelExample2 extends Frame implements ActionListener {

    JTextField tf;
    JLabel l;
    JButton b;

    LabelExample2(){

        tf=new JTextField();
        tf.setBounds(50,50,150,20);
        l=new JLabel();
        l.setBounds(50,100,250,20);
        b=new JButton("Find IP");
        b.setBounds(50,150,95,30);
        b.addActionListener(this);
        add(b);
        add(tf);
        add(l);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            String host = tf.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            l.setText("IP of " + host + " is " + ip);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
