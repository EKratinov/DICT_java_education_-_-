import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        char currentPlayer = 'X';
        while (true) {
            playerMove(currentPlayer);
            printBoard();
            String result = analyzeBoard();

            if (!result.equals("Game not finished")) {
                System.out.println(result);
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void updateBoard(String input) {
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = input.charAt(i) == '_' ? ' ' : input.charAt(i);
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static String analyzeBoard() {
        boolean xWins = checkWin('X');
        boolean oWins = checkWin('O');
        int xCount = 0, oCount = 0, emptyCount = 0;

        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'X') xCount++;
                else if (cell == 'O') oCount++;
                else emptyCount++;
            }
        }

        if (xWins && oWins || Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else if (emptyCount == 0) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }

    public static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public static void playerMove(char symbol) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] coordinates = scanner.nextLine().split(" ");

            try {
                int row = Integer.parseInt(coordinates[0]) - 1;
                int col = Integer.parseInt(coordinates[1]) - 1;

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[row][col] = symbol;
                    break;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
