package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class Board_Test {

    @Test
    public void testCreateBoard() {
        Board board = new Board();
        String[][] boardArray = board.createBoard();
        assertEquals(8, boardArray.length);
        assertEquals(8, boardArray[0].length);
        assertEquals("O", boardArray[3][3]);
        assertEquals("O", boardArray[4][4]);
        assertEquals("X", boardArray[3][4]);
        assertEquals("X", boardArray[4][3]);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && j == 3) || (i == 4 && j == 4) || (i == 3 && j == 4) || (i == 4 && j == 3)) {
                    assertNotEquals(".", boardArray[i][j]);
                } else {
                    assertEquals(".", boardArray[i][j]);
                }
            }
        }
    }

    @Test
    public void testPrintBoard() {
        Board board = new Board();
        String[][] boardArray = board.createBoard();
        board.printBoard(boardArray);
        // This test is more difficult to automate as it involves printing to the console
        // But you can check the output manually to ensure it's correct
    }

    @Test
    public void testCheckPossibleWhiteMoves() {
        Board board = new Board();
        String[][] boardArray = board.createBoard();
        String[][] possibleMoves = board.checkPossibleWhiteMoves(boardArray);
        assertEquals(8, possibleMoves.length);
        assertEquals(8, possibleMoves[0].length);
        assertEquals("1", possibleMoves[2][3]);
        assertEquals("1", possibleMoves[3][2]);
        assertEquals("1", possibleMoves[4][5]);
        assertEquals("1", possibleMoves[5][4]);
        assertEquals("1", possibleMoves[2][5]);
        assertEquals("1", possibleMoves[5][2]);
        assertEquals("1", possibleMoves[3][6]);
        assertEquals("1", possibleMoves[6][3]);
    }

    @Test
    public void testCheckPossibleBlackMoves() {
        Board board = new Board();
        String[][] boardArray = board.createBoard();
        String[][] possibleMoves = board.checkPossibleBlackMoves(boardArray);
        assertEquals(8, possibleMoves.length);
        assertEquals(8, possibleMoves[0].length);
        assertEquals("1", possibleMoves[2][4]);
        assertEquals("1", possibleMoves[4][2]);
        assertEquals("1", possibleMoves[3][5]);
        assertEquals("1", possibleMoves[5][3]);
        assertEquals("1", possibleMoves[2][2]);
        assertEquals("1", possibleMoves[5][5]);
        assertEquals("1", possibleMoves[4][6]);
        assertEquals("1", possibleMoves[6][4]);
    }

    @Test
    public void testFinalizeWhiteMoves() {
        Board board = new Board();
        String[][] boardArray = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    boardArray[i][j] = "O";
                } else if ((i == 3 && j == 4) || (i == 4 && j == 3)) {
                    boardArray[i][j] = "X";
                } else {
                    boardArray[i][j] = ".";
                }
            }
        }
        Boolean[][] isChecked = new Boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                isChecked[i][j] = false;
            }
        }
        board.finalizeWhiteMoves(isChecked, boardArray, 4, 4, 1, 0);
        assertEquals("*", boardArray[3][4]);
    }

    @Test
    public void testFinalizeBlackMoves() {
        Board board = new Board();
        String[][] boardArray = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    boardArray[i][j] = "O";
                } else if ((i == 3 && j == 4) || (i == 4 && j == 3)) {
                    boardArray[i][j] = "X";
                } else {
                    boardArray[i][j] = ".";
                }
            }
        }
        Boolean[][] isChecked = new Boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                isChecked[i][j] = false;
            }
        }
        board.finalizeBlackMoves(isChecked, boardArray, 3, 3, 1, 0);
        assertEquals("*", boardArray[4][3]);
    }

    @Test
    public void testMakeNodesWhite() {
        Board board = new Board();
        String[][] boardArray = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    boardArray[i][j] = "O";
                } else if ((i == 3 && j == 4) || (i == 4 && j == 3)) {
                    boardArray[i][j] = "X";
                } else {
                    boardArray[i][j] = ".";
                }
            }
        }
        board.makeNodesWhite(boardArray, 3, 4);
        assertEquals("O", boardArray[3][4]);
        assertEquals("O", boardArray[4][4]);
        assertEquals("O", boardArray[4][3]);
    }

    @Test
    public void testMakeNodesBlack() {
        Board board = new Board();
        String[][] boardArray = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
                    boardArray[i][j] = "O";
                } else if ((i == 3 && j == 4) || (i == 4 && j == 3)) {
                    boardArray[i][j] = "X";
                } else {
                    boardArray[i][j] = ".";
                }
            }
        }
        board.makeNodesBlack(boardArray, 4, 3);
        assertEquals("X", boardArray[4][3]);
        assertEquals("X", boardArray[3][3]);
        assertEquals("X", boardArray[3][4]);
    }
}
