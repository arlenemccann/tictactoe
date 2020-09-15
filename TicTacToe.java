import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    // Attributes
    private char board[][];
    private char isXTurn;


    // Constructors
    public TicTacToe() {
        board = new char[3][3];
        isXTurn = 'X';
        startGame();
        //gameReset();
    }

    public void gameReset(){
        startGame();
        printBoard();
        placeMark();
        noMoreSpots();
        hasWinner();

    }



    public char placeMark() {
        return isXTurn;
    }

    public void startGame() {
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                board[i][j] = '-';
            }
        }

    }

    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");

        }
    }

    public boolean noMoreSpots() {
        boolean boardFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    boardFull = false;
                }
            }
        }
        return boardFull;
    }


    public boolean hasWinner() {

        return (checkRows() || checkColumns() || checkDiagonals());

    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (rowColumn(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;

    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (rowColumn(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }

        return false;
    }


    private boolean checkDiagonals() {
        return ((rowColumn(board[0][0], board[1][1], board[2][2])) || (rowColumn(board[0][2], board[1][1], board[2][0])));


    }

    private boolean rowColumn(char n1, char n2, char n3) {
        return ((n1 != '-') && (n1 == n2) && (n2 == n3));

    }

    public void changePlayer() {
        if (isXTurn == 'X') {
            isXTurn = 'O';
        } else {
            isXTurn = 'X';
        }

    }

    public boolean currentPlace(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = isXTurn;
                    return true;
                }
            }

        }
        return false;

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        TicTacToe game = new TicTacToe();

        game.startGame();
        System.out.println("Let's Play Tic Tac Toe!!");
        do {
            System.out.println("\nTic Tac Toe Board: ");
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Player " + game.placeMark() + ", please enter an empty row (hit enter) and column (hit enter again) to play!");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            }
            while (!game.currentPlace(row, col));
            game.changePlayer();

        }
        while (!game.hasWinner() && !game.noMoreSpots());
        if (game.noMoreSpots() && !game.hasWinner()) {

            System.out.println("Tie game folks!");
        }
        else
            {
                System.out.println("Let's play Tic Tac Toe!");
                game.printBoard();
                game.changePlayer();
                System.out.println(game.placeMark() + " Wins!");

            }

        System.out.println("Want to play again?? Press 1, otherwise Press 0: ");
        int option = scanner.nextInt();
        if(option == 1){
           game.gameReset();
        }


    }
}
