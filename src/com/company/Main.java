package com.company;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        //Interface Interface=new Interface(); // makes screen


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true); // for testing only (true)
        window.setTitle("game");

        screen screen = new screen();
        window.add(screen);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        screen.startGameThread();

    }
}
