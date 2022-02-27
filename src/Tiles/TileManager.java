package Tiles;

import com.company.Panel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    int tileTypes=5;
    Panel gamePanel;
    Tile[] tile;

    public TileManager(Panel gamePanel) {
        this.gamePanel = gamePanel;
        tile=new Tile[5];
        getTileImage();
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tileImages/grass.png"));

            tile[1]=new Tile();
            tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tileImages/wall.png"));






        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }
    public void draw(Graphics2D g2D){
        for (int i = 0; i < gamePanel.getWidth(); i+=gamePanel.tileSize) {
            for (int j = 0; j < gamePanel.getHeight(); j++){
                g2D.drawImage(tile[0].image,i,j,gamePanel.tileSize, gamePanel.tileSize,null);
            }
        }
    }
}
