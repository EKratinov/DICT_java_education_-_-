import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = input.charAt(i);
        }
        printBoard();
    }
}
