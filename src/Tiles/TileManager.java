package Tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.io.File;
import java.util.Scanner;


public class TileManager {


    GamePanel gamePanel;

    int assetNumber = 3;
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

    // returns a tile map int[row][cols]
    public int[][] readMap(String filePath) {
        File mapFile = new File(filePath);
        int[][] tile = new int[gamePanel.MAX_ROWS][gamePanel.MAX_COLS];

        try {
            Scanner reader = new Scanner(mapFile);

            int i = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] split = line.split(" ");
                tile[i][i] = Integer.parseInt(split[i]);
                i++;
            }
            reader.close();


        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

    return tile;
    }


    public void drawMap(Graphics2D g2d){
        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;
        int [][] map = readMap("res/Maps/mapTest.txt");

        while ((row < gamePanel.MAX_ROWS)) {
            g2d.drawImage(assets[map[row][col]], x, y, null);
            col++;
            x += gamePanel.GAME_SIZE;

            if (col == gamePanel.MAX_COLS) {
                col = 0;
                row++;
                y += gamePanel.GAME_SIZE;
                x = 0;
            }
        }
    }
}
