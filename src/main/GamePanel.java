package main;

import Entity.Player;
import Tiles.TileManager;

import javax.swing.JPanel;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int ORIGINAL_SIZE = 16; // Game asset size
    final int SCALE = 3; // Scaling Size

    public final int GAME_SIZE = ORIGINAL_SIZE * SCALE; // Game Size == 48
    final int MAX_COLS = 16; // Number of columns int Tiles
    final int MAX_ROWS = 12; // Number of rows in Tiles
    final int GAME_WIDTH = MAX_COLS * GAME_SIZE; // Pixel Width 768
    final int GAME_HEIGHT = MAX_ROWS * GAME_SIZE; // Pixel Height 576

    Thread gameThread;
    InputHandler input = new InputHandler();
    Player player = new Player(this, input);
    TileManager grid = new TileManager();

    // FPS
    final int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
    }

    // Starts the thread responsible for running the game loop
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Methode responsible for running the game loop itself
    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS; // Desired Draw Interval
        long lastTime = System.nanoTime(); // Saves the last time function was called
        double delta = 0; // Sets the delta time to zero
        long currentTime; // Initializes the currentTime
        int frames = 0; // FPS counter
        long timer = 0; // FPS display per second
    while (gameThread.isAlive()) {
            // System.out.println("Game thread running");

            currentTime = System.nanoTime(); // Gets the current Time

            delta += (currentTime - lastTime) / drawInterval; // Calculates DeltaTime
            timer += (currentTime - lastTime); // Timer responsible for the FPS display
            lastTime = currentTime; // Sets the last time to the next time

            // Checks for when to next draw call
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                frames++;
            }

            // Displays FPS
            if (timer >= 1000000000) {
                System.out.println("FPS: " + frames);
                timer = 0;
                frames = 0;
            }
        }
    }

    // Checks
    public void update() {
        player.update();

    }

    // Draw calls
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
         grid.drawGrid(g2d);
        player.draw(g2d);
        g2d.dispose();
    }
}