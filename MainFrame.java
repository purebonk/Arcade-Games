import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton button1, button2, button3, button4;

    public MainFrame() {
        setTitle("Arcade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        // Add title banner panel
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(new Color(180, 0, 0)); // Adjusted shade of red
        Border border = BorderFactory.createEmptyBorder(30, 10, 30, 10);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        titlePanel.setBorder(BorderFactory.createCompoundBorder(border, lineBorder));

        JLabel titleLabel = new JLabel("Aaron's Arcade");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBackground(new Color(10, 10, 200));
        titlePanel.add(titleLabel);

        

        // Create panels for each button
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBackground(new Color(200, 40, 40)); // Adjusted shade of black

        JPanel panel1 = createButtonPanel("Tic Tac Toe", "tic_image.png", 1);
        JPanel panel2 = createButtonPanel("Maze Runner", "maze_image.png", 2);
         JPanel panel3 = createButtonPanel("Dodge Balls", "dodgeball.png", 3);
        // JPanel panel3 = createButtonPanel("game 3", "path_to_image3.png", 3);
        // JPanel panel4 = createButtonPanel("game 4", "path_to_image4.png", 4);

        buttonPanel.add(panel1);
        buttonPanel.add(panel2);
        buttonPanel.add(panel3);
        // buttonPanel.add(panel4);

        add(buttonPanel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);
        setVisible(true);
    }

  private JPanel createButtonPanel(String label, String imagePath, final int gameNumber) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(new Color(60, 60, 60));
    Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
    panel.setBorder(BorderFactory.createCompoundBorder(border, lineBorder));

    JLabel labelComponent = new JLabel(label);
    labelComponent.setForeground(Color.WHITE);
    labelComponent.setFont(new Font("Arial", Font.BOLD, 16));
    labelComponent.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(labelComponent, BorderLayout.NORTH);

    JButton button = new JButton();
    button.setHorizontalTextPosition(SwingConstants.CENTER);
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
    button.setFont(new Font("Arial", Font.BOLD, 16));
    button.setForeground(Color.WHITE);
    button.setBackground(new Color(60, 60, 60));
    button.setFocusPainted(false);

    ImageIcon icon = new ImageIcon(imagePath);
    Image originalImage = icon.getImage();
    int imageSize = Math.min(button.getPreferredSize().width - 20, button.getPreferredSize().height - 60);
    Image scaledImage = originalImage.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
    button.setIcon(new ImageIcon(scaledImage));

    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            launchGame(gameNumber);
        }
    });

    panel.add(button, BorderLayout.CENTER);
    
    return panel;
}

 private void launchGame(int gameNumber) {
        // Read configuration from file and pass it to the Game class
        // String configFilePath = "game" + gameNumber + ".config";
        // // Instantiate the Game class with the configuration
        // Game game = new Game(configFilePath);
        // // Start the game
        // game.start();
        if(gameNumber == 1)
        {
             TicTacToe tictactoe = new TicTacToe();
        }
        if(gameNumber == 2)
        {
             SwingUtilities.invokeLater(() -> {
            MazeGame mazeGame = new MazeGame();
            mazeGame.startTime = System.currentTimeMillis(); // Set the start time
            mazeGame.timer.start(); // Start the timer
        });
        }
        if(gameNumber == 3)
        {
             SwingUtilities.invokeLater(() -> {
            CharacterMovementFrame frame = new CharacterMovementFrame();
            frame.setVisible(true);
        });
        }
      
       
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
