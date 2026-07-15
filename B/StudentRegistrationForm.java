import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel lblName, lblEmail, lblCourse, lblGender;
    JTextField txtName, txtEmail;
    JComboBox<String> courseBox;
    JRadioButton male, female;
    ButtonGroup bg;
    JButton btnSubmit, btnReset;

    StudentRegistrationForm() {

        setTitle("Student Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new GridLayout(6, 2, 5, 5));

        // Labels
        lblName = new JLabel("Student Name:");
        lblEmail = new JLabel("Email:");
        lblCourse = new JLabel("Course:");
        lblGender = new JLabel("Gender:");

        // Text Fields
        txtName = new JTextField();
        txtEmail = new JTextField();

        // Combo Box
        String courses[] = {"Select Course", "BCA", "BIM", "BIT", "CSIT"};
        courseBox = new JComboBox<>(courses);

        // Radio Buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        // Buttons
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");

        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);

        // Add Components
        add(lblName);
        add(txtName);

        add(lblEmail);
        add(txtEmail);

        add(lblCourse);
        add(courseBox);

        add(lblGender);
        add(genderPanel);

        add(btnSubmit);
        add(btnReset);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSubmit) {

            String name = txtName.getText();
            String email = txtEmail.getText();

            if (name.isEmpty() || email.isEmpty() || courseBox.getSelectedIndex() == 0 || bg.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
                return;
            }

            String gender = male.isSelected() ? "Male" : "Female";

            String message = "Student Name: " + name +
                    "\nEmail: " + email +
                    "\nCourse: " + courseBox.getSelectedItem() +
                    "\nGender: " + gender;

            JOptionPane.showMessageDialog(this, message);
        }

        if (e.getSource() == btnReset) {

            txtName.setText("");
            txtEmail.setText("");
            courseBox.setSelectedIndex(0);
            bg.clearSelection();
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}