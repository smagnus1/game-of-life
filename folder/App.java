package com.game_of_life;



public class App {
    public static void main(String[] args) {
        Board board = new Board(20);
        Life life = new Life(board);                      
        life.initiateSpaceship();        
        life.evolve(board);
    }
}


