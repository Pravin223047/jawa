package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tflname,tfphone,tfaddress,tfsalary,tfemail,tfeducation;
    JLabel labelname,heading,labelLname,labeldob,labelSalary,labeladdress,labelphone,labelemail,tfIdNum,JlAdharNum,JlIdNum,labeledu,lblname,dcdob,tfAdharNum;
    JButton update,back;
    String Idnum;
    
    UpdateEmployee(String Idnum) {
        setTitle("Update Employee");
        setSize(300, 150);
        this.Idnum = Idnum;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 250, 30);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        labelname = new JLabel("Name:-");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 200, 30);
        add(lblname);

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

        dcdob = new JLabel();
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

        tfAdharNum = new JLabel();
        tfAdharNum.setBounds(600, 300, 200, 30);
        add(tfAdharNum);

        JlIdNum = new JLabel("Employee ID:-");
        JlIdNum.setBounds(50, 350, 150, 30);
        JlIdNum.setFont(new Font("serif", Font.PLAIN, 20));
        add(JlIdNum);

        tfIdNum = new JLabel();
        tfIdNum.setFont(new Font("serif",Font.BOLD,25));
        tfIdNum.setBounds(200, 350, 200, 30);
        add(tfIdNum);

        labeledu = new JLabel("Qualification:-");
        labeledu.setBounds(450, 350, 150, 30);
        labeledu.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeledu);

        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 350, 200, 30);
        add(tfeducation);
        
        try{
            conn c = new conn();
            String query = "select * from employee where Idnum= '"+Idnum+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tflname.setText(rs.getString("lname"));
                dcdob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfIdNum.setText(rs.getString("Idnum"));
                tfeducation.setText(rs.getString("education"));
                tfAdharNum.setText(rs.getString("adhar"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        update = new JButton("Update Details");
        update.setBounds(250,550, 150, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
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
        if(ae.getSource() == update){
            String lname = tflname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            
            try{
                conn c= new conn();
                String query = "update employee set lname = '"+lname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"' where Idnum = '"+Idnum+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Sucessfully");
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
        new UpdateEmployee("");
    }
}
