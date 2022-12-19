package org.cis1200.Matching;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LaunchApp implements Runnable {
    JFrame launchFrame = new JFrame();
    JButton launchButton = new JButton("Launch");
    JButton savedButton = new JButton("Last game");

    public void run() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("Launch.png"));

        launchButton.setBounds(75, 300, 100, 35);
        savedButton.setBounds(225, 300, 100, 35);

        launchButton.setFocusable(false);
        launchButton.addActionListener(e -> {
            launchFrame.dispose();
            new AppFrame(new CardPanel());
        });
        savedButton.addActionListener(e -> {
            FileInputStream fi;
            try {
                fi = new FileInputStream("files/progress.ser");
            } catch (FileNotFoundException ex) {
                return;
            }
            ObjectInputStream oi;
            try {
                oi = new ObjectInputStream(fi);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                CardPanel myCardPanel = (CardPanel) oi.readObject();
                myCardPanel.addListeners();
                launchFrame.dispose();
                new AppFrame(myCardPanel);
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        launchFrame.add(launchButton);
        launchFrame.add(savedButton);
        launchFrame.add(label);
        launchFrame.pack();

        launchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launchFrame.setSize(400, 400);
        launchFrame.setLocationRelativeTo(null);
        launchFrame.setLayout(new BorderLayout());
        launchFrame.setVisible(true);
    }
}
