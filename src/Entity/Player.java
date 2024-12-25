package Entity;

import main.GamePanel;
import main.InputHandler;

import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    InputHandler input;

    public Player(GamePanel gp, InputHandler input) {
        this.gp = gp;
        this.input = input;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 6;
    }

    public void update() {
        if(input.upPressed) {
            y -= speed;
        }
        if(input.downPressed) {
            y += speed;
        }
        if(input.leftPressed) {
            x -= speed;
        }
        if(input.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, gp.GAME_SIZE, gp.GAME_SIZE);
    }
}
