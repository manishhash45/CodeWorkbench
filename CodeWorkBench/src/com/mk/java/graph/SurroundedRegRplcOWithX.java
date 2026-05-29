package com.mk.java.graph;

public class SurroundedRegRplcOWithX {
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
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && board[0][i] == 'O')
                dfs(0, i, board, visited);

            if (!visited[m - 1][i] && board[m - 1][i] == 'O')
                dfs(m - 1, i, board, visited);

        }

        for (int j = 0; j < m; j++) {
            if (!visited[j][0] && board[j][0] == 'O')
                dfs(j, 0, board, visited);

            if (!visited[j][n - 1] && board[j][n - 1] == 'O')
                dfs(j,n - 1, board, visited);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' &&!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }


    private static void dfs(int i, int j, char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && !visited[nr][nc]) {
                dfs(nr, nc, board, visited);
            }
        }
    }
}
