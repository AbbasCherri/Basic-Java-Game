package Entity;

import java.awt.image.BufferedImage;

public abstract class Entity {
    public double x, y;
    public int speed;
    final public double GRAVITY = 1.3;

    public BufferedImage idle, up;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 0;

}
