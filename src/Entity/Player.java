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
        speed = 6;
        direction = "down";
    }

    public void update() {
        if(input.upPressed) {

            direction = "up";
            y -= speed;
        }
        if(input.downPressed) {
            direction = "down";
            y += speed;
        }
        if(input.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if(input.rightPressed) {
            direction = "right";
            x += speed;
        }

        if (input.isMoving()){
            spriteCounter++;
        }
        if (spriteCounter >= 10) {
            if (spriteNumber == 1){
                spriteNumber = 2;
            }else{
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }

    public void getPlayerImage(){
        try{
            // Loads the player sprites
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_up_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_right_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_left_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/WalkingSprite/boy_down_2.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d) {

        BufferedImage Image = null;
        switch(direction){
            case "up":
                if (spriteNumber == 1){
                    Image = up1;
            }else{
                 Image = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1){
                    Image = down1;
                }else {
                    Image = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1){
                    Image = left1;
                }else {
                    Image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1){
                    Image = right1;
                }else{
                    Image = right2;
                }
                break;
        }
        g2d.drawImage(Image, x, y, gp.GAME_SIZE, gp.GAME_SIZE,  null);
    }
}
