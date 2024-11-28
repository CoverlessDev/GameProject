package org.example;
import javax.swing.*;
public class App {


    private static void initWindow(){

        //Creates window frame
        JFrame window = new JFrame("Base frame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Need to create a board class
        Board board = new Board();
    }

    public static void main(String[] args) {

    }
}
