package sample4.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Page3m {
    JButton b1;
    Font font2;
    JFrame frame;
    Page3m(String[] a,int b,String t,String u,int r,String w)
    {

         frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(0, 1000);
        frame.setTitle("College Predictor");
        Container c = frame.getContentPane();
        c.setLayout(null);

        font2 = new Font("Arial", Font.PLAIN,20);

        JLabel label8 = new JLabel("YOU HAVE A CHANCE IN THIS COLLEGE AS PER YOUR CRITERIA:");
        label8.setBounds(100,20,1200,40);
        label8.setFont(new Font("Arial", Font.CENTER_BASELINE,30));
        c.add(label8);
        ArrayList<String> list[] = new ArrayList[4];
        list = new Trym().cry(a,a[b],r,w);

        int k = 1;
        int f = 150;
        Iterator m = list[0].iterator();
        JButton[] x = new JButton[list[0].size()];
        JLabel label0,label,label1,label2,label3,label4,label5,label6;
        label0 = new JLabel("COLLEGE NAME");
        label0.setBounds(100,100,300,30);
        label0.setFont(new Font("Arial", Font.BOLD,30));
        c.add(label0);
        label2 = new JLabel("STATE");
        label2.setBounds(400,100,300,30);
        label2.setFont(new Font("Arial", Font.BOLD,30));
        c.add(label2);
        label4 = new JLabel("NRIF RANK");
        label4.setBounds(600,100,300,30);
        label4.setFont(new Font("Arial", Font.BOLD,30));
        c.add(label4);
        label5 = new JLabel("COLLEGE FEES(4 YRS)");
        label5.setBounds(900,100,350,30);
        label5.setFont(new Font("Arial", Font.BOLD,30));
        c.add(label5);
        if(list[0].isEmpty())
        {
            label = new JLabel("BETTER LUCK NEXT TIME !");
            label.setBounds(200, f+30, 600, 30);
            label.setFont(new Font("Arial", Font.PLAIN, 30));
            label.setForeground(Color.RED);
            c.add(label);
        }
        else if(t.equals("ANY STATE") && u.equals("ANY FEES")) {
            while (m.hasNext()) {
                label = new JLabel(k + ") " + m.next().toString());
                label.setBounds(100, f, 300, 30);
                label.setFont(new Font("Arial", Font.PLAIN, 20));
                label.setForeground(Color.BLUE);
                label1 = new JLabel(list[1].get(k - 1));
                label1.setBounds(400, f, 300, 30);
                label1.setFont(new Font("Arial", Font.PLAIN, 20));
                label1.setForeground(Color.BLUE);
                label3 = new JLabel(list[2].get(k - 1));
                label3.setBounds(600, f, 300, 30);
                label3.setFont(new Font("Arial", Font.PLAIN, 20));
                label3.setForeground(Color.BLUE);
                c.add(label3);
                label6 = new JLabel(list[3].get(k - 1));
                label6.setBounds(900, f, 300, 30);
                label6.setFont(new Font("Arial", Font.PLAIN, 20));
                label6.setForeground(Color.BLUE);
                c.add(label6);
                c.add(label);
                c.add(label1);

                k++;
                f += 30;
            }
        }
        else if(list[1].contains(t) || list[3].contains(u))
        {
            int z = list[1].indexOf(t);
            label = new JLabel(list[0].get(z));
            label.setBounds(100,f+50,300,30);
            label.setFont(new Font("Arial", Font.PLAIN,20));
            label.setForeground(Color.BLUE);
            label1 = new JLabel(t);
            label1.setBounds(400,f+50,300,30);
            label1.setFont(new Font("Arial", Font.PLAIN,20));
            label1.setForeground(Color.BLUE);
            label3 = new JLabel(list[2].get(z));
            label3.setBounds(600,f+50,300,30);
            label3.setFont(new Font("Arial", Font.PLAIN,20));
            label3.setForeground(Color.BLUE);
            c.add(label3);
            label6 = new JLabel(list[3].get(z));
            label6.setBounds(900,f+50,300,30);
            label6.setFont(new Font("Arial", Font.PLAIN,20));
            label6.setForeground(Color.BLUE);
            c.add(label6);
            c.add(label);
            c.add(label1);
        }

        else if(t.equals("ANY STATE") && !(u.equals("ANY FEES")))
        {
            for(int i =0; i<list[3].size(); i++)
                if (Integer.parseInt(u) >= Integer.parseInt(list[3].get(i)))
                {
                    label = new JLabel(list[0].get(i));
                    label.setBounds(100, f, 300, 30);
                    label.setFont(new Font("Arial", Font.PLAIN, 20));
                    label.setForeground(Color.BLUE);
                    label1 = new JLabel(list[1].get(i));
                    label1.setBounds(400, f, 300, 30);
                    label1.setFont(new Font("Arial", Font.PLAIN, 20));
                    label1.setForeground(Color.BLUE);
                    label3 = new JLabel(list[2].get(i));
                    label3.setBounds(600, f, 300, 30);
                    label3.setFont(new Font("Arial", Font.PLAIN, 20));
                    label3.setForeground(Color.BLUE);
                    c.add(label3);
                    label6 = new JLabel(list[3].get(i));
                    label6.setBounds(900, f, 300, 30);
                    label6.setFont(new Font("Arial", Font.PLAIN, 20));
                    label6.setForeground(Color.BLUE);
                    c.add(label6);
                    c.add(label);
                    c.add(label1);
                    f+=30;
                }
        }
        b1 = new JButton("CLOSE");
        b1.setBounds(500,700,300,30);
        b1.setFont(font2);
        c.add(b1);
        b1.addActionListener(this::actionPerformed);
    }
    public void actionPerformed(ActionEvent a) {
        frame.dispose();
    }
}

