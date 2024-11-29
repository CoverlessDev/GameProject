package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface CommonUtilities {

    default BufferedImage generateImage(String imagePath) {

        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException exception) {
            System.out.println("Error opening file " + exception.getMessage());
        }
        return image;
    }
}
