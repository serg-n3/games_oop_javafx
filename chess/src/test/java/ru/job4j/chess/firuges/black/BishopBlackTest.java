package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.position();
        assertThat(bishopBlack.position()).isEqualTo(Cell.A1);

    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        bishopBlack.copy(Cell.A2);
        assertThat(bishopBlack.copy(Cell.A2).position()).isEqualTo(Cell.A2);
    }

    @Test
    public void whenMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.A2);
                });
        assertThat(exception.getMessage()).
                isEqualTo("Could not move by diagonal from %s to %s", Cell.A1, Cell.A2);
    }
}