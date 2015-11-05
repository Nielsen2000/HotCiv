package hotciv.framework;

/**
 * Created by Johnny Hansen on 05-11-2015.
 */
public class CityImpl implements City {
    /** return the owner of this city.
     * @return the player that controls this city.
     */
    protected Player owner;
    public CityImpl(Player owner){
        this.owner = owner;
    }

    public Player getOwner(){ return owner; };

    /** return the size of the population.
     * @return population size.
     */
    public int getSize(){ return 1; }

    /** return the type of unit this city is currently producing.
     * @return a string type defining the unit under production,
     * see GameConstants for valid values.
     */
    public String getProduction(){ return null; }

    /** return the work force's focus in this city.
     * @return a string type defining the focus, see GameConstants
     * for valid return values.
     */
    public String getWorkforceFocus(){ return null; }

}
