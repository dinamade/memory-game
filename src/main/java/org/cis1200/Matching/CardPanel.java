package org.cis1200.Matching;

import javax.swing.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.*;

public class CardPanel extends JPanel implements Serializable {
    private int lastClick = -1;

    private final JButton[][] buttons;

    List<String> fronts;

    ImageIcon back = new ImageIcon("back.png");

    CardPanel() {
        buttons = new JButton[4][4];
        this.setLayout(new GridLayout(4, 4));
        fronts = Arrays.asList(
                "pic1.png", "pic1.png",
                "pic2.png", "pic2.png",
                "pic3.png", "pic3.png",
                "pic4.png", "pic4.png",
                "pic5.png", "pic5.png",
                "pic6.png", "pic6.png",
                "pic7.png", "pic7.png",
                "pic8.png", "pic8.png"
        );
        Collections.shuffle(fronts);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(back);
                this.add(buttons[i][j]);
            }
        }
        addListeners();
    }

    public void addListeners() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addActionListener(e -> {
                    int b = finalI * 4 + finalJ;
                    if (lastClick == -1) {
                        buttons[finalI][finalJ].setIcon(new ImageIcon(fronts.get(b)));
                        lastClick = b;
                    } else {
                        if (fronts.get(b).equals(fronts.get(lastClick))) {
                            buttons[finalI][finalJ].setIcon(new ImageIcon(fronts.get(b)));
                            buttons[lastClick / 4][lastClick % 4]
                                    .setIcon(new ImageIcon(fronts.get(b)));
                        } else {
                            buttons[finalI][finalJ].setIcon(back);
                            buttons[lastClick / 4][lastClick % 4].setIcon(back);
                        }
                        lastClick = -1;
                    }

                });
            }
        }

    }

}