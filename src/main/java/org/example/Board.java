package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel implements ActionListener, KeyListener {

    public final int delay = 25;
    public static final int tileSize = 50;
    public static final int columns = 18;
    public static final int rows = 12;
    private final Player player;
    private BufferedImage background;

    private Timer timer;

    public Board() {

        setPreferredSize(new Dimension(tileSize * columns, tileSize * rows));
        setBackground(new Color(232, 232, 232));

        timer = new Timer(delay, this);
        timer.start();
        player = new Player();

    }

    //TODO Work on this as I don't feel as if the boundaries are correct
    private void drawBackground(Graphics inGraphics) {
        try {
            this.background = ImageIO.read(new File("src/main/resources/tilemap.png"));
        } catch (IOException exception) {
            System.out.println("Error opening file" + exception.getMessage());
        }

        inGraphics.drawImage(background,0,0, tileSize * columns, tileSize * rows, null );
    }

    @Override
    public void actionPerformed(ActionEvent inAction) {

        player.tick();
        repaint();
    }

    @Override
    public void paintComponent(Graphics inGraphics) {
        super.paintComponent(inGraphics);

        drawBackground(inGraphics);

        player.draw(inGraphics, this);

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        //Unused method
    }

    @Override
    public void keyPressed(KeyEvent e) {

        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //React to key release
    }
}
