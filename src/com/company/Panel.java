package com.company;

import Tiles.TileManager;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    final int characterSize=16;
    final int characterScaling=3;
    public final int tileSize=characterSize*characterScaling;
    final int width=16*tileSize;
    final int height=12*tileSize;

    public Panel(){
        this.setPreferredSize(new Dimension(width,height));
        this.setDoubleBuffered(true);
        this.addKeyListener(listener);
        this.setFocusable(true);

    }
    TileManager tileManager=new TileManager(this);
    Input listener= new Input();
    Player player = new Player(this,listener);
    Thread gameThread;

    public void StartThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double frameInterval=1000000000/60;
        double nextFrame=System.nanoTime()+frameInterval;
        while(gameThread!=null) {
            update();
            repaint();
            double remainingTime=nextFrame-System.nanoTime();
            if(remainingTime<0){
                remainingTime=0;
            }try{
            Thread.sleep((long) remainingTime/1000000);}
            catch(Exception e){
                System.out.println("Error: "+e);
            }
            nextFrame+=frameInterval;
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g2){
            super.paintComponent(g2);
            Graphics2D g2D = (Graphics2D) g2;
            tileManager.draw(g2D);
            player.draw((Graphics2D) g2);
            g2D.dispose();

    }
}
