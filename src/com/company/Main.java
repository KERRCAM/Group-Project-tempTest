package com.company;
import javax.swing.*;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Screen gameScreen= new Screen();
        Panel gamePanel=new Panel();
        gameScreen.add(gamePanel);
        gameScreen.pack();
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setVisible(true);
        gamePanel.StartThread();
    }
}
