package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Player implements CommonUtilities {

    private BufferedImage image;
    private Point pos;

    //Constructor
    public Player() {
        this.image = generateImage("src/main/resources/slimeimage.png");
        pos = new Point(0, 0);

    }

    public void draw(Graphics inGraphics, ImageObserver inObserver) {
        inGraphics.drawImage(image, pos.x, pos.y, 50, 50, inObserver);
    }

    /**
     * Method that registers what key has been pressed and change the position of the player
     *
     * @param inEvent - The event that has happened i.e key press.
     */
    public void keyPressed(KeyEvent inEvent) {

        int key = inEvent.getKeyCode();

        //vk is virtual key
        if (key == KeyEvent.VK_W) {
            pos.translate(0, -3);
        }
        if (key == KeyEvent.VK_D) {
            pos.translate(3, 0);
        }
        if (key == KeyEvent.VK_S) {
            pos.translate(0, 3);
        }
        if (key == KeyEvent.VK_A) {
            pos.translate(-3, 0);
        }
    }

    public void tick() {


        //TODO Need to set player boundaries based on the size of the window, although it might be an idea that once a player
        //  hits a certain area that it generates a new part of the map so return to this later
        //Setting player boundaries

        //Stops player from leaving the board
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= Board.columns * Board.tileSize) {
            pos.x = Board.columns - 1;
        }

        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= Board.rows * Board.tileSize) {
            pos.y = Board.rows - 1;
        }
    }
}
