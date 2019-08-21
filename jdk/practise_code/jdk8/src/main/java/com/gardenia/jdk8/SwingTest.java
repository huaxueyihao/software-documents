package com.gardenia.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public static void main(String[] args) {

        JFrame jframe = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");

//        jButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Pressed!");
//            }
//        });

        jButton.addActionListener(event -> {
            System.out.println("Button Pressed!");
            System.out.println("Button Pressed!");
            System.out.println("Button Pressed!");
        });

        jframe.add(jButton);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
