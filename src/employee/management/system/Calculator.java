package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Calculator extends JFrame implements ActionListener {

    Choice Idnum;
    JLabel labelname, lblname, labelphone, lblphone, labelemail, lblemail, salary, labeledu, rolls, roll, labelday, tfIdNum;
    JTextField rolls1, roll1, salary1;
    JComboBox cbedu, cbaedu;
    JButton clear, back, print, cal_sal;
    JDateChooser dcdob;
    double sal;
    int ral, prev;

    Calculator() {
        setTitle("Salary Calculator");
        setSize(300, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("Id Number");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        Idnum = new Choice();
        Idnum.setBounds(200, 50, 150, 30);
        add(Idnum);

        try {
            conn c = new conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                Idnum.add(rs.getString("Idnum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);

        labelemail = new JLabel("Email");
        labelemail.setBounds(50, 150, 100, 30);
        add(labelemail);

        lblemail = new JLabel();
        lblemail.setBounds(200, 150, 150, 30);
        add(lblemail);

        salary = new JLabel("Salary");
        salary.setFont(new Font("serif", Font.PLAIN, 20));
        salary.setBounds(300, 290, 250, 40);
        add(salary);

        salary1 = new JTextField();
        salary1.setEditable(false);
        salary1.setFont(new Font("serif", Font.PLAIN, 20));
        salary1.setBounds(400, 290, 150, 40);
        add(salary1);

        labeledu = new JLabel("Size of Item");
        labeledu.setBounds(450, 50, 250, 30);
        add(labeledu);

        String courses[] = {"1212", "1218", "1624", "1632", "1832", "2754", "3060"};
        cbedu = new JComboBox(courses);
        cbedu.setBackground(Color.WHITE);
        cbedu.setBounds(700, 50, 100, 30);
        add(cbedu);

        rolls = new JLabel("No of Total rolls");
        rolls.setBounds(450, 100, 250, 30);
        add(rolls);

        rolls1 = new JTextField();
        rolls1.setBounds(700, 100, 100, 30);
        add(rolls1);

        roll = new JLabel("No of second hand rolls");
        roll.setBounds(450, 150, 250, 30);
        add(roll);

        roll1 = new JTextField();
        roll1.setBounds(700, 150, 100, 30);
        add(roll1);

        JLabel JlIdNum = new JLabel("ID Number:-");
        JlIdNum.setBounds(50, 250, 100, 30);
        add(JlIdNum);

        tfIdNum = new JLabel();
        tfIdNum.setBounds(200, 250, 100, 30);
        add(tfIdNum);

        JLabel labeldob = new JLabel("Date:-");
        labeldob.setBounds(450, 200, 100, 30);
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(700, 200, 100, 30);
        add(dcdob);

        labelday = new JLabel("Day:-");
        labelday.setBounds(50, 200, 100, 30);
        add(labelday);

        String days[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        cbaedu = new JComboBox(days);
        cbaedu.setBackground(Color.WHITE);
        cbaedu.setBounds(200, 200, 100, 30);
        add(cbaedu);

        try {
            conn c = new conn();
            String query = "select * from employee where Idnum = '" + Idnum.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                tfIdNum.setText(rs.getString("Idnum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Idnum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from employee where Idnum = '" + Idnum.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblemail.setText(rs.getString("email"));
                        tfIdNum.setText(rs.getString("Idnum"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cal_sal = new JButton("Calculate");
        cal_sal.setBounds(160, 400, 120, 30);
        cal_sal.setBackground(Color.BLACK);
        cal_sal.setForeground(Color.WHITE);
        cal_sal.addActionListener(this);
        add(cal_sal);

        clear = new JButton("Clear");
        clear.setBounds(300, 400, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        print = new JButton("View Details");
        print.setBounds(440, 400, 120, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(580, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(870, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cal_sal) {
            int rolls = Integer.parseInt(rolls1.getText());
            int roll = Integer.parseInt(roll1.getText());

            if ((cbedu.getSelectedItem()) == "1212") {
                double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }
            else if((cbedu.getSelectedItem()) == "1218"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }
            else if((cbedu.getSelectedItem()) == "1218"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }else if((cbedu.getSelectedItem()) == "1624"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }else if((cbedu.getSelectedItem()) == "1632"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }else if((cbedu.getSelectedItem()) == "1832"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }else if((cbedu.getSelectedItem()) == "2754"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }else if((cbedu.getSelectedItem()) == "3060"){
            double rate = 2.7;
                ral = rolls;
                prev = rolls;
                if (roll < 10 && roll >= 0) {
                    sal = rolls * rate;
                } else if (roll <= 20 && roll >= 10) {
                    ral = ral - 1;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);

                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 1 roll since 2nd hand cloth produced is almost greater than 10% of total cloth produced.");
                } else {
                    ral = ral - 5;
                    ral = ral - roll;
                    sal = ral * rate;
                    String rol = String.valueOf(ral);
                    rolls1.setText(rol);
                    JOptionPane.showMessageDialog(null, "Deduction of 5 roll since 2nd hand cloth produced is almost greater than 30% of total cloth produced.");
                }
                System.out.println(sal);
                salary1.setText("      " + sal + "Rs.    ");
            }
        } else if (ae.getSource() == clear) {
            String Idnum = tfIdNum.getText();
            String name = lblname.getText();
            String email = lblemail.getText();
            String troll = String.valueOf(prev);
            String droll = roll1.getText();
            String rol = String.valueOf(ral);
            String size = (String) cbedu.getSelectedItem();
            String doa = (String) cbaedu.getSelectedItem();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salry = String.valueOf(sal);

            try {
                conn c = new conn();
                String query = "insert into recipt values('" + Idnum + "','" + name + "','" + email + "','" + dob + "','" + doa + "','" + size + "','" + troll + "','" + droll + "','" + rol + "','" + salry + "')";
                c.s.executeUpdate(query);
                setVisible(false);
            new Calculator();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == print) {
            setVisible(false);
                new View_recipt();
        } else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
