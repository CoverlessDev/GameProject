package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
public class Player implements CommonUtilities {

    public BufferedImage image;
    private Point pos;

    private Graphics graphics;
    private ImageObserver observer;

    PlayerAnimation animation = new PlayerAnimation();

    //Empty consutrctpr
    public Player(){

    }
    //Constructor
    public Player(BufferedImage image) {
        this.image = generateImage("src/main/resources/Slime2.png");
        pos = new Point(0, 0);

    }

    public void changeFrame(BufferedImage image) {
        this.image = image;
        draw(graphics, observer);
    }

    public void draw(Graphics inGraphics, ImageObserver inObserver) {
        this.graphics = inGraphics;
        this.observer = inObserver;

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
            pos.translate(0, -7);

        }
        if (key == KeyEvent.VK_D) {
            pos.translate(7, 0);
            this.image = null;
            animation.animateD();
        }
        if (key == KeyEvent.VK_S) {
            pos.translate(0, 7);
        }
        if (key == KeyEvent.VK_A) {
            pos.translate(-7, 0);
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
