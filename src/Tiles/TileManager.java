
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
            tile[0].image=ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_center.png"));
            tile[1]=new Tile();
            tile[1].image=ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_left.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_platform_right.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/TerrainTiles/terrain_top_center.png"));






        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }
    public void draw(Graphics2D g2D){
        int screenCenterX = gamePanel.getWidth()/2- gamePanel.tileSize/2;
        int screenCenterY = gamePanel.getHeight()/2-gamePanel.tileSize/2;

        g2D.drawImage(tile[0].image,screenCenterX,screenCenterY,gamePanel.tileSize, gamePanel.tileSize,null);
        g2D.drawImage(tile[1].image,screenCenterX- gamePanel.tileSize,screenCenterY,gamePanel.tileSize, gamePanel.tileSize,null);
        g2D.drawImage(tile[2].image,screenCenterX + gamePanel.tileSize,screenCenterY,gamePanel.tileSize, gamePanel.tileSize,null);
        for (int i = 0; i < gamePanel.getWidth(); i = i+ gamePanel.tileSize) {
            g2D.drawImage(tile[3].image,i,gamePanel.getHeight()-30,gamePanel.tileSize,gamePanel.tileSize,null);
        }

    }

}
