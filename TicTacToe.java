import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    
    Random random = new Random();
    private JFrame frame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textfield = new JLabel();
    //9 buttons for tictactoe duh
    private JButton[] buttons = new JButton[9];
    boolean player1turn;
    // boolean tieRan;
    Color defaultColor = new Color(0, 220, 220); // Original background color



    public TicTacToe()
    {
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.red, 5));

        textfield.setBackground(new Color(255, 199, 189));    
        textfield.setForeground(new Color(111, 100, 253));     
        textfield.setFont(new Font("Courier", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 00, 800, 100);
        titlePanel.add(textfield);
    
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("ROMAN_BASELINE", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(0, 220, 220)); 
            buttons[i].setForeground(new Color(50, 50, 50));
        }
        
        frame.add(titlePanel, BorderLayout.NORTH    );
        frame.add(buttonPanel); 
        textfield.setText("Tic Tac Toe");
        
        firstTurn();
       
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource() == buttons[i])
            {
                if(player1turn)
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1turn = false;
                        textfield.setText("O Player's Turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(Color.YELLOW);
                        buttons[i].setText("O");
                        player1turn = true;
                        textfield.setText("X Player's Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
       
    
        // if (player1turn) {
        //     textfield.setText("X Player's Turn, Nice Job");
        // } else {
            
        //     textfield.setText("O Player's Turn, Nice Try");
        // }
        // try {
		// 	Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
        // textfield.setText("Tic Tac Toe");

        try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1turn=true;
			textfield.setText("X turn");
		}
		else {
			player1turn=false;
			textfield.setText("O turn");
		}

    }
    

    public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
        }

        boolean tie = true;
    for (int i = 0; i < 9; i++) {
        if (buttons[i].getText().isEmpty()) {
            tie = false;
            break;
        }
    }

    if (tie) {
        // Disable all buttons
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("It's a tie!");
    }
       
}
		
	
    
   
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    
        SwingWorker<Void, Void> flashWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                for (int i = 0; i < 2; i++) {

                    SwingUtilities.invokeLater(() -> {
                    buttons[a].setBackground(defaultColor);
                    buttons[b].setBackground(defaultColor);
                    buttons[c].setBackground(defaultColor);
                });
                Thread.sleep(500);

                    buttons[a].setBackground(defaultColor);
                    buttons[b].setBackground(defaultColor);
                    buttons[c].setBackground(defaultColor);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.GREEN);
                    buttons[b].setBackground(Color.GREEN);
                    buttons[c].setBackground(Color.GREEN);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.RED);
                    buttons[b].setBackground(Color.RED);
                    buttons[c].setBackground(Color.RED);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.yellow);
                    buttons[b].setBackground(Color.yellow);
                    buttons[c].setBackground(Color.yellow);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.pink);
                    buttons[b].setBackground(Color.pink);
                    buttons[c].setBackground(Color.pink);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.black);
                    buttons[b].setBackground(Color.black);
                    buttons[c].setBackground(Color.black);
                    Thread.sleep(500);
                }
                return null;
            }
    
            @Override
            protected void done() {
                buttons[a].setBackground(defaultColor);
                buttons[b].setBackground(defaultColor);
                buttons[c].setBackground(defaultColor);
            }
        };
    
        flashWorker.execute();
    }
    
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
    
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    
        SwingWorker<Void, Void> flashWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 2; i++) {
                    buttons[a].setBackground(defaultColor);
                    buttons[b].setBackground(defaultColor);
                    buttons[c].setBackground(defaultColor);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.GREEN);
                    buttons[b].setBackground(Color.GREEN);
                    buttons[c].setBackground(Color.GREEN);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.RED);
                    buttons[b].setBackground(Color.RED);
                    buttons[c].setBackground(Color.RED);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.yellow);
                    buttons[b].setBackground(Color.yellow);
                    buttons[c].setBackground(Color.yellow);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.pink);
                    buttons[b].setBackground(Color.pink);
                    buttons[c].setBackground(Color.pink);
                    Thread.sleep(500);
                    buttons[a].setBackground(Color.black);
                    buttons[b].setBackground(Color.black);
                    buttons[c].setBackground(Color.black);
                    Thread.sleep(500);
                }
                return null;
            }
    
            @Override
            protected void done() {
                buttons[a].setBackground(defaultColor);
                buttons[b].setBackground(defaultColor);
                buttons[c].setBackground(defaultColor);
            }
        
        };

        flashWorker.execute();
       
    }

    // public void setTurn(boolean guess)
    // {
    //     player1turn = guess;
    // }
 
        
      
    }



