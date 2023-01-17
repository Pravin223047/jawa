package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname,tflname,tfphone,tfaddress,tfsalary,tfemail,tfAdharNum;
    JDateChooser dcdob;
    JLabel labelname,heading,labelLname,labeldob,labelSalary,labeladdress,labelphone,labelemail,tfIdNum,JlAdharNum,JlIdNum,labeledu;
    JComboBox cbedu;
    JButton add,back;
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    AddEmployee() {
        setTitle("Add Employee");
        setSize(300, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 250, 30);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        labelname = new JLabel("Name:-");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 200, 30);
        add(tfname);

        labelLname = new JLabel("Last Name:-");
        labelLname.setBounds(450, 150, 150, 30);
        labelLname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelLname);

        tflname = new JTextField();
        tflname.setBounds(600, 150, 200, 30);
        add(tflname);

        labeldob = new JLabel("Date Of Birth:-");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 200, 30);
        add(dcdob);

        labelSalary = new JLabel("Salary:-");
        labelSalary.setBounds(450, 200, 150, 30);
        labelSalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelSalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 200, 30);
        add(tfsalary);

        labeladdress = new JLabel("Address:-");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        add(tfaddress);

        labelphone = new JLabel("Phone:-");
        labelphone.setBounds(450, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 200, 30);
        add(tfphone);

        labelemail = new JLabel("Email:-");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 200, 30);
        add(tfemail);

        JlAdharNum = new JLabel("Adhar Number:-");
        JlAdharNum.setBounds(450, 300, 150, 30);
        JlAdharNum.setFont(new Font("serif", Font.PLAIN, 20));
        add(JlAdharNum);

        tfAdharNum = new JTextField();
        tfAdharNum.setBounds(600, 300, 200, 30);
        add(tfAdharNum);

        JlIdNum = new JLabel("Employee ID:-");
        JlIdNum.setBounds(50, 350, 150, 30);
        JlIdNum.setFont(new Font("serif", Font.PLAIN, 20));
        add(JlIdNum);

        tfIdNum = new JLabel(""+number);
        tfIdNum.setFont(new Font("serif",Font.BOLD,25));
        tfIdNum.setBounds(200, 350, 200, 30);
        add(tfIdNum);

        labeledu = new JLabel("Qualification:-");
        labeledu.setBounds(450, 350, 150, 30);
        labeledu.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeledu);

        String courses[] = {"NONE", "BCA", "BBA", "BSC", "BA", "BTECH", "BCOM", "MCA", "MBA", "MSC", "MA", "MTECH", "MCOM", "PHD", "DIPLOMA"};
        cbedu = new JComboBox(courses);
        cbedu.setBackground(Color.WHITE);
        cbedu.setBounds(600, 350, 200, 30);
        add(cbedu);

        add = new JButton("Add Details");
        add.setBounds(250,550, 150, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String name = tfname.getText();
            String lname = tflname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String Idnum = tfIdNum.getText();
            String education = (String) cbedu.getSelectedItem();
            String adhar = tfAdharNum.getText();
            
            try{
                conn c= new conn();
                String query = "insert into employee values('"+name+"','"+lname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+Idnum+"','"+education+"','"+adhar+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added Sucessfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]) {
        new AddEmployee();
    }
}
