package com.game_of_life;
public class Board {

    public String[][] board;
    public int boardLen;

    public Board(int size) {
        this.board = makeBoard(size);
        this.boardLen = board.length;
    }   
  
    private static String[][] makeBoard(int size) {
        String[][] board = new String[size][size];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = "[ ]";
            }
        }
        return board;
    }

    public void printBoard() {
        for(int row = 0;  row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if(col == board[row].length-1) {
                    System.out.println();
                }
            }
        }
        System.out.println("----------------------------------------");
    }

    public void clearBoard() {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = "[ ] ";
            }
        }
    }
    
    //komma på bättre sätt?
    public int neighbourCount(int row, int col) {
        int count = 0;
        if(cellIsAlive(row-1, col-1)) { count++; }
        if(cellIsAlive(row, col-1))   { count++; }
        if(cellIsAlive(row+1, col-1)) { count++; }
        if(cellIsAlive(row-1, col))   { count++; }
        if(cellIsAlive(row+1, col))   { count++; }
        if(cellIsAlive(row-1, col+1)) { count++; }
        if(cellIsAlive(row, col+1))   { count++; }
        if(cellIsAlive(row+1, col+1)) { count++; }
        return count;
    }

    public boolean allIsX(String s) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col] != s) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean allIsDeath() {
       return allIsX("[ ] ");
    }

    public boolean allIsLife() {
        return allIsX("[■] ");
    }

    public void cellToLife(int row, int col) {
        board[row][col] = "[■] ";
    }

    public void cellDeath(int row, int col) {
        board[row][col] = "[ ] ";
    }

    public boolean cellIsAlive(int row, int col) {
        if(row < 0 || row > boardLen-1 || col < 0 || col > boardLen-1) {
            return false;
        }
        return board[row][col] == "[■] ";
    }

    public boolean cellIsDead(int row, int col) {
        return board[row][col] == "[ ] ";
    }
}
