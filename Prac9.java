package app;

import database.CollegeDAO;
import database.CollegePredictorDAO;
import database.StudentDAO2;
import model.Student;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Prac9 implements ActionListener {
    JFrame frame;
    JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
    Container container;
    JTextField name, email, examName, rank;
    Font font, font2, font3;
    JRadioButton mains, advance, general, obc, scst;
    JButton close, predictCollege;
    ButtonGroup exam, category;
    JComboBox fieldCombo, stateCombo, feesCombo;
    String[] allFields;
    Student student;
    StudentDAO2 studentDAO2;
    // CollegePredictorDAO collegePredictorDAO;
    CollegeDAO collegeDAO;

    public Prac9(StudentDAO2 studentDAO2, CollegeDAO collegeDAO) {
        this.studentDAO2 = studentDAO2;
        this.collegeDAO = collegeDAO;
    }

    public void nextPage() {

        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(0, 1000);
        frame.setTitle("College Predictor");
        container = frame.getContentPane();
        container.setLayout(null);

        label = new JLabel("NAME : ");
        label.setBounds(100, 50, 200, 30);
        name = new JTextField();
        name.setBounds(300, 50, 200, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        font = new Font("Arial", Font.BOLD, 30);
        font2 = new Font("Arial", Font.PLAIN, 20);
        label.setFont(font);
        container.add(label);
        container.add(name);

        label1 = new JLabel("EMAIL : ");
        label1.setBounds(100, 100, 200, 30);
        email = new JTextField();
        email.setBounds(300, 100, 300, 30);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setFont(font);
        container.add(label1);
        container.add(email);
        // public void actionPerformed(ActionEvent event)
        label2 = new JLabel("MOBILE NO.: ");
        label2.setBounds(100, 150, 300, 30);
        examName = new JTextField();
        examName.setBounds(300, 150, 200, 30);
        examName.setFont(new Font("Arial", Font.PLAIN, 20));
        label2.setFont(font);
        container.add(label2);
        container.add(examName);

        label3 = new JLabel("EXAM NAME: ");
        label3.setBounds(100, 200, 300, 30);
        label3.setFont(font);
        container.add(label3);

        mains = new JRadioButton("JEE MAINS");
        mains.setBounds(100, 250, 300, 30);
        mains.setFont(font2);

        advance = new JRadioButton("JEE ADVANCE");
        advance.setBounds(100, 300, 400, 30);
        advance.setFont(font2);
        exam = new ButtonGroup();
        exam.add(mains);
        exam.add(advance);
        container.add(mains);
        container.add(advance);

        label4 = new JLabel("CATEGORY: ");
        label4.setBounds(100, 350, 300, 30);
        label4.setFont(font);
        container.add(label4);

        general = new JRadioButton("GENERAL");
        general.setBounds(100, 400, 300, 30);
        general.setFont(font2);

        obc = new JRadioButton("OBC");
        obc.setBounds(100, 450, 300, 30);
        obc.setFont(font2);

        scst = new JRadioButton("SC/ST");
        scst.setBounds(100, 500, 300, 30);
        scst.setFont(font2);

        category = new ButtonGroup();
        category.add(general);
        category.add(obc);
        category.add(scst);
        container.add(general);
        container.add(obc);
        container.add(scst);

        label5 = new JLabel("EXAM RANK: ");
        label5.setBounds(100, 550, 300, 30);
        rank = new JTextField();
        rank.setBounds(300, 550, 200, 30);
        rank.setFont(font2);
        label5.setFont(font);
        container.add(label5);
        container.add(rank);

        label6 = new JLabel("CHOOSE FIELD: ");
        label6.setBounds(900, 350, 300, 30);
        //java.util.List<String> fields = collegeDAO.getFields();
        // String a[] = fields.toArray(new String[fields.size()]);
        String a[] = {"Chemical Engineering","Civil Engineering","Computer Science and Engineering","Electrical Engineering","Electronics and Communication Engineering","Mechanical Engineering","Bio Technology","Artificial intelligence","Biotechnology and Biochemical Engineering","Electrical and Electronics Engineering","Mining Engineering","Aerospace Engineering"};
        allFields = a;
        fieldCombo = new JComboBox(a);
        fieldCombo.setBounds(900, 400, 300, 30);
        label6.setFont(font);
        container.add(label6);
        container.add(fieldCombo);
        container.revalidate();

        predictCollege = new JButton("PREDICT COLLEGE-->");
        predictCollege.setBounds(800, 650, 300, 30);
        predictCollege.setFont(font2);
        container.add(predictCollege);
        predictCollege.addActionListener(this);

        close = new JButton("<--PREVIOUS");
        close.setBounds(300, 650, 300, 30);
        close.setFont(font2);
        container.add(close);
        close.addActionListener(this);

        label7 = new JLabel("");
        label7.setBounds(100, 700, 800, 100);
        label7.setFont(new Font("Arial", Font.BOLD, 25));
        label7.setForeground(Color.RED);
        container.add(label7);

        label8 = new JLabel("SELECT STATE:");
        label8.setBounds(900, 150, 400, 30);
        label8.setFont(font);
        container.add(label8);
        java.util.List<String> states = collegeDAO.getStates();
        String m[] = states.toArray(new String[states.size()]);
        stateCombo = new JComboBox(m);
        stateCombo.setBounds(900, 200, 300, 30);
        container.add(stateCombo);
        container.revalidate();

        label9 = new JLabel("SELECT RANGE OF FEES:");
        label9.setBounds(900, 250, 400, 30);
        label9.setFont(font);
        container.add(label9);
        String n[] = {"ANY FEES", "upto 5 lacs", "upto 10 lacs"};
        feesCombo = new JComboBox(n);
        feesCombo.setBounds(900, 300, 300, 30);
        container.add(feesCombo);
        container.revalidate();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("PREDICT COLLEGE-->")) {
            boolean check = false;
            boolean pack = false;
            int fieldIndex = fieldCombo.getSelectedIndex();
            String stateName = stateCombo.getSelectedItem().toString();
            String[] fees = {"ANY FEES", "500000", "1000000"};
            int fieldName = feesCombo.getSelectedIndex();
            String nameOfField = fieldCombo.getSelectedItem().toString();
            System.out.print(nameOfField);
            int rank = parseInt(this.rank.getText());
            String name = this.name.getText();
            String email = this.email.getText();
            String phone = examName.getText();
            // Store in database


            if (advance.isSelected()) {
                pack = true;
                if (general.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, advance.getText(), general.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                } else if (obc.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, advance.getText(), obc.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                } else {
                    check = true;
                    student = new Student(name, phone, email, rank, advance.getText(), scst.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                }
            } else if (mains.isSelected()) {
                pack = true;
                if (general.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, mains.getText(), general.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                } else if (obc.isSelected()) {
                    check = true;
                    student = new Student(name, phone, email, rank, mains.getText(), obc.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                } else {
                    check = true;
                    student = new Student(name, phone, email, rank, mains.getText(), scst.getText(), fieldCombo.getSelectedItem().toString(), stateCombo.getSelectedItem().toString(), feesCombo.getSelectedItem().toString());
                }
            }
            try {
                studentDAO2.insert(student);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//
//            studentDAO2.search(name);
            if (new Validator().check(name, email, phone, rank) & check & pack) {
                frame.dispose();
                if (advance.isSelected()) {
                    if (general.isSelected())
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "General", this.studentDAO2,this.collegeDAO);
                    else if (obc.isSelected())
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "OBC", this.studentDAO2,this.collegeDAO);
                    else
                        new Page3(allFields, fieldIndex, stateName, fees[fieldName], rank, "SC/ST", this.studentDAO2,this.collegeDAO);
                } else if (mains.isSelected()) {
                    if (general.isSelected())
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "General", this.studentDAO2,this.collegeDAO);
                    else if (obc.isSelected())
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "OBC", this.studentDAO2,this.collegeDAO);
                    else
                        new Page3m(allFields, fieldIndex, stateName, fees[fieldName], rank, "SC/ST", this.studentDAO2,this.collegeDAO);
                }
            } else {
                label7.setText("INCORRECT  EMAIL , NAME , MOBILE NUMBER OR RANK");
            }
        } else if (ae.getActionCommand().equals("<--PREVIOUS")) {
            frame.dispose();
            Page1 page1 = new Page1(this.studentDAO2, this.collegeDAO);
            page1.runApplication();
        }

    }
}