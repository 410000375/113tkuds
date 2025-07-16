import java.util.Scanner;

public class TicTacToe5x5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = '.';

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);

        char currentPlayer = 'X';
        while (true) {
            int row = -1, col = -1;
            while (true) {
                if (!sc.hasNextInt()) return;
                row = sc.nextInt();
                if (!sc.hasNextInt()) return;
                col = sc.nextInt();
                if (row < 0 || row >= 5 || col < 0 || col >= 5) {
                    System.out.println("無效座標，請重新輸入。");
                    continue;
                }
                if (board[row][col] != '.') {
                    System.out.println("該位置已有棋子，請重新輸入。");
                    continue;
                }
                break;
            }

            board[row][col] = currentPlayer;
            System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", currentPlayer, row, col);
            printBoard(board);

            if (isWinner(board, currentPlayer)) {
                System.out.printf("玩家 %c 獲勝！\n", currentPlayer);
                break;
            } else if (isBoardFull(board)) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < 5; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);
                if (j < 4) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 5; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != player) rowWin = false;
                if (board[j][i] != player) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != player) diag1 = false;
            if (board[i][4 - i] != player) diag2 = false;
        }

        return diag1 || diag2;
    }

    static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
        
    }
}