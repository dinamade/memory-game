package org.cis1200.Matching;

import java.io.*;
import javax.swing.*;

public class AppFrame extends JFrame {
    public AppFrame(CardPanel panel) {
        this.setTitle("Remember your TAs");
        this.setSize(800, 800);

        JMenuBar menu = new JMenuBar();
        JMenu moreMenu = new JMenu("More");

        JMenuItem save = new JMenuItem("Save");

        save.addActionListener(e -> {
            new Thread(() -> {
                FileOutputStream fo;
                try {
                    fo = new FileOutputStream("files/progress.ser");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ObjectOutputStream oo;
                try {
                    oo = new ObjectOutputStream(fo);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    oo.writeObject(panel);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();

        });

        moreMenu.add(save);

        menu.add(moreMenu);
        this.setJMenuBar(menu);
        this.setVisible(true);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.pack();
    }

}
