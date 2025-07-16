public class TicTacToeGame {
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    static char[][] initializeBoard() {
        char[][] board = new char[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    static void printBoard(char[][] board) {
        System.out.println();
        System.out.println("  0 1 2 3 4");
        for (int row = 0; row < 5; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 5; col++) {
                System.out.print(board[row][col]);
                if (col < 4) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    static char checkWinner(char[][] board) {
        for (int i = 0; i < 5; i++) {
            if (board[i][0] != EMPTY &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2] &&
                board[i][2] == board[i][3] &&
                board[i][3] == board[i][4]) {
                return board[i][0];
            }
            if (board[0][i] != EMPTY &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i] &&
                board[2][i] == board[3][i] &&
                board[3][i] == board[4][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != EMPTY &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
            board[2][2] == board[3][3] &&
            board[3][3] == board[4][4]) {
            return board[0][0];
        }
        if (board[0][4] != EMPTY &&
            board[0][4] == board[1][3] &&
            board[1][3] == board[2][2] &&
            board[2][2] == board[3][1] &&
            board[3][1] == board[4][0]) {
            return board[0][4];
        }
        return EMPTY;
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = initializeBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        char currentPlayer = PLAYER_X;
        while (true) {
            System.out.printf("請玩家 %c 輸入 row col：", currentPlayer);
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);
                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("平手！");
                    break;
                }
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        sc.close();
    }
}