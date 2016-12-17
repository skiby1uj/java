package ticTacToe;


import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ticTacToe extends JFrame {

    static boolean canGo;
    static Socket socket;
    
    class ButtonXO extends JButton implements ActionListener {
        int buttonID;
        byte value = 0;
        /*  0: start
            1: X
            2: O  */

        public ButtonXO(int id) {
            buttonID = id;
            this.setFont(new Font("Dialog", Font.PLAIN, 120));
            this.addActionListener(this);
        }

        //naciskamy na button
        public void actionPerformed(ActionEvent e) {
            
            if (this.getText() != "") return;
            
            try {
                OutputStream os = socket.getOutputStream();
                os.write(buttonID);
                setText("X");
                InputStream is = socket.getInputStream();
                int buttonRead = is.read();
                buttons[buttonRead].setText("O");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            determineIfWin();
        }

    }

    byte turn = 1; //1 - X turn; 2 - O turn

    
    JPanel labels = new JPanel();
    static ButtonXO buttons[] = new ButtonXO[9];
    JPanel p = new JPanel();
    
    public ticTacToe(){
        super("XO Game");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(3,3));

        for(int i=0;i<9;i++){
            buttons[i] = new ButtonXO(i);
            p.add(buttons[i]);
        }
        add(p);
        setVisible(true);
    }

    private void xWins() {
        JOptionPane.showMessageDialog(this,
                "X wins",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void oWins() {
        JOptionPane.showMessageDialog(this,
                "O wins",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void determineIfWin() {
        String one = buttons[0].getText();
        String two = buttons[1].getText();
        String three = buttons[2].getText();
        String four = buttons[3].getText();
        String five = buttons[4].getText();
        String six = buttons[5].getText();
        String seven = buttons[6].getText();
        String eight = buttons[7].getText();
        String nine = buttons[8].getText();

        if ((one == "X" && two == "X" && three == "X") ||
                (four == "X" && five == "X" && six == "X") ||
                (seven == "X" && eight == "X" && nine == "X") ||
                (one == "X" && four == "X" && seven == "X") ||
                (two == "X" && five == "X" && eight == "X") ||
                (three == "X" && six == "X" && nine == "X") ||
                (one == "X" && five == "X" && nine == "X") ||
                (three == "X" && five == "X" && seven == "X")) {
            xWins();
            resetGame();
        }

        if ((one == "O" && two == "O" && three == "O") ||
                (four == "O" && five == "O" && six == "O") ||
                (seven == "O" && eight == "O" && nine == "O") ||
                (one == "O" && four == "O" && seven == "O") ||
                (two == "O" && five == "O" && eight == "O") ||
                (three == "O" && six == "O" && nine == "O") ||
                (one == "O" && five == "O" && nine == "O") ||
                (three == "O" && five == "O" && seven == "O")) {
            oWins();
            resetGame();
        }
        int countAlreadySet = 0;
        for(int i=0;i<9;i++){
            if(buttons[i].getText() != "") countAlreadySet++;
        }
        if (countAlreadySet == 9) {
            JOptionPane.showMessageDialog(this,
                    "Draw!",
                    "Winner",
                    JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
    }

    private void resetGame() {
        for(int i=0;i<9;i++){
            buttons[i].setText("");
        }
    }

    public static void main(String args[]) throws IOException{
        new ticTacToe();
        if(args.length == 0)
        {
            ServerSocket ss = new ServerSocket(4000);
            socket = ss.accept();
            InputStream is = socket.getInputStream();
            int buttonRead = is.read();
            buttons[buttonRead].setText("O");
        }
        else
        {
            socket = new Socket(args[0], 4000);
        }
        
    }
}