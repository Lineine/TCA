package net.mooctest;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Othello_Test {

    @Test
    public void testStrategyOfBlackMove_EmptyBoard() {
        Othello othello = new Othello();
        String[][] black_board = new String[8][8];
        String[][] game_board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                black_board[i][k] = "";
                game_board[i][k] = "";
            }
        }

        ArrayList<Integer> result = othello.strategyOfBlackMove(black_board, game_board);
        assertEquals(0, result.size());
    }

    @Test
    public void testStrategyOfBlackMove_SingleBlackPiece() {
        Othello othello = new Othello();
        String[][] black_board = new String[8][8];
        String[][] game_board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                black_board[i][k] = "";
                game_board[i][k] = "";
            }
        }
        black_board[3][3] = "*";
        game_board[3][3] = "*";

        ArrayList<Integer> result = othello.strategyOfBlackMove(black_board, game_board);
        assertEquals(2, result.size());
        assertEquals(3, (int) result.get(0));
        assertEquals(3, (int) result.get(1));
    }

    @Test
    public void testStrategyOfBlackMove_MultipleBlackPieces() {
        Othello othello = new Othello();
        String[][] black_board = new String[8][8];
        String[][] game_board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                black_board[i][k] = "";
                game_board[i][k] = "";
            }
        }
        black_board[3][3] = "*";
        black_board[4][4] = "*";
        game_board[3][3] = "*";
        game_board[4][4] = "*";

        ArrayList<Integer> result = othello.strategyOfBlackMove(black_board, game_board);
        assertEquals(2, result.size());
        // The actual values of row and column may vary due to randomness
        assertTrue(result.get(0) >= 0 && result.get(0) < 8);
        assertTrue(result.get(1) >= 0 && result.get(1) < 8);
    }

    @Test
    public void testStrategyOfBlackMove_NoValidMove() {
        Othello othello = new Othello();
        String[][] black_board = new String[8][8];
        String[][] game_board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                black_board[i][k] = "";
                game_board[i][k] = "X";
            }
        }

        ArrayList<Integer> result = othello.strategyOfBlackMove(black_board, game_board);
        assertEquals(0, result.size());
    }
}
