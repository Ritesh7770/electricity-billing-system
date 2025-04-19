# electricity-billing-system
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInformation extends JFrame implements ActionListener {
    String meterNumber;
    JButton cancel;

    ViewInformation(String meterNumber) {
        this.meterNumber = meterNumber;

        // Set window title, size, and background color
        setTitle("View Customer Information");
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // Absolute positioning layout

        // Add heading label
        JLabel heading = new JLabel("View Customer Information");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        add(heading);

        // Add name label
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(70, 80, 100, 20);
        add(nameLabel);

        JLabel nameLabelText = new JLabel();
        nameLabelText.setBounds(200, 80, 150, 20);
        add(nameLabelText);

        // Add meter number label
        JLabel meterno = new JLabel("Meter Number");
        meterno.setBounds(70, 140, 100, 20);
        add(meterno);

        JLabel meternoText = new JLabel();
        meternoText.setBounds(200, 140, 150, 20);
        add(meternoText);

        // Add address label
        JLabel address = new JLabel("Address");
        address.setBounds(70, 200, 100, 20);
        add(address);

        JLabel addressText = new JLabel();
        addressText.setBounds(200, 200, 150, 20);
        add(addressText);

        // Add city label
        JLabel city = new JLabel("City");
        city.setBounds(70, 260, 100, 20);
        add(city);

        JLabel cityText = new JLabel();
        cityText.setBounds(200, 260, 150, 20);
        add(cityText);

        // Add state label
        JLabel state = new JLabel("State");
        state.setBounds(500, 80, 100, 20);
        add(state);

        JLabel stateText = new JLabel();
        stateText.setBounds(600, 80, 150, 20);
        add(stateText);

        // Add email label
        JLabel email = new JLabel("Email");
        email.setBounds(500, 140, 100, 20);
        add(email);

        JLabel emailText = new JLabel();
        emailText.setBounds(600, 140, 150, 20);
        add(emailText);

        // Add phone label
        JLabel phone = new JLabel("Phone");
        phone.setBounds(500, 200, 100, 20);
        add(phone);

        JLabel phoneText = new JLabel();
        phoneText.setBounds(600, 200, 150, 20);
        add(phoneText);

        // 🧪 Hardcoded sample customer info
        if (meterNumber.equals("123456")) {
            nameLabelText.setText("John Doe");
            meternoText.setText("123456");
            addressText.setText("123 Main Street");
            cityText.setText("New York");
            stateText.setText("NY");
            emailText.setText("john.doe@example.com");
            phoneText.setText("9876543210");
        } else {
            JOptionPane.showMessageDialog(this, "Customer not found.");
        }

        // Add cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(24, 118, 242));
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 350, 120, 25);
        cancel.addActionListener(this);
        add(cancel);

        // Set the window to close properly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewInformation("123456"); // Test with the meter number "123456"
    }
}
