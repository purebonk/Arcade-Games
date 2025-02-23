// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Random;

// public class HeadsOrTailsFrame extends JFrame implements ActionListener {
//     private JLabel resultLabel;
//     private JButton headsButton;
//     private JButton tailsButton;
//     private Random random;
//     private String result;
//     private boolean guess;

//     public HeadsOrTailsFrame() {
//         setTitle("Heads Or Tails?");
//         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//         setSize(500, 500);
//         setLayout(new BorderLayout());
//         getContentPane().setBackground(new Color(200, 200, 255));

//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//         centerPanel.setPreferredSize(new Dimension(400, 300));

//         resultLabel = new JLabel("To Decide Who Goes First... Pick Heads Or Tails!");
//         resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         centerPanel.add(resultLabel);

//         headsButton = new JButton("Heads");
//         headsButton.addActionListener(this);
//         headsButton.setPreferredSize(new Dimension(150, 150));
//         centerPanel.add(headsButton);

//         tailsButton = new JButton("Tails");
//         tailsButton.addActionListener(this);
//         tailsButton.setPreferredSize(new Dimension(150, 150));
//         centerPanel.add(tailsButton);

//         random = new Random();

//         add(centerPanel, BorderLayout.CENTER);

//         setVisible(true);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == headsButton) {
//             play("Heads");
//         } else if (e.getSource() == tailsButton) {
//             play("Tails");
//         }
//     }

//     private void play(String selection) {
//         String[] options = {"Heads", "Tails"};
//         result = options[random.nextInt(2)];

//         StringBuilder message = new StringBuilder("<html><font color='#800080' size='+3'>");
//         message.append("The result is: ").append(result).append("<br>");

//         if (selection.equals(result)) {
//             guess = true;
//             message.append("Congratulations! You chose correctly!");
//         } else {
//             message.append("Sorry! You chose incorrectly.");
//             guess = true;
//         }
//         message.append("</font></html>");

//         resultLabel.setText(message.toString());
//         headsButton.setVisible(true);
//         tailsButton.setVisible(true);
//     }

//     public boolean getResult() {
//         return guess;
//     }

// }









// boolean[][] Map2 = {
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
//             {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
//         };