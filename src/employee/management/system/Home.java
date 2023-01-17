package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove, calculator,attendance,viewattendance;

    Home() {
        setTitle("Home");
        setSize(300, 150);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(820, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(650, 260, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        calculator = new JButton("Salary Calculator");
        calculator.setBounds(650, 140, 150, 40);
        calculator.addActionListener(this);
        image.add(calculator);

        attendance = new JButton("Attendance");
        attendance.setBounds(650, 200, 150, 40);
        attendance.addActionListener(this);
        image.add(attendance);
        
        viewattendance = new JButton("View Attendance");
        viewattendance.setBounds(820, 200, 150, 40);
        viewattendance.addActionListener(this);
        image.add(viewattendance);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == calculator) {
            setVisible(false);
            new Calculator();
        } else if (ae.getSource() == attendance) {
            setVisible(false);
            new Attendance();
        }else if (ae.getSource() == viewattendance) {
            setVisible(false);
            new ViewAttendance();
        }
    }

    public static void main(String args[]) {
        new Home();
    }

}
