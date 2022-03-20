package brickbreaker;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame obj = new JFrame(); 
        Gameplay gamePlay = new Gameplay();
        obj.setSize(700,625);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        obj.setTitle("Brick Breaker");
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setResizable(false);
        obj.add(gamePlay);

    }

}
