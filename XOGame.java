import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.border.Border;

public class XOGame extends JFrame implements ActionListener {
    static char[][] board;
    static boolean play  = true ;
    static char currentPlayer;
    static JLabel[][] labels;
    static JP jp;
    static GLCanvas glcanvas = null;
    JButton button = new JButton("new");
    JPanel jpp;

    public XOGame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(415, 435);
        this.setLayout(null);
        this.setLocation(200, 100);
        glcanvas = new GLCanvas();

        board = new char[3][3];
        currentPlayer = 'X';
        liss lis = new liss();

        jp = new JP();
        jpp= new JPanel();
        jp.setBackground(Color.black);
        jp.setLayout(new GridLayout(3,3));
        jp.setBounds(0, 0, 400, 400);
        jp.addMouseListener(lis);
        labels = new JLabel[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setBackground(Color.black);
                labels[i][j].setBounds(30 + j * 110, 30 + i * 110, 210, 200);
                labels[i][j].setOpaque(true);
                labels[i][j].setBackground(Color.black);
                labels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                labels[i][j].setVerticalAlignment(SwingConstants.CENTER);
                labels[i][j].setFont(new Font("Arial", Font.PLAIN, 48));
//                labels[i][j].addMouseListener(this);
                Border border = BorderFactory.createLineBorder(Color.white, 1);
                labels[i][j].setBorder(border);
                jp.add(labels[i][j]);
            }
        }
        this.add(jp,BorderLayout.CENTER);
        button.addActionListener(this);
        jpp.setLayout(new BorderLayout());
        jpp.add(button, BorderLayout.CENTER);
        this.add(jpp,BorderLayout.SOUTH);
        this.setVisible(true);
    }



    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
                labels[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }

    static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] ==  board[i][1]  && board[i][2] == board[i][1] && board[i][0] != 0 && board[i][1] != 0) {
               return true;
            }
        }
        for (int i = 0; i < 3; i++) {
                if (board[0][i] ==  board[1][i]  && board[2][i] == board[1][i]&& board[0][i] != 0 && board[1][i] != 0) {
                    return true  ;
                }
        }
        if (board[1][1] ==  board[0][2]  && board[1][1] == board[2][0]&& board[1][1] != 0 ) return true;
        if (board[1][1] ==  board[2][2]  && board[1][1] == board[0][0]&& board[1][1] != 0 ) return true;
        return false ;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void showResult() {
        String result;
        if (!play) result = "continue?";
        else if (checkWin()) {
            result = "Player " + currentPlayer + " wins!";
        }

        else {

            result = "It's a draw!";
        }
//        JOptionPane.showMessageDialog(jp, result, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        Object[] options = {"YES", "No"};

        // Show the option dialog
        int resultt = JOptionPane.showOptionDialog(
                jp,
                "continue?",
                result,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        // Process the user's choice
        switch (resultt) {
            case JOptionPane.YES_OPTION:
                play = true ;
                XOGame.resetGame();
                break;
            case JOptionPane.NO_OPTION:
                play = false ;
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                play=false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new XOGame();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resetGame();
    }
}

class JP extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(20, 20, 350, 330);
        g.setColor(Color.black);
        g.drawRect(20, 20, 350, 330);
        g.drawRect(30, 30, 330, 310);
        g.drawLine(140, 20, 140, 350);
        g.drawLine(250, 20, 250, 350);
        g.drawLine(20, 140, 370, 140);
        g.drawLine(20, 250, 370, 250);
    }
}
class liss implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (!XOGame.play){
            XOGame.showResult();
            return;
        }
        int row = (e.getY() - 30) / 110;
        int col = (e.getX() - 30) / 110;
        System.out.println("mouse clicked");
        System.out.println(row+" "+col);
        if (XOGame.board[row][col] == 0) {
            XOGame.board[row][col] = (char) ((XOGame.currentPlayer == 'X') ? 1 : 2);

            XOGame.labels[row][col].setText(String.valueOf(XOGame.currentPlayer));
            XOGame.labels[row][col].setForeground(XOGame.currentPlayer == 'X' ? Color.blue : Color.red);

            if (XOGame.checkWin() || XOGame.checkDraw()) {
                XOGame.showResult();
            } else {
                XOGame.switchPlayer();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

