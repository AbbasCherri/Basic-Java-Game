package main;

import javax.swing.JFrame;
import java.io.IOException;


public class Main{
    public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setResizable(false); // Screen cannot be resized

    frame.setTitle("2d Game"); // Game Title

    GamePanel gamePanel = new GamePanel();
    frame.add(gamePanel); // Adds Game frame Settings
    frame.pack(); // Packs the Game to the screen

    gamePanel.startGameThread(); // Starts the game loop

    frame.setLocationRelativeTo(null); // Centers frame
    frame.setVisible(true); // Sets screen visible

    }
}