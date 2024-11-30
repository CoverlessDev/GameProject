package org.example;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerAnimation extends Player implements CommonUtilities {

    BufferedImage normalFrame0, normalFrame1, normalFrame2;
    ArrayList<BufferedImage> playerAnimation = new ArrayList<>();

    //TODO Find a better way of handling this
    public PlayerAnimation() {
        this.normalFrame0 = generateImage("src/main/resources/Slime0.png");
        this.normalFrame1 = generateImage("src/main/resources/Slime1.png");
        this.normalFrame2 = generateImage("src/main/resources/Slime2.png");

        playerAnimation.add(normalFrame0);
        playerAnimation.add(normalFrame1);
        playerAnimation.add(normalFrame2);

    }

    public void animateD(){
        for (BufferedImage bufferedImage : playerAnimation) {
            super.changeFrame(bufferedImage);
        }
    }

    public void animateW(){

    }

    public void animateS(){

    }

    public void animateA(){

    }
}

