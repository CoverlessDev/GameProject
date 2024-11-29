package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Player {

    private BufferedImage image;
    private Point pos;

    //Constructor
    public Player(){
        loadImage();

        pos = new Point(0,0);

    }

    private void loadImage(){

        //Change this to logger and remove try and catch
        try{
            this.image = ImageIO.read(new File("src/main/resources/slimeimage.png"));
            }catch (IOException exception){
            System.out.println("Error opening file" + exception.getMessage());
        }
    }

    public void draw(Graphics inGraphics, ImageObserver inObserver){
        inGraphics.drawImage(image, pos.x, pos.y, 50,50, inObserver);
    }

    /**
     * Method that registers what key has been pressed and change the position of the player
     *
     * @param inEvent - The event that has happened i.e key press.
     * */
    public void keyPressed(KeyEvent inEvent){

        int key = inEvent.getKeyCode();

        //vk is virtual key
        if (key == KeyEvent.VK_W){
            pos.translate(0,-1);
        }
        if (key == KeyEvent.VK_D){
            pos.translate(1, 0);
        }
        if (key == KeyEvent.VK_S){
            pos.translate(0, 1);
        }
        if (key == KeyEvent.VK_A){
            pos.translate(-1,0);
        }
    }

    public void tick(){

        //Stops player from leaving the board
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= Board.columns) {
            pos.x = Board.columns - 1;
        }

        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= Board.rows) {
            pos.y = Board.rows - 1;
        }
    }
}
