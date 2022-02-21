package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;

public class screen extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;


    public screen(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            //System.out.println("test");
            //update();

            repaint();

        }
    /*
    public void update() {

        }
    */
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.white);
            g2.fillRect(100, 100, tileSize, tileSize);
            g2.dispose();
        }



    }


    /*
    private int width;
    private int height;
    public screen() {
        super();
        width = 500;
        height = 500;
    }
    */



}
