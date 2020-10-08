package sample4.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Page1 {
    JFrame frame;
    JPanel panel;
    Page1()
    {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(0, 1000);
        frame.pack();
        frame.setTitle("College Predictor");
        frame.setBackground(Color.green);
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        Container c = frame.getContentPane();
        c.setLayout(null);
        Font font3 = new Font("BOLD", Font.CENTER_BASELINE,40);
        JLabel label7 = new JLabel("COLLEGE PREDICTOR");
        label7.setBounds(550,50,500,40);
        label7.setFont(font3);

        /*frame.setLayout(new BorderLayout());
        frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ayush\\Google Drive\\ideaprojects\\src\\sample4\\java\\Ayush.png")));
        frame.setLayout(new FlowLayout());*/

        ImageIcon i = new ImageIcon("C:\\Users\\ayush\\Google Drive\\ideaprojects\\src\\sample4\\java\\Ayush.png");
        JLabel label = new JLabel(i);
        label.setBounds(50,100,1500,400);
        frame.add(label);
        JLabel label6 = new JLabel("Terms and Conditions:");
        label6.setBounds(550,500,400,30);
        label6.setFont(new Font("BOLD",Font.CENTER_BASELINE,30));
        JLabel label5 = new JLabel("1) College predictor not take any guarantee for accuracy or completeness in the predictions.");
        label5.setBounds(300,550,850,30);
        label5.setFont(new Font("BOLD",Font.PLAIN,20));
        label5.setForeground(Color.BLUE);
        JLabel label4 = new JLabel("2) College predictor is not liable for any losses that occur due to the predictions.");
        label4.setBounds(300,575,800,30);
        label4.setForeground(Color.BLUE);
        label4.setFont(new Font("BOLD",Font.PLAIN,20));
        JLabel label3 = new JLabel("3) The users may verify before using information.");
        label3.setBounds(300,600,800,30);
        label3.setFont(new Font("BOLD",Font.PLAIN,20));
        label3.setForeground(Color.BLUE);
        c.add(label6);
        c.add(label7);
        c.add(label5);
        c.add(label4);
        c.add(label3);
       // c.add(label);

        JButton b1 = new JButton("NEXT ==>");
        b1.setBounds(500,700,300,30);
        b1.setFont(new Font("Arial", Font.PLAIN,30));
        c.add(b1);
        b1.addActionListener(this::actionPerformed);
    }
    public void actionPerformed(ActionEvent a)
    {
        frame.dispose();
        new prac9();
    }
}
