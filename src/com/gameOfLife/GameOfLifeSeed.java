package com.gameOfLife;

public class GameOfLifeSeed {
    private int height, width;
    private Cell[][] cells;

    public GameOfLifeSeed(Cell[][] cell) {
        this.cells = cell;
        height = width = cell.length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int totalNeighboursAt(int row, int col) {
        int count=0;
        if (col != width-1){
            if(isAlive(row,col+1)){
                count++;
            }
        }

        if (row != height-1 && col != 0){
            if(isAlive(row+1,col-1)){
                count++;
            }
        }

        if (row != height-1){
            if(isAlive(row+1,col)){
                count++;
            }
        }

        if (row != height-1 && col != width-1){
            if(isAlive(row+1,col+1)){
                count++;
            }
        }
        if (row != 0 && col != 0){
            if(isAlive(row-1,col-1)){
                count++;
            }
        }

        if (row != 0){
            if(isAlive(row-1,col)){
                count++;
            }
        }

        if (row != 0 && col != width-1){
            if(isAlive(row-1,col+1)){
                count++;
            }
        }
        if (col != 0){
            if(isAlive(row,col-1)){
                count++;
            }
        }

        return count;
    }

    public boolean isAlive(int row, int col) {
        return cells[row][col].getState();
    }

    public void update() {
        prepare();
        for (int h = 0; h< cells.length; h++){
            for (int w = 0; w< cells[h].length; w++){
                cells[h][w].updateState();
            }
        }
    }

    private void prepare() {
        for (int h = 0; h< cells.length; h++){
            for (int w = 0; w< cells[h].length; w++){
                int neighbourCount = totalNeighboursAt(h,w);
                if (neighbourCount < 2) { cells[h][w].setNewState(false);}  //underpop
                else if (neighbourCount > 3) { cells[h][w].setNewState(false);} //overcrowd
                else if (neighbourCount == 3) { cells[h][w].setNewState(true);} //born
                else if (neighbourCount == 2) { cells[h][w].setNewState(cells[h][w].getState());} // stay same
            }
        }
    }
}
