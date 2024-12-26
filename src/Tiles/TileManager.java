package Tiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

// ToDo Grid System


public class TileManager {

    BufferedImage tileSprite;
    BufferedImage grass, wall, water;


    // Total Screen of 16x12
    // 16 cols
    // 12 rows

    public void drawGrid(Graphics2D g2d) {
        g2d.drawLine(200, 200, 400, 400);
    }


    public void draw(Graphics2D g2d, int x, int y, BufferedImage image) {
        g2d.drawImage(image, x, y, null);
    }

    // methode for setting the tile types
    public void setTileType(BufferedImage image, String tilePath) throws IOException {
        try{
        tileSprite = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Tiles/"+tilePath)));;
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
