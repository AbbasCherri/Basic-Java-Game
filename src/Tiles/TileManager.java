package Tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class TileManager {



    int assetNumber = 3;
    GamePanel gamePanel;
    BufferedImage[] assets = new BufferedImage[assetNumber];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        try{
            assets[0] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/grass.png")));
            assets[1] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/wall.png")));
            assets[2] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/water.png")));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void drawMap(Graphics2D g2d){
        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        while (row < gamePanel.GAME_WIDTH || col < gamePanel.GAME_HEIGHT){
            g2d.drawImage(assets[0], x, y, null);
            col++;
            x += gamePanel.GAME_SIZE;

            if (col+1 == gamePanel.GAME_WIDTH){
                col = 0;
                row++;
                y += gamePanel.GAME_SIZE;
                x = 0;
            }
        }

    }






}
