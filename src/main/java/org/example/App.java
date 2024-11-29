package org.example;
import javax.swing.*;
public class App {


    private static void initWindow(){

        //Creates window frame
        JFrame window = new JFrame("Base frame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
         window.add(board);
         window.addKeyListener(board);

         window.setResizable(true);

         window.pack();
         window.setLocationRelativeTo(null);
         window.setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initWindow();
            }
        });
    }
}
