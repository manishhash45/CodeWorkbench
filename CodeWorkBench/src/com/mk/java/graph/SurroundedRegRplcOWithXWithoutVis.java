package com.mk.java.graph;

public class SurroundedRegRplcOWithXWithoutVis {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        printBoard(board);
        solve(board);
        System.out.println("Surrounded Regions replaced with X:");
        printBoard(board);

    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark boundary connected O's
        for (int i = 0; i < n; i++) {
            dfs(0, i, board);
            dfs(m - 1, i, board);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }

        // Step 2: Flip remaining O -> X, restore # -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }


    private static void dfs(int i, int j, char[][] board) {
        int m = board.length, n = board[0].length;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
            return;

        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            dfs(i + dr[k], j + dc[k], board);
        }
    }
}
