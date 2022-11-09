package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size =Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (position.getX() - dest.getX())>0 ? 1 : -1;
        int deltaY = (position.getY() - dest.getY())>0 ? 1 : -1;
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
       boolean rsl = false;
       if ((position.getX() + position.getY() == dest.getX() + dest.getY())
               || (position.getX() - position.getY() == dest.getX() - dest.getY())) {
           rsl = true;
       }

        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
