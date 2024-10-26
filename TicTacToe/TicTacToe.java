public class TicTacToe {
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

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
        printBoard();
    }
}