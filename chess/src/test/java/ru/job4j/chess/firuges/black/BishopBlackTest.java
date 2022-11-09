package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    public void whePositionIsCorrect()  {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        assertThat(bishop.position(), is(Cell.A3));
    }

    @Test
    public void whenCopyIsCorrect() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        assertThat(bishop.copy(Cell.D6).position(), is(Cell.D6));
    }

    @Test
    public void whenWayIsCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5), is(expected));
    }
}