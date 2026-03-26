/**
 * Represents a position (cell) on the Battleship game board.
 * <p>
 * A position is defined by its row and column coordinates, and
 * maintains information about whether it is occupied by a ship
 * and whether it has been hit.
 * </p>
 *
 * <p>
 * This class also provides utility methods for adjacency checks,
 * equality comparison, and state updates (occupy/shoot).
 * </p>
 *
 * @author Gonçalo Nunes 100678
 * @version 1.0
 * @since 26/03/2026
 */
package iscteiul.ista.battleship;

import java.util.Objects;

public class Position implements IPosition {

    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Constructs a Position with the specified row and column.
     * Initially, the position is not occupied and not hit.
     *
     * @param row    the row coordinate
     * @param column the column coordinate
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row of this position.
     *
     * @return the row index
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this position.
     *
     * @return the column index
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Generates a hash code for this position.
     *
     * @return hash code based on row, column, and state flags
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another object for equality.
     * <p>
     * Two positions are considered equal if they have the same
     * row and column coordinates.
     * </p>
     *
     * @param otherPosition the object to compare with
     * @return true if positions have the same coordinates, false otherwise
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Checks if this position is adjacent to another position.
     * <p>
     * A position is considered adjacent if it is horizontally,
     * vertically, or diagonally next to the other position.
     * </p>
     *
     * @param other the other position
     * @return true if positions are adjacent, false otherwise
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 &&
                Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Checks if this position is occupied by a ship.
     *
     * @return true if occupied, false otherwise
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Checks if this position has been hit.
     *
     * @return true if hit, false otherwise
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a string representation of this position.
     *
     * @return formatted string with row and column
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}