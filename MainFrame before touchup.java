// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;


// public class MainFrame extends JFrame {
//     private JButton button1, button2, button3, button4;

//     public MainFrame() {
//         setTitle("Arcade Theme");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(400, 300);
//         setLayout(new GridLayout(2, 2));

//         // Create buttons with labels and images
//         button1 = createButton("Start game 1", "path_to_image1.png", 1);
//         button2 = createButton("Start game 2", "path_to_image2.png", 2);
//         button3 = createButton("Start game 3", "path_to_image3.png", 3);
//         button4 = createButton("Start game 4", "path_to_image4.png", 4);

//         // Add buttons to the frame
//         add(button1);
//         add(button2);
//         add(button3);
//         add(button4);

//         setVisible(true);
//     }

//     private JButton createButton(String label, String imagePath, final int gameNumber) {
//         JButton button = new JButton(label);
//         button.setHorizontalTextPosition(SwingConstants.CENTER);
//         button.setVerticalTextPosition(SwingConstants.BOTTOM);
//         button.setFont(new Font("Arial", Font.BOLD, 16));
//         button.setForeground(Color.WHITE);
//         button.setBackground(Color.RED);
//         button.setFocusPainted(false);

//         ImageIcon icon = new ImageIcon(imagePath);
//         Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//         button.setIcon(new ImageIcon(scaledImage));

//         button.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 launchGame(gameNumber);
//             }
//         });

//         return button;
//     }

//     // private void launchGame(int gameNumber) {
//     //     // Launch the game corresponding to the button clicked
//     //     System.out.println("Launching game " + gameNumber);
//     // }

// //     public static void main(String[] args) {
// //         SwingUtilities.invokeLater(new Runnable() {
// //             public void run() {
// //                 new ArcadeFrame();
// //             }
// //         });
// //     }
// // }



// // public class MainFrame extends JFrame {
// //     private JButton[] buttons;

// //     public MainFrame() {
// //         setTitle("Game Launcher");
// //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// //         setSize(400, 300);
// //         setLocationRelativeTo(null);

// //         initializeButtons();
// //         createLayout();

// //         setVisible(true);
// //     }

// //     private void initializeButtons() {
// //         buttons = new JButton[4];
// //         for (int i = 0; i < buttons.length; i++) {
// //             buttons[i] = new JButton("Start game " + (i + 1));
// //             final int gameNumber = i + 1;
// //             buttons[i].addActionListener(new ActionListener() {
// //                 @Override
// //                 public void actionPerformed(ActionEvent e) {
// //                     launchGame(gameNumber);
// //                 }
// //             });
// //         }
// //     }

// //     private void createLayout() {
// //         setLayout(new GridLayout(2, 2));

// //         for (JButton button : buttons) {
// //             add(button);
// //         }
// //     }

//     private void launchGame(int gameNumber) {
//         // Read configuration from file and pass it to the Game class
//         // String configFilePath = "game" + gameNumber + ".config";
//         // // Instantiate the Game class with the configuration
//         // Game game = new Game(configFilePath);
//         // // Start the game
//         // game.start();
//         if(gameNumber == 1)
//         {
//              TicTacToe tictactoe = new TicTacToe();
//         }
//         if(gameNumber == 2)
//         {
//              SwingUtilities.invokeLater(() -> {
//             MazeGame mazeGame = new MazeGame();
//             mazeGame.startTime = System.currentTimeMillis(); // Set the start time
//             mazeGame.timer.start(); // Start the timer
//         });
//         }
//         if(gameNumber == 3)
//         {
//              TicTacToe tictactoe = new TicTacToe();
//         }
//         if(gameNumber == 4)
//         {
//              TicTacToe tictactoe = new TicTacToe();
//         }
       
//     // }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 new MainFrame();
//             }
//         });
//     }
// }