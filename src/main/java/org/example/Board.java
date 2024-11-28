package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final int delay = 25;
    private final int tileSize = 50;
    private final int columns = 18;
    private final int rows = 12;

    private Timer timer;

    //create reference of player class

    public Board(){

        setPreferredSize(new Dimension(tileSize * columns, tileSize * rows));
        setBackground(new Color(232, 232, 232));

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
