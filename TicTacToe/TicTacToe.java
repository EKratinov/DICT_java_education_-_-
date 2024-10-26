import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        // Этап 1: Инициализация пустого поля и печать начального состояния
        initializeBoard();
        printBoard();

        // Этап 2: Ввод состояния поля и печать его в виде сетки 3x3
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells (use 'X', 'O', or '_'): ");
        String input = scanner.nextLine();
        updateBoard(input);
        printBoard();

        // Этап 3: Анализ состояния поля и вывод результата
        String result = analyzeBoard();
        System.out.println(result);
    }

    // Инициализация пустого поля
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Обновление игрового поля на основе ввода пользователя
    public static void updateBoard(String input) {
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = input.charAt(i) == '_' ? ' ' : input.charAt(i);
        }
    }

    // Печать текущего состояния игрового поля
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

    // Анализ состояния игры
    public static String analyzeBoard() {
        boolean xWins = checkWin('X');
        boolean oWins = checkWin('O');
        int xCount = 0, oCount = 0, emptyCount = 0;

        // Подсчёт символов X, O и пустых ячеек
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'X') xCount++;
                else if (cell == 'O') oCount++;
                else emptyCount++;
            }
        }

        // Проверка различных состояний игры
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

    // Проверка выигрыша для указанного символа
    public static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||  // Проверка строк
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {  // Проверка столбцов
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||  // Диагональ слева направо
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);    // Диагональ справа налево
    }
}
