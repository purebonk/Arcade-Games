import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MazeGame extends JFrame {
    private final int mazeWidth = 20;
    private final int mazeHeight = 15;
    private final int cellSize = 40;
    private final int circleSize = 20;

    private int characterX = 0;
    private int characterY = 0;

    private int startX = 0;
    private int startY = 0;

    private int endX = mazeWidth - 1;
    private int endY = mazeHeight - 1;

    private int mapNum;
    long startTime; // Variable to store the start time
    Timer timer; // Timer to update the elapsed time

    private boolean[][] maze = new boolean[20][20];
    
    public MazeGame() {
        getMaze();
        ((JComponent)getContentPane()).setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        setVisible(true);
        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        Board board = new Board();
        add(board);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                moveCharacter(e.getKeyCode());
                checkGameOver();
                repaint();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = elapsedTime / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                setTitle("Maze Game - Time: " + minutes + "m " + remainingSeconds + "s");
            }
        });
    }

    private void getMaze()
    {
        mapNum = (int)(Math.random()*3 + 1);
         if(mapNum == 3)
        {
            characterX = 9;
        }
        boolean[][] Map1 = {
            {false, true, true, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false},
            {false, false, true, false, true, false, false, false, true, false, false, false, true, true, true, true, true, true, true, false},
            {true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false},
            {false, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false},
            {false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true},
            {false, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, true},
            {true, false, true, false, true, true, true, true, true, true, false, false, false, true, true, true, true, true, false, true},
            {false, false, true, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false, true},
            {false, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {false, false, true, false, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true},
            {true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true},
            {true, false, true, false, true, true, true, true, true, false, false, false, false, false, false, false, false, true, true, true},
            {true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false}
        };

        boolean[][] Map2 = {
            {false, true, false, false, false, false, false, false, false, true, true, false, false, false, false, false, true, false, false, false},
            {false, false, false, true, true, true, true, true, false, true, true, false, true, true, true, false, false, false, true, false},
            {true, true, true, true, true, true, false, false, false, true, true, false, false, false, false, true, true, true, true, false},
            {true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, false},
            {true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, false},
            {false, false, false, false, true, false, false, true, true, true, false, false, false, false, false, true, true, true, false, true},
            {false, true, true, false, true, false, true, true, true, true, false, true, true, true, true, true, true, true, false, true},
            {false, true, true, false, false, false, true, true, true, true, false, true, true, true, true, true, true, true, false, false},
            {false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, false},
            {false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, false},
            {false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, true, false, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, false, true, false, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, false, false, true, true, false, true, false, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, false, false, true}
        };
        boolean[][] Map3 = {
            {true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, false, false, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false},
            {false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, true, false},
            {false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, false, false, false},
            {false, false, true, true, true, true, false, true, true, true, true, true, false, false, false, true, true, true, true, true},
            {true, false, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true},
            {true, false, false, false, true, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true},
            {true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, true, true, false, true, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true},
            {true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true},
            {true, true, true, false, false, false, true, true, false, false, false, false, true, true, true, true, true, true, true, true}
        };
        
        if(mapNum == 1){
            for (int i = 0; i < Map1.length; i++) {
                for (int j = 0; j < Map1[i].length; j++) {
                    maze[i][j] = Map1[i][j];
                }
            }
        }
        if(mapNum == 2){
            for (int i = 0; i < Map2.length; i++) {
                for (int j = 0; j < Map2[i].length; j++) {
                    maze[i][j] = Map2[i][j];
                }
            }
        }
        if(mapNum == 3){
            for (int i = 0; i < Map3.length; i++) {
                for (int j = 0; j < Map3[i].length; j++) {
                    maze[i][j] = Map3[i][j];
                }
            }
        }
    }

    private void moveCharacter(int keyCode) {
       
       
         
            int newX = characterX;
            int newY = characterY;
        
        
        switch (keyCode) {
            case KeyEvent.VK_W:
                newY--;
                break;
            case KeyEvent.VK_S:
                newY++;
                break;
            case KeyEvent.VK_A:
                newX--;
                break;
            case KeyEvent.VK_D:
                newX++;
                break;
        }

        if (isValidMove(newX, newY)) {
            characterX = newX;
            characterY = newY;
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < mazeWidth && y >= 0 && y < mazeHeight && !maze[y][x];
    }

    // private void checkGameOver() {
    //     if (characterX == endX && characterY == endY) {
    //         JOptionPane.showMessageDialog(this, "Congratulations! You reached the end of the maze.");
    //         System.exit(0);
    //     }
    // }

    private void checkGameOver() {
        if(mapNum == 1)
        {
            if (characterX == endX && characterY == endY) {
                timer.stop(); // Stop the timer
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = elapsedTime / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                JOptionPane.showMessageDialog(this, "Congratulations! You reached the end of the maze.\nTime taken: " + minutes + "m " + remainingSeconds + "s");
                System.exit(0);
            }
        }
        if(mapNum == 2)
        {
            if (characterX == 12 && characterY == endY) {
                timer.stop(); // Stop the timer
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = elapsedTime / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                JOptionPane.showMessageDialog(this, "Congratulations! You reached the end of the maze.\nTime taken: " + minutes + "m " + remainingSeconds + "s");
                System.exit(0);
            }
        }
        if(mapNum == 3)
        {
            if (characterX == 8 && characterY == endY) {
                timer.stop(); // Stop the timer
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = elapsedTime / 1000;
                long minutes = seconds / 60;
                long remainingSeconds = seconds % 60;
                JOptionPane.showMessageDialog(this, "Congratulations! You reached the end of the maze.\nTime taken: " + minutes + "m " + remainingSeconds + "s");
                System.exit(0);
            }
        }
    }


    class Board extends JPanel {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(mazeWidth * cellSize, mazeHeight * cellSize);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int y = 0; y < mazeHeight; y++) {
                for (int x = 0; x < mazeWidth; x++) {
                    if (maze[y][x]) {
                        g.setColor(Color.BLACK);
                        g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                    }
                }
            }
        if(mapNum == 3)
        {
            characterX = 9;
        }
           
            g.setColor(Color.RED);
            g.fillOval(characterX * cellSize + (cellSize - circleSize) / 2,
                    characterY * cellSize + (cellSize - circleSize) / 2,
                    circleSize,
                    circleSize);
            if(mapNum == 1)
            {
                g.setColor(Color.GREEN);
                g.fillRect(startX * cellSize, startY * cellSize, cellSize, cellSize);
                
                g.setColor(Color.BLUE);
                g.fillRect(endX * cellSize, endY * cellSize, cellSize, cellSize);
            }
             if(mapNum == 2)
            {
                g.setColor(Color.GREEN);
                g.fillRect(startX * cellSize, startY * cellSize, cellSize, cellSize);
                
                g.setColor(Color.BLUE);
                g.fillRect(12 * cellSize, endY * cellSize, cellSize, cellSize);
            }
             if(mapNum == 3)
            {
                g.setColor(Color.GREEN);
                g.fillRect(9 * cellSize, startY * cellSize, cellSize, cellSize);
                
                g.setColor(Color.BLUE);
                g.fillRect(8 * cellSize, endY * cellSize, cellSize, cellSize);
            }
        }
    }

    

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         MazeGame mazeGame = new MazeGame();
    //         mazeGame.startTime = System.currentTimeMillis(); // Set the start time
    //         mazeGame.timer.start(); // Start the timer
    //     });
    // }

}
