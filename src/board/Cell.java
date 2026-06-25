package board;

import entities.CellVisitor;
import entities.Unit;

public interface Cell {
    String accept(CellVisitor v);
}
