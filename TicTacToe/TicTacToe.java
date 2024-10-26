import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];


    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            playerMove('X');
            printBoard();
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
