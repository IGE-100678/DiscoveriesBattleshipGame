package iscteiul.ista.battleship;

/**
 * Represents a Barge (Barca) in the Battleship game.
 * A Barge is a specific type of Ship with a fixed size of 1.
 */
public class Barge extends Ship {

    /**
     * The constant size of a Barge ship.
     */
    private static final Integer SIZE = 1;

    /**
     * The constant name for this type of ship.
     */
    private static final String NAME = "Barca";

    /**
     * Constructs a new Barge instance with a specified bearing and position.
     * * @param bearing the direction the barge is facing (Compass bearing).
     * @param pos     the starting position (upper left position) of the barge on the grid.
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Retrieves the size of the Barge.
     * * @return the size of the ship, which is always 1 for a Barge.
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}

