package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import javax.swing.*;

public class GuiTest extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField inputFName = new JTextField("", 5);
    private JTextField inputLName = new JTextField("", 5);
    private JLabel labelF = new JLabel("FirstName");
    private JLabel labelL = new JLabel("LastName");

    public GuiTest (){
        super ("TEST");
        this.setBounds(150, 100, 750, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8, 5, 2,2));

        container.add(labelF);
        container.add(inputFName);

        container.add(labelL);
        container.add(inputLName);


        button.addActionListener(new ButtonEventListener ());
        container.add(button);
    }
    class ButtonEventListener implements  ActionListener{
        public void actionPerformed (ActionEvent e){
            String message = "Your number:\n";
            message +=Numbers(inputFName.getText()) + Numbers(inputLName.getText()) + "\n";

            message += "User:\n";
            message +=inputFName.getText() +"\n";
            message +=inputLName.getText() +"\n";
            JOptionPane.showMessageDialog(null, message, "output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    String Numbers (String data){
        String messages = "";
        try {
            int array = data.getBytes("UTF-8").length;
            messages =  array  +"";
        } catch (UnsupportedEncodingException array) {
            messages =  "0";
        }
        return messages;
    }
}