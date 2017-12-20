import static org.junit.Assert.*;

import com.gameOfLife.GameOfLifeSeed;
import com.gameOfLife.Cell;
import org.junit.Test;


public class GameOfLifeTest {

    @Test
    public void shouldGetNeighboursCountWhenStateisTrueForAllCells() {

        Cell[][] cells = {
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(true), new Cell(true), new Cell(true)}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        assertEquals(3, seed.totalNeighboursAt(0,0));
        assertEquals(8, seed.totalNeighboursAt(1,1));
        assertEquals(5, seed.totalNeighboursAt(1,0));
    }
    @Test
    public void shouldGetNeighboursCountForRandomStatesOfCells() {

        Cell[][] cells = {
                {new Cell(true), new Cell(false), new Cell(true)},
                {new Cell(false), new Cell(true), new Cell(true)},
                {new Cell(true), new Cell(true), new Cell(true)}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        assertEquals(1, seed.totalNeighboursAt(0,0));
        assertEquals(6, seed.totalNeighboursAt(1,1));
        assertEquals(4, seed.totalNeighboursAt(1,0));
    }

    @Test
    public void verifyIfGridRemainsSameforBlockPattern() {
        Cell[][] cells = {
                {new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(true), new Cell(true)},
                {new Cell(), new Cell(true), new Cell(true)}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertSame(cells, seed.getCells());
    }

    @Test
    public void verifyIfGridRemainsSameforBoatPattern() {
        Cell[][] cells = {
                {new Cell(), new Cell(true), new Cell(true)},
                {new Cell(true), new Cell(), new Cell(true)},
                {new Cell(), new Cell(true), new Cell()}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertSame(cells, seed.getCells());
    }

    @Test
    public void verifyBlinkerPattern() {
        Cell[][] cells = {
                {new Cell(), new Cell(), new Cell()},
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(), new Cell(), new Cell()}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertEquals(false, seed.isAlive(1, 0));
        assertEquals(false, seed.isAlive(1, 2));
        assertEquals(true, seed.isAlive(1, 1));
        assertEquals(true, seed.isAlive(0, 1));
        assertEquals(true, seed.isAlive(2, 1));
    }

    @Test
    public void verifyToadPattern() {
        Cell[][] cells = {
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(true), new Cell(true), new Cell(true), new Cell()},
                {new Cell(), new Cell(), new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()},
                {new Cell(), new Cell(), new Cell(), new Cell(), new Cell()}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertEquals(true, seed.isAlive(0, 2));
        assertEquals(true, seed.isAlive(1, 1));
        assertEquals(true, seed.isAlive(1, 4));
        assertEquals(true, seed.isAlive(2, 1));
        assertEquals(true, seed.isAlive(2, 4));
        assertEquals(true, seed.isAlive(3, 3));
    }
    @Test
    public void verifyIfAllCellsDie() {
        Cell[][] cells = {
                {new Cell(true), new Cell(), new Cell(true)},
                {new Cell(), new Cell(), new Cell()},
                {new Cell(true), new Cell(), new Cell(true)}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertEquals(false, seed.isAlive(0, 0));
        assertEquals(false, seed.isAlive(2, 2));
        assertEquals(false, seed.isAlive(2, 0));
        assertEquals(false, seed.isAlive(0, 2));
        assertEquals(false, seed.isAlive(1, 1));
    }


    @Test
    public void verifyOverpopulationAndIsBorn() {
        Cell[][] cells = {
                {new Cell(true), new Cell(true), new Cell(true)},
                {new Cell(true), new Cell(true), new Cell()},
                {new Cell(), new Cell(), new Cell()}
        };

        GameOfLifeSeed seed = new GameOfLifeSeed(cells);

        seed.update();

        assertEquals(true, seed.isAlive(0, 0));
        assertEquals(true, seed.isAlive(0, 2));
        assertEquals(true, seed.isAlive(1, 0));
        assertEquals(true, seed.isAlive(1, 2));
        assertEquals(false, seed.isAlive(0, 1));
        assertEquals(false, seed.isAlive(1, 1));
    }
}
