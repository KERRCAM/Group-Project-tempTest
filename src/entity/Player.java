package entity;

import com.company.Input;
import com.company.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    Panel gp;
    Input keyH;

    public final int screenX;
    public final int screenY;

    public Player(Panel gp, Input keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.worldWidth/4;
        screenY = gp.worldHeight/4;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48; // values for collision of entire sprite box

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        speedY = 4;
        speedX = 4;
        airTime = 0;
        direction="none";
    }

    public double timeFalling(){
        airTime = airTime + 0.004;
        if (airTime > 1.6) {
            airTime = 1.6;
        }
        return (airTime);
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResource("/gameImages/player_up1.png"));
            up2 = ImageIO.read(getClass().getResource("/gameImages/player_up2.png"));
            up3 = ImageIO.read(getClass().getResource("/gameImages/player_up3.png"));
            up4 = ImageIO.read(getClass().getResource("/gameImages/player_up4.png"));
            down1 = ImageIO.read(getClass().getResource("/gameImages/player_down1.png"));
            down2 = ImageIO.read(getClass().getResource("/gameImages/player_down2.png"));
            down3 = ImageIO.read(getClass().getResource("/gameImages/player_down3.png"));
            down4 = ImageIO.read(getClass().getResource("/gameImages/player_down4.png"));
            left1 = ImageIO.read(getClass().getResource("/gameImages/player_left1.png"));
            left2 = ImageIO.read(getClass().getResource("/gameImages/player_left2.png"));
            left3 = ImageIO.read(getClass().getResource("/gameImages/player_left3.png"));
            left4 = ImageIO.read(getClass().getResource("/gameImages/player_left4.png"));
            right1 = ImageIO.read(getClass().getResource("/gameImages/player_right1.png"));
            right2 = ImageIO.read(getClass().getResource("/gameImages/player_right2.png"));
            right3 = ImageIO.read(getClass().getResource("/gameImages/player_right3.png"));
            right4 = ImageIO.read(getClass().getResource("/gameImages/player_right4.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //worldY += speedY*timeFalling();
        if(keyH.up == true || keyH.down == true || keyH.left == true || keyH.right == true){
            if(keyH.up){
                direction = "up";
                //lastDirection="up";
                //worldY -= 10;
            }else if (keyH.down){
                direction = "down";
                //lastDirection="down";
                //worldY += speedY;
            }else if(keyH.left){
                direction = "left";
                //lastDirection="left";
                //worldX -= speedX;
            }else if (keyH.right){
                direction = "right";
                //lastDirection="right";
                //worldX += speedX;
            }

            //check collision
            collisionOn = false;
            gp.cTest.checkTile(this);
            //if false player can move if true player cant move
            if(collisionOn == false) {
                switch(direction) {
                    case "up":
                        //worldY -= speed;
                        worldY -= 10;
                        break;
                    case "down":
                        //worldY += speed;
                        worldY += speedY;
                        break;
                    case "left":
                        //worldX -= speed;
                        worldX -= speedX;
                        break;
                    case "right":
                        //worldX += speed;
                        worldX += speedX;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if ( spriteNum == 2){
                    spriteNum = 3;
                }else if (spriteNum == 3){
                    spriteNum = 4;
                }else if(spriteNum == 4){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }else{
            direction="none";
        }
    }
    public void draw(Graphics2D g){


        BufferedImage image = null;
        switch (direction){
            case"up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if(spriteNum == 4){
                    image = up4;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if(spriteNum == 4){
                    image = down4;
                }
                break;
            case "left":
                if (spriteNum==1) {
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                break;
            case"none":
                switch(lastDirection){
                    case"up":
                        image=up1;
                        break;
                    case"down":
                        image=down1;
                        break;
                    case"right":
                        image=right1;
                        break;
                    case"left":
                        image=left1;
                        break;
                }
        }
        g.drawImage(image, screenX, screenY,gp.tileSize,gp.tileSize, null);

    }
}
