package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
    public boolean up;
    public boolean down;
    public boolean right;
    public boolean left;
    public boolean boostRight;
    public boolean boostLeft;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_W){
            up=true;
        }
        if(code==KeyEvent.VK_A){
            left=true;
        }
        if(code==KeyEvent.VK_S){
            down=true;
        }
        if(code==KeyEvent.VK_D){
            right=true;
        }
        if(code==KeyEvent.VK_E){
            boostRight=true;
        }
        if(code==KeyEvent.VK_Q){
            boostLeft=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_W){
            up=false;
        }
        if(code==KeyEvent.VK_A){
            left=false;
        }
        if(code==KeyEvent.VK_S){
            down=false;
        }
        if(code==KeyEvent.VK_D){
            right=false;
        }
        if(code==KeyEvent.VK_E){
            boostRight=false;
        }
        if(code==KeyEvent.VK_Q){
            boostLeft=false;
        }
    }
}
