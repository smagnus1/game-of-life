package com.game_of_life;

import java.util.ArrayList;


// public class Life {
//     Board board;

//     public Life(Board board) {
//         this.board = board;
//     }

    
//     public void advanceBoard(Board board, ArrayList<Cell> lifeList, ArrayList<Cell> killList) {
//         /* for (Cell cell : lifeList) {
//             board.cellToLife(cell.getKey(), cell.getValue());
//         }
//         for (Cell cell : killList) {
//             board.cellDeath(cell.getKey(), cell.getValue());
//         } */
//         for (Pair<Integer, Integer> p : lifeList) {
//             board.cellToLife(p.getKey(), p.getValue());
//         }
//         for (Pair<Integer, Integer> p : killList) {
//             board.cellDeath(p.getKey(), p.getValue());
//         }
//         //Clear the lists between different iterations
//         killList.clear();
//         lifeList.clear();
//         try {
//             Thread.sleep(500);
//         } catch (InterruptedException ex) {
//             Thread.currentThread().interrupt();
//         }
//         board.printBoard();
//     }
    
//     public void checkCells(Board board, ArrayList<Cell> lifeList, ArrayList<Cell> killList) {
//         for (int row = 0; row < board.boardLen; row++) {
//             for (int col = 0; col < board.boardLen; col++) {
//                 boolean alive = board.cellIsAlive(row, col);
//                 int nbrNeighbours = board.neighbourCount(row, col);
//                 Cell cell = new Cell(row, col);
//                 if (!alive && nbrNeighbours == 3) {
//                     lifeList.add(cell);
//                 }
//                 if (alive && nbrNeighbours < 2) {
//                     killList.add(cell);
//                 }
//                 if (alive && nbrNeighbours > 3) {
//                     killList.add(cell);
//                 }
//             }
//         }
//     }
    
//     /*
//     * 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation. 
//     * 2. Any live cell with two or three live neighbours lives on to the next generation. 
//     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation. 
//     * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
//     */
//     public void evolve(Board board) {
//         ArrayList<Cell> killList = new ArrayList<>();
//         ArrayList<Cell> lifeList = new ArrayList<>();
//         board.printBoard();
//         while (!board.allIsLife() && !board.allIsDeath()) {
//             checkCells(board, lifeList, killList);
//             advanceBoard(board, lifeList, killList);
//         }
//     }

//     /*
//     * Some default shapes to initiate with
//     */
//     public void initiateTriLife() {
//         board.clearBoard();
//         board.cellToLife(2, 2);
//         board.cellToLife(2, 3);
//         board.cellToLife(2, 4);
//     }
    
//     public void initiateSpaceship() {
//         board.clearBoard();
//         board.cellToLife(1, 1);
//         board.cellToLife(1, 3);
//         board.cellToLife(2, 2);
//         board.cellToLife(3, 2);
//         board.cellToLife(2, 3);
    
//     }
    
//     public void initiateTetraLife() {
//         board.clearBoard();
//         board.cellToLife(3, 1);
//         board.cellToLife(3, 2);
//         board.cellToLife(3, 3);
//         board.cellToLife(3, 4);
//     }
// }




public class Life {
    Board board;

    public Life(Board board) {
        this.board = board;
    }

    
    public void advanceBoard(Board board, ArrayList<Pair<Integer, Integer>> lifeList, ArrayList<Pair<Integer, Integer>> killList) {
        for (Pair<Integer, Integer> p : lifeList) {
            board.cellToLife(p.getKey(), p.getValue());
        }
        for (Pair<Integer, Integer> p : killList) {
            board.cellDeath(p.getKey(), p.getValue());
        }
        //Clear the lists between different iterations
        killList.clear();
        lifeList.clear();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        board.printBoard();
    }
    
    public void checkCells(Board board, ArrayList<Pair<Integer, Integer>> lifeList, ArrayList<Pair<Integer, Integer>> killList) {
        for (int row = 0; row < board.boardLen; row++) {
            for (int col = 0; col < board.boardLen; col++) {
                boolean alive = board.cellIsAlive(row, col);
                int nbrNeighbours = board.neighbourCount(row, col);
                Pair<Integer, Integer> p = new Pair<Integer, Integer>(row, col);
                //Pair cell = new Pair(row, col);
                if (!alive && nbrNeighbours == 3) {
                    lifeList.add(p);
                }
                if (alive && nbrNeighbours < 2) {
                    killList.add(p);
                }
                if (alive && nbrNeighbours > 3) {
                    killList.add(p);
                }
            }
        }
    }
    
    
    public void evolve(Board board) {
        ArrayList<Pair<Integer, Integer>> killList = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> lifeList = new ArrayList<>();
        board.printBoard();
        while (!board.allIsLife() && !board.allIsDeath()) {
            checkCells(board, lifeList, killList);
            advanceBoard(board, lifeList, killList);
        }
    }

   
    public void initiateTriLife() {
        board.clearBoard();
        board.cellToLife(2, 2);
        board.cellToLife(2, 3);
        board.cellToLife(2, 4);
    }
    
    public void initiateSpaceship() {
        board.clearBoard();
        board.cellToLife(1, 1);
        board.cellToLife(1, 3);
        board.cellToLife(2, 2);
        board.cellToLife(3, 2);
        board.cellToLife(2, 3);
    
    }
    
    public void initiateTetraLife() {
        board.clearBoard();
        board.cellToLife(3, 1);
        board.cellToLife(3, 2);
        board.cellToLife(3, 3);
        board.cellToLife(3, 4);
    }
} 