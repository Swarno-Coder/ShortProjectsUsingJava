import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer = 'X';
    private JLabel statusLabel;

    public TicTacToeGUI() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 48));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player " + currentPlayer + "'s turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(statusLabel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                buttons[row][col].setEnabled(false);

                if (checkWin(row, col)) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    resetBoard();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetBoard();
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    statusLabel.setText("Player " + currentPlayer + "'s turn");
                }
            }
        }

        private boolean checkWin(int r, int c) {
            String symbol = String.valueOf(currentPlayer);

            // Check row
            for (int i = 0; i < 3; i++) {
                if (!buttons[r][i].getText().equals(symbol)) {
                    break;
                }
                if (i == 2) {
                    return true;
                }
            }

            // Check column
            for (int i = 0; i < 3; i++) {
                if (!buttons[i][c].getText().equals(symbol)) {
                    break;
                }
                if (i == 2) {
                    return true;
                }
            }

            // Check diagonals
            if (r == c) {
                for (int i = 0; i < 3; i++) {
                    if (!buttons[i][i].getText().equals(symbol)) {
                        break;
                    }
                    if (i == 2) {
                        return true;
                    }
                }
            }

            if (r + c == 2) {
                for (int i = 0; i < 3; i++) {
                    if (!buttons[i][2 - i].getText().equals(symbol)) {
                        break;
                    }
                    if (i == 2) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().equals("")) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void resetBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                    buttons[i][j].setEnabled(true);
                }
            }
            currentPlayer = 'X';
            statusLabel.setText("Player " + currentPlayer + "'s turn");
        }
    }
    //Main method to run the file
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
