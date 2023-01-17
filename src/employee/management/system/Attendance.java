package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Attendance extends JFrame implements ActionListener {
    
    Choice Idnum;
    JButton add, back;
    JComboBox cbedu,cbaedu;
    JDateChooser dcdob;
    JLabel lblname,lbllname,lblphone,lblemail,tfIdNum,labelday;
    
    Attendance() {
        setTitle("Attendance");
        setSize(300, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelIdnum = new JLabel("Id Number");
        labelIdnum.setBounds(50, 50, 100, 30);
        add(labelIdnum);
        
        Idnum = new Choice();
        Idnum.setBounds(200, 50, 150, 30);
        add(Idnum);
        
        try {
            conn c = new conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                Idnum.add(rs.getString("Idnum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 200, 100, 30);
        add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(200, 200, 100, 30);
        add(lblphone);
        
        JLabel labellname = new JLabel("Last Name");
        labellname.setBounds(50, 150, 100, 30);
        add(labellname);
        
        lbllname = new JLabel();
        lbllname.setBounds(200, 150, 100, 30);
        add(lbllname);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 250, 100, 30);
        add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(200, 250, 100, 30);
        add(lblemail);
        
        JLabel labeledu = new JLabel("Attendance:-");
        labeledu.setBounds(50, 350, 100, 30);
        add(labeledu);

        String courses[] = {"PRESENT","ABSENT"};
        cbedu = new JComboBox(courses);
        cbedu.setBackground(Color.WHITE);
        cbedu.setBounds(200, 350, 100, 30);
        add(cbedu);
        
        JLabel JlIdNum = new JLabel("ID Number:-");
        JlIdNum.setBounds(50, 300, 100, 30);
        add(JlIdNum);

        tfIdNum = new JLabel();
        tfIdNum.setBounds(200, 300, 100, 30);
        add(tfIdNum);
        
        JLabel labeldob = new JLabel("Date:-");
        labeldob.setBounds(50, 400, 100, 30);
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 400, 100, 30);
        add(dcdob);
        
        labelday = new JLabel("Day:-");
        labelday.setBounds(50, 450, 100, 30);
        add(labelday);

        String days[] = { "SUNDAY","MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        cbaedu = new JComboBox(days);
        cbaedu.setBackground(Color.WHITE);
        cbaedu.setBounds(200, 450, 200, 30);
        add(cbaedu);
        
        try {
            conn c = new conn();
            String query = "select * from employee where Idnum = '"+Idnum.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lbllname.setText(rs.getString("lname"));
                lblphone.setText(rs.getString("phone"));
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
                    String query = "select * from employee where Idnum = '"+Idnum.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lbllname.setText(rs.getString("lname"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                        tfIdNum.setText(rs.getString("Idnum"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        add = new JButton("Add Details");
        add.setBounds(50, 550, 100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(200, 550, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 800);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = lblname.getText();
            String lname = lbllname.getText();
            String phone = lblphone.getText();
            String email = lblemail.getText();
            String attendance = (String) cbedu.getSelectedItem();
            String Idnum = tfIdNum.getText();
            String doa = (String) cbaedu.getSelectedItem();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
            try {
                conn c = new conn();
                String query = "insert into attendance values('"+Idnum+"','"+name+"','"+lname+"','"+phone+"','"+email+"','"+attendance+"','"+doa+"','"+dob+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Attendance Modified Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new Attendance();
    }
}
