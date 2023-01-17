package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewClass extends JFrame implements ActionListener {
  JTextField hoursField;
  JTextField rateField;
  JButton calculateButton;
  JLabel resultLabel;

  public NewClass() {
    setTitle("Salary Calculator");
    setSize(300, 150);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    hoursField = new JTextField(10);
    rateField = new JTextField(10);
    calculateButton = new JButton("Calculate");
    resultLabel = new JLabel("Enter hours and rate to see the salary.");

    calculateButton.addActionListener(this);

    add(new JLabel("Hours:"));
    add(hoursField);
    add(new JLabel("Rate:"));
    add(rateField);
    add(calculateButton);
    add(resultLabel);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    double hours = Double.parseDouble(hoursField.getText());
    double rate = Double.parseDouble(rateField.getText());
    double salary = hours * rate;
    resultLabel.setText("Salary: $" + salary);
  }

  public static void main(String[] args) {
    new NewClass();
  }

}

