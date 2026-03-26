/**
 * Abstract representation of a Ship in the Battleship game.
 * <p>
 * A Ship has a category, a bearing (orientation), an initial position,
 * and a list of positions it occupies on the board.
 * </p>
 *
 * <p>
 * This class provides common behavior for all ship types, such as:
 * movement boundaries, collision detection, shooting, and state checks.
 * </p>
 *
 * @author Gonçalo Nunes 100678
 * @version 1.0
 * @since 26/03/2026
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Factory method responsible for creating specific Ship instances
     * based on the given type.
     *
     * @param shipKind the type/category of the ship
     * @param bearing  the orientation of the ship
     * @param pos      the starting position of the ship
     * @return a concrete Ship instance or null if type is invalid
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;

    /**
     * Constructs a Ship with the specified category, orientation, and position.
     *
     * @param category the ship category/type
     * @param bearing  the orientation of the ship
     * @param pos      the starting position
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Returns the category/type of the ship.
     *
     * @return the ship category
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the list of positions occupied by the ship.
     *
     * @return list of positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Returns the initial position of the ship.
     *
     * @return the starting position
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Returns the orientation (bearing) of the ship.
     *
     * @return the bearing
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Checks if the ship is still afloat (i.e., at least one position is not hit).
     *
     * @return true if at least one part of the ship is not hit, false otherwise
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Returns the smallest row index occupied by the ship.
     *
     * @return top-most row
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Returns the largest row index occupied by the ship.
     *
     * @return bottom-most row
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Returns the smallest column index occupied by the ship.
     *
     * @return left-most column
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Returns the largest column index occupied by the ship.
     *
     * @return right-most column
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Checks if the ship occupies a given position.
     *
     * @param pos the position to check
     * @return true if the ship occupies the position, false otherwise
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Checks if this ship is too close to another ship.
     * A ship is considered too close if any of its positions
     * are adjacent to positions of the other ship.
     *
     * @param other the other ship
     * @return true if too close, false otherwise
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Checks if this ship is too close to a given position.
     *
     * @param pos the position to check
     * @return true if any part of the ship is adjacent to the position
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Shoots at a given position. If the position is part of the ship,
     * it will be marked as hit.
     *
     * @param pos the position to shoot at
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Returns a string representation of the ship.
     *
     * @return formatted string with category, bearing, and position
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }
}