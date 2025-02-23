import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterMovementFrame extends JFrame {
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 800;
    private static final int CHARACTER_SIZE = 40;
    private static final int CHARACTER_SPEED = 5;
    private static final int CIRCLE_SIZE = 20;
    private static final int CIRCLE_SPEED = 2;
    
    private int characterX;
    private int characterY;
    private boolean movingUp; 
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;
    
    private List<Circle> circles;
    private boolean gameRunning;

    private Timer timer;
    private long startTime;
    
    public CharacterMovementFrame() {
        setTitle("Dodging b");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CharacterPanel characterPanel = new CharacterPanel();
        add(characterPanel);

        characterX = (FRAME_WIDTH - CHARACTER_SIZE) / 2; // Initial X position of the character
        characterY = (FRAME_HEIGHT - CHARACTER_SIZE) / 2; // Initial Y position of the character

        circles = new ArrayList<>();
        gameRunning = true;

        addKeyListener(new CharacterMovementKeyListener());
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameRunning) {
                    characterPanel.updateCharacterPosition();
                    updateCirclePositions();
                    checkCollisions();
                    characterPanel.repaint();
                }
            }
        });

        startTime = System.currentTimeMillis();
        timer.start();
    }

    private void updateCirclePositions() {
        Random random = new Random();
        for (Circle circle : circles) {
            circle.x -= CIRCLE_SPEED;
            if (circle.x + CIRCLE_SIZE < 0) {
                // Circle has moved off the screen, remove it
                circles.remove(circle);
                break;
            }
        }

        // Add new circles randomly
        if (random.nextDouble() < 0.02) {
            int randomY = random.nextInt(FRAME_HEIGHT - CIRCLE_SIZE);
            circles.add(new Circle(FRAME_WIDTH, randomY));
        }
    }

    private void checkCollisions() {
        Rectangle characterBounds = new Rectangle(characterX, characterY, CHARACTER_SIZE, CHARACTER_SIZE);
        for (Circle circle : circles) {
            Rectangle circleBounds = new Rectangle(circle.x, circle.y, CIRCLE_SIZE, CIRCLE_SIZE);
            if (characterBounds.intersects(circleBounds)) {
                gameRunning = false;
                timer.stop();

                long endTime = System.currentTimeMillis();
                long survivalTime = (endTime - startTime) / 1000; // in seconds

                JOptionPane.showMessageDialog(this, "Game Over! You survived for " + survivalTime + " seconds.");

                int option = JOptionPane.showConfirmDialog(this, "Do you want to restart?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    restartGame();
                } else {
                    System.exit(0);
                }

                break;
            }
        }
    }

    private class CharacterPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT); // Clear the panel

            g.setColor(Color.BLUE);
            g.fillOval(characterX, characterY, CHARACTER_SIZE, CHARACTER_SIZE);

            g.setColor(Color.RED);
            for (Circle circle : circles) {
                g.fillOval(circle.x, circle.y, CIRCLE_SIZE, CIRCLE_SIZE);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000; // in seconds
            g.drawString("Survival Time: " + elapsedTime + " seconds", 20, 30);
        }

        public void updateCharacterPosition() {
            int newCharacterX = characterX;
            int newCharacterY = characterY;

            if (movingUp)
                newCharacterY -= CHARACTER_SPEED;
            if (movingDown)
                newCharacterY += CHARACTER_SPEED;
            if (movingLeft)
                newCharacterX -= CHARACTER_SPEED;
            if (movingRight)
                newCharacterX += CHARACTER_SPEED;

            // Check if the new position is within the boundaries
            if (newCharacterX >= 0 && newCharacterX + CHARACTER_SIZE <= FRAME_WIDTH)
                characterX = newCharacterX;
            if (newCharacterY >= 0 && newCharacterY + CHARACTER_SIZE <= FRAME_HEIGHT)
                characterY = newCharacterY;
        }
    }

    private class CharacterMovementKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_W)
                movingUp = true;
            else if (key == KeyEvent.VK_S)
                movingDown = true;
            else if (key == KeyEvent.VK_A)
                movingLeft = true;
            else if (key == KeyEvent.VK_D)
                movingRight = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_W)
                movingUp = false;
            else if (key == KeyEvent.VK_S)
                movingDown = false;
            else if (key == KeyEvent.VK_A)
                movingLeft = false;
            else if (key == KeyEvent.VK_D)
                movingRight = false;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Not needed for this implementation
        }
    }

    private static class Circle {
        public int x;
        public int y;

        public Circle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void restartGame() {
        characterX = (FRAME_WIDTH - CHARACTER_SIZE) / 2;
        characterY = (FRAME_HEIGHT - CHARACTER_SIZE) / 2;

        circles.clear();
        gameRunning = true;

        startTime = System.currentTimeMillis();
        timer.start();
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         CharacterMovementFrame frame = new CharacterMovementFrame();
    //         frame.setVisible(true);
    //     });
    // }
}
