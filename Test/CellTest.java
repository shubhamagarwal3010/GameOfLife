import static org.junit.Assert.*;

import com.gameOfLife.Cell;
import org.junit.Test;


public class CellTest {

    @Test
    public void verifyIfStatusIsUpdatedOfCell() {
        Cell c = new Cell();

        c.setNewState(true);
        c.updateState();
        assertEquals(true, c.getState());
    }

}
