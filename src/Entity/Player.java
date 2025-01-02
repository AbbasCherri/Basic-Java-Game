package Entity;

import main.GamePanel;
import main.InputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel gp;
    InputHandler input;

    public Player(GamePanel gp, InputHandler input) {
        this.gp = gp;
        this.input = input;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 25;
        direction = "idle";
    }

    public void update() {
        if (input.jet){
            y -= speed * gp.delta;
            if (direction.equals("idle")) {
                direction = "up";
            }else{
                direction = "idle";
            }
        }else {
            y += GRAVITY;
        }
        input.jet = false;


    }

    public void getPlayerImage(){
        try{
            // Loads the player sprites
            idle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/bird/bird.png")));
            up = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/bird/birdUp.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d) {

        BufferedImage Image = idle;
        if (direction.equals("up")){
            Image = up;
        }
        g2d.drawImage(Image, (int) x, (int) y, gp.GAME_SIZE, gp.GAME_SIZE,  null);
    }
}
