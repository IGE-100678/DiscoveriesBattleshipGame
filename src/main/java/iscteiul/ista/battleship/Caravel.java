package iscteiul.ista.battleship;

/**
 * Represents a Caravel (Caravela) in the Battleship game.
 * A Caravel is a specific type of Ship that occupies 2 adjacent positions
 * either vertically or horizontally depending on its bearing.
 */
public class Caravel extends Ship {

    /**
     * The constant size of a Caravel ship (occupies 2 spaces).
     */
    private static final Integer SIZE = 2;

    /**
     * The constant name for this type of ship.
     */
    private static final String NAME = "Caravela";

    /**
     * Constructs a new Caravel instance, calculating its occupied positions 
     * based on the given bearing and starting position.
     * * @param bearing the direction the Caravel is facing (Compass bearing).
     * @param pos     the initial point (upper/left position) for positioning the Caravel.
     * @throws NullPointerException     if the provided bearing is null.
     * @throws IllegalArgumentException if the bearing provided is not supported.
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Retrieves the size of the Caravel.
     * * @return the size of the ship, which is always 2 for a Caravel.
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}